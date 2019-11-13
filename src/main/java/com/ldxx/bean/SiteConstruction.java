package com.ldxx.bean;

import java.math.BigDecimal;

public class SiteConstruction {
	
    private String id;

    private String roadid;

    private String sitenumber;

    private BigDecimal lng;

    private BigDecimal lat;

    private String stakemark;

    private String lane;

    private String remarks;

    private int deletestate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoadid() {
		return roadid;
	}

	public void setRoadid(String roadid) {
		this.roadid = roadid;
	}

	public String getSitenumber() {
		return sitenumber;
	}

	public void setSitenumber(String sitenumber) {
		this.sitenumber = sitenumber;
	}

	public BigDecimal getLng() {
		return lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public String getStakemark() {
		return stakemark;
	}

	public void setStakemark(String stakemark) {
		this.stakemark = stakemark;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getDeletestate() {
		return deletestate;
	}

	public void setDeletestate(int deletestate) {
		this.deletestate = deletestate;
	}
    
    
}
