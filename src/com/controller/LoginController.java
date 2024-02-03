package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bdUtil.UserDAO;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserDAO loginDao;

    public LoginController(UserDAO loginDao) {
        this.loginDao = new UserDAO();
    }

    @GetMapping
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/validate")
    public String authenticate(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {
        try {
            if (loginDao.validate(username, password)) {
                return "home";
            } else {
                model.addAttribute("error", "Login not successful.");
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred during login.");
            return "login";
        }
    }
}
