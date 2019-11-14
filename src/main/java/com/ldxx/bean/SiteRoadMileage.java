package com.ldxx.bean;
/**
 * 摊铺里程
 * @author hp
 *
 */
public class SiteRoadMileage {
	
	public String id;

    public String siteId;//地点_id

    public String roadNo;//路段编号

    public float length;//摊铺里程

    public String datetime;//日期时间

    public String editUserId2;//最后录入用户

    public String editDatetime2;//最后录入日期

    public int deleteState;//逻辑删除1存在；0删除
    

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

	public String getRoadNo() {
		return roadNo;
	}

	public void setRoadNo(String roadNo) {
		this.roadNo = roadNo;
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
