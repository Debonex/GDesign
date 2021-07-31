package com.example.debonex.pojo;

/**
 * @author Debonet
 * @date 2021年7月27日
 */
public class Commodity {
    private int idCommodity;
    private String title;
    private int entity;
    private String hire;
    private String timelimit;
    private String region;
    private double value;
    private String specification;

    public Commodity(int idCommodity, String title, int entity, String hire, String timelimit, String region, double value, String specification) {
        this.idCommodity = idCommodity;
        this.title = title;
        this.entity = entity;
        this.hire = hire;
        this.timelimit = timelimit;
        this.region = region;
        this.value = value;
        this.specification = specification;
    }

    public Commodity() {
    }

    public int getIdCommodity() {
        return idCommodity;
    }

    public void setIdCommodity(int idCommodity) {
        this.idCommodity = idCommodity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEntity() {
        return entity;
    }

    public void setEntity(int entity) {
        this.entity = entity;
    }

    public String getHire() {
        return hire;
    }

    public void setHire(String hire) {
        this.hire = hire;
    }

    public String getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(String timelimit) {
        this.timelimit = timelimit;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}
