package com.ldxx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ldxx.bean.QualityByPlateRealTimeProdocutionData;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class PeiBiVo  extends QualityByPlateRealTimeProdocutionData {


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


    public PeiBiVo getPeiBiVoByPeiBiVoList (List<QualityByPlateRealTimeProdocutionData> list){

        List<BigDecimal> yList1 = list.stream().map(QualityByPlateRealTimeProdocutionData::getMaterialsUse1).collect(Collectors.toList());
        List<BigDecimal> yList2 = list.stream().map(QualityByPlateRealTimeProdocutionData::getMaterialsUse2).collect(Collectors.toList());
        List<BigDecimal> yList3 = list.stream().map(QualityByPlateRealTimeProdocutionData::getMaterialsUse3).collect(Collectors.toList());
        List<BigDecimal> yList4 = list.stream().map(QualityByPlateRealTimeProdocutionData::getMaterialsUse4).collect(Collectors.toList());
        List<BigDecimal> yList5 = list.stream().map(QualityByPlateRealTimeProdocutionData::getMaterialsUse5).collect(Collectors.toList());
        List<BigDecimal> yList6 = list.stream().map(QualityByPlateRealTimeProdocutionData::getMaterialsUse6).collect(Collectors.toList());
        List<BigDecimal> yList7 = list.stream().map(QualityByPlateRealTimeProdocutionData::getBoneFlourUse).collect(Collectors.toList());
        List<BigDecimal> yList8 = list.stream().map(QualityByPlateRealTimeProdocutionData::getPitchUse).collect(Collectors.toList());
        List<Date> xList = list.stream().map(QualityByPlateRealTimeProdocutionData::getProductionTime).collect(Collectors.toList());
        PeiBiVo peiBiVo = new PeiBiVo();
        peiBiVo.setyList1(yList1);
        peiBiVo.setyList2(yList2);
        peiBiVo.setyList3(yList3);
        peiBiVo.setyList4(yList4);
        peiBiVo.setyList5(yList5);
        peiBiVo.setyList6(yList6);
        peiBiVo.setyList7(yList7);
        peiBiVo.setyList8(yList8);
        peiBiVo.setxList(xList);
        return  peiBiVo;
    }
}
