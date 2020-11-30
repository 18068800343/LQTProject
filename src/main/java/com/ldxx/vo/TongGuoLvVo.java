package com.ldxx.vo;

import com.ldxx.bean.QualityJiPei;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


public class TongGuoLvVo{



    private List<String> xList;
    private List<BigDecimal> yList0075;
    private List<BigDecimal> yList015;
    private List<BigDecimal> yList03;
    private List<BigDecimal> yList06;
    private List<BigDecimal> yList118;
    private List<BigDecimal> yList236;
    private List<BigDecimal> yList475;
    private List<BigDecimal> yList95;
    private List<BigDecimal> yList132;
    private List<BigDecimal> yList16;
    private List<BigDecimal> yList19;
    private List<BigDecimal> yList265;
    private List<BigDecimal> yList315;
    private List<BigDecimal> yList375;



    public List<String> getxList() {
        return xList;
    }

    public void setxList(List<String> xList) {
        this.xList = xList;
    }

    public List<BigDecimal> getyList0075() {
        return yList0075;
    }

    public void setyList0075(List<BigDecimal> yList0075) {
        this.yList0075 = yList0075;
    }

    public List<BigDecimal> getyList015() {
        return yList015;
    }

    public void setyList015(List<BigDecimal> yList015) {
        this.yList015 = yList015;
    }

    public List<BigDecimal> getyList03() {
        return yList03;
    }

    public void setyList03(List<BigDecimal> yList03) {
        this.yList03 = yList03;
    }

    public List<BigDecimal> getyList06() {
        return yList06;
    }

    public void setyList06(List<BigDecimal> yList06) {
        this.yList06 = yList06;
    }

    public List<BigDecimal> getyList118() {
        return yList118;
    }

    public void setyList118(List<BigDecimal> yList118) {
        this.yList118 = yList118;
    }

    public List<BigDecimal> getyList236() {
        return yList236;
    }

    public void setyList236(List<BigDecimal> yList236) {
        this.yList236 = yList236;
    }

    public List<BigDecimal> getyList475() {
        return yList475;
    }

    public void setyList475(List<BigDecimal> yList475) {
        this.yList475 = yList475;
    }

    public List<BigDecimal> getyList95() {
        return yList95;
    }

    public void setyList95(List<BigDecimal> yList95) {
        this.yList95 = yList95;
    }

    public List<BigDecimal> getyList132() {
        return yList132;
    }

    public void setyList132(List<BigDecimal> yList132) {
        this.yList132 = yList132;
    }

    public List<BigDecimal> getyList16() {
        return yList16;
    }

    public void setyList16(List<BigDecimal> yList16) {
        this.yList16 = yList16;
    }

    public List<BigDecimal> getyList19() {
        return yList19;
    }

    public void setyList19(List<BigDecimal> yList19) {
        this.yList19 = yList19;
    }

    public List<BigDecimal> getyList265() {
        return yList265;
    }

    public void setyList265(List<BigDecimal> yList265) {
        this.yList265 = yList265;
    }

    public List<BigDecimal> getyList315() {
        return yList315;
    }

    public void setyList315(List<BigDecimal> yList315) {
        this.yList315 = yList315;
    }

    public List<BigDecimal> getyList375() {
        return yList375;
    }

    public void setyList375(List<BigDecimal> yList375) {
        this.yList375 = yList375;
    }

    public TongGuoLvVo getPeiBiVoByPeiBiVoList (List<QualityJiPei> list){

        List<BigDecimal> yList1 = list.stream().map(QualityJiPei::getP0075).collect(Collectors.toList());
        List<BigDecimal> yList2 = list.stream().map(QualityJiPei::getP015).collect(Collectors.toList());
        List<BigDecimal> yList3 = list.stream().map(QualityJiPei::getP03).collect(Collectors.toList());
        List<BigDecimal> yList4 = list.stream().map(QualityJiPei::getP06).collect(Collectors.toList());
        List<BigDecimal> yList5 = list.stream().map(QualityJiPei::getP118).collect(Collectors.toList());
        List<BigDecimal> yList6 = list.stream().map(QualityJiPei::getP236).collect(Collectors.toList());
        List<BigDecimal> yList7 = list.stream().map(QualityJiPei::getP475).collect(Collectors.toList());
        List<BigDecimal> yList8 = list.stream().map(QualityJiPei::getP95).collect(Collectors.toList());
        List<BigDecimal> yList9 = list.stream().map(QualityJiPei::getP132).collect(Collectors.toList());
        List<BigDecimal> yList10 = list.stream().map(QualityJiPei::getP16).collect(Collectors.toList());
        List<BigDecimal> yList11 = list.stream().map(QualityJiPei::getP19).collect(Collectors.toList());
        List<BigDecimal> yList12 = list.stream().map(QualityJiPei::getP265).collect(Collectors.toList());
        List<BigDecimal> yList13 = list.stream().map(QualityJiPei::getP315).collect(Collectors.toList());
        List<BigDecimal> yList14 = list.stream().map(QualityJiPei::getP375).collect(Collectors.toList());

        List<String> xList = list.stream().map(QualityJiPei::getDatetime).collect(Collectors.toList());
        TongGuoLvVo tongGuoLvVo = new TongGuoLvVo();
        tongGuoLvVo.setyList0075(yList1);
        tongGuoLvVo.setyList015(yList2);
        tongGuoLvVo.setyList03(yList3);
        tongGuoLvVo.setyList06(yList4);
        tongGuoLvVo.setyList118(yList5);
        tongGuoLvVo.setyList236(yList6);
        tongGuoLvVo.setyList475(yList7);
        tongGuoLvVo.setyList95(yList8);
        tongGuoLvVo.setyList132(yList9);
        tongGuoLvVo.setyList16(yList10);
        tongGuoLvVo.setyList19(yList11);
        tongGuoLvVo.setyList265(yList12);
        tongGuoLvVo.setyList315(yList13);
        tongGuoLvVo.setyList375(yList14);

        tongGuoLvVo.setxList(xList);
        return  tongGuoLvVo;
    }
}
