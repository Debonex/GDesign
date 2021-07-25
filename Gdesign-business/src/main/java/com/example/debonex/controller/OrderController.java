package com.example.debonex.controller;

import com.example.debonex.pojo.GResponse;
import com.example.debonex.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/selectOrderList")
    public GResponse selectOrderList(@RequestParam int currentPage) {
        return orderService.selectOrderPage(currentPage);
    }
}
