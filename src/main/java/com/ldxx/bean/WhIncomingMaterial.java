package com.ldxx.bean;

/**
 * 进料监控报表
 * @author hp
 *
 */
public class WhIncomingMaterial {
	
	public String id;

    public String no;//编号

    public String datetime;//时间

    public Double weight;//重量

    public String materials;//材料id
    public String materialsName;//材料名

    public String waterContent;//含水量

    public String companyId;//来货单位

    public Double price;//价格

    public String storNo;//料仓编号

    public String meminfo;//备注

    public String editUserId;//录入人

    public int deleteState;//逻辑删除 1:存在；0删除
    

	public String getMaterialsName() {
		return materialsName;
	}

	public void setMaterialsName(String materialsName) {
		this.materialsName = materialsName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	public String getWaterContent() {
		return waterContent;
	}

	public void setWaterContent(String waterContent) {
		this.waterContent = waterContent;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStorNo() {
		return storNo;
	}

	public void setStorNo(String storNo) {
		this.storNo = storNo;
	}

	public String getMeminfo() {
		return meminfo;
	}

	public void setMeminfo(String meminfo) {
		this.meminfo = meminfo;
	}

	public String getEditUserId() {
		return editUserId;
	}

	public void setEditUserId(String editUserId) {
		this.editUserId = editUserId;
	}

	public int getDeleteState() {
		return deleteState;
	}

	public void setDeleteState(int deleteState) {
		this.deleteState = deleteState;
	}
    
    
    

}
