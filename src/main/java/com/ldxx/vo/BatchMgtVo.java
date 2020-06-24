package com.ldxx.vo;

import com.ldxx.bean.BatchMgt;

public class BatchMgtVo extends BatchMgt {

	private String roadName;

	private String roadNo;
	
	private String flName;
	
	private String yuguweight;

	private String uName;

	private String siteNumber;
	private String stakeMark;

	public String getStakeMark() {
		return stakeMark;
	}

	public void setStakeMark(String stakeMark) {
		this.stakeMark = stakeMark;
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

	public String getRoadNo() {
		return roadNo;
	}

	public void setRoadNo(String roadNo) {
		this.roadNo = roadNo;
	}

	public String getFlName() {
		return flName;
	}

	public void setFlName(String flName) {
		this.flName = flName;
	}

	public String getYuguweight() {
		return yuguweight;
	}

	public void setYuguweight(String yuguweight) {
		this.yuguweight = yuguweight;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}
}