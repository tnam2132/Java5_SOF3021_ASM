package java5_sof3021_assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java5_sof3021_assignment.entity.Account;
import java5_sof3021_assignment.entity.Category;
import java5_sof3021_assignment.entity.Order;
import java5_sof3021_assignment.entity.OrderDetail;
import java5_sof3021_assignment.entity.Product;
import java5_sof3021_assignment.service.AccountService;
import java5_sof3021_assignment.service.CategoryService;
import java5_sof3021_assignment.service.OrderDetailService;
import java5_sof3021_assignment.service.OrderService;
import java5_sof3021_assignment.service.ProductService;
import java5_sof3021_assignment.service.SessionService;

@Controller
public class OrderController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	AccountService accountService;
	@Autowired
	SessionService sessionService;
	@Autowired
	OrderService orderService;
	@Autowired
	OrderDetailService orderDetailService;

	@GetMapping("order/view")
	public String searchAndPage(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 8);
		Page<Order> page = orderService.getAll(pageable);
		model.addAttribute("url", "view");
		model.addAttribute("pages", page);
		return "order_qldl/order_view";
	}

	@PostMapping("order/search")
	public String searchAndPage(Model model, @RequestParam("address") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(sessionService.get("address"));
		sessionService.set("address", kwords);
		Pageable pageable = PageRequest.of(p.orElse(0), 8);
		Page<Order> page = orderService.findByAddressLike("%" + kwords + "%", pageable);
		model.addAttribute("url", "search");
		model.addAttribute("pages", page);
		return "order_qldl/order_view";
	}
	//Trả về hóa đơn
	@GetMapping(value = "order/create", params = "id")
	public String createForm(Model model, @ModelAttribute("order") Order order, 
			@RequestParam("id") Integer id) {
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		Order order1 = new Order();
		model.addAttribute("order", order1);
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setPrice(product.getPrice());
		orderDetail.setQuantity(1);
		model.addAttribute("orderDetail", orderDetail);
		return "order_qldl/order_insert";
	}
	//Trả về hóa đơn + update số lượng
	@PostMapping(value = "order/create_update", params = "id")
	public String createUpdateForm(Model model, @RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		Order order = new Order();
		model.addAttribute("order", order);
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setPrice(product.getPrice());
		if (quantity != null && quantity >= 0) {
			orderDetail.setQuantity(quantity);
		} else {
			orderDetail.setQuantity(1);
		}
		model.addAttribute("orderDetail", orderDetail);
		return "order_qldl/order_insert";
	}

	@PostMapping("order/create_order")
	public String create(Model model, @ModelAttribute("order") Order order,
			@RequestParam("ma") Integer ma,
			@RequestParam("qty") Integer quantity,
			@RequestParam("price") Double price) {
		Account account = accountService.findByUsername(sessionService.get("username"));
		order.setAccount(account);
		order.setStatus(0);
		orderService.create(order);
		System.out.println("Tạo hóa đơn thành công");
		
		Product product = productService.findById(ma);
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setQuantity(quantity);
		orderDetail.setPrice(price);
		orderDetail.setProduct(product);
		orderDetail.setOrder(order);
		orderDetailService.create(orderDetail);
		System.out.println("Đặt hàng thành công");
		return "redirect:/homepage";
	}

	@GetMapping(value = "order/update", params = "id")
	public String update(Model model, @RequestParam("id") Integer id) {
		Order order = orderService.findById(id);
		model.addAttribute("order", order);
		return "order_qldl/order_update";
	}

	@PostMapping("order/update_order")
	public String update_order(Model model, @ModelAttribute("order") Order order) {
		orderService.update(order);
		return "redirect:/order/view";
	}

	@RequestMapping(value = "order/delete", params = "id")
	public String delete(Model model, @RequestParam("id") Integer id) {
		orderService.delete(id);
		System.out.println("Xóa thành công");
		return "redirect:/order/view";
	}
}
