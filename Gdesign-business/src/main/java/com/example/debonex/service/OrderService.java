package com.example.debonex.service;

import com.example.debonex.constants.Constants;
import com.example.debonex.mapper.OrderMapper;
import com.example.debonex.pojo.GResponse;
import com.example.debonex.pojo.Order;
import com.example.debonex.pojo.OrderPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    /**
     * @param currentPage current page number
     * @param perPage     order count per page
     * @param uid         user id
     * @return order page info
     */
    public GResponse selectOrderPage(int currentPage, int perPage, int uid) {
        try {
            List<Order> list = orderMapper.selectOrderPage(currentPage, perPage, uid);
            OrderPage res = new OrderPage(list, currentPage, orderMapper.selectOrderCount(uid));
            return new GResponse(Constants.SUCCESS, res);
        } catch (Exception e) {
            e.printStackTrace();
            return new GResponse(Constants.FAILED);
        }
    }
}
