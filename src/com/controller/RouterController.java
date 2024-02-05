package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RouterController {

    @GetMapping("/")
    public String loginController(HttpSession session) {
        if (session.getAttribute("username") != null) {
            // User is logged in, redirect to user home page
            return "redirect:/home";
        } else if (session.getAttribute("adminUsername") != null) {
            // Admin is logged in, redirect to admin home page
            return "redirect:/admin/home";
        } else {
            // No one is logged in, redirect to login page
            return "redirect:/login";
        }
    }
    
    @GetMapping("/submission")
    public String submissionMenu() {
    	return "submission-menu";
    }
}
