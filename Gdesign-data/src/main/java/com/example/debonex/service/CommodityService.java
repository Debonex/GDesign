package com.example.debonex.service;

import com.example.debonex.mapper.CommodityMapper;
import com.example.debonex.pojo.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Debonet
 */
@Service
public class CommodityService {
    @Autowired
    CommodityMapper commodityMapper;

    /**
     * @param commodityId 商品id
     * @return 商品详细信息
     */
    public Commodity findById(Integer commodityId){
        return commodityMapper.selectById(commodityId);
    }

    /**
     *
     * @param commodityIdList 商品id列表
     * @return  商品详细信息列表
     */
    public List<Commodity> findCommodityListById(int[] commodityIdList){
        List<Commodity> result = new ArrayList<Commodity>();
        for(int i:commodityIdList){
            result.add(commodityMapper.selectById(i));
        }
        return result;
    }
}
