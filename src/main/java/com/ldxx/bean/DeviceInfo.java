package com.ldxx.bean;

import java.util.List;

public class DeviceInfo {

	private String id;
	private String code;
	private String name;
	private String model;
	private String typeId;
	private String manufacturer;
	private String contact;
	private String status;
	private String remarks;
	private String editUserId;
	private String editDatetime;
	private int deleteState;

	private DicDeviceType dicDeviceType;


	private String serviceCondition;//使用情况
	private String deviceMaintenanceCycle;//设备维修保养周期
	private String enterTime;//进场时间
	private String quitTime;//出场时间
	private String ownOrLease;//（分自有、租赁）
	private List<Accessory> accessory;

	private String typeName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getServiceCondition() {
		return serviceCondition;
	}

	public void setServiceCondition(String serviceCondition) {
		this.serviceCondition = serviceCondition;
	}

	public String getDeviceMaintenanceCycle() {
		return deviceMaintenanceCycle;
	}

	public void setDeviceMaintenanceCycle(String deviceMaintenanceCycle) {
		this.deviceMaintenanceCycle = deviceMaintenanceCycle;
	}

	public String getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
	}

	public String getQuitTime() {
		return quitTime;
	}

	public void setQuitTime(String quitTime) {
		this.quitTime = quitTime;
	}

	public String getOwnOrLease() {
		return ownOrLease;
	}

	public void setOwnOrLease(String ownOrLease) {
		this.ownOrLease = ownOrLease;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public DicDeviceType getDicDeviceType() {
		return dicDeviceType;
	}
	public void setDicDeviceType(DicDeviceType dicDeviceType) {
		this.dicDeviceType = dicDeviceType;
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
	public String getEditUserId() {
		return editUserId;
	}
	public void setEditUserId(String editUserId) {
		this.editUserId = editUserId;
	}
	
	
}
