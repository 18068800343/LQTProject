package com.ldxx.bean;

import java.math.BigDecimal;

/**
 * 车辆管理
 * @author hp
 *
 */
public class TruckInfo {
	
	public String id;

    public String truckIc;//车牌

    public String truckType;//车型

    public BigDecimal weight;//载重

    public String driver;//驾驶员

    public String GPSId;//GPS序号

    public int deleteState;//逻辑删除 0:删除

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTruckIc() {
		return truckIc;
	}

	public void setTruckIc(String truckIc) {
		this.truckIc = truckIc;
	}

	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getGPSId() {
		return GPSId;
	}

	public void setGPSId(String gPSId) {
		GPSId = gPSId;
	}

	public int getDeleteState() {
		return deleteState;
	}

	public void setDeleteState(int deleteState) {
		this.deleteState = deleteState;
	}

	
    
    
    

}
