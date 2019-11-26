package com.ldxx.bean;

/**
 * 摊铺速度
 */
public class SiteRoadSpend {
    public String id;

    public String siteId;//地点_id
    public String siteNumber;//标段
    public String roadName;//路段
    public String roadId;

    public float speed;//摊铺速度

    public String datetime;//日期时间

    public String editUserId2;//最后录入用户

    public String editDatetime2;//最后录入日期
    
    private String editUName;
    
    public int deleteState;//删除状态

    
    public String getEditUName() {
		return editUName;
	}

	public void setEditUName(String editUName) {
		this.editUName = editUName;
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

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getEditUserId2() {
        return editUserId2;
    }

    public void setEditUserId2(String editUserId2) {
        this.editUserId2 = editUserId2;
    }

    public String getEditDatetime2() {
        return editDatetime2;
    }

    public void setEditDatetime2(String editDatetime2) {
        this.editDatetime2 = editDatetime2;
    }

    public int getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(int deleteState) {
        this.deleteState = deleteState;
    }
}
