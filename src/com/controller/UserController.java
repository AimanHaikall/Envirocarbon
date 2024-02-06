package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Submission;
import com.model.User;

import bdUtil.HibernateCF;
import bdUtil.SubmissionDAO;

@Controller
public class UserController {

	@GetMapping("/home")
	public ModelAndView userHomePage(HttpSession session) {
		SubmissionDAO submissionDao = new SubmissionDAO();
		ModelAndView mav = new ModelAndView();
		// Check if the user is logged in
		if (session.getAttribute("username") != null) {
			double totalWater = 0;
			double totalElectric = 0;
			double totalRecycle = 0;
			List<Submission> submissions = submissionDao.getAllSubmissions();
			for (Submission submission : submissions) {
				totalWater += submission.getResultWater();
				totalElectric += submission.getResultElectric();
				totalRecycle += submission.getResultRecycle();
			}
			mav.addObject("totalWater", totalWater);
			mav.addObject("totalElectric", totalElectric);
			mav.addObject("totalRecycle", totalRecycle);
			// User is logged in, proceed to user home page
			mav.setViewName("home");
			return mav;
		}
		else if (session.getAttribute("adminUsername") != null) {
			// User is logged in, proceed to user home page
			mav.setViewName("redirect:/admin/home");
			return mav;
		}  else {
			// User is not logged in, redirect to login page or another page
			mav.setViewName("/login");
			return mav;
		}
	}
	

	@GetMapping("/user")
	public String userProfilePage(HttpSession session) {
		// Check if the user is logged in
		if (session.getAttribute("username") != null) {
			// User is logged in, proceed to user home page
			return "editProfile";
		} else {
			// User is not logged in, redirect to login page or another page
			return "/login";
		}
	}

	@GetMapping("/user/email")
	public ModelAndView changeEmail(HttpSession session) {
		ModelAndView model = new ModelAndView("email");
		return model;
		// functions

	}

	@GetMapping("/user/password")
	public ModelAndView changePassword(HttpSession session) {
		ModelAndView model = new ModelAndView("password");
		return model;
	}

	@PostMapping("/user/email")
	public ModelAndView changeEmail(HttpServletRequest request, @RequestParam String email,
			@RequestParam String confirmEmail) {
		ModelAndView modelAndView = new ModelAndView("redirect:/user");

		try {
			HttpSession sessionUser = request.getSession();
			User user = (User) sessionUser.getAttribute("user");

			// Validate User Session
			if (user == null) {
				modelAndView.addObject("error", "User not logged in");
				return modelAndView;
			}

			if (!email.equals(confirmEmail)) {
				modelAndView.addObject("error", "Email and Confirm Email must match.");
				modelAndView.setViewName("changeEmail"); // Show the form again with an error message
				return modelAndView;
			}

			user.setEmail(email);

			// Save the Water instance, which will cascade the save operation to User
			try (Session session = HibernateCF.getSessionFactory().openSession()) {
				session.beginTransaction();
				session.update(user);
				session.getTransaction().commit();
				modelAndView.addObject("message", "Email added successfully");
			} catch (Exception e) {
				// Log the exception
				e.printStackTrace();
				modelAndView.addObject("error", "An error occurred");
			}

		} catch (Exception e) {
			// Log the exception
			e.printStackTrace();
			modelAndView.addObject("error", "An unexpected error occurred");
		}

		return modelAndView;
	}

	@PostMapping("/user/password")
	public ModelAndView changePassword(HttpServletRequest request, @RequestParam String oldPassword,
			@RequestParam String password, @RequestParam String confirmPassword) {
		ModelAndView modelAndView = new ModelAndView("redirect:/user");

		try {
			HttpSession sessionUser = request.getSession();
			User user = (User) sessionUser.getAttribute("user");

			// Validate User Session
			if (user == null) {
				modelAndView.addObject("error", "User not logged in");
				return modelAndView;
			}

			if (!oldPassword.equals(user.getPassword())) {
				modelAndView.addObject("error", "Wrong old password.");
				modelAndView.setViewName("changePassword"); // Show the form again with an error message
				return modelAndView;
			}

			if (!password.equals(confirmPassword)) {
				modelAndView.addObject("error", "Password and Confirm Password must match.");
				modelAndView.setViewName("changePassword"); // Show the form again with an error message
				return modelAndView;
			}

			// Perform additional password validation if needed

			// Update user's password
			user.setPassword(password);

			// Save the User instance with the updated password
			try (Session session = HibernateCF.getSessionFactory().openSession()) {

				session.beginTransaction();
				session.update(user);
				session.getTransaction().commit();
				modelAndView.addObject("message", "Password changed successfully");
			} catch (Exception e) {
				// Log the exception
				e.printStackTrace();
				modelAndView.addObject("error", "An error occurred");
			}

		} catch (Exception e) {
			// Log the exception
			e.printStackTrace();
			modelAndView.addObject("error", "An unexpected error occurred");
		}

		return modelAndView;
	}

	@PostMapping("/user")
	public ModelAndView updateProfile(HttpServletRequest request, @RequestParam String name, @RequestParam String username,
			@RequestParam String phoneNum) {
		{
			ModelAndView modelAndView = new ModelAndView("redirect:/user");

			try {
				HttpSession sessionUser = request.getSession();
				User user = (User) sessionUser.getAttribute("user");

				// Validate User Session
				if (user == null) {
					modelAndView.addObject("error", "User not logged in");
					return modelAndView;
				}

				// Save the User instance with the updated password
				try (Session session = HibernateCF.getSessionFactory().openSession()) {

					// Update only non-null fields
					if (name != null)
						user.setName(name);
					if (username != null)
						user.setUsername(username);
					if (phoneNum != null)
						user.setPhoneNum(phoneNum);

					session.beginTransaction();
					session.update(user);
					session.getTransaction().commit();
					session.close();

					// Redirect to "/user/getAll" with success message
					modelAndView.addObject("message", "User (ID: " + user.getId() + ") updated successfully!");
					modelAndView.setViewName("editProfile");

					session.beginTransaction();
					session.update(user);
					session.getTransaction().commit();
					modelAndView.addObject("message", "Password changed successfully");
				} catch (Exception e) {
					// Log the exception
					e.printStackTrace();
					modelAndView.addObject("error", "An error occurred");
				}

			} catch (Exception e) {
				// Log the exception
				e.printStackTrace();
				modelAndView.addObject("error", "An unexpected error occurred");
			}

			return modelAndView;

		}
	}
}
