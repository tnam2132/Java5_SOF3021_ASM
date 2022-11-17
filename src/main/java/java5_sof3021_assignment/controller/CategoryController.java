package java5_sof3021_assignment.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java5_sof3021_assignment.entity.Account;
import java5_sof3021_assignment.entity.Category;
import java5_sof3021_assignment.service.CategoryService;
import java5_sof3021_assignment.service.ProductService;
import java5_sof3021_assignment.service.SessionService;

@Controller
public class CategoryController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	SessionService sessionService;

	@GetMapping("/category/view")
	public String view(Model model,@RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0),8);
		Page<Category> page = categoryService.getAll(pageable);
		model.addAttribute("pages", page);
		model.addAttribute("url", "view");
		return "category_qldl/category_view";
	}
	
	@PostMapping("category/search")
	public String searchAndPage(Model model, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(sessionService.get("keywords"));
		sessionService.set("keywords", kwords);
		Pageable pageable = PageRequest.of(p.orElse(0),8);
		Page<Category> page = categoryService.findByNameLike("%" + kwords + "%", pageable);
		model.addAttribute("url", "search");
		model.addAttribute("pages", page);
		return "category_qldl/category_view";
	}
	
	@GetMapping("/category/insert")
	public String insert(Model model, @ModelAttribute("category") Category category) {
		Category category2 = new Category();
		model.addAttribute("category", category2);
		return "category_qldl/category_insert";
	}
	
	@PostMapping("/category/insert_category")
	public String insertCategory(Model model,@Valid @ModelAttribute("category") Category category, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			categoryService.create(category);
			System.out.println("Thêm loại hàng thành công");
			return "category_qldl/category_view";
		}
		return "category_qldl/category_insert";
	}

	@GetMapping(value = "/category/update", params = "id")
	public String update(Model model, @ModelAttribute("category") Category category, @RequestParam("id") Integer id) {
		category = categoryService.findById(id);
		model.addAttribute("category", category);
		return "category_qldl/category_update";
	}
	
	@PostMapping("/category/update_category")
	public String updateCategory(Model model, @ModelAttribute("category") Category category) {
		categoryService.update(category);
		return "redirect:/category/view";
	}
	
	@GetMapping(value = "/category/delete", params = "id")
	public String delete(Model model, @ModelAttribute("category") Category category, @RequestParam("id") Integer id) {
		categoryService.delete(id);
		System.out.println("Xóa thành công");
		return "redirect:/category/view";
	}
}
