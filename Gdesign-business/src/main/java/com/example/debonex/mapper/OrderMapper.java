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
    public List<Order> selectOrderPage(@Param("currentPage") int currentPage, @Param("perPage") int perPage, @Param("uid") int uid);

    /**
     * @param uid user id
     * @return order list
     */
    public int selectOrderCount(@Param("uid") int uid);

    /**
     * insert new order line
     *
     * @param order order info
     */
    public void insertOrder(@Param("item") Order order);

    /**
     * @param prefix order id prefix
     * @return order info
     */
    public List<Order> selectOrderByIdPrefix(@Param("prefix") String prefix);

    /**
     * @param idOrder order id
     */
    public void deleteOrder(@Param("idOrder") String idOrder);
}
