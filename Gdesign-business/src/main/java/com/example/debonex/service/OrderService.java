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

    @Autowired
    CommodityService commodityService;

    /**
     * @param currentPage current page number
     * @param perPage     order count per page
     * @param uid         user id
     * @return order page info
     */
    public GResponse selectOrderPage(int currentPage, int perPage, int uid) {
        try {
            List<Order> list = orderMapper.selectOrderPage(currentPage, perPage, uid);
            list.forEach(item -> {
                item.setCommodity(commodityService.selectCommodity(item.getIdCommodity()));
            });
            OrderPage res = new OrderPage(list, currentPage, orderMapper.selectOrderCount(uid));
            return new GResponse(Constants.SUCCESS, res);
        } catch (Exception e) {
            e.printStackTrace();
            return new GResponse(Constants.FAILED);
        }
    }

    /**
     * @param idCommodity  commodity id
     * @param numCommodity commodity num
     * @param date         date info
     * @return response
     */
    public GResponse insertOrder(int idCommodity, int numCommodity, String date, int uid) {
        try {
            String prefix = "S" + date.replaceAll("-", "");
            List<Order> list = orderMapper.selectOrderByIdPrefix(prefix);
            String newId = prefix;
            if (list.size() == 0) {
                newId = prefix + "100000";
            } else {
                String suffixMax = list.get(0).getIdOrder().substring(9);
                newId = prefix + String.valueOf(Integer.parseInt(suffixMax) + 1);
            }
            Order order = new Order();
            order.setIdOrder(newId);
            order.setIdCommodity(idCommodity);
            order.setNumCommodity(numCommodity);
            double valueCommodity = commodityService.selectCommodity(idCommodity).getValue();
            order.setAmountOrder(numCommodity * valueCommodity);
            order.setUid(uid);
            orderMapper.insertOrder(order);
            return new GResponse(Constants.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new GResponse(Constants.FAILED);
        }

    }
}
