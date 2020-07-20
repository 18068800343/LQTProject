package com.ldxx.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 仓储管理
 * @author hp
 *
 */
public class WhWarehouseCount {
	
	public String id;

    public String storNo;//料仓编号

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date datetime;//时间

    public BigDecimal weight;//重量

    public String materials;//材料
    public String materialsName;//材料名称

    public String meminfo;//备注

	public String editUserId2;//最后录入用户
	private String uName;

	public String editDatetime2;//最后录入日期

	public int deleteState;//逻辑删除 0:删除；1存在

	private BigDecimal maxWeight;

	private BigDecimal tiji;

	public BigDecimal getTiji() {
		return tiji;
	}

	public void setTiji(BigDecimal tiji) {
		this.tiji = tiji;
	}

	public BigDecimal getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(BigDecimal maxWeight) {
		this.maxWeight = maxWeight;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStorNo() {
		return storNo;
	}

	public void setStorNo(String storNo) {
		this.storNo = storNo;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	public String getMaterialsName() {
		return materialsName;
	}

	public void setMaterialsName(String materialsName) {
		this.materialsName = materialsName;
	}

	public String getMeminfo() {
		return meminfo;
	}

	public void setMeminfo(String meminfo) {
		this.meminfo = meminfo;
	}

	public String getEditUserId2() {
		return editUserId2;
	}

	public void setEditUserId2(String editUserId2) {
		this.editUserId2 = editUserId2;
	}

	public String getEditDatetime2() {
		return editDatetime2;
	}

	public void setEditDatetime2(String editDatetime2) {
		this.editDatetime2 = editDatetime2;
	}

	public int getDeleteState() {
		return deleteState;
	}

	public void setDeleteState(int deleteState) {
		this.deleteState = deleteState;
	}
    

    
    

}
