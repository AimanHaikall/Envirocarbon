package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;

import bdUtil.HibernateCF;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

	@GetMapping
	public String userAccount(HttpSession session) {
		if (session.getAttribute("adminUsername") == null) {
			return "/login";
		}
		return "redirect:/admin/user/getAll";
	}

	@RequestMapping("/getAll")
	public ModelAndView getAll() {
		ModelAndView modelAndView = new ModelAndView("admin/usermanagement");
		Session session = HibernateCF.getSessionFactory().openSession();

		@SuppressWarnings("unchecked")
		List<User> pList = session.createQuery("from User").list();
		for (User user : pList) {
			System.out.println(user);
		}
		modelAndView.addObject("users", pList);
		modelAndView.addObject("currentView", "getAll");

		return modelAndView;
	}

	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/user/getAll");

		Session session = HibernateCF.getSessionFactory().openSession();

		User prog = new User();
		prog.setName(request.getParameter("name"));
		prog.setUsername(request.getParameter("username"));
		prog.setPhoneNum(request.getParameter("phoneNum"));
		prog.setEmail(request.getParameter("email"));
		prog.setPassword(request.getParameter("password"));
		session.beginTransaction();
		session.save(prog);
		session.getTransaction().commit();
		session.close();

		modelAndView.addObject("message", "User added successfully!");
		modelAndView.addObject("currentView", "add");

		return modelAndView;
	}

	@RequestMapping("/getById")
	public ModelAndView getById(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/usermanagement");

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Session session = HibernateCF.getSessionFactory().openSession();
			User p = session.get(User.class, id);

			if (p != null) {
				List<User> userList = new ArrayList<>();
				userList.add(p);
				modelAndView.addObject("users", userList);
				modelAndView.addObject("currentView", "getById");
			} else {
				modelAndView.addObject("message", "User with ID " + id + " does not exist.");
				modelAndView.setViewName("redirect:/admin/user/getAll");
			}
		} catch (NumberFormatException e) {
			modelAndView.addObject("message", "Invalid format!");
			modelAndView.setViewName("redirect:/admin/user/getAll");
		}

		return modelAndView;
	}

	@PostMapping("/update")
	public ModelAndView updateUser(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/usermanagement");

		String idParam = request.getParameter("id");
		String name = request.getParameter("newName");
		String email = request.getParameter("newEmail");
		String phoneNum = request.getParameter("newPhoneNum");
		String username = request.getParameter("newUsername");
		String password = request.getParameter("newPassword");

		modelAndView.addObject("currentView", "update");

		try {
			int id = Integer.parseInt(idParam);

			Session session = HibernateCF.getSessionFactory().openSession();
			User user = session.get(User.class, id);

			if (name != null || email != null || phoneNum != null || username != null || password != null) {

				// Update only non-null fields
				if (name != "")
					user.setName(name);
				if (email != "")
					user.setEmail(email);
				if (phoneNum != "")
					user.setPhoneNum(phoneNum);
				if (username != "")
					user.setUsername(username);
				if (password != "")
					user.setPassword(password);

				session.beginTransaction();
				session.update(user);
				session.getTransaction().commit();
				session.close();

				// Redirect to "/user/getAll" with success message
				modelAndView.addObject("message", "User (ID: " + id + ") updated successfully!");
				modelAndView.setViewName("redirect:/admin/user/getAll");

			}
		} catch (NumberFormatException e) {
			e.printStackTrace(); // Print the exception details
			modelAndView.addObject("message", "Invalid format!");
			modelAndView.setViewName("redirect:/admin/user/getAll");
		}

		return modelAndView;
	}

	@GetMapping("/update")
	public ModelAndView detailUser(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/usermanagement");

		modelAndView.addObject("currentView", "update");

		try {
			Session session = HibernateCF.getSessionFactory().openSession();

			// User with the given ID doesn't exist, show details for the update form
			User inst = session.get(User.class, Integer.parseInt(request.getParameter("id")));

			List<User> userList = new ArrayList<>();
			userList.add(inst);

			modelAndView.addObject("idParam", Integer.parseInt(request.getParameter("id")));
			modelAndView.addObject("users", userList);

		} catch (NumberFormatException e) {
			e.printStackTrace(); // Print the exception details
			modelAndView.addObject("message", "Invalid format!");
			modelAndView.setViewName("redirect:/admin/user/getAll");
		}

		return modelAndView;
	}

	@RequestMapping("/delete")
	public ModelAndView deleteUser(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/user/getAll");

		Session session = HibernateCF.getSessionFactory().openSession();
		User user = session.get(User.class, id);

		if (user != null) {
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
			session.close();

			modelAndView.addObject("message", "User (ID: " + id + ") deleted successfully!");
		} else {
			modelAndView.addObject("message", "User with ID " + id + " does not exist.");
		}

		modelAndView.addObject("currentView", "delete");

		return modelAndView;
	}
}