package com.ldxx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ldxx.bean.QualityRealtimeDeviation;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class PianChaVo {




    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private List<Date> xList;
    private List<BigDecimal> yList1;
    private List<BigDecimal> yList2;
    private List<BigDecimal> yList3;
    private List<BigDecimal> yList4;
    private List<BigDecimal> yList5;
    private List<BigDecimal> yList6;
    private List<BigDecimal> yList7;
    private List<BigDecimal> yList8;
    private List<BigDecimal> yList9;
    private List<BigDecimal> yList10;
    private List<BigDecimal> yList11;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public List<Date> getxList() {
        return xList;
    }

    public void setxList(List<Date> xList) {
        this.xList = xList;
    }

    public List<BigDecimal> getyList1() {
        return yList1;
    }

    public void setyList1(List<BigDecimal> yList1) {
        this.yList1 = yList1;
    }

    public List<BigDecimal> getyList2() {
        return yList2;
    }

    public void setyList2(List<BigDecimal> yList2) {
        this.yList2 = yList2;
    }

    public List<BigDecimal> getyList3() {
        return yList3;
    }

    public void setyList3(List<BigDecimal> yList3) {
        this.yList3 = yList3;
    }

    public List<BigDecimal> getyList4() {
        return yList4;
    }

    public void setyList4(List<BigDecimal> yList4) {
        this.yList4 = yList4;
    }

    public List<BigDecimal> getyList5() {
        return yList5;
    }

    public void setyList5(List<BigDecimal> yList5) {
        this.yList5 = yList5;
    }

    public List<BigDecimal> getyList6() {
        return yList6;
    }

    public void setyList6(List<BigDecimal> yList6) {
        this.yList6 = yList6;
    }

    public List<BigDecimal> getyList7() {
        return yList7;
    }

    public void setyList7(List<BigDecimal> yList7) {
        this.yList7 = yList7;
    }

    public List<BigDecimal> getyList8() {
        return yList8;
    }

    public void setyList8(List<BigDecimal> yList8) {
        this.yList8 = yList8;
    }

    public List<BigDecimal> getyList9() {
        return yList9;
    }

    public void setyList9(List<BigDecimal> yList9) {
        this.yList9 = yList9;
    }

    public List<BigDecimal> getyList10() {
        return yList10;
    }

    public void setyList10(List<BigDecimal> yList10) {
        this.yList10 = yList10;
    }

    public List<BigDecimal> getyList11() {
        return yList11;
    }

    public void setyList11(List<BigDecimal> yList11) {
        this.yList11 = yList11;
    }

    public PianChaVo getPianChaVoByPianChaVoList (List<QualityRealtimeDeviation> list){

        List<BigDecimal> yList1 = list.stream().map(QualityRealtimeDeviation::getMaterialDeviation1).collect(Collectors.toList());
        List<BigDecimal> yList2 = list.stream().map(QualityRealtimeDeviation::getMaterialDeviation2).collect(Collectors.toList());
        List<BigDecimal> yList3 = list.stream().map(QualityRealtimeDeviation::getMaterialDeviation3).collect(Collectors.toList());
        List<BigDecimal> yList4 = list.stream().map(QualityRealtimeDeviation::getMaterialDeviation4).collect(Collectors.toList());
        List<BigDecimal> yList5 = list.stream().map(QualityRealtimeDeviation::getMaterialDeviation5).collect(Collectors.toList());
        List<BigDecimal> yList6 = list.stream().map(QualityRealtimeDeviation::getMaterialDeviation6).collect(Collectors.toList());
        List<BigDecimal> yList7 = list.stream().map(QualityRealtimeDeviation::getBoneFlourDeviation).collect(Collectors.toList());
        List<BigDecimal> yList8 = list.stream().map(QualityRealtimeDeviation::getPitchDeviation).collect(Collectors.toList());
        List<BigDecimal> yList9 = list.stream().map(QualityRealtimeDeviation::getPass475).collect(Collectors.toList());
        List<BigDecimal> yList10 = list.stream().map(QualityRealtimeDeviation::getPass236).collect(Collectors.toList());
        List<BigDecimal> yList11 = list.stream().map(QualityRealtimeDeviation::getPass0075).collect(Collectors.toList());
        List<Date> xList = list.stream().map(QualityRealtimeDeviation::getDatetime).collect(Collectors.toList());
        PianChaVo pianChaVo = new PianChaVo();
        pianChaVo.setyList1(yList1);
        pianChaVo.setyList2(yList2);
        pianChaVo.setyList3(yList3);
        pianChaVo.setyList4(yList4);
        pianChaVo.setyList5(yList5);
        pianChaVo.setyList6(yList6);
        pianChaVo.setyList7(yList7);
        pianChaVo.setyList8(yList8);
        pianChaVo.setyList9(yList9);
        pianChaVo.setyList10(yList10);
        pianChaVo.setyList11(yList11);
        pianChaVo.setxList(xList);
        return  pianChaVo;
    }
}
