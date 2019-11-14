package com.ldxx.bean;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 批次管理
 * @author hp
 *
 */
public class BatchMgt {
	
	public String id;

    public String roadId;//路段编号
    public String roadName;

    public String batch;//批次

    public String licencePlate;//车牌

    public BigDecimal unloadedWeight;//空车重量

    public BigDecimal loadingWeight;//装料后重量

    public BigDecimal loadingTemperature;//装料温度

    public String pitchType;//成品沥青类型
    public String pitchTypeName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date datetimeIn;//入场时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date datetimeOut;//出场时间

    public String editUserId;//最后录入用户

    public String editDatetime;//最后录入日期

    public int deleteState;//逻辑删除1存在，0删除

    
	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public String getPitchTypeName() {
		return pitchTypeName;
	}

	public void setPitchTypeName(String pitchTypeName) {
		this.pitchTypeName = pitchTypeName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoadId() {
		return roadId;
	}

	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	public BigDecimal getUnloadedWeight() {
		return unloadedWeight;
	}

	public void setUnloadedWeight(BigDecimal unloadedWeight) {
		this.unloadedWeight = unloadedWeight;
	}

	public BigDecimal getLoadingWeight() {
		return loadingWeight;
	}

	public void setLoadingWeight(BigDecimal loadingWeight) {
		this.loadingWeight = loadingWeight;
	}

	public BigDecimal getLoadingTemperature() {
		return loadingTemperature;
	}

	public void setLoadingTemperature(BigDecimal loadingTemperature) {
		this.loadingTemperature = loadingTemperature;
	}

	public String getPitchType() {
		return pitchType;
	}

	public void setPitchType(String pitchType) {
		this.pitchType = pitchType;
	}

	public Date getDatetimeIn() {
		return datetimeIn;
	}

	public void setDatetimeIn(Date datetimeIn) {
		this.datetimeIn = datetimeIn;
	}

	public Date getDatetimeOut() {
		return datetimeOut;
	}

	public void setDatetimeOut(Date datetimeOut) {
		this.datetimeOut = datetimeOut;
	}

	public String getEditUserId() {
		return editUserId;
	}

	public void setEditUserId(String editUserId) {
		this.editUserId = editUserId;
	}

	public String getEditDatetime() {
		return editDatetime;
	}

	public void setEditDatetime(String editDatetime) {
		this.editDatetime = editDatetime;
	}

	public int getDeleteState() {
		return deleteState;
	}

	public void setDeleteState(int deleteState) {
		this.deleteState = deleteState;
	}

    
    
}
