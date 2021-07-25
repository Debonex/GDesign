package com.example.debonex.controller;

import com.example.debonex.pojo.GResponse;
import com.example.debonex.pojo.User;
import com.example.debonex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Debonex
 * @date 2021年6月21日
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/register")
    public GResponse register(@RequestBody User user){
        return userService.register(user);
    }

    @RequestMapping("/login")
    public GResponse login(@RequestBody User user){
        return userService.login(user);
    }
}
