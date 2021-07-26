package com.example.debonex.service;

import com.example.debonex.pojo.GResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    ServiceService serviceService;

    public GResponse selectOrderPage(int currentPage, int perPage, int uid) {
        ServiceInstance businessService = serviceService.discover("business-service");
        String url = businessService.getUri().toString() + "/order/selectOrderPage";
        return new RestTemplate().getForObject(url + "?currentPage=" + currentPage + "&perPage=" + perPage + "&uid=" + uid, GResponse.class);
    }
}
