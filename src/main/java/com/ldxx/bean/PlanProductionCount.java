package com.ldxx.bean;

import java.math.BigDecimal;

public class PlanProductionCount {

	private String id;
	private String planId;
	private String batchId;
	private BigDecimal pdNeedIncOrDec;
	private String pdNeedSource;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public BigDecimal getPdNeedIncOrDec() {
		return pdNeedIncOrDec;
	}
	public void setPdNeedIncOrDec(BigDecimal pdNeedIncOrDec) {
		this.pdNeedIncOrDec = pdNeedIncOrDec;
	}
	public String getPdNeedSource() {
		return pdNeedSource;
	}
	public void setPdNeedSource(String pdNeedSource) {
		this.pdNeedSource = pdNeedSource;
	}
	
}
