package com.example.debonex.controller;

import com.example.debonex.mapper.CommodityMapper;
import com.example.debonex.pojo.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Debonex
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    CommodityMapper commodityMapper;

    @RequestMapping("/findById")
    public Commodity findById(@RequestParam Integer commodityId){
        return commodityMapper.selectById(commodityId);
    }
}
