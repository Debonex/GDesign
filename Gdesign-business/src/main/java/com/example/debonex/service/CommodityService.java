package com.example.debonex.service;

import com.example.debonex.mapper.CommodityMapper;
import com.example.debonex.pojo.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityService {
    @Autowired
    CommodityMapper commodityMapper;

    /**
     * @param commodityIdList commodity id list
     * @return commodity info list
     */
    public List<Commodity> selectCommodityList(List<Integer> commodityIdList) {
        List<Commodity> res = new ArrayList<Commodity>();
        for (int i : commodityIdList) {
            res.add(commodityMapper.selectCommodity(i));
        }
        return res;
    }

    /**
     * @param idCommodity commodity id
     * @return commodity info
     */
    public Commodity selectCommodity(int idCommodity) {
        return commodityMapper.selectCommodity(idCommodity);
    }
}
