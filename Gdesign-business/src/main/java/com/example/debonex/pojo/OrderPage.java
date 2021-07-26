package com.example.debonex.pojo;

import java.util.List;

/**
 * @author Debonet
 * @date 2021年7月26日
 */
public class OrderPage {
    private List<Order> orderList;
    private int currentPage;
    private int totalRow;

    public OrderPage(List<Order> orderList, int currentPage, int totalRow) {
        this.orderList = orderList;
        this.currentPage = currentPage;
        this.totalRow = totalRow;
    }

    public OrderPage() {
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }
}
