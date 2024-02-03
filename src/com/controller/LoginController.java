package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bdUtil.UserDAO;

@Controller
@RequestMapping("/login")
public class LoginController {

	private final UserDAO loginDao;

	public LoginController() {
		this.loginDao = new UserDAO();
	}

	@GetMapping
	public String showLoginForm() {
		return "login";
	}

	@PostMapping()
	public ModelAndView authenticate(@RequestParam("username") String username,
			@RequestParam("password") String password, Model model) {
		ModelAndView modelAndView = new ModelAndView();

		try {
			if (loginDao.validate(username, password)) {
				modelAndView.setViewName("redirect:/home");
			} else {
				model.addAttribute("error", "Login not successful.");
				modelAndView.setViewName("login");
			}
		} catch (Exception e) {
			model.addAttribute("error", "An error occurred during login.");
			modelAndView.setViewName("login");
		}

		return modelAndView;
	}

}
