package com.sahan.spring_security.controller;

import com.sahan.spring_security.model.User;
import com.sahan.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String getHome(){
        return "Successfully Logged in :) ";
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
