package com.ldxx.bean;

public class SiteIncomingMaterialTempWarning {
    private String id;

    private String fieid;

    private String datetime;

    private String warningtype;

    private String warningcontent;

    //预警状态（1:未操作；2:已取消;3:以废料）
    private int warningstate;

    private String edituserid;

    private String editdatetime;

    private int deletestate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFieid() {
        return fieid;
    }

    public void setFieid(String fieid) {
        this.fieid = fieid;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
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
