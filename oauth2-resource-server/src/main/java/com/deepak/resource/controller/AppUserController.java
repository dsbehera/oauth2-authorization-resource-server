package com.deepak.resource.controller;

import com.deepak.resource.entity.AppUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resource")
public class AppUserController {

    @GetMapping("/users")
    public AppUser[] getAppUsers() {
        return new AppUser[] {
                new AppUser(1l, "deepak", "deepak@admin.com"),
                new AppUser(2l, "shalu", "shalu@admin.com"),
                new AppUser(3l, "rahul", "rahul@admin.com"),
        };
    }
 }
