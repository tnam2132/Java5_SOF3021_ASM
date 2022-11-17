package java5_sof3021_assignment.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java5_sof3021_assignment.entity.Account;
import java5_sof3021_assignment.service.AccountService;
import java5_sof3021_assignment.service.CookieService;
import java5_sof3021_assignment.service.ParamService;
import java5_sof3021_assignment.service.SessionService;

@Controller
public class AccountController {
	@Autowired
	CookieService cookieService;
	@Autowired
	ParamService paramService;
	@Autowired
	SessionService sessionService;
	@Autowired
	AccountService accountService;
	@Autowired
	HttpServletResponse httpServletResponse;

//	Quản lý tài khoản
	@GetMapping("login/form")
	public String loginForm(Model model) {
		Account account = new Account();
		account.setFullname("1");
		account.setEmail("1");
		account.setPhoto("1");
		model.addAttribute("account", account);
		return "account_management/login";
	}

	@PostMapping("login")
	public String login(Model model, @Valid @ModelAttribute("account") Account account, BindingResult bindingResult) throws ServletException, IOException {
		if (!bindingResult.hasErrors()) {
			String un = paramService.getString("username", "");
			String pw = paramService.getString("password", "");
			boolean rm = paramService.getBoolean("remember");
			List<Account> accounts = accountService.getAll();
			boolean loginSuccessful = false;
			for (Account account1 : accounts) {
				if (un.equalsIgnoreCase(account1.getUsername()) && pw.equalsIgnoreCase(account1.getPassword())) {
					sessionService.set("username", un);
					sessionService.set("role", account1.getAdmin());
					loginSuccessful = true;
					if (rm == true) {
						cookieService.add("user", un, 10);
						System.out.println("Nhớ tài khoản");
					} else {
						cookieService.remove("user");
						System.out.println("Xóa tài khoản nhớ");
					}
				}
			}
			if (loginSuccessful == true) {
				System.out.println("Đăng nhập thành công");
				return "redirect:/homepage";
			} else {
				System.out.println("Đăng nhập thất bại");
				return "account_management/login";
			}
		}
		return "account_management/login";
	}

	@GetMapping("logout")
	public String logout(Model model) {
		sessionService.remove("username");
		sessionService.remove("role");
		System.out.println("Đăng xuất thành công");
		return "redirect:/login/form";
	}

	@GetMapping("register/form")
	public String registerForm(Model model, @ModelAttribute("account") Account account) {
		Account account1 = new Account();
		account1.setPhoto("1");
		model.addAttribute("account", account1);	
		return "account_management/register";
	}

	@PostMapping("register")
	public String register(Model model, @Valid @ModelAttribute("account") Account account,
			BindingResult bindingResult) {
		System.out.println(bindingResult.hasErrors());
		if (!bindingResult.hasErrors()) {
			account.setActivated(0);
			account.setAdmin(1);
			accountService.create(account);
			System.out.println("Đăng ký thành công");
			return "redirect:/login/form";
		}
		return "account_management/register";
	}

//	Quản lý dữ liệu tài khoản
	@GetMapping("/account/view")
	public String view(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 8);
		Page<Account> page = accountService.getAll(pageable);
		model.addAttribute("pages", page);
		model.addAttribute("url", "view");
		return "account_qldl/account_view";
	}

	@PostMapping("account/search")
	public String searchAndPage(Model model, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(sessionService.get("keywords"));
		sessionService.set("keywords", kwords);
		Pageable pageable = PageRequest.of(p.orElse(0), 8);
		Page<Account> page = accountService.findByUsername("%" + kwords + "%", pageable);
		model.addAttribute("pages", page);
		model.addAttribute("url", "search");
		return "account_qldl/account_view";
	}

	@GetMapping("account/create")
	public String insert(Model model) {
		Account account = new Account();
		account.setAdmin(0);
		model.addAttribute("account", account);
		return "account_qldl/account_insert";
	}

	@PostMapping("account/create_account")
	public String create(Model model, @Valid @ModelAttribute("account") Account account, BindingResult bindingResult) {
		account.setActivated(0);
		accountService.create(account);
		System.out.println("create TC");
		return "redirect:/account/view";
	}

	@GetMapping(value = "account/update", params = "id")
	public String update(Model model, @RequestParam("id") Integer id) {
		if (id == 0) {
			Account account = accountService.findByUsername(sessionService.get("username"));
			model.addAttribute("account", account);
			return "account_qldl/account_update";
		}
		Account acc = accountService.findById(id);
		model.addAttribute("account", acc);
		return "account_qldl/account_update";
	}

	@PostMapping("account/update_account")
	public String update(Model model, @ModelAttribute("account") Account account) {
		accountService.update(account);
		System.out.println("update thành công");
		return "redirect:/account/view";
	}

	@GetMapping(value = "account/delete", params = "id")
	public String delete(Model model, @RequestParam("id") Integer id) {
		accountService.delete(id);
		System.out.println("Xóa thành công");
		return "redirect:/account/view";
	}

//	Đổi mật khẩu
	@GetMapping("account/change_password_form")
	public String changePasswordForm(Model model) {
		Account account = new Account();
		model.addAttribute("account", account);
		return "account_management/change_password";
	}

	@PostMapping("account/change_password")
	public String changePassword(Model model, @ModelAttribute("account") Account account,
			@ModelAttribute("new_password") String newPassword,
			@ModelAttribute("re_new_password") String reNewPassword) {
		Account account2 = accountService.findByUsername(sessionService.get("username"));
		if (account.getPassword().equalsIgnoreCase(account2.getPassword())) {
			if (newPassword.equalsIgnoreCase(reNewPassword)) {
				account2.setPassword(newPassword);
				accountService.update(account2);
				System.out.println("Đổi mật khẩu thành công");
			} else {
				System.out.println("Nhập lại mật khẩu không trùng khớp");
				return "redirect:/account/change_password_form";
			}
		} else {
			System.out.println("Mật khẩu người dùng sai");
			return "redirect:/account/change_password_form";
		}
		return "redirect:/homepage";
	}
}
