package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Water;

import bdUtil.HibernateCF;

@Controller
@RequestMapping("/water")
public class WaterController {
	
	@GetMapping("/list")
	public String addWater() {
	    return "water";
	}
	
	@RequestMapping("/add")
	public ModelAndView addPost(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("waterForm");
	    
	    return modelAndView;
	}
	
	@PostMapping("/add")
	public ModelAndView addWater(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("redirect:/water/list");

	    try {

	    	String dn = request.getParameter("days");
	        int daysNum = Integer.parseInt(dn);
	        String pf = request.getParameter("prorated");
	        double proratedFactor = Double.parseDouble(pf);
	        String cm = request.getParameter("m3");
	        double consumptionM3 = Double.parseDouble(cm);
	        String cr = request.getParameter("rm");
	        double consumptionRM = Double.parseDouble(cr);
	        String month = request.getParameter("month");

	        Water water = new Water();
	        water.setDaysNum(daysNum);
	        water.setProratedFactor(proratedFactor);
	        water.setConsumptionM3(consumptionM3);
	        water.setConsumptionRM(consumptionRM);
	        water.setMonth(month);
	        
	        modelAndView.addObject("water", water);
	        
	        Session session = HibernateCF.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(water);
	        session.getTransaction().commit();
	        session.close();

	        modelAndView.addObject("message", "Program added successfully");

	    } catch (Exception e) {
	        e.printStackTrace();
	        modelAndView.addObject("error", "An error occurred while adding the program");
	    }
	    
	    return modelAndView;}
}
