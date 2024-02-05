package com.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Electric;
import com.model.User;
import com.model.Water;

import bdUtil.HibernateCF;
import bdUtil.WaterDAO;

@Controller
@RequestMapping("/water")
public class WaterController {
	
	

//	@GetMapping("/list")
//	public String addWater() {
//	    return "water";
//	}
	@Transactional
	@GetMapping("/list")
    public ModelAndView getAll(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("water");
        WaterDAO waterDao = new WaterDAO();
        try {
        	HttpSession sessionUser = request.getSession();
	        User user = (User) sessionUser.getAttribute("user");

            // Validate User
            if (user == null) {
                modelAndView.addObject("error", "User not found");
                return modelAndView;
            }
            
           
            List<Water> waterRecords = waterDao.getWaterByUser(user);

            
            modelAndView.addObject("waterRecords", waterRecords);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("error", "An unexpected error occurred");
        }

        return modelAndView;
    }

	
	
	@RequestMapping("/add")
	public ModelAndView addPost(HttpServletRequest request) {
	    ModelAndView modelAndView = new ModelAndView("waterForm");

	    return modelAndView;
	}

	@PostMapping("/add")
	public ModelAndView addWater(HttpServletRequest request,HttpSession session1) {
	    ModelAndView modelAndView = new ModelAndView("redirect:/water/list");

	    try {
	        HttpSession sessionUser = request.getSession();
	        User user = (User) sessionUser.getAttribute("user");

	        // Validate User Session
	        if (user == null) {
	            modelAndView.addObject("error", "User not logged in");
	            return modelAndView;
	        }

	        String dn = request.getParameter("days");
	        String pf = request.getParameter("prorated");
	        String cm = request.getParameter("m3");
	        String cr = request.getParameter("rm");
	        String month = request.getParameter("month");

	        if (dn == null || dn.isEmpty() || pf == null || pf.isEmpty()
	                || cm == null || cm.isEmpty() || cr == null || cr.isEmpty() || month == null || month.isEmpty()) {
	            modelAndView.addObject("error", "All fields are required");
	            return modelAndView;
	        }

	        int daysNum = Integer.parseInt(dn);
	        double proratedFactor = Double.parseDouble(pf);
	        double consumptionM3 = Double.parseDouble(cm);
	        double consumptionRM = Double.parseDouble(cr);

	        Water water = new Water();
	        water.setDaysNum(daysNum);
	        water.setProratedFactor(proratedFactor);
	        water.setConsumptionM3(consumptionM3);
	        water.setConsumptionRM(consumptionRM);
	        water.setMonth(month);
	        water.setUser(user);

	        // Save the Water instance, which will cascade the save operation to User
	        try (Session session = HibernateCF.getSessionFactory().openSession()) {
	            session.beginTransaction();
	            session.save(water);
	            session.getTransaction().commit();
	            modelAndView.addObject("message", "Program added successfully");
	        } catch (Exception e) {
	            // Log the exception
	            e.printStackTrace();
	            modelAndView.addObject("error", "An error occurred while adding the program");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        modelAndView.addObject("error", "An unexpected error occurred");
	    }

	    return modelAndView;
	}




	
	@RequestMapping("/update/{id}")
	public ModelAndView updatePost(@PathVariable int id, HttpServletRequest request) {
	    ModelAndView modelAndView = new ModelAndView("waterFormUpdate");

	    try {
	        Session session = HibernateCF.getSessionFactory().openSession();
	        Water water = session.get(Water.class, id);
	        session.close();

	        if (water != null) {
	            modelAndView.addObject("water", water);
	        } else {
	            modelAndView.addObject("error", "Water record not found");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        modelAndView.addObject("error", "An error occurred while fetching the water record");
	    }

	    return modelAndView;
	}
	
	@PostMapping("/update/{id}")
	public ModelAndView updateWater(@PathVariable int id, HttpServletRequest request) {
	    ModelAndView modelAndView = new ModelAndView("redirect:/water/list");

	    try {
	        Session session = HibernateCF.getSessionFactory().openSession();
	        session.beginTransaction();

	        Water water = session.get(Water.class, id);

	        if (water != null) {
	            String dn = request.getParameter("days");
	            int daysNum = Integer.parseInt(dn);
	            String pf = request.getParameter("prorated");
	            double proratedFactor = Double.parseDouble(pf);
	            String cm = request.getParameter("m3");
	            double consumptionM3 = Double.parseDouble(cm);
	            String cr = request.getParameter("rm");
	            double consumptionRM = Double.parseDouble(cr);
	            String month = request.getParameter("month");

	            water.setDaysNum(daysNum);
	            water.setProratedFactor(proratedFactor);
	            water.setConsumptionM3(consumptionM3);
	            water.setConsumptionRM(consumptionRM);
	            water.setMonth(month);

	            session.update(water);
	            session.getTransaction().commit();
	            session.close();

	            modelAndView.addObject("message", "Water record updated successfully");
	        } else {
	            modelAndView.addObject("error", "Water record not found");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        modelAndView.addObject("error", "An error occurred while updating the water record");
	    }

	    return modelAndView;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteWater(@PathVariable int id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/water/list");
		
		try {
	        Session session = HibernateCF.getSessionFactory().openSession();
	        session.beginTransaction();

	        Water water = session.get(Water.class, id);

	        if (water != null) {

	            session.delete(water);
	            session.getTransaction().commit();
	            session.close();

	            mav.addObject("message", "Water record deleted successfully");
	        } else {
	            mav.addObject("error", "Water record not found");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        mav.addObject("error", "An error occurred while deleting the water record");
	    }
		
		return mav;
	}
	
	
	
	
	
}
