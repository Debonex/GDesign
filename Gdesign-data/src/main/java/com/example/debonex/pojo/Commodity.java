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

    public Commodity(Integer id, String title, Integer entity, String hire, String timelimit, String region) {
        this.id = id;
        this.title = title;
        this.entity = entity;
        this.hire = hire;
        this.timelimit = timelimit;
        this.region = region;
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
