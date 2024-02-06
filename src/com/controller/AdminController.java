package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Electric;
import com.model.Recycle;
import com.model.Submission;
import com.model.Water;

import bdUtil.ElectricDAO;
import bdUtil.RecycleDAO;
import bdUtil.SubmissionDAO;
import bdUtil.UserDAO;
import bdUtil.WaterDAO;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
	UserDAO userDao = new UserDAO();
	WaterDAO waterDao = new WaterDAO();
	ElectricDAO electricDao = new ElectricDAO();
	RecycleDAO recycleDao = new RecycleDAO();
	SubmissionDAO submissionDao = new SubmissionDAO();

	@GetMapping("/admin/home")
	public ModelAndView adminHomePage(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// Check if the admin is logged in
		if (session.getAttribute("adminUsername") != null) {
			// Admin is logged in, proceed to admin home page
			long totalUser = userDao.getTotalUser();
			List<Water> allWater = waterDao.getAllWater();
			List<Electric> allElectric = electricDao.getAllElectric();
			List<Recycle> allRecycle = recycleDao.getAllRecycle();
			List<Submission> submissions = submissionDao.getAllSubmissions();
			int sizeWater = allWater.size();
			int sizeElectric = allElectric.size();
			int sizeRecycle = allRecycle.size();
			int sizeSubmissions = submissions.size();
			double totalWater = 0;
			double totalElectric = 0;
			double totalRecycle = 0;
			for (Submission submission : submissions) {
				totalWater += submission.getResultWater();
				totalElectric += submission.getResultElectric();
				totalRecycle += submission.getResultRecycle();
			}
			
			mav.addObject("submissions", submissions);
			mav.addObject("totalUser", totalUser);
			mav.addObject("sizeWater", sizeWater);
			mav.addObject("sizeElectric", sizeElectric);
			mav.addObject("sizeRecycle", sizeRecycle);
			mav.addObject("totalWater", totalWater);
			mav.addObject("totalElectric", totalElectric);
			mav.addObject("totalRecycle", totalRecycle);
			mav.addObject("sizeSubmissions", sizeSubmissions);
			mav.addObject("totalUser", totalUser);

			mav.setViewName("/admin/home");
			return mav;
		} else {
			// Admin is not logged in, redirect to login page or another page
			mav.setViewName("/login");
			return mav;
		}
	}
}
