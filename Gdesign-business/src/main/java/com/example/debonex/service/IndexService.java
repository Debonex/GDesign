package com.example.debonex.service;

import com.example.debonex.controller.IndexController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
    @Autowired
    IndexController indexController;
}
