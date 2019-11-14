package com.ldxx.bean;

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
