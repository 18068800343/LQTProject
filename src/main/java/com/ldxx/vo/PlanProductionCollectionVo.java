package com.ldxx.vo;

import com.ldxx.bean.PlanProductionCollection;

public class PlanProductionCollectionVo extends PlanProductionCollection
{
	private String uname;
	
	private String flno;
	
	private String sitename;
	
	private String rdnumber;
	
	private String roadno;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getFlno() {
		return flno;
	}

	public void setFlno(String flno) {
		this.flno = flno;
	}

	public String getSitename() {
		return sitename;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public String getRoadno() {
		return roadno;
	}

	public void setRoadno(String roadno) {
		this.roadno = roadno;
	}

	public String getRdnumber() {
		return rdnumber;
	}

	public void setRdnumber(String rdnumber) {
		this.rdnumber = rdnumber;
	}
	
}