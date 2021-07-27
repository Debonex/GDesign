package com.example.debonex.service;

import com.example.debonex.pojo.GResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Debonet
 * @date 2021年7月28日
 */
@Service
public class CommodityService {

    @Autowired
    ServiceService serviceService;

    /**
     * @param currentPage current page number
     * @param perPage     commodity count per page
     * @return commodity info list
     */
    public GResponse selectCommodityPage(int currentPage, int perPage) {
        ServiceInstance businessService = serviceService.discover("business-service");
        String url = businessService.getUri() + "/commodity/selectCommodityPage";
        return new RestTemplate().getForObject(url + "?currentPage=" + currentPage + "&perPage=" + perPage, GResponse.class);
    }
}
