package com.ldxx.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Time;

public class PlanProductionCollection
{
    private String planid;

    private String roadid;

    private String planno;

    private String roadnumber;

    private String recipeid;

    private BigDecimal pdneed;

    @DateTimeFormat(pattern = "hh-mm-ss")
    private Time drymixingtime;
    @DateTimeFormat(pattern = "hh-mm-ss")
    private Time wetmixingtime;

    private BigDecimal radio;

    private BigDecimal pdtemp;

    private BigDecimal arrivetemp;

    private BigDecimal price;

    private String datetime;

    private String edituserid;

	private String editdatetime;

	private int deletestate;

	private String pianchaid;

	private String planstate;

	private String finishTime;
	private String distance;
	private String pathPlan;

	private BigDecimal chang;
	private BigDecimal kuan;
	private BigDecimal gao;
	private BigDecimal midu;
	private BigDecimal fuyuliang;

	private BigDecimal pdTempMax;//成品温度最高要求
	private String productionTime;//生产时间
	private String remark;//备注

	public BigDecimal getPdTempMax() {
		return pdTempMax;
	}

	public void setPdTempMax(BigDecimal pdTempMax) {
		this.pdTempMax = pdTempMax;
	}

	public String getProductionTime() {
		return productionTime;
	}

	public void setProductionTime(String productionTime) {
		this.productionTime = productionTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getChang() {
		return chang;
	}

	public void setChang(BigDecimal chang) {
		this.chang = chang;
	}

	public BigDecimal getKuan() {
		return kuan;
	}

	public void setKuan(BigDecimal kuan) {
		this.kuan = kuan;
	}

	public BigDecimal getGao() {
		return gao;
	}

	public void setGao(BigDecimal gao) {
		this.gao = gao;
	}

	public BigDecimal getMidu() {
		return midu;
	}

	public void setMidu(BigDecimal midu) {
		this.midu = midu;
	}

	public BigDecimal getFuyuliang() {
		return fuyuliang;
	}

	public void setFuyuliang(BigDecimal fuyuliang) {
		this.fuyuliang = fuyuliang;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getPathPlan() {
		return pathPlan;
	}

	public void setPathPlan(String pathPlan) {
		this.pathPlan = pathPlan;
	}

	public String getPlanstate() {
		return planstate;
	}

	public void setPlanstate(String planstate) {
		this.planstate = planstate;
	}

	public String getPianchaid() {
		return pianchaid;
	}

	public void setPianchaid(String pianchaid) {
		this.pianchaid = pianchaid;
	}

	public String getPlanid() {
		return planid;
	}

	public void setPlanid(String planid) {
		this.planid = planid;
	}

	public String getRoadid() {
		return roadid;
	}

	public void setRoadid(String roadid) {
		this.roadid = roadid;
	}

	public String getPlanno() {
		return planno;
	}

	public void setPlanno(String planno) {
		this.planno = planno;
	}

	public String getRoadnumber() {
		return roadnumber;
	}

	public void setRoadnumber(String roadnumber) {
		this.roadnumber = roadnumber;
	}

	public String getRecipeid() {
		return recipeid;
	}

	public void setRecipeid(String recipeid) {
		this.recipeid = recipeid;
	}
	
	public Time getDrymixingtime() {
		return drymixingtime;
	}

	public void setDrymixingtime(Time drymixingtime) {
		this.drymixingtime = drymixingtime;
	}

	public Time getWetmixingtime() {
		return wetmixingtime;
	}

	public void setWetmixingtime(Time wetmixingtime) {
		this.wetmixingtime = wetmixingtime;
	}

	public BigDecimal getRadio() {
		return radio;
	}

	public void setRadio(BigDecimal radio) {
		this.radio = radio;
	}

	public BigDecimal getPdtemp() {
		return pdtemp;
	}

	public void setPdtemp(BigDecimal pdtemp) {
		this.pdtemp = pdtemp;
	}

	public BigDecimal getArrivetemp() {
		return arrivetemp;
	}

	public void setArrivetemp(BigDecimal arrivetemp) {
		this.arrivetemp = arrivetemp;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getEdituserid() {
		return edituserid;
	}

	public void setEdituserid(String edituserid) {
		this.edituserid = edituserid;
	}

	public String getEditdatetime() {
		return editdatetime;
	}

	public void setEditdatetime(String editdatetime) {
		this.editdatetime = editdatetime;
	}

	public int getDeletestate() {
		return deletestate;
	}

	public void setDeletestate(int deletestate) {
		this.deletestate = deletestate;
	}

	public BigDecimal getPdneed() {
		return pdneed;
	}

	public void setPdneed(BigDecimal pdneed) {
		this.pdneed = pdneed;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
}