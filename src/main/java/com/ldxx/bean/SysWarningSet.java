package com.ldxx.bean;

/**
 * 预警管理
 * @author hp
 *
 */
public class SysWarningSet {
	
	private String id;
	//预警项
	private String warnName;
	//是否预警
	private int warnSet;//0:否；1：预警
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
