package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouterController {

    private boolean isLoggedIn = false;

    @GetMapping("/")
    public String loginController() {
        return isLoggedIn ? "redirect:/home" : "redirect:/login";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}
