package com.ldxx.bean;

import java.math.BigDecimal;

public class SiteConstruction {
	
    private String id;

    private String roadno;

    private String sitename;

    private BigDecimal startlng;

    private BigDecimal startlat;

    private BigDecimal endlng;

    private BigDecimal endlat;

    private String stakemark;

    private String lane;

    private String remarks;

    private int deletestate;

    private String roadnumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoadno() {
		return roadno;
	}

	public void setRoadno(String roadno) {
		this.roadno = roadno;
	}

	public String getSitename() {
		return sitename;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public BigDecimal getStartlng() {
		return startlng;
	}

	public void setStartlng(BigDecimal startlng) {
		this.startlng = startlng;
	}

	public BigDecimal getStartlat() {
		return startlat;
	}

	public void setStartlat(BigDecimal startlat) {
		this.startlat = startlat;
	}

	public BigDecimal getEndlng() {
		return endlng;
	}

	public void setEndlng(BigDecimal endlng) {
		this.endlng = endlng;
	}

	public BigDecimal getEndlat() {
		return endlat;
	}

	public void setEndlat(BigDecimal endlat) {
		this.endlat = endlat;
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

	public String getRoadnumber() {
		return roadnumber;
	}

	public void setRoadnumber(String roadnumber) {
		this.roadnumber = roadnumber;
	}
    
}
