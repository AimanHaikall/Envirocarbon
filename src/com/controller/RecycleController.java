package com.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Recycle;
import com.model.User;

import bdUtil.RecycleDAO;
import bdUtil.UserDAO;

@Controller
@RequestMapping("/recycle")
public class RecycleController {
	private RecycleDAO recycleDAO = new RecycleDAO();
	private UserDAO userDAO = new UserDAO();

	public RecycleController(RecycleDAO recycleDAO, UserDAO userDAO) {
		super();
		this.recycleDAO = recycleDAO;
		this.userDAO = userDAO;
	}
	
	@RequestMapping("/home")
	public ModelAndView recycleHome() {
		ModelAndView model = new ModelAndView("recycle");
		User user = userDAO.getCurrentUser();
		List<Recycle> recycleList = new ArrayList<>();
		recycleList = recycleDAO.getRecycleById(user);
		
		model.addObject("recycleList", recycleList);
		
		return model;
	}
	
	@RequestMapping("/form")
	public ModelAndView recycleForm() {
		ModelAndView model = new ModelAndView("recycleForm");
		
		return model;
	}
	
	@RequestMapping("/save")
	public ModelAndView save(@RequestParam ("weightKg") double weightKg, @RequestParam ("weightRm") double weightRm, @RequestParam ("month") Date month) {
		ModelAndView model = new ModelAndView("recycle");
		
		try {
            recycleDAO.save(weightKg, weightRm, month);
            model.addObject("message", "recycle has been saved");
        } catch (Exception e) {
            model.addObject("error", "An error occurred during save recycle.");
        }
		
		
		return model;
	}
	
}
