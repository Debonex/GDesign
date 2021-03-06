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

    /**
     * @param currentPage current order page number
     * @param perPage     order count per page
     * @param uid         user id
     * @return order page info
     */
    public GResponse selectOrderPage(int currentPage, int perPage, int uid) {
        ServiceInstance businessService = serviceService.discover("business-service");
        String url = businessService.getUri().toString() + "/order/selectOrderPage";
        return new RestTemplate().getForObject(url + "?currentPage=" + currentPage + "&perPage=" + perPage + "&uid=" + uid, GResponse.class);
    }

    /**
     * @param idCommodity  commodity id
     * @param numCommodity commodity count
     * @param date         date string yyyymmdd
     * @param uid          user id
     * @return response
     */
    public GResponse insertOrder(int idCommodity, int numCommodity, String date, int uid) {
        ServiceInstance businessService = serviceService.discover("business-service");
        String url = businessService.getUri().toString() + "/order/insertOrder";
        return new RestTemplate().getForObject(url + "?idCommodity=" + idCommodity + "&numCommodity=" + numCommodity + "&date=" + date + "&uid=" + uid, GResponse.class);
    }

    /**
     * delete order by id
     *
     * @param idOrder order id
     * @return response
     */
    public GResponse deleteOrder(String idOrder) {
        ServiceInstance businessService = serviceService.discover("business-service");
        String url = businessService.getUri().toString() + "/order/deleteOrder";
        return new RestTemplate().getForObject(url + "?idOrder=" + idOrder, GResponse.class);
    }

    /**
     * @param idOrder      order id
     * @param idCommodity  commodity id
     * @param numCommodity commodity count
     * @return new order info
     */
    public GResponse updateOrder(String idOrder, int idCommodity, int numCommodity) {
        ServiceInstance businessService = serviceService.discover("business-service");
        String url = businessService.getUri().toString() + "/order/updateOrder";
        return new RestTemplate().getForObject(url + "?idOrder=" + idOrder + "&idCommodity=" + idCommodity + "&numCommodity=" + numCommodity, GResponse.class);
    }
}
