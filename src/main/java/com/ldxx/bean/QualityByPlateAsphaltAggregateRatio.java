package com.ldxx.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 逐盘油石比
 * @author hp
 *
 */
public class QualityByPlateAsphaltAggregateRatio {
	
	public String id;

    public String planId;//生产计划_ID

    public String planNo;//计划编号

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date nowTime;//日期

    public BigDecimal asphaltAggregateRatio;//油石比


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getNowTime() {
		return nowTime;
	}

	public void setNowTime(Date nowTime) {
		this.nowTime = nowTime;
	}

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


	public BigDecimal getAsphaltAggregateRatio() {
		return asphaltAggregateRatio;
	}

	public void setAsphaltAggregateRatio(BigDecimal asphaltAggregateRatio) {
		this.asphaltAggregateRatio = asphaltAggregateRatio;
	}
    
    
}
