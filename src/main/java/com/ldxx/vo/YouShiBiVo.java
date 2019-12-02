package com.ldxx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ldxx.bean.QualityByPlateAsphaltAggregateRatio;
import com.ldxx.dao.QualityByPlateAsphaltAggregateRatioDao;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class YouShiBiVo {


    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private List<Date> xList;
    private List<BigDecimal> yList1;

    @Resource
    private QualityByPlateAsphaltAggregateRatioDao dao;

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

    public YouShiBiVo getYouShiBiVoByPeiBiVoList (List<QualityByPlateAsphaltAggregateRatio> list){

        List<BigDecimal> yList1 = list.stream().map(QualityByPlateAsphaltAggregateRatio::getAsphaltAggregateRatio).collect(Collectors.toList());

        List<Date> xList = list.stream().map((QualityByPlateAsphaltAggregateRatio::getNowTime)).collect(Collectors.toList());

        YouShiBiVo youShiBiVo = new YouShiBiVo();
        youShiBiVo.setyList1(yList1);
        youShiBiVo.setxList(xList);
        return  youShiBiVo;
    }
}
