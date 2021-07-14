package com.example.debonex.controller;

import com.example.debonex.pojo.Commodity;
import com.example.debonex.service.CommodityService;
import com.example.debonex.vo.CommodityIdListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Debonex
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {


    @Autowired
    CommodityService commodityService;

    @RequestMapping("/findById")
    public Commodity findById(@RequestParam Integer commodityId) {
        return commodityService.findById(commodityId);
    }

    @RequestMapping(value = "/findListById", method = RequestMethod.POST)
    public List<Commodity> findCommodityListById(@RequestBody CommodityIdListVO commodityIdListVO) {
        return commodityService.findCommodityListById(commodityIdListVO.getCommodityIdList());
    }
}
