package com.ldxx.bean;

/**
 * 预警管理
 * @author hp
 *
 */
public class SysWarningSet {
	
	private String Id;
	//预警项
	private String warnName;
	//是否预警
	private int warnSet;//0:否；1：预警
	
	public String getId() {
		return Id;
	}
	public void setId(String Id) {
		this.Id = Id;
	}
	public String getWarnName() {
		return warnName;
	}
	public void setWarnName(String warnName) {
		this.warnName = warnName;
	}
	public int getWarnSet() {
		return warnSet;
	}
	public void setWarnSet(int warnSet) {
		this.warnSet = warnSet;
	}

}
