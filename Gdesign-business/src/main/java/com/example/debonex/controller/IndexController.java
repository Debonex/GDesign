package com.example.debonex.controller;

import com.example.debonex.pojo.GResponse;
import com.example.debonex.pojo.User;
import com.example.debonex.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Debonet
 */
@RequestMapping("/user")
@RestController
public class IndexController {

    @Autowired
    IndexService indexService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public GResponse login(@RequestBody User user){
        return indexService.login(user);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public GResponse register(@RequestBody User user){
        return indexService.register(user);
    }
}
