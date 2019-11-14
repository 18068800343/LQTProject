package com.ldxx.bean;

import java.math.BigDecimal;

public class SiteFieldMaterialMgt {
	
    private String id;

    private String siteid;

    private String batchid;

    private BigDecimal temp;

    private BigDecimal weight;

    private String datetime;

    private String edituserid;

    private String editdatetime;

    private int deletestate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getBatchid() {
		return batchid;
	}

	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}

	public BigDecimal getTemp() {
		return temp;
	}

	public void setTemp(BigDecimal temp) {
		this.temp = temp;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
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
    
}
