package com.example.debonex.pojo;

/**
 * @author Debonet
 * @date 2021年7月26日
 */
public class Order {
    private String idOrder;
    private int idCommodity;
    private int numCommodity;
    private double amountOrder;
    private Integer idStore;
    private double commission1;
    private int idDistributor1;
    private double commission2;
    private int idDistributor2;
    private double commission3;
    private int idDistributor3;
    private int uid;
    private Commodity commodity;

    public Order(String idOrder, int idCommodity, int numCommodity, double amountOrder, Integer idStore, double commission1, int idDistributor1, double commission2, int idDistributor2, double commission3, int idDistributor3, int uid, Commodity commodity) {
        this.idOrder = idOrder;
        this.idCommodity = idCommodity;
        this.numCommodity = numCommodity;
        this.amountOrder = amountOrder;
        this.idStore = idStore;
        this.commission1 = commission1;
        this.idDistributor1 = idDistributor1;
        this.commission2 = commission2;
        this.idDistributor2 = idDistributor2;
        this.commission3 = commission3;
        this.idDistributor3 = idDistributor3;
        this.uid = uid;
        this.commodity = commodity;
    }

    public Order() {
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdCommodity() {
        return idCommodity;
    }

    public void setIdCommodity(int idCommodity) {
        this.idCommodity = idCommodity;
    }

    public int getNumCommodity() {
        return numCommodity;
    }

    public void setNumCommodity(int numCommodity) {
        this.numCommodity = numCommodity;
    }

    public double getAmountOrder() {
        return amountOrder;
    }

    public void setAmountOrder(double amountOrder) {
        this.amountOrder = amountOrder;
    }

    public Integer getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public double getCommission1() {
        return commission1;
    }

    public void setCommission1(double commission1) {
        this.commission1 = commission1;
    }

    public int getIdDistributor1() {
        return idDistributor1;
    }

    public void setIdDistributor1(int idDistributor1) {
        this.idDistributor1 = idDistributor1;
    }

    public double getCommission2() {
        return commission2;
    }

    public void setCommission2(double commission2) {
        this.commission2 = commission2;
    }

    public int getIdDistributor2() {
        return idDistributor2;
    }

    public void setIdDistributor2(int idDistributor2) {
        this.idDistributor2 = idDistributor2;
    }

    public double getCommission3() {
        return commission3;
    }

    public void setCommission3(double commission3) {
        this.commission3 = commission3;
    }

    public int getIdDistributor3() {
        return idDistributor3;
    }

    public void setIdDistributor3(int idDistributor3) {
        this.idDistributor3 = idDistributor3;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setIdStore(Integer idStore) {
        this.idStore = idStore;
    }
}
