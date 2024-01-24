package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class LoginController {

    private boolean isLoggedIn = false;

    @RequestMapping("/")
    public String loginController(HttpServletRequest request, HttpServletResponse response) {
        if (isLoggedIn) {
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping("/home")
    public String homePage(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }
    
    @RequestMapping("/login")
    public String loginPage(HttpServletRequest request, HttpServletResponse response) {
        return "login";
    }
}
