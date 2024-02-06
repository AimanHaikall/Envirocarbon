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

import com.model.Submission;

import bdUtil.HibernateCF;
import bdUtil.SubmissionDAO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/admin/submission")
public class AdminSubmissionController {

	@GetMapping
	public String submissionAccount(HttpSession session) {
		if (session.getAttribute("adminUsername") == null) {
			return "/login";
		}
		return "redirect:/admin/submission/getAll";
	}

	@RequestMapping("/getAll")
	public ModelAndView getAll() {
		ModelAndView modelAndView = new ModelAndView("admin/submission");
		Session session = HibernateCF.getSessionFactory().openSession();

		@SuppressWarnings("unchecked")
		List<Submission> pList = session.createQuery("from Submission").list();

		if (pList.isEmpty()) {
		    // Handle the case when the list is empty
		    modelAndView.addObject("errorMessage", "No submissions found.");
		} else {
		    // Add the list to the model when it's not empty
		    modelAndView.addObject("submissions", pList);
		}

		modelAndView.addObject("currentView", "getAll");
		return modelAndView;

	}

	@RequestMapping("/getById")
	public ModelAndView getById(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/submission");

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Session session = HibernateCF.getSessionFactory().openSession();
			Submission p = session.get(Submission.class, id);

			if (p != null) {
				List<Submission> submissionList = new ArrayList<>();
				submissionList.add(p);
				modelAndView.addObject("submissions", submissionList);
				modelAndView.addObject("currentView", "getById");
			} else {
				modelAndView.addObject("message", "Submission with ID " + id + " does not exist.");
				modelAndView.setViewName("redirect:/admin/submission/getAll");
			}
		} catch (NumberFormatException e) {
			modelAndView.addObject("message", "Invalid format!");
			modelAndView.setViewName("redirect:/admin/submission/getAll");
		}

		return modelAndView;
	}

	@PostMapping("/update")
	public ModelAndView updateSubmission(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/submission");

		String idParam = request.getParameter("id");
		double resultWater = 0;
		double resultElectric = 0;
		double resultRecycle = 0;
		
		String newResultWaterParam = request.getParameter("newResultWater");
		String newResultElectricParam = request.getParameter("newResultElectric");
		String newResultRecycleParam = request.getParameter("newResultRecycle");

		if (!newResultWaterParam.isEmpty()) {
		    resultWater = Double.parseDouble(newResultWaterParam);
		}

		if (!newResultElectricParam.isEmpty()) {
		    resultElectric = Double.parseDouble(newResultElectricParam);
		}

		if (!newResultRecycleParam.isEmpty()) {
		    resultRecycle = Double.parseDouble(newResultRecycleParam);
		}
		
		modelAndView.addObject("currentView", "update");

		try {
			int id = Integer.parseInt(idParam);

			Session session = HibernateCF.getSessionFactory().openSession();
			Submission submission = session.get(Submission.class, id);

			if (resultWater > 0 || resultElectric > 0 || resultRecycle > 0) {

				// Update only non-null fields
				if (resultWater > 0 )
					submission.setResultWater(resultWater);
				if (resultElectric > 0 )
					submission.setResultElectric(resultElectric);
				if (resultRecycle > 0 )
					submission.setResultRecycle(resultRecycle);


				session.beginTransaction();
				session.update(submission);
				session.getTransaction().commit();
				session.close();

				// Redirect to "/submission/getAll" with success message
				modelAndView.addObject("message", "Submission (ID: " + id + ") updated successfully!");
				modelAndView.setViewName("redirect:/admin/submission/getAll");

			}
		} catch (NumberFormatException e) {
			e.printStackTrace(); // Print the exception details
			modelAndView.addObject("message", "Invalid format!");
			modelAndView.setViewName("redirect:/admin/submission/getAll");
		}

		return modelAndView;
	}

	@GetMapping("/update")
	public ModelAndView detailSubmission(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/submission");

		modelAndView.addObject("currentView", "update");

		try {
			Session session = HibernateCF.getSessionFactory().openSession();

			// Submission with the given ID doesn't exist, show details for the update form
			Submission inst = session.get(Submission.class, Integer.parseInt(request.getParameter("id")));

			List<Submission> submissionList = new ArrayList<>();
			submissionList.add(inst);

			modelAndView.addObject("idParam", Integer.parseInt(request.getParameter("id")));
			modelAndView.addObject("submissions", submissionList);

		} catch (NumberFormatException e) {
			e.printStackTrace(); // Print the exception details
			modelAndView.addObject("message", "Invalid format!");
			modelAndView.setViewName("redirect:/admin/submission/getAll");
		}

		return modelAndView;
	}

	@RequestMapping("/delete")
	public ModelAndView deleteSubmission(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/submission/getAll");

		Session session = HibernateCF.getSessionFactory().openSession();
		Submission submission = session.get(Submission.class, id);

		if (submission != null) {
			session.beginTransaction();
			session.delete(submission);
			session.getTransaction().commit();
			session.close();

			modelAndView.addObject("message", "Submission (ID: " + id + ") deleted successfully!");
		} else {
			modelAndView.addObject("message", "Submission with ID " + id + " does not exist.");
		}

		modelAndView.addObject("currentView", "delete");

		return modelAndView;
	}
	
	@RequestMapping("/leaderboard")
	public ModelAndView getAllLeaderboard() {
		SubmissionDAO submissionDao = new SubmissionDAO();
		ModelAndView modelAndView = new ModelAndView("admin/leaderboard");
		Session session = HibernateCF.getSessionFactory().openSession();

		List<Submission> submissions = submissionDao.getAllSubmissions();

        // Sort the list in decreasing order based on the total result
        submissions.sort(Comparator.comparingDouble(Submission::calculateTotalResult).reversed());

		if (submissions.isEmpty()) {
		    // Handle the case when the list is empty
		    modelAndView.addObject("errorMessage", "No submissions found.");
		} else {
		    // Add the list to the model when it's not empty
		    modelAndView.addObject("submissions", submissions);
		}

		modelAndView.addObject("currentView", "getAll");
		return modelAndView;
	}
}