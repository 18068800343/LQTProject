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

    private String expresswayName;

    //路段方向
    private String direction;
	//起桩号
	private String startMark;
	//止桩号
	private String endMark;
	//沥青层次
	private String storey;
	//长
	private double roadLong;
	//宽
	private double roadWeight;
	//深
	private double roadDeep;

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getStartMark() {
		return startMark;
	}

	public void setStartMark(String startMark) {
		this.startMark = startMark;
	}

	public String getEndMark() {
		return endMark;
	}

	public void setEndMark(String endMark) {
		this.endMark = endMark;
	}

	public String getStorey() {
		return storey;
	}

	public void setStorey(String storey) {
		this.storey = storey;
	}

	public double getRoadLong() {
		return roadLong;
	}

	public void setRoadLong(double roadLong) {
		this.roadLong = roadLong;
	}

	public double getRoadWeight() {
		return roadWeight;
	}

	public void setRoadWeight(double roadWeight) {
		this.roadWeight = roadWeight;
	}

	public double getRoadDeep() {
		return roadDeep;
	}

	public void setRoadDeep(double roadDeep) {
		this.roadDeep = roadDeep;
	}

	public String getExpresswayName() {
		return expresswayName;
	}

	public void setExpresswayName(String expresswayName) {
		this.expresswayName = expresswayName;
	}

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
