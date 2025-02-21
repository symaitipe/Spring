package com.sahan.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vli")
public class UserController {

    @GetMapping("/home")
    public String getHome(){
        return "Successfully Logged in :) ";
    }
}
