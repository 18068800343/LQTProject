package com.ldxx.bean;

import java.math.BigDecimal;
import java.sql.Time;

import org.springframework.format.annotation.DateTimeFormat;

public class PlanConstructionDeviation
{
    public String id;

    public String planid;

    public String roadid;

    public String pianchaname;
    
    private String pianchano;
    
    public BigDecimal Materialdeviation1;

    public BigDecimal Materialdeviation2;

    public BigDecimal Materialdeviation3;

    public BigDecimal Materialdeviation4;

    public BigDecimal Materialdeviation5;

    public BigDecimal Materialdeviation6;

    public BigDecimal Boneflourdeviation;

    public BigDecimal pitchdeviation;

    public BigDecimal pdTempOffset;

    public BigDecimal arriveTempOffset;
    @DateTimeFormat(pattern = "hh-mm-ss")
    public Time drymixingtimedeviation;
    @DateTimeFormat(pattern = "hh-mm-ss")
    public Time wetmixingtimedeviation;

    public BigDecimal pass475;

    public BigDecimal pass236;

    public BigDecimal pass0075;

    public String datetime;

    public int deletestate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public BigDecimal getMaterialdeviation1() {
		return Materialdeviation1;
	}

	public void setMaterialdeviation1(BigDecimal materialdeviation1) {
		Materialdeviation1 = materialdeviation1;
	}

	public BigDecimal getMaterialdeviation2() {
		return Materialdeviation2;
	}

	public void setMaterialdeviation2(BigDecimal materialdeviation2) {
		Materialdeviation2 = materialdeviation2;
	}

	public BigDecimal getMaterialdeviation3() {
		return Materialdeviation3;
	}

	public void setMaterialdeviation3(BigDecimal materialdeviation3) {
		Materialdeviation3 = materialdeviation3;
	}

	public BigDecimal getMaterialdeviation4() {
		return Materialdeviation4;
	}

	public void setMaterialdeviation4(BigDecimal materialdeviation4) {
		Materialdeviation4 = materialdeviation4;
	}

	public BigDecimal getMaterialdeviation5() {
		return Materialdeviation5;
	}

	public void setMaterialdeviation5(BigDecimal materialdeviation5) {
		Materialdeviation5 = materialdeviation5;
	}

	public BigDecimal getMaterialdeviation6() {
		return Materialdeviation6;
	}

	public void setMaterialdeviation6(BigDecimal materialdeviation6) {
		Materialdeviation6 = materialdeviation6;
	}

	public BigDecimal getBoneflourdeviation() {
		return Boneflourdeviation;
	}

	public void setBoneflourdeviation(BigDecimal boneflourdeviation) {
		Boneflourdeviation = boneflourdeviation;
	}

	public BigDecimal getPitchdeviation() {
		return pitchdeviation;
	}

	public void setPitchdeviation(BigDecimal pitchdeviation) {
		this.pitchdeviation = pitchdeviation;
	}

	public Time getDrymixingtimedeviation() {
		return drymixingtimedeviation;
	}

	public void setDrymixingtimedeviation(Time drymixingtimedeviation) {
		this.drymixingtimedeviation = drymixingtimedeviation;
	}

	public Time getWetmixingtimedeviation() {
		return wetmixingtimedeviation;
	}

	public void setWetmixingtimedeviation(Time wetmixingtimedeviation) {
		this.wetmixingtimedeviation = wetmixingtimedeviation;
	}

	public BigDecimal getPass475() {
		return pass475;
	}

	public void setPass475(BigDecimal pass475) {
		this.pass475 = pass475;
	}

	public BigDecimal getPass236() {
		return pass236;
	}

	public void setPass236(BigDecimal pass236) {
		this.pass236 = pass236;
	}

	public BigDecimal getPass0075() {
		return pass0075;
	}

	public void setPass0075(BigDecimal pass0075) {
		this.pass0075 = pass0075;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public int getDeletestate() {
		return deletestate;
	}

	public void setDeletestate(int deletestate) {
		this.deletestate = deletestate;
	}

	public String getPianchaname() {
		return pianchaname;
	}

	public void setPianchaname(String pianchaname) {
		this.pianchaname = pianchaname;
	}

	public String getPianchano() {
		return pianchano;
	}

	public void setPianchano(String pianchano) {
		this.pianchano = pianchano;
	}

	public BigDecimal getPdTempOffset() {
		return pdTempOffset;
	}

	public void setPdTempOffset(BigDecimal pdTempOffset) {
		this.pdTempOffset = pdTempOffset;
	}

	public BigDecimal getArriveTempOffset() {
		return arriveTempOffset;
	}

	public void setArriveTempOffset(BigDecimal arriveTempOffset) {
		this.arriveTempOffset = arriveTempOffset;
	}
	
	
}
