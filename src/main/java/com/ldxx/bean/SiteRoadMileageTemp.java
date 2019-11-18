package com.ldxx.bean;

import java.math.BigDecimal;

/**
 * 摊铺温度
 */
public class SiteRoadMileageTemp {

    public String id;

    public String siteId;//地点_id
    public String siteNumber;//标段
    public String roadName;//路段
    public String roadId;

    public BigDecimal temp;//摊铺温度

    public String datetime;//最后录入日期

    public String editUserId;//最后录入用户

    public String editDatetime;//施工时间

    public int deleteState;

    public String getSiteNumber() {
        return siteNumber;
    }

    public void setSiteNumber(String siteNumber) {
        this.siteNumber = siteNumber;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getRoadId() {
        return roadId;
    }

    public void setRoadId(String roadId) {
        this.roadId = roadId;
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

    public BigDecimal getTemp() {
        return temp;
    }

    public void setTemp(BigDecimal temp) {
        this.temp = temp;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getEditUserId() {
        return editUserId;
    }

    public void setEditUserId(String editUserId) {
        this.editUserId = editUserId;
    }

    public String getEditDatetime() {
        return editDatetime;
    }

    public void setEditDatetime(String editDatetime) {
        this.editDatetime = editDatetime;
    }

    public int getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(int deleteState) {
        this.deleteState = deleteState;
    }
}
