package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;
import com.model.Water;
import com.model.Electric;

import bdUtil.ElectricDAO;
import bdUtil.HibernateCF;

@Controller
@RequestMapping("/electric")
public class ElectricController {

	@GetMapping("/list")
    public ModelAndView getAll(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("electric");
        ElectricDAO electricDao = new ElectricDAO();
        try {
        	HttpSession sessionUser = request.getSession();
	        User user = (User) sessionUser.getAttribute("user");

            // Validate User
            if (user == null) {
                modelAndView.addObject("error", "User not found");
                return modelAndView;
            }

            List<Electric> electricRecords = electricDao.getElectricByUser(user); 
            
            modelAndView.addObject("electricRecords", electricRecords);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("error", "An unexpected error occurred");
        }

        return modelAndView;
    }
	
	@RequestMapping("/add")
	public ModelAndView addPost(HttpServletRequest request) {
	    ModelAndView modelAndView = new ModelAndView("electricForm");

	    return modelAndView;
	}

	@PostMapping("/add")
	public ModelAndView addElectric(HttpServletRequest request,HttpSession session1) {
	    ModelAndView modelAndView = new ModelAndView("redirect:/electric/list");

	    try {
	        HttpSession sessionUser = request.getSession();
	        User user = (User) sessionUser.getAttribute("user");

	        if (user == null) {
	            modelAndView.addObject("error", "User not logged in");
	            return modelAndView;
	        }

	        String dn = request.getParameter("days");
	        String pf = request.getParameter("prorated");
	        String kwh = request.getParameter("kwh");
	        String cr = request.getParameter("rm");
	        String month = request.getParameter("month");

	        if (dn == null || dn.isEmpty() || pf == null || pf.isEmpty()
	                || kwh == null || kwh.isEmpty() || cr == null || cr.isEmpty() || month == null || month.isEmpty()) {
	            modelAndView.addObject("error", "All fields are required");
	            return modelAndView;
	        }

	        int daysNum = Integer.parseInt(dn);
	        double proratedFactor = Double.parseDouble(pf);
	        double consumptionkwh = Double.parseDouble(kwh);
	        double consumptionRM = Double.parseDouble(cr);

	        Electric electric = new Electric();
	        electric.setDaysNum(daysNum);
	        electric.setProratedFactor(proratedFactor);
	        electric.setConsumptionKWH(consumptionkwh);
	        electric.setConsumptionRM(consumptionRM);
	        electric.setMonth(month);
	        electric.setUser(user);

//	        user.addElectric(electric);

	        try (Session session = HibernateCF.getSessionFactory().openSession()) {

	            session.beginTransaction();
	            session.save(electric);
//	            session.update(user);
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
	    ModelAndView modelAndView = new ModelAndView("electricFormUpdate");

	    try {
	        Session session = HibernateCF.getSessionFactory().openSession();
	        Electric electric = session.get(Electric.class, id);
	        session.close();

	        if (electric != null) {
	            modelAndView.addObject("electric", electric);
	        } else {
	            modelAndView.addObject("error", "Electric record not found");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        modelAndView.addObject("error", "An error occurred while fetching the electric record");
	    }

	    return modelAndView;
	}
	
	@PostMapping("/update/{id}")
	public ModelAndView updateElectric(@PathVariable int id, HttpServletRequest request) {
	    ModelAndView modelAndView = new ModelAndView("redirect:/electric/list");

	    try {
	        Session session = HibernateCF.getSessionFactory().openSession();
	        session.beginTransaction();

	        Electric electric = session.get(Electric.class, id);

	        if (electric != null) {
	            String dn = request.getParameter("days");
	            int daysNum = Integer.parseInt(dn);
	            String pf = request.getParameter("prorated");
	            double proratedFactor = Double.parseDouble(pf);
	            String kwh = request.getParameter("kwh");
	            double consumptionKWH = Double.parseDouble(kwh);
	            String cr = request.getParameter("rm");
	            double consumptionRM = Double.parseDouble(cr);
	            String month = request.getParameter("month");

	            electric.setDaysNum(daysNum);
	            electric.setProratedFactor(proratedFactor);
	            electric.setConsumptionKWH(consumptionKWH);
	            electric.setConsumptionRM(consumptionRM);
	            electric.setMonth(month);

	            session.update(electric);
	            session.getTransaction().commit();
	            session.close();

	            modelAndView.addObject("message", "Electric record updated successfully");
	        } else {
	            modelAndView.addObject("error", "Electric record not found");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        modelAndView.addObject("error", "An error occurred while updating the electric record");
	    }

	    return modelAndView;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteElectric(@PathVariable int id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/electric/list");
		
		try {
	        Session session = HibernateCF.getSessionFactory().openSession();
	        session.beginTransaction();

	        Electric electric = session.get(Electric.class, id);

	        if (electric != null) {

	            session.delete(electric);
	            session.getTransaction().commit();
	            session.close();

	            mav.addObject("message", "Electric record deleted successfully");
	        } else {
	            mav.addObject("error", "Electric record not found");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        mav.addObject("error", "An error occurred while deleting the electric record");
	    }
		
		return mav;
	}
	
	
}