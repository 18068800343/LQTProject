package com.ldxx.bean;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 逐盘拌合生产数据实时监控
 * @author hp
 *
 */
public class QualityByPlateRealTimeProdocutionData {
	
	public String ID;
	
    public String planId;//生产计划_ID

    public String planNo;//计划编号

    public BigDecimal materialsUse1;//料1用量

    public BigDecimal materialsUse2;

    public BigDecimal materialsUse3;

    public BigDecimal materialsUse4;

    public BigDecimal materialsUse5;

    public BigDecimal materialsUse6;

    public BigDecimal boneFlourUse;//粉用量

    public BigDecimal pitchUse;//沥青用量

    public BigDecimal minTemperature;//最低温度

    public BigDecimal maxTemperature;//最高温度

    public Time  dryTime;//干拌用时

    public Time  wetTime;//湿拌用时

    public Date productionTime;//生产时间

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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

	public BigDecimal getMaterialsUse1() {
		return materialsUse1;
	}

	public void setMaterialsUse1(BigDecimal materialsUse1) {
		this.materialsUse1 = materialsUse1;
	}

	public BigDecimal getMaterialsUse2() {
		return materialsUse2;
	}

	public void setMaterialsUse2(BigDecimal materialsUse2) {
		this.materialsUse2 = materialsUse2;
	}

	public BigDecimal getMaterialsUse3() {
		return materialsUse3;
	}

	public void setMaterialsUse3(BigDecimal materialsUse3) {
		this.materialsUse3 = materialsUse3;
	}

	public BigDecimal getMaterialsUse4() {
		return materialsUse4;
	}

	public void setMaterialsUse4(BigDecimal materialsUse4) {
		this.materialsUse4 = materialsUse4;
	}

	public BigDecimal getMaterialsUse5() {
		return materialsUse5;
	}

	public void setMaterialsUse5(BigDecimal materialsUse5) {
		this.materialsUse5 = materialsUse5;
	}

	public BigDecimal getMaterialsUse6() {
		return materialsUse6;
	}

	public void setMaterialsUse6(BigDecimal materialsUse6) {
		this.materialsUse6 = materialsUse6;
	}

	public BigDecimal getBoneFlourUse() {
		return boneFlourUse;
	}

	public void setBoneFlourUse(BigDecimal boneFlourUse) {
		this.boneFlourUse = boneFlourUse;
	}

	public BigDecimal getPitchUse() {
		return pitchUse;
	}

	public void setPitchUse(BigDecimal pitchUse) {
		this.pitchUse = pitchUse;
	}

	public BigDecimal getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(BigDecimal minTemperature) {
		this.minTemperature = minTemperature;
	}

	public BigDecimal getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(BigDecimal maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public Time getDryTime() {
		return dryTime;
	}

	public void setDryTime(Time dryTime) {
		this.dryTime = dryTime;
	}

	public Time getWetTime() {
		return wetTime;
	}

	public void setWetTime(Time wetTime) {
		this.wetTime = wetTime;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getProductionTime() {
		return productionTime;
	}

	public void setProductionTime(Date productionTime) {
		this.productionTime = productionTime;
	}


}
