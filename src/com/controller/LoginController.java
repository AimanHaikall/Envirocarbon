package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bdUtil.UserDAO;
import bdUtil.AdminDAO;
import com.model.User;
import com.model.Admin;

@Controller
@RequestMapping("/login")
public class LoginController {

	private final UserDAO userDao;
	private final AdminDAO adminDao;

	public LoginController() {
		this.userDao = new UserDAO();
		this.adminDao = new AdminDAO();
	}

	@GetMapping
	public String showLoginForm(HttpSession session) {
	    // Check if an admin is already authenticated
	    if (session.getAttribute("adminUsername") != null) {
	        return "redirect:/admin/home";
	    }
	    
	    // Check if a user is already authenticated
	    if (session.getAttribute("username") != null) {
	        return "redirect:/home";
	    }

	    // If no one is authenticated, return the login page
	    return "login";
	}


	@PostMapping()
	public ModelAndView authenticate(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session, Model model) {
		ModelAndView modelAndView = new ModelAndView();

		try {
			if (userDao.validate(username, password)) {
				// Retrieve additional user information
				User user = userDao.getUserByUsername(username);

				if (user != null) {
					// Set the authenticated user attributes in the session
					session.setAttribute("username", username);
					session.setAttribute("userid", user.getId());
					session.setAttribute("user", user);

					modelAndView.setViewName("redirect:/home");
					return modelAndView;
				}
			} else if (adminDao.validate(username, password)) {
				// Retrieve additional admin information
				Admin admin = adminDao.getAdminByUsername(username);

				if (admin != null) {
					// Set the authenticated admin attributes in the session
					session.setAttribute("adminUsername", username);
					session.setAttribute("adminid", admin.getId());
					session.setAttribute("admin", admin);

					modelAndView.setViewName("redirect:/admin/home");
				} else {
					model.addAttribute("error", "Failed to retrieve admin information.");
					modelAndView.setViewName("login");
				}
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
