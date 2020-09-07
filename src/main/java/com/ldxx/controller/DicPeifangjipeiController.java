package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.bean.DicPeifangjipei;
import com.ldxx.dao.DicPeifangjipeiDao;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("DicPeifangjipei")
@RestController
public class DicPeifangjipeiController {

    @Autowired
    private DicPeifangjipeiDao dao;

    @RequestMapping("/getAllDicPeifangjipei")
    public List<DicPeifangjipei> getAllDicPeifangjipei(){
        List<DicPeifangjipei> list = dao.getAllDicPeifangjipei();
        return list;
    }

    @RequestMapping("/insertDicPeifangjipei")
    public String insertDicPeifangjipei(@RequestBody DicPeifangjipei DicPeifangjipei){
        JSONObject jsonObject=new JSONObject();
        DicPeifangjipei.setId(LDXXUtils.getUUID12());
        int i = dao.getCountName(DicPeifangjipei.getName(), DicPeifangjipei.getPeifangId());
        if(i>0){
            i=-1;
        }else{
            String mark;
            switch (DicPeifangjipei.getName()){
                case "5#仓":
                    mark="5";
                    break;
                case  "4#仓":
                    mark="4";
                    break;
                case  "3#仓":
                    mark="3";
                    break;
                case  "2#仓":
                    mark="2";
                    break;
                case  "矿粉":
                    mark="kf";
                    break;
                default:
                    mark ="";
                    break;
            }
            DicPeifangjipei.setMark(mark);
            i = dao.insertDicPeifangjipei(DicPeifangjipei);
        }

        String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
        jsonObject.put("resultMsg",daoMsg);
        jsonObject.put("flag",i);
        jsonObject.put("obj",DicPeifangjipei);
        return jsonObject.toJSONString();
    }
    @RequestMapping("/updDicPeifangjipei")
    public String updDicPeifangjipei(@RequestBody DicPeifangjipei DicPeifangjipei){
        JSONObject jsonObject=new JSONObject();
        int i = dao.xg_getCountName(DicPeifangjipei.getName(), DicPeifangjipei.getPeifangId(),DicPeifangjipei.getId());
        if(i>0){
            i=-1;
        }else{
            String mark;
            switch (DicPeifangjipei.getName()){
                case "5#仓":
                    mark="5";
                    break;
                case  "4#仓":
                    mark="4";
                    break;
                case  "3#仓":
                    mark="3";
                    break;
                case  "2#仓":
                    mark="2";
                    break;
                case  "矿粉":
                    mark="kf";
                    break;
                default:
                    mark ="";
                    break;
            }
            DicPeifangjipei.setMark(mark);
            i = dao.updDicPeifangjipei(DicPeifangjipei);
        }
        String daoMsg = MsgFormatUtils.getMsgByResult(i, "更新");
        jsonObject.put("resultMsg",daoMsg);
        jsonObject.put("flag",i);
        jsonObject.put("obj",DicPeifangjipei);
        return jsonObject.toJSONString();
    }

    @RequestMapping("/delDicPeifangjipei")
    public int delDicPeifangjipei(String id){
        int i = dao.delDicPeifangjipei(id);
        return i;
    }

}
