package com.ldxx.vo;

import com.ldxx.bean.PlanProductionCollection;

import java.math.BigDecimal;

public class PlanProductionCollectionVo extends PlanProductionCollection {
	private String uname;

	private String flno;

	private String roadname;

	private String roadno;

	private String pianchano;

	private String pianchaname;

    private String sumneed;

    private String planstatecn;

    private String stakeMark;

    private String turnRoundStakeMark;

    private String team;

    private String shigongceng;

    private String chedao;

    private String direction;

    private String roadName;

    private BigDecimal lng;

    private BigDecimal lat;

    private String siteId;

    private BigDecimal zongjia;

    public String getShigongceng() {
        return shigongceng;
    }

    public void setShigongceng(String shigongceng) {
        this.shigongceng = shigongceng;
    }

    public String getChedao() {
        return chedao;
    }

    public void setChedao(String chedao) {
        this.chedao = chedao;
    }

    public BigDecimal getZongjia() {
        return zongjia;
    }

    public void setZongjia(BigDecimal zongjia) {
        this.zongjia = zongjia;
    }

    public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getStakeMark() {
		return stakeMark;
	}

	public void setStakeMark(String stakeMark) {
		this.stakeMark = stakeMark;
	}

	public String getTurnRoundStakeMark() {
		return turnRoundStakeMark;
	}

	public void setTurnRoundStakeMark(String turnRoundStakeMark) {
		this.turnRoundStakeMark = turnRoundStakeMark;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public BigDecimal getLng() {
		return lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public String getPlanstatecn() {
		return planstatecn;
	}

	public void setPlanstatecn(String planstatecn) {
		this.planstatecn = planstatecn;
	}

	public String getSumneed() {
		return sumneed;
	}

	public void setSumneed(String sumneed) {
		this.sumneed = sumneed;
	}

	public String getPianchano() {
		return pianchano;
	}

	public void setPianchano(String pianchano) {
		this.pianchano = pianchano;
	}

	public String getPianchaname() {
		return pianchaname;
	}

	public void setPianchaname(String pianchaname) {
		this.pianchaname = pianchaname;
	}

	public String getRoadno() {
		return roadno;
	}

	public void setRoadno(String roadno) {
		this.roadno = roadno;
	}

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

	public String getRoadname() {
		return roadname;
	}

	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}

}