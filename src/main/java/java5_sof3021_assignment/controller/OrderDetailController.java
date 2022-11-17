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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java5_sof3021_assignment.entity.Account;
import java5_sof3021_assignment.entity.Category;
import java5_sof3021_assignment.entity.Order;
import java5_sof3021_assignment.entity.OrderDetail;
import java5_sof3021_assignment.entity.ReportCategory;
import java5_sof3021_assignment.entity.ReportDate;
import java5_sof3021_assignment.service.CategoryService;
import java5_sof3021_assignment.service.OrderDetailService;
import java5_sof3021_assignment.service.ProductService;
import java5_sof3021_assignment.service.SessionService;

@Controller
public class OrderDetailController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	SessionService sessionService;
	@Autowired
	OrderDetailService orderDetailService;

	@GetMapping("order_details/view")
	public String view(Model model,@RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0),8);
		Page<OrderDetail> page = orderDetailService.getAll(pageable);
		model.addAttribute("pages", page);
		model.addAttribute("url", "view");
		return "order_details_qldl/order_details_view";
	}
	
	@PostMapping(value ="order_details/search", params = "id")
	public String searchAndPage(Model model, @RequestParam("id") Integer id,
			@RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0),8);
		Page<OrderDetail> page = orderDetailService.findById(id, pageable);
		model.addAttribute("url", "search");
		model.addAttribute("pages", page);
		return "order_details_qldl/order_details_view";
	}
	
	@GetMapping(value = "/order_details/update", params = "id")
	public String update(Model model, @RequestParam("id") Integer id) {
		OrderDetail orderDetail = orderDetailService.findById(id);
		model.addAttribute("orderDetail", orderDetail);
		return "order_details_qldl/order_details_update";
	}
	
	@PostMapping("/order_details/update_order_details")
	public String updateOrderDetails(Model model, @ModelAttribute("orderDetail") OrderDetail orderDetail) {
		orderDetailService.update(orderDetail);
		return "redirect:/order_details/view";
	}
	
	@GetMapping(value = "/order_details/delete", params = "id")
	public String delete(Model model, @RequestParam("id") Integer id) {
		orderDetailService.delete(id);
		System.out.println("Xóa thành công");
		return "redirect:/order_details/view";
	}
	
	@GetMapping("statistics-category")
	public String statisticsCategory(Model model,@RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0),8);
		Page<ReportCategory> pages= orderDetailService.revenueByCategory(pageable);
		model.addAttribute("pages", pages);
		return "statistics/statistics_category_view";
	}
	
	@GetMapping("statistics-date")
	public String statisticsDate(Model model,@RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0),8);
		Page<ReportDate> pages= orderDetailService.revenueByDate(pageable);
		model.addAttribute("pages", pages);
		return "statistics/statistics_date_view";
	}
}
