package com.example.debonex.mapper;

import com.example.debonex.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    /**
     * @param currentPage current page number
     * @param perPage     order num per page
     * @return order list
     */
    public List<Order> selectOrderPage(int currentPage, int perPage);

    /**
     *
     * @return total order count
     */
    public int selectOrderCount();
}
