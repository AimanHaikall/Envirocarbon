package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @GetMapping("/admin/home")
    public String adminHomePage(HttpSession session) {
        // Check if the admin is logged in
        if (session.getAttribute("adminUsername") != null) {
            // Admin is logged in, proceed to admin home page
            return "admin/home";
        } else {
            // Admin is not logged in, redirect to login page or another page
            return "/login";
        }
    }
}
