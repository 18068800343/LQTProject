package com.ldxx.bean;

import java.math.BigDecimal;
import java.sql.Time;

import org.springframework.format.annotation.DateTimeFormat;

public class PlanProductionCollection
{
    private String planid;

    private String roadid;

    private String planno;

    private String roadnumber;

    private String recipeid;

    private BigDecimal pdneed;

    @DateTimeFormat(pattern = "hh-mm-ss")
    private Time drymixingtime;
    @DateTimeFormat(pattern = "hh-mm-ss")
    private Time wetmixingtime;

    private BigDecimal radio;

    private BigDecimal pdtemp;

    private BigDecimal arrivetemp;

    private BigDecimal price;

    private String datetime;

    private String edituserid;

    private String editdatetime;

    private int deletestate;

	public String getPlanid() {
		return planid;
	}

	public void setPlanid(String planid) {
		this.planid = planid;
	}

	public String getRoadid() {
		return roadid;
	}

	public void setRoadid(String roadid) {
		this.roadid = roadid;
	}

	public String getPlanno() {
		return planno;
	}

	public void setPlanno(String planno) {
		this.planno = planno;
	}

	public String getRoadnumber() {
		return roadnumber;
	}

	public void setRoadnumber(String roadnumber) {
		this.roadnumber = roadnumber;
	}

	public String getRecipeid() {
		return recipeid;
	}

	public void setRecipeid(String recipeid) {
		this.recipeid = recipeid;
	}
	
	public Time getDrymixingtime() {
		return drymixingtime;
	}

	public void setDrymixingtime(Time drymixingtime) {
		this.drymixingtime = drymixingtime;
	}

	public Time getWetmixingtime() {
		return wetmixingtime;
	}

	public void setWetmixingtime(Time wetmixingtime) {
		this.wetmixingtime = wetmixingtime;
	}

	public BigDecimal getRadio() {
		return radio;
	}

	public void setRadio(BigDecimal radio) {
		this.radio = radio;
	}

	public BigDecimal getPdtemp() {
		return pdtemp;
	}

	public void setPdtemp(BigDecimal pdtemp) {
		this.pdtemp = pdtemp;
	}

	public BigDecimal getArrivetemp() {
		return arrivetemp;
	}

	public void setArrivetemp(BigDecimal arrivetemp) {
		this.arrivetemp = arrivetemp;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getEdituserid() {
		return edituserid;
	}

	public void setEdituserid(String edituserid) {
		this.edituserid = edituserid;
	}

	public String getEditdatetime() {
		return editdatetime;
	}

	public void setEditdatetime(String editdatetime) {
		this.editdatetime = editdatetime;
	}

	public int getDeletestate() {
		return deletestate;
	}

	public void setDeletestate(int deletestate) {
		this.deletestate = deletestate;
	}

	public BigDecimal getPdneed() {
		return pdneed;
	}

	public void setPdneed(BigDecimal pdneed) {
		this.pdneed = pdneed;
	}
	
}