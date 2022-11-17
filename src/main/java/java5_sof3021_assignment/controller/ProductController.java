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
import java5_sof3021_assignment.entity.Product;
import java5_sof3021_assignment.service.AccountService;
import java5_sof3021_assignment.service.CategoryService;
import java5_sof3021_assignment.service.ProductService;
import java5_sof3021_assignment.service.SessionService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	AccountService accountService;
	@Autowired
	SessionService sessionService;

	@GetMapping("product/view")
	public String searchAndPage(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 8);
		Page<Product> page = productService.getAll(pageable);
		model.addAttribute("url", "view");
		model.addAttribute("pages", page);
		return "product_qldl/product_view";
	}

	@PostMapping("product/search")
	public String searchAndPage(Model model, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(sessionService.get("keywords"));
		sessionService.set("keywords", kwords);
		Pageable pageable = PageRequest.of(p.orElse(0), 8);
		Page<Product> page = productService.findByNameLike("%" + kwords + "%", pageable);
		model.addAttribute("url", "search");
		model.addAttribute("pages", page);
		return "product_qldl/product_view";
	}

	@GetMapping("product/insert")
	public String insert(Model model, @ModelAttribute("product") Product product) {
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		return "product_qldl/product_insert";
	}

	@PostMapping("product/create_product")
	public String create(Model model, @ModelAttribute("product") Product product) {
		Account account = accountService.findByUsername(sessionService.get("username"));
		product.setAccount(account);
		product.setLast_modified_account(account);
		productService.create(product);
		return "redirect:/product/view";
	}

	@GetMapping(value = "product/update", params = "id")
	public String update(Model model, @RequestParam("id") Integer id) {
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		return "product_qldl/product_update";
	}

	@PostMapping("product/update_product")
	public String update_product(Model model, @ModelAttribute("product") Product product) {
		Account account1 = accountService.findByUsername(sessionService.get("username"));
		Product product2 = productService.findById(product.getId());
		product.setCreatedDate(product2.getCreatedDate());
		product.setAccount(product2.getAccount());
		product.setLast_modified_account(account1);
		productService.update(product);
		return "redirect:/product/view";
	}

	@GetMapping(value = "product/delete", params = "id")
	public String delete(Model model, @RequestParam("id") Integer id) {
		productService.delete(id);
		System.out.println("Xóa thành công");
		return "redirect:product/view";
	}
	
	@GetMapping(value = "product/ctsp", params = "id")
	public String ctsp(Model model, @RequestParam("id") Integer id, @RequestParam("p") Optional<Integer> p) {
		Product product = productService.findById(id);
		Pageable pageable = PageRequest.of(p.orElse(0), 8);
		Page<Product> page = productService.findByCategory_Id(product.getCategory().getId(), pageable);
		model.addAttribute("pages", page);
		model.addAttribute("product", product);
		return "trangchu/product_view_ctsp";
	}
}
