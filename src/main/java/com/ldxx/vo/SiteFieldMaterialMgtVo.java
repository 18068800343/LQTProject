package com.ldxx.vo;

import com.ldxx.bean.SiteFieldMaterialMgt;

public class SiteFieldMaterialMgtVo extends SiteFieldMaterialMgt {

	//路段编号
	private String roadno;
	//路段编号
	private String roadname;
	// 车牌
	private String licenceplate;
	// 批次编号
	private String batch;
	// 来料类型，也叫配方名称
	private String flname;
	// 空车重量
	private String unloadedweight;
	// 录入人名称
	private String uname;
	//预估来料重量
	private String yuguweight;

	private String siteId;
	private String sitenumber;
	private String stakemark;

	public String getStakemark() {
		return stakemark;
	}

	public void setStakemark(String stakemark) {
		this.stakemark = stakemark;
	}

	public String getSitenumber() {
		return sitenumber;
	}

	public void setSitenumber(String sitenumber) {
		this.sitenumber = sitenumber;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getRoadname() {
		return roadname;
	}

	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}

	public String getYuguweight() {
		return yuguweight;
	}

	public void setYuguweight(String yuguweight) {
		this.yuguweight = yuguweight;
	}

	public String getRoadno() {
		return roadno;
	}

	public void setRoadno(String roadno) {
		this.roadno = roadno;
	}

	public String getLicenceplate() {
		return licenceplate;
	}

	public void setLicenceplate(String licenceplate) {
		this.licenceplate = licenceplate;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getFlname() {
		return flname;
	}

	public void setFlname(String flname) {
		this.flname = flname;
	}

	public String getUnloadedweight() {
		return unloadedweight;
	}

	public void setUnloadedweight(String unloadedweight) {
		this.unloadedweight = unloadedweight;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

}