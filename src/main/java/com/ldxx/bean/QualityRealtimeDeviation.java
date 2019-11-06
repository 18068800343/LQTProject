package com.ldxx.bean;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 逐盘生产偏差分析
 * @author hp
 *
 */
public class QualityRealtimeDeviation {

	public String id;

    public String planId;//生产计划_ID

    public String planNo;//计划编号

    public BigDecimal MaterialDeviation1;//料1偏差

    public BigDecimal MaterialDeviation2;

    public BigDecimal MaterialDeviation3;

    public BigDecimal MaterialDeviation4;

    public BigDecimal MaterialDeviation5;

    public BigDecimal MaterialDeviation6;

    public BigDecimal BoneFlourDeviation;//粉偏差

    public BigDecimal pitchDeviation;//沥青偏差

    public BigDecimal minDemperature;//最低温度

    public BigDecimal maxTemperature;//最高温度

    public Time dryMixingDeviation;//干拌偏差

    public Time wetMixingDeviation;//湿拌偏差

    public BigDecimal pass475;//通过率偏差4.75

    public BigDecimal pass236;//通过率偏差2.36

    public BigDecimal pass0075;//通过率偏差0.075

    public Date datetime;//日期时间

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

	public BigDecimal getMaterialDeviation1() {
		return MaterialDeviation1;
	}

	public void setMaterialDeviation1(BigDecimal materialDeviation1) {
		MaterialDeviation1 = materialDeviation1;
	}

	public BigDecimal getMaterialDeviation2() {
		return MaterialDeviation2;
	}

	public void setMaterialDeviation2(BigDecimal materialDeviation2) {
		MaterialDeviation2 = materialDeviation2;
	}

	public BigDecimal getMaterialDeviation3() {
		return MaterialDeviation3;
	}

	public void setMaterialDeviation3(BigDecimal materialDeviation3) {
		MaterialDeviation3 = materialDeviation3;
	}

	public BigDecimal getMaterialDeviation4() {
		return MaterialDeviation4;
	}

	public void setMaterialDeviation4(BigDecimal materialDeviation4) {
		MaterialDeviation4 = materialDeviation4;
	}

	public BigDecimal getMaterialDeviation5() {
		return MaterialDeviation5;
	}

	public void setMaterialDeviation5(BigDecimal materialDeviation5) {
		MaterialDeviation5 = materialDeviation5;
	}

	public BigDecimal getMaterialDeviation6() {
		return MaterialDeviation6;
	}

	public void setMaterialDeviation6(BigDecimal materialDeviation6) {
		MaterialDeviation6 = materialDeviation6;
	}

	public BigDecimal getBoneFlourDeviation() {
		return BoneFlourDeviation;
	}

	public void setBoneFlourDeviation(BigDecimal boneFlourDeviation) {
		BoneFlourDeviation = boneFlourDeviation;
	}

	public BigDecimal getPitchDeviation() {
		return pitchDeviation;
	}

	public void setPitchDeviation(BigDecimal pitchDeviation) {
		this.pitchDeviation = pitchDeviation;
	}

	public BigDecimal getMinDemperature() {
		return minDemperature;
	}

	public void setMinDemperature(BigDecimal minDemperature) {
		this.minDemperature = minDemperature;
	}

	public BigDecimal getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(BigDecimal maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public Time getDryMixingDeviation() {
		return dryMixingDeviation;
	}

	public void setDryMixingDeviation(Time dryMixingDeviation) {
		this.dryMixingDeviation = dryMixingDeviation;
	}

	public Time getWetMixingDeviation() {
		return wetMixingDeviation;
	}

	public void setWetMixingDeviation(Time wetMixingDeviation) {
		this.wetMixingDeviation = wetMixingDeviation;
	}

	public BigDecimal getPass475() {
		return pass475;
	}

	public void setPass475(BigDecimal pass475) {
		this.pass475 = pass475;
	}

	public BigDecimal getPass236() {
		return pass236;
	}

	public void setPass236(BigDecimal pass236) {
		this.pass236 = pass236;
	}

	public BigDecimal getPass0075() {
		return pass0075;
	}

	public void setPass0075(BigDecimal pass0075) {
		this.pass0075 = pass0075;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
    
    
    
	
}
