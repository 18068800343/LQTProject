package com.ldxx.vo;

import com.ldxx.bean.SiteRoadMileageTemp;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


public class TanPuWenDuVo {


    private List<String> xList;
    private List<BigDecimal> yList1;
    private List<BigDecimal> yList2;

    public List<BigDecimal> getyList2() {
        return yList2;
    }

    public void setyList2(List<BigDecimal> yList2) {
        this.yList2 = yList2;
    }

    public List<String> getxList() {
        return xList;
    }

    public void setxList(List<String> xList) {
        this.xList = xList;
    }

    public List<BigDecimal> getyList1() {
        return yList1;
    }

    public void setyList1(List<BigDecimal> yList1) {
        this.yList1 = yList1;
    }

    public TanPuWenDuVo getTanPuWenDuVoByPeiBiVoList (List<SiteRoadMileageTemp> list){

        List<BigDecimal> yList1 = list.stream().map(SiteRoadMileageTemp::getTemp).collect(Collectors.toList());

        List<BigDecimal> yList2 = list.stream().map(SiteRoadMileageTemp::getTemp2).collect(Collectors.toList());

        List<String> xList = list.stream().map((SiteRoadMileageTemp::getDatetime)).collect(Collectors.toList());

        TanPuWenDuVo tanPuWenDuVo = new TanPuWenDuVo();
        tanPuWenDuVo.setyList1(yList1);
        tanPuWenDuVo.setyList2(yList2);

        tanPuWenDuVo.setxList(xList);
        return  tanPuWenDuVo;
    }
}
