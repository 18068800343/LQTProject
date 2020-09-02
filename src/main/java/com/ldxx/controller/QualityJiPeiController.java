package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.bean.DicPeifangshaikong;
import com.ldxx.bean.QualityJiPei;
import com.ldxx.dao.QualityJiPeiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("QualityJiPei")
@RestController
public class QualityJiPeiController {

    @Autowired
    private QualityJiPeiDao dao;

    @RequestMapping("/getAllQualityJiPeiByPeiFang")
    public String getAllQualityJiPeiByPeiFang(String peifangName,String datetime){
        JSONObject jsonObject=new JSONObject();
        QualityJiPei list = dao.getAllQualityJiPeiByPeiFang(peifangName,datetime);
        List<DicPeifangshaikong> list2 = dao.getDicPeifangshaikongByName(peifangName);
        jsonObject.put("QualityJiPei",list);
        jsonObject.put("DicPeifangshaikong",list2);
        return jsonObject.toJSONString();
    }

    @RequestMapping("/getAllQualityJiPeiByTime")
    public List<QualityJiPei> getAllQualityJiPeiByTime(String beginTime,String endTime){
        List<QualityJiPei> list = dao.getAllQualityJiPeiByTime(beginTime,endTime);
        return list;
    }
}
