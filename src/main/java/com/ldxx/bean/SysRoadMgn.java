package com.ldxx.bean;

import java.math.BigDecimal;

public class SysRoadMgn {
    private String roadId;

    private String roadNo;

    private String roadName;

    private BigDecimal startLng;

    private BigDecimal startLat;

    private BigDecimal endLng;

    private BigDecimal endLat;

    private String remarks;

    private int deleteState;

	public String getRoadId() {
		return roadId;
	}

	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}

	public String getRoadNo() {
		return roadNo;
	}

	public void setRoadNo(String roadNo) {
		this.roadNo = roadNo;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public BigDecimal getStartLng() {
		return startLng;
	}

	public void setStartLng(BigDecimal startLng) {
		this.startLng = startLng;
	}

	public BigDecimal getStartLat() {
		return startLat;
	}

	public void setStartLat(BigDecimal startLat) {
		this.startLat = startLat;
	}

	public BigDecimal getEndLng() {
		return endLng;
	}

	public void setEndLng(BigDecimal endLng) {
		this.endLng = endLng;
	}

	public BigDecimal getEndLat() {
		return endLat;
	}

	public void setEndLat(BigDecimal endLat) {
		this.endLat = endLat;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getDeleteState() {
		return deleteState;
	}

	public void setDeleteState(int deleteState) {
		this.deleteState = deleteState;
	}

	
    
}
