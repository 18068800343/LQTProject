package com.ldxx.bean;

import java.math.BigDecimal;

public class SiteCompactionSpeed {
    private String id;

    private String siteid;

    private String batchid;

    private String roadrollername;

    private BigDecimal compactionspeed;

    private String datetime;

    private String edituserid;

    private String editdatetime;

    private int deletestate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getBatchid() {
        return batchid;
    }

    public void setBatchid(String batchid) {
        this.batchid = batchid;
    }

    public String getRoadrollername() {
        return roadrollername;
    }

    public void setRoadrollername(String roadrollername) {
        this.roadrollername = roadrollername;
    }

    public BigDecimal getCompactionspeed() {
        return compactionspeed;
    }

    public void setCompactionspeed(BigDecimal compactionspeed) {
        this.compactionspeed = compactionspeed;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getEdituserid() {
        return edituserid;
    }

    public void setEdituserid(String edituserid) {
        this.edituserid = edituserid;
    }

    public String getEditdatetime() {
        return editdatetime;
    }

    public void setEditdatetime(String editdatetime) {
        this.editdatetime = editdatetime;
    }

    public int getDeletestate() {
        return deletestate;
    }

    public void setDeletestate(int deletestate) {
        this.deletestate = deletestate;
    }
}
