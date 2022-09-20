package com.deepak.client.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:dashboard";
        }
        return "redirect:home";
    }

    @GetMapping(path = "/dashboard")
    @ResponseBody
    public String dashboard() {
        return "<h1>Welcome to dashboard !!!</h1>";
    }

    @GetMapping(path = "/home")
    @ResponseBody
    public String home() {
        return "<h1>Home Page ! </h1> Go to <a href='/dashboard'>dashboard</a>";
    }

}
