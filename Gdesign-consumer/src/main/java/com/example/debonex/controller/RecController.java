package com.example.debonex.controller;

import com.example.debonex.service.RecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Debonex
 * @date 2021年6月21日
 */
@RestController
@RequestMapping("/rec")
public class RecController {

    @Autowired
    RecService recService;

    @RequestMapping("/contentBase")
    public Object getContentBase(){
        return recService.contentBase(1);
    }

}
