package com.ldxx.bean;

import java.math.BigDecimal;

public class PlanProductionCount {
	private String id;

	private String planid;

	private String batchid;

	private BigDecimal pdneedincordec;

	private int pdneedsourcestate;

	private String datetime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlanid() {
		return planid;
	}

	public void setPlanid(String planid) {
		this.planid = planid;
	}

	public String getBatchid() {
		return batchid;
	}

	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}

	public BigDecimal getPdneedincordec() {
		return pdneedincordec;
	}

	public void setPdneedincordec(BigDecimal pdneedincordec) {
		this.pdneedincordec = pdneedincordec;
	}

	public int getPdneedsourcestate() {
		return pdneedsourcestate;
	}

	public void setPdneedsourcestate(int pdneedsourcestate) {
		this.pdneedsourcestate = pdneedsourcestate;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
}
