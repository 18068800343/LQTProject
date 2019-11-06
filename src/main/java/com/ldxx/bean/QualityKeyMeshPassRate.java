package com.ldxx.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 关键筛孔通过率列表
 * @author hp
 *
 */
public class QualityKeyMeshPassRate {

	public String id;
	 //生产计划_ID
    public String planId;
    //计划编号
    public String planNo;
    //生产时间
    public Date productionTime;
    //4.75
    public BigDecimal r1;
    //2.36
    public BigDecimal r2;
    //0.075
    public BigDecimal r3;
    
    
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
	public Date getProductionTime() {
		return productionTime;
	}
	public void setProductionTime(Date productionTime) {
		this.productionTime = productionTime;
	}
	public BigDecimal getR1() {
		return r1;
	}
	public void setR1(BigDecimal r1) {
		this.r1 = r1;
	}
	public BigDecimal getR2() {
		return r2;
	}
	public void setR2(BigDecimal r2) {
		this.r2 = r2;
	}
	public BigDecimal getR3() {
		return r3;
	}
	public void setR3(BigDecimal r3) {
		this.r3 = r3;
	}

    
    
}
