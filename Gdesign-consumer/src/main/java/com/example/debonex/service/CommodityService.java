package com.example.debonex.service;

import com.example.debonex.pojo.Commodity;
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

    /**
     * @param commodity commodity info
     * @return response
     */
    public GResponse insertCommodity(Commodity commodity) {
        ServiceInstance businessService = serviceService.discover("business-service");
        String url = businessService.getUri() + "/commodity/insertCommodity";
        return new RestTemplate().postForObject(url, commodity, GResponse.class);
    }

    /**
     * @param keyword search keyword
     * @return commodity info list
     */
    public GResponse searchCommodityList(String keyword) {
        ServiceInstance businessService = serviceService.discover("business-service");
        String url = businessService.getUri() + "/commodity/searchCommodityList";
        return new RestTemplate().getForObject(url + "?keyword=" + keyword, GResponse.class);
    }
}
