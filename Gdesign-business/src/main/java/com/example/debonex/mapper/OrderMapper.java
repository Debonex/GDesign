package com.example.debonex.mapper;

import com.example.debonex.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    /**
     * @param currentPage current page number
     * @param perPage     order num per page
     * @param uid         user id
     * @return order list
     */
    public List<Order> selectOrderPage(@Param("currentPage") int currentPage,@Param("perPage") int perPage,@Param("uid") int uid);

    /**
     * @param uid user id
     * @return order list
     */
    public int selectOrderCount(@Param("uid") int uid);
}
