package com.example.debonex.service;

import com.example.debonex.constants.Constants;
import com.example.debonex.mapper.CommodityMapper;
import com.example.debonex.pojo.Commodity;
import com.example.debonex.pojo.CommodityPage;
import com.example.debonex.pojo.GResponse;
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

    /**
     * @param currentPage current page number
     * @param perPage     commodity count per page
     * @return commodity info list
     */
    public GResponse selectCommodityPage(int currentPage, int perPage) {
        try {
            List<Commodity> list = commodityMapper.selectCommodityList(currentPage, perPage);
            int totalRow = commodityMapper.selectCommodityCount();
            return new GResponse(Constants.SUCCESS, new CommodityPage(list, currentPage, totalRow));
        } catch (Exception e) {
            return new GResponse(Constants.FAILED);
        }


    }
}
