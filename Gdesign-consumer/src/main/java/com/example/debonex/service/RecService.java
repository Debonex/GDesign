package com.example.debonex.service;

import com.example.debonex.pojo.GResponse;
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
     * @param uid user id
     * @return commodity info list
     */
    public GResponse recommend(int uid) {
        ServiceInstance recService = serviceService.discover("rec-service");
        String url = recService.getUri().toString() + "/rec";
        return new RestTemplate().getForObject(url + "?uid=" + uid, GResponse.class);
    }
}
