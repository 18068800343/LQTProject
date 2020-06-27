package com.ldxx.bean;

import java.math.BigDecimal;

/**
 * 摊铺温度
 */
public class SiteRoadMileageTemp {

	private String id;

	private String siteId;//地点_id
	private String siteNumber;//标段
	private String roadName;//路段
	private String roadId;

	private BigDecimal temp;//摊铺温度

	private BigDecimal temp2;//摊铺温度
    private BigDecimal intensityOfSegregation;

	private BigDecimal lixidu;//摊铺温度

	private String datetime;//最后录入日期

	private String editUserId;//最后录入用户
    
	private String editDatetime;//施工时间
    
    private String editUName;

    private int deleteState;

    private String stakeMark;


    public BigDecimal getIntensityOfSegregation() {
        return intensityOfSegregation;
    }

    public void setIntensityOfSegregation(BigDecimal intensityOfSegregation) {
        this.intensityOfSegregation = intensityOfSegregation;
    }

    public String getStakeMark() {
        return stakeMark;
    }

    public void setStakeMark(String stakeMark) {
        this.stakeMark = stakeMark;
    }

    public BigDecimal getLixidu() {
        return lixidu;
    }

    public void setLixidu(BigDecimal lixidu) {
        this.lixidu = lixidu;
    }

    public BigDecimal getTemp2() {
		return temp2;
	}

	public void setTemp2(BigDecimal temp2) {
		this.temp2 = temp2;
	}

	public String getEditUName() {
		return editUName;
	}

	public void setEditUName(String editUName) {
		this.editUName = editUName;
	}

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
