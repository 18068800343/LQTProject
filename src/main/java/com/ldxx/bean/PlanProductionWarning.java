package com.ldxx.bean;

public class PlanProductionWarning {
    private String id;

    private String planid;

    private String datetime;

    private String roadid;

    private String warningtype;

    private String warningcontent;

    private int warningstate;

    private int sendstatus;

    private String sendtime;

    private String senduserid;

    private int deletestate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlanid() {
        return planid;
    }

    public void setPlanid(String planid) {
        this.planid = planid;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getRoadid() {
        return roadid;
    }

    public void setRoadid(String roadid) {
        this.roadid = roadid;
    }

    public String getWarningtype() {
        return warningtype;
    }

    public void setWarningtype(String warningtype) {
        this.warningtype = warningtype;
    }

    public String getWarningcontent() {
        return warningcontent;
    }

    public void setWarningcontent(String warningcontent) {
        this.warningcontent = warningcontent;
    }

    public int getWarningstate() {
        return warningstate;
    }

    public void setWarningstate(int warningstate) {
        this.warningstate = warningstate;
    }

    public int getSendstatus() {
        return sendstatus;
    }

    public void setSendstatus(int sendstatus) {
        this.sendstatus = sendstatus;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getSenduserid() {
        return senduserid;
    }

    public void setSenduserid(String senduserid) {
        this.senduserid = senduserid;
    }

    public int getDeletestate() {
        return deletestate;
    }

    public void setDeletestate(int deletestate) {
        this.deletestate = deletestate;
    }
}
