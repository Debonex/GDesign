package com.example.debonex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Debonex
 * @date 2021年6月21日
 */
@Service
public class RecService {

    @Autowired
    ServiceService serviceService;

    /**
     * 基于内容的推荐
     * @param uid 用户id
     * @return 推荐商品列表
     */
    public Object contentBase(Integer uid){
        ServiceInstance recService = serviceService.discover("rec-service");
        String url = recService.getUri().toString()+"/rec/contentBase";
        Object callResult = new RestTemplate().getForObject(url,Object.class);
        System.out.println(callResult);
        return callResult;
    }
}
