package com.ldxx.bean;
/**
 * 部门
 * @author hp
 *
 */
public class UOrganizationManagement {
	
	public String omId;

	public String omNo;//部门编号

    public String omName;//部门名称

    public String superiorId;//上级部门外键

    public String omTel;//部门电话

    public String omFax;//部门传真

    public String sfProduction;//是否为生产部门
    

	public String getOmId() {
		return omId;
	}

	public void setOmId(String omId) {
		this.omId = omId;
	}

	public String getOmNo() {
		return omNo;
	}

	public void setOmNo(String omNo) {
		this.omNo = omNo;
	}

	public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
	}

	public String getSuperiorId() {
		return superiorId;
	}

	public void setSuperiorId(String superiorId) {
		this.superiorId = superiorId;
	}

	public String getOmTel() {
		return omTel;
	}

	public void setOmTel(String omTel) {
		this.omTel = omTel;
	}

	public String getOmFax() {
		return omFax;
	}

	public void setOmFax(String omFax) {
		this.omFax = omFax;
	}

	public String getSfProduction() {
		return sfProduction;
	}

	public void setSfProduction(String sfProduction) {
		this.sfProduction = sfProduction;
	}
    
    

}
