package com.ldxx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ldxx.bean.QualityKeyMeshPassRate;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class TongGuoLvVo{


    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private List<Date> xList;
    private List<BigDecimal> yList1;
    private List<BigDecimal> yList2;
    private List<BigDecimal> yList3;


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


    public TongGuoLvVo getPeiBiVoByPeiBiVoList (List<QualityKeyMeshPassRate> list){

        List<BigDecimal> yList1 = list.stream().map(QualityKeyMeshPassRate::getR1).collect(Collectors.toList());
        List<BigDecimal> yList2 = list.stream().map(QualityKeyMeshPassRate::getR2).collect(Collectors.toList());
        List<BigDecimal> yList3 = list.stream().map(QualityKeyMeshPassRate::getR3).collect(Collectors.toList());

        List<Date> xList = list.stream().map(QualityKeyMeshPassRate::getProductionTime).collect(Collectors.toList());
        TongGuoLvVo tongGuoLvVo = new TongGuoLvVo();
        tongGuoLvVo.setyList1(yList1);
        tongGuoLvVo.setyList2(yList2);
        tongGuoLvVo.setyList3(yList3);

        tongGuoLvVo.setxList(xList);
        return  tongGuoLvVo;
    }
}
