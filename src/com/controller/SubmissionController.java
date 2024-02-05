package com.controller;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Electric;
import com.model.Submission;
import com.model.User;
import com.model.Water;

import bdUtil.ElectricDAO;
import bdUtil.RecycleDAO;
import bdUtil.SubmissionDAO;
import bdUtil.WaterDAO;

@Controller
@RequestMapping("/submission")
public class SubmissionController {
	WaterDAO waterDao = new WaterDAO();
	ElectricDAO electricDao = new ElectricDAO();
	RecycleDAO recycleDao = new RecycleDAO();
	SubmissionDAO submissionDao = new SubmissionDAO();

	@RequestMapping("/leaderboard")
	public ModelAndView leaderboard(HttpServletRequest request) {
	    ModelAndView mav = new ModelAndView("leaderboard");

	    try {
	        // Retrieve all submissions
	        List<Submission> submissions = submissionDao.getAllSubmissions();

	        // Sort the list in decreasing order based on the total result
	        submissions.sort(Comparator.comparingDouble(Submission::calculateTotalResult).reversed());

	        // Add the sorted list to the ModelAndView
	        mav.addObject("submissions", submissions);

	    } catch (Exception e) {
	        e.printStackTrace();
	        mav.addObject("error", "An unexpected error occurred");
	    }

	    return mav;
	}



	@RequestMapping("/calculateWater")
	public ModelAndView calculateAndFindAverageWater(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("submission");

		try {
			HttpSession sessionUser = request.getSession();
			User user = (User) sessionUser.getAttribute("user");

			List<Water> allWaterSubmissions = waterDao.getWaterByUser(user);

			if (allWaterSubmissions.isEmpty()) {
				mav.addObject("error", "No water submissions found");
				return mav;
			}

			double totalCalculatedValue = 0.0;

			for (Water water : allWaterSubmissions) {
				double calculatedValue = calculateValueWater(water.getProratedFactor());
				totalCalculatedValue += calculatedValue;
			}

			double averageValue = totalCalculatedValue / allWaterSubmissions.size();
			submissionDao.updateResult(1, averageValue, user);
			mav.addObject("averageValue", averageValue);

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("error", "An unexpected error occurred");
		}

		return mav;
	}

	@RequestMapping("/calculateElectric")
	public ModelAndView calculateAndFindAverageElectric(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("submission");
		ElectricDAO electricDao = new ElectricDAO();
		try {
			HttpSession sessionUser = request.getSession();
			User user = (User) sessionUser.getAttribute("user");
			List<Electric> allElectricSubmissions = electricDao.getElectricByUser(user); // Assuming you have a method
																							// to fetch all submissions

			if (allElectricSubmissions.isEmpty()) {
				mav.addObject("error", "No Electric submissions found");
				return mav;
			}

			double totalCalculatedValue = 0.0;

			for (Electric electric : allElectricSubmissions) {
				double calculatedValue = calculateValueElectric(electric.getProratedFactor()

				);

				totalCalculatedValue += calculatedValue;
			}

			double averageValue = totalCalculatedValue / allElectricSubmissions.size();
			submissionDao.updateResult(2, averageValue, user);
			mav.addObject("averageValue", averageValue);

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("error", "An unexpected error occurred");
		}

		return mav;
	}

	private double calculateValueWater(double consumptionM3) {

		return consumptionM3 * 0.419;
	}

	private double calculateValueElectric(double consumptionKWH) {

		return consumptionKWH * 0.584;
	}
	
	private double calculateValueRecycling(double kiraRecycle) {

		return kiraRecycle * 0.584;
	}

}
