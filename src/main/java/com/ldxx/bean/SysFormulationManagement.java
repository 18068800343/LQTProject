package com.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

public class SysFormulationManagement {
	private String flId;
	private String flNo;
	private String flName;
	private BigDecimal materialsUse1;
	private BigDecimal materialsUse2;
	private BigDecimal materialsUse3;
	private BigDecimal materialsUse4;
	private BigDecimal materialsUse5;
	private BigDecimal materialsUse6;
	private BigDecimal boneFlourUse;
	private BigDecimal pitchUse;
	private List<SysMaterialAttached> fsclList;
	private Integer deleteState;
	public String getFlId() {
		return flId;
	}
	public void setFlId(String flId) {
		this.flId = flId;
	}
	public String getFlNo() {
		return flNo;
	}
	public void setFlNo(String flNo) {
		this.flNo = flNo;
	}
	public String getFlName() {
		return flName;
	}
	public void setFlName(String flName) {
		this.flName = flName;
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
	public Integer getDeleteState() {
		return deleteState;
	}
	public void setDeleteState(Integer deleteState) {
		this.deleteState = deleteState;
	}
	public List<SysMaterialAttached> getFsclList() {
		return fsclList;
	}
	public void setFsclList(List<SysMaterialAttached> fsclList) {
		this.fsclList = fsclList;
	}

	
}
