package com.ldxx.bean;

public class Guanlianbianhao {

    private String id;
    private String llId; //来料id
    private String siteId;//施工地点id
    private String ppcId;//生产计划id
    private String datetime;
    private String sbbh;//设备编号

    public String getLlId() {
        return llId;
    }

    public void setLlId(String llId) {
        this.llId = llId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getPpcId() {
        return ppcId;
    }

    public void setPpcId(String ppcId) {
        this.ppcId = ppcId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getSbbh() {
        return sbbh;
    }

    public void setSbbh(String sbbh) {
        this.sbbh = sbbh;
    }
}
