package com.ldxx.vo;

import com.ldxx.bean.SiteRoadSpend;

import java.util.List;
import java.util.stream.Collectors;


public class TanPuSuDuVo {


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

    public TanPuSuDuVo getTanPuSuDuVoByPeiBiVoList (List<SiteRoadSpend> list){

        List<Float> yList1 = list.stream().map(SiteRoadSpend::getSpeed).collect(Collectors.toList());

        List<String> xList = list.stream().map((SiteRoadSpend::getDatetime)).collect(Collectors.toList());

        TanPuSuDuVo tanPuSuDuVo = new TanPuSuDuVo();
        tanPuSuDuVo.setyList1(yList1);
        tanPuSuDuVo.setxList(xList);
        return  tanPuSuDuVo;
    }
}
