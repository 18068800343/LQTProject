package com.ldxx.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 批次管理
 * @author hp
 *
 */
public class BatchMgt {
	
	private String id;

	private String roadId;//路段编号

	private String batch;//批次

	private String licencePlate;//车牌

	private BigDecimal unloadedWeight;//空车重量

	private BigDecimal loadingWeight;//装料后重量

	private BigDecimal loadingTemperature;//装料温度

	private String pitchType;//成品沥青类型
	private String pitchTypeName;
	
	private String uName;
	
	private String roadName;//路段编号，暂时防止显示报错用 19.11.25

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date datetimeIn;//入场时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date datetimeOut;//出场时间

    public String editUserId;//最后录入用户

    public String editDatetime;//最后录入日期

    public int deleteState;//逻辑删除1存在，0删除

	private String siteId;


	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
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

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	
    
    
}
