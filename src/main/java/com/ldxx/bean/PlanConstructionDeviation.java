package com.ldxx.bean;

import java.math.BigDecimal;
import java.sql.Time;

public class PlanConstructionDeviation
{
	private String id;

	private String planid;

	private String roadid;

	private BigDecimal Material_deviation_1;

	private BigDecimal Material_deviation_2;

	private BigDecimal Material_deviation_3;

	private BigDecimal Material_deviation_4;

	private BigDecimal Material_deviation_5;

	private BigDecimal Material_deviation_6;

	private BigDecimal Bone_flour_deviation;

	private BigDecimal pitchdeviation;

	private BigDecimal tempmax;

	private BigDecimal tempmin;

	private Time dry_mixing_time_deviation;

	private Time wet_mixing_time_deviation;

	private BigDecimal pass_475;

	private BigDecimal pass_236;

	private BigDecimal pass_0075;

	private String datetime;
    
	private int delete_state;

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

	public BigDecimal getMaterial_deviation_1() {
		return Material_deviation_1;
	}

	public void setMaterial_deviation_1(BigDecimal material_deviation_1) {
		Material_deviation_1 = material_deviation_1;
	}

	public BigDecimal getMaterial_deviation_2() {
		return Material_deviation_2;
	}

	public void setMaterial_deviation_2(BigDecimal material_deviation_2) {
		Material_deviation_2 = material_deviation_2;
	}

	public BigDecimal getMaterial_deviation_3() {
		return Material_deviation_3;
	}

	public void setMaterial_deviation_3(BigDecimal material_deviation_3) {
		Material_deviation_3 = material_deviation_3;
	}

	public BigDecimal getMaterial_deviation_4() {
		return Material_deviation_4;
	}

	public void setMaterial_deviation_4(BigDecimal material_deviation_4) {
		Material_deviation_4 = material_deviation_4;
	}

	public BigDecimal getMaterial_deviation_5() {
		return Material_deviation_5;
	}

	public void setMaterial_deviation_5(BigDecimal material_deviation_5) {
		Material_deviation_5 = material_deviation_5;
	}

	public BigDecimal getMaterial_deviation_6() {
		return Material_deviation_6;
	}

	public void setMaterial_deviation_6(BigDecimal material_deviation_6) {
		Material_deviation_6 = material_deviation_6;
	}

	public BigDecimal getBone_flour_deviation() {
		return Bone_flour_deviation;
	}

	public void setBone_flour_deviation(BigDecimal bone_flour_deviation) {
		Bone_flour_deviation = bone_flour_deviation;
	}

	public BigDecimal getPitchdeviation() {
		return pitchdeviation;
	}

	public void setPitchdeviation(BigDecimal pitchdeviation) {
		this.pitchdeviation = pitchdeviation;
	}

	public BigDecimal getTempmax() {
		return tempmax;
	}

	public void setTempmax(BigDecimal tempmax) {
		this.tempmax = tempmax;
	}

	public BigDecimal getTempmin() {
		return tempmin;
	}

	public void setTempmin(BigDecimal tempmin) {
		this.tempmin = tempmin;
	}

	public Time getDry_mixing_time_deviation() {
		return dry_mixing_time_deviation;
	}

	public void setDry_mixing_time_deviation(Time dry_mixing_time_deviation) {
		this.dry_mixing_time_deviation = dry_mixing_time_deviation;
	}

	public Time getWet_mixing_time_deviation() {
		return wet_mixing_time_deviation;
	}

	public void setWet_mixing_time_deviation(Time wet_mixing_time_deviation) {
		this.wet_mixing_time_deviation = wet_mixing_time_deviation;
	}

	public BigDecimal getPass_475() {
		return pass_475;
	}

	public void setPass_475(BigDecimal pass_475) {
		this.pass_475 = pass_475;
	}

	public BigDecimal getPass_236() {
		return pass_236;
	}

	public void setPass_236(BigDecimal pass_236) {
		this.pass_236 = pass_236;
	}

	public BigDecimal getPass_0075() {
		return pass_0075;
	}

	public void setPass_0075(BigDecimal pass_0075) {
		this.pass_0075 = pass_0075;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public int getDelete_state() {
		return delete_state;
	}

	public void setDelete_state(int delete_state) {
		this.delete_state = delete_state;
	}
    
}
