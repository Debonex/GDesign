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

    @RequestMapping("/selectOrderPage")
    public GResponse selectOrderPage(@RequestParam int currentPage, @RequestParam int perPage, @RequestParam int uid) {
        return orderService.selectOrderPage(currentPage, perPage, uid);
    }

    @RequestMapping("/insertOrder")
    public GResponse insertOrder(@RequestParam int idCommodity, @RequestParam int numCommodity, @RequestParam String date, @RequestParam int uid) {
        return orderService.insertOrder(idCommodity, numCommodity, date, uid);
    }
}
