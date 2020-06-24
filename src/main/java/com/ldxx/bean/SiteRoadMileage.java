package com.ldxx.bean;
/**
 * 摊铺里程
 * @author hp
 *
 */
public class SiteRoadMileage {
	
	private String id;

	private String siteId;//地点_id
	private String siteNumber;//标段
	private String roadName;//路段
	private String roadId;

	private float length;//摊铺里程

	private String datetime;//日期时间

	private String editUserId2;//最后录入用户
    
    private String editUName;//最后录入用户姓名
    
    private String editDatetime2;//最后录入日期

    private int deleteState;//逻辑删除1存在；0删除

    private String stakeMark;

	public String getStakeMark() {
		return stakeMark;
	}

	public void setStakeMark(String stakeMark) {
		this.stakeMark = stakeMark;
	}

	public String getEditUName() {
		return editUName;
	}

	public void setEditUName(String editUName) {
		this.editUName = editUName;
	}

	public String getRoadId() {
		return roadId;
	}

	public void setRoadId(String roadId) {
		this.roadId = roadId;
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

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
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
