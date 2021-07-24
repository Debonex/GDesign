package com.example.debonex.pojo;

/**
 * @author Debonex
 */
public class Commodity {
    private Integer id;
    private String title;
    private Integer entity;
    private String hire;
    private String timelimit;
    private String region;
    private Double value;
    private String specification;

    public Commodity(Integer id, String title, Integer entity, String hire, String timelimit, String region, Double value, String specification) {
        this.id = id;
        this.title = title;
        this.entity = entity;
        this.hire = hire;
        this.timelimit = timelimit;
        this.region = region;
        this.value = value;
        this.specification = specification;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEntity() {
        return entity;
    }

    public void setEntity(Integer entity) {
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
}
