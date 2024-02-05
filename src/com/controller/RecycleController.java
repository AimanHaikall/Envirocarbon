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
import com.model.Recycle;

import bdUtil.HibernateCF;
import bdUtil.RecycleDAO;

@Controller
@RequestMapping("/recycle")
public class RecycleController {
	
	@Transactional
	@GetMapping("/list")
    public ModelAndView getAll(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("recycle");
        RecycleDAO recycleDao = new RecycleDAO();
        try {
        	HttpSession sessionUser = request.getSession();
	        User user = (User) sessionUser.getAttribute("user");

            // Validate User
            if (user == null) {
                modelAndView.addObject("error", "User not found");
                return modelAndView;
            }
            
           
            List<Recycle> recycleRecords = recycleDao.getRecycleByUser(user);

            
            modelAndView.addObject("recycleRecords", recycleRecords);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("error", "An unexpected error occurred");
        }

        return modelAndView;
    }

	
	
	@RequestMapping("/add")
	public ModelAndView addPost(HttpServletRequest request) {
	    ModelAndView modelAndView = new ModelAndView("recycleForm");

	    return modelAndView;
	}

	@PostMapping("/add")
	public ModelAndView addRecycle(HttpServletRequest request,HttpSession session1) {
	    ModelAndView modelAndView = new ModelAndView("redirect:/recycle/list");

	    try {
	        HttpSession sessionUser = request.getSession();
	        User user = (User) sessionUser.getAttribute("user");

	        // Validate User Session
	        if (user == null) {
	            modelAndView.addObject("error", "User not logged in");
	            return modelAndView;
	        }

	        String wkg = request.getParameter("weightKg");
	        String wrm = request.getParameter("weightRm");
	        String month = request.getParameter("month");

	        if (wkg == null || wkg.isEmpty() || wrm == null || wrm.isEmpty() || month == null || month.isEmpty()) {
	            modelAndView.addObject("error", "All fields are required");
	            return modelAndView;
	        }

	        double weightKg = Double.parseDouble(wkg);
	        double weightRm= Double.parseDouble(wrm);

	        Recycle recycle= new Recycle();
	        recycle.setWeightKg(weightKg);
	        recycle.setWeightRm(weightRm);
	        recycle.setMonth(month);
	        recycle.setUser(user);

	        // Save the Water instance, which will cascade the save operation to User
	        try (Session session = HibernateCF.getSessionFactory().openSession()) {
	            session.beginTransaction();
	            session.save(recycle);
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
	    ModelAndView modelAndView = new ModelAndView("recycleFormUpdate");

	    try {
	        Session session = HibernateCF.getSessionFactory().openSession();
	        Recycle recycle = session.get(Recycle.class, id);
	        session.close();

	        if (recycle != null) {
	            modelAndView.addObject("recycle", recycle);
	        } else {
	            modelAndView.addObject("error", "Recycle record not found");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        modelAndView.addObject("error", "An error occurred while fetching the recycle record");
	    }

	    return modelAndView;
	}
	
	@PostMapping("/update/{id}")
	public ModelAndView updateRecycle(@PathVariable int id, HttpServletRequest request) {
	    ModelAndView modelAndView = new ModelAndView("redirect:/recycle/list");

	    try {
	        Session session = HibernateCF.getSessionFactory().openSession();
	        session.beginTransaction();

	        Recycle recycle = session.get(Recycle.class, id);

	        if (recycle != null) {
	            String wkg = request.getParameter("weightKg");
	            double weightKg = Double.parseDouble(wkg);
	            String wrm = request.getParameter("weightRm");
	            double weightRm = Double.parseDouble(wrm);
	            String month = request.getParameter("month");

	            recycle.setWeightKg(weightKg);
	            recycle.setWeightRm(weightRm);
	            recycle.setMonth(month);

	            session.update(recycle);
	            session.getTransaction().commit();
	            session.close();

	            modelAndView.addObject("message", "Recycle record updated successfully");
	        } else {
	            modelAndView.addObject("error", "Recycle record not found");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        modelAndView.addObject("error", "An error occurred while updating the recycle record");
	    }

	    return modelAndView;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteRecycle(@PathVariable int id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/recycle/list");
		
		try {
	        Session session = HibernateCF.getSessionFactory().openSession();
	        session.beginTransaction();

	        Recycle recycle = session.get(Recycle.class, id);

	        if (recycle != null) {

	            session.delete(recycle);
	            session.getTransaction().commit();
	            session.close();

	            mav.addObject("message", "Recycle record deleted successfully");
	        } else {
	            mav.addObject("error", "Recycle record not found");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        mav.addObject("error", "An error occurred while deleting the recycle record");
	    }
		
		return mav;
	}
	
	
}
