package com.ldxx.bean;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 逐盘油石比
 * @author hp
 *
 */
public class QualityByPlateAsphaltAggregateRatio {
	
	public String id;

    public String planId;//生产计划_ID

    public String planNo;//计划编号

    public Date date;//日期

    public Time time;//时间

    public String asphaltAggregateRatio;//油石比

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

	public String getPlanNo() {
		return planNo;
	}

	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getAsphaltAggregateRatio() {
		return asphaltAggregateRatio;
	}

	public void setAsphaltAggregateRatio(String asphaltAggregateRatio) {
		this.asphaltAggregateRatio = asphaltAggregateRatio;
	}
    
    
}
