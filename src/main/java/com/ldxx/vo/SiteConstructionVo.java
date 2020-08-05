package com.ldxx.vo;

import com.ldxx.bean.SiteConstruction;

import java.math.BigDecimal;

public class SiteConstructionVo extends SiteConstruction {

	private String roadno;
	private String roadname;
	private BigDecimal allXuQiu;
	private BigDecimal allGongYing;
	private String datetime;

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public BigDecimal getAllXuQiu() {
		return allXuQiu;
	}

	public void setAllXuQiu(BigDecimal allXuQiu) {
		this.allXuQiu = allXuQiu;
	}

	public BigDecimal getAllGongYing() {
		return allGongYing;
	}

	public void setAllGongYing(BigDecimal allGongYing) {
		this.allGongYing = allGongYing;
	}

	public String getRoadno() {
		return roadno;
	}

	public void setRoadno(String roadno) {
		this.roadno = roadno;
	}

	public String getRoadname() {
		return roadname;
	}

	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}

}