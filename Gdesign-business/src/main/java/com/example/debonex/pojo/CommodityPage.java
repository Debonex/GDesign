package com.example.debonex.pojo;

import java.util.List;

/**
 * @author Debonet
 * @date 2021年7月28日
 */
public class CommodityPage {
    private List<Commodity> commodityList;
    private int currentPage;
    private int totalRow;

    public CommodityPage(List<Commodity> commodityList, int currentPage, int totalRow) {
        this.commodityList = commodityList;
        this.currentPage = currentPage;
        this.totalRow = totalRow;
    }

    public List<Commodity> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<Commodity> commodityList) {
        this.commodityList = commodityList;
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
