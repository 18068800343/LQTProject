package com.ldxx.vo;

import com.ldxx.bean.SiteRoadMileage;

import java.util.List;
import java.util.stream.Collectors;


public class TanPuLiChengVo {


    private List<String> xList;
    private List<Float> yList1;

    public List<String> getxList() {
        return xList;
    }

    public void setxList(List<String> xList) {
        this.xList = xList;
    }

    public List<Float> getyList1() {
        return yList1;
    }

    public void setyList1(List<Float> yList1) {
        this.yList1 = yList1;
    }

    public TanPuLiChengVo getTanPuLiChengVoByPeiBiVoList (List<SiteRoadMileage> list){

        List<Float> yList1 = list.stream().map(SiteRoadMileage::getLength).collect(Collectors.toList());

        List<String> xList = list.stream().map((SiteRoadMileage::getDatetime)).collect(Collectors.toList());

        TanPuLiChengVo tanPuLiChengVo = new TanPuLiChengVo();
        tanPuLiChengVo.setyList1(yList1);
        tanPuLiChengVo.setxList(xList);
        return  tanPuLiChengVo;
    }
}
