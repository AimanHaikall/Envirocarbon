package com.controller;

import java.util.function.Supplier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;

import bdUtil.UserDAO;

@Controller
@RequestMapping("/register")
public class RegisterController {

	private final UserDAO registerDao;

	public RegisterController() {
		this.registerDao = new UserDAO();
	}

	@GetMapping
	public String showLoginForm() {
		return "register";
	}

	@PostMapping()
	public ModelAndView register(@RequestParam("name") String name, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("phoneNum") String phoneNum,
			@RequestParam("email") String email, @RequestParam("cpassword") String cpassword, Model model) {
		ModelAndView modelAndView = new ModelAndView();

		try {
			if (password.equals(cpassword)) {
				User newUser = new User();
				newUser.setName(name);
				newUser.setUsername(username);
				newUser.setPassword(password);
				newUser.setPhoneNum(phoneNum);
				newUser.setEmail(email);

				try {
					registerDao.saveUser(newUser);

					modelAndView.setViewName("redirect:/login");
				} catch (Exception e) {
					modelAndView.setViewName("redirect:/register");
				}

			} else {
				model.addAttribute("error", "Passwords do not match.");
				modelAndView.setViewName("register");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "An error occurred during registration.");
			modelAndView.setViewName("register");
		}

		return modelAndView;
	}

}
