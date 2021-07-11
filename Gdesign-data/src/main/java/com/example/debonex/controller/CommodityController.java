package com.example.debonex.controller;

import com.example.debonex.mapper.CommodityMapper;
import com.example.debonex.pojo.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    CommodityMapper commodtiyMapper;

    @RequestMapping("/findById")
    public List<Commodity> findById(List<Integer> idList){
        int i;
        List<Commodity> result = new ArrayList<Commodity>();
        for (i=0;i<idList.size();i++){
            int id = idList.get(i);
            result.add(commodtiyMapper.selectById(id));
        }
        return result;
    }
}
