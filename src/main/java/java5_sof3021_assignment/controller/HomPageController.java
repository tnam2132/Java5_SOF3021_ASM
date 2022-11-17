package java5_sof3021_assignment.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java5_sof3021_assignment.entity.Account;
import java5_sof3021_assignment.entity.Category;
import java5_sof3021_assignment.entity.DiscountDetails;
import java5_sof3021_assignment.entity.Product;
import java5_sof3021_assignment.repository.AccountRepository;
import java5_sof3021_assignment.repository.ProductRepository;
import java5_sof3021_assignment.service.AccountService;
import java5_sof3021_assignment.service.CategoryService;
import java5_sof3021_assignment.service.DiscountDetailService;
import java5_sof3021_assignment.service.ProductService;

@Controller
public class HomPageController {
	@Autowired
	AccountService accountService;

	@Autowired
	ProductService productService;

	@Autowired
	DiscountDetailService discountDetailService;

	@Autowired
	CategoryService categoryService;

	@RequestMapping("homepage")
	public String homePage(Model model, @RequestParam("p") Optional<Integer> p) {
		model.addAttribute("url", "homepage");
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		Pageable pageable = PageRequest.of(p.orElse(0), 8);
		Page<Product> pages = discountDetailService.getTop10(pageable);
		model.addAttribute("pages", pages);
		return "trangchu/home_page";
	}

	@RequestMapping("category/{id}")
	public String category(Model model, @PathVariable("id") Integer id, @RequestParam("p") Optional<Integer> p) {
		model.addAttribute("url", "category/" + id.toString());
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		Pageable pageable = PageRequest.of(p.orElse(0), 8);
		Page<Product> pages = productService.findByCategory_Id(id, pageable);
		model.addAttribute("pages", pages);
		return "trangchu/home_page";
	}
}
