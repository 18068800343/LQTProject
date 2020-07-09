package com.ldxx.bean;

import java.math.BigDecimal;

/**
 * 预警管理
 *
 * @author hp
 */
public class SysWarningSet {

	private String id;
	//预警项
	private String warnName;
	//是否预警
	private int warnSet;//0:否；1：预警
	private BigDecimal minwarn;
	private BigDecimal maxwarn;
	private int warngrade;

	public BigDecimal getMinwarn() {
		return minwarn;
	}

	public void setMinwarn(BigDecimal minwarn) {
		this.minwarn = minwarn;
	}

	public BigDecimal getMaxwarn() {
		return maxwarn;
	}

	public void setMaxwarn(BigDecimal maxwarn) {
		this.maxwarn = maxwarn;
	}

	public int getWarngrade() {
		return warngrade;
	}

	public void setWarngrade(int warngrade) {
		this.warngrade = warngrade;
	}

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
