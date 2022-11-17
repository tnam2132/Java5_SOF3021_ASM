package java5_sof3021_assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java5_sof3021_assignment.interface_Asm.ShoppingCartInterface;

@Controller
public class ShoppingCartController {
	@Autowired
	ShoppingCartInterface cartServiceImpl;

	@GetMapping("cart/view")
	public String view(Model model) {
		model.addAttribute("cart", cartServiceImpl);
		return "cart_qldl/cart_view";
	}

	@GetMapping("/cart/add/{id}")
	public String add(@PathVariable("id") Integer id) {
		cartServiceImpl.add(id);
		return "redirect:/homepage";
	}

	@PostMapping("/cart/update/{id}")
	public String update(@PathVariable("id") Integer id, @RequestParam("qty") String qty) {
		try {
			Integer quantity = Integer.parseInt(qty);
			if (quantity <= 0) {
				return "redirect:/cart/view";
			}
			cartServiceImpl.update(id, quantity);
			return "redirect:/cart/view";
		} catch (Exception e) {
			return "redirect:/cart/view";
		}

	}

	@GetMapping("/cart/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		cartServiceImpl.remove(id);
		return "redirect:/cart/view";
	}

	@RequestMapping("/cart/clear")
	public String clear() {
		cartServiceImpl.clear();
		return "redirect:/cart/view";
	}
	
}
