package com.example.debonex.controller;

import com.example.debonex.pojo.Commodity;
import com.example.debonex.pojo.GResponse;
import com.example.debonex.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Debonet
 * @date 2021年7月28日
 */
@RequestMapping("/commodity")
@RestController
public class CommodityController {

    @Autowired
    CommodityService commodityService;

    @RequestMapping("/selectCommodityPage")
    public GResponse selectCommodityPage(@RequestParam int currentPage, @RequestParam int perPage) {
        return commodityService.selectCommodityPage(currentPage, perPage);
    }

    @RequestMapping("/insertCommodity")
    public GResponse insertCommodity(@RequestBody Commodity commodity) {
        return commodityService.insertCommodity(commodity);
    }

    @RequestMapping("/searchCommodityList")
    public GResponse searchCommodityList(@RequestParam String keyword) {
        return commodityService.searchCommodityList(keyword);
    }
}
