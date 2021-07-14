package com.example.debonex.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Debonet
 */
public class CommodityIdListVO {
    private int[] commodityIdList;


    public int[] getCommodityIdList() {
        return commodityIdList;
    }

    public void setCommodityIdList(int[] commodityIdList) {
        this.commodityIdList = commodityIdList;
    }

    public CommodityIdListVO(int[] commodityIdList) {
        this.commodityIdList = commodityIdList;
    }

    public CommodityIdListVO() {
    }

    public CommodityIdListVO(String json) throws JsonProcessingException {
        CommodityIdListVO res = new ObjectMapper().readValue(json,CommodityIdListVO.class);
        this.commodityIdList = res.getCommodityIdList();
    }
}
