package com.ldxx.controller;


import com.alibaba.fastjson.JSONObject;
import com.ldxx.bean.WhCangchu;
import com.ldxx.dao.WhCangchuDao;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("WhCangchu")
public class WhCangchuController {

    @Autowired
    private WhCangchuDao dao;

    @RequestMapping("/getAllWhCangchu")
    public List<WhCangchu> getAllWhCangchu(){
        List<WhCangchu> list = dao.getAllWhCangchu();
        return list;
    }

    @RequestMapping("/delWhCangchu")
    public int delWhCangchu(String id){
        return dao.delWhCangchu(id);
    }

    @RequestMapping("/getWhCangchuById")
    public WhCangchu getWhCangchuById(String id){
        WhCangchu WhCangchu = dao.getWhCangchuById(id);
        return WhCangchu;
    }

    @RequestMapping("/addWhCangchu")
    public String addWhCangchu(WhCangchu whCangchu){
        JSONObject jsonObject = new JSONObject();
        whCangchu.setId(LDXXUtils.getUUID12());
        int countbianhao = dao.countbianhao(whCangchu.getBianhao());
        int i=0;
        if(countbianhao>0){
            i=-2;
        }else{
            i=dao.addWhCangchu(whCangchu);
        }
        String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
        jsonObject.put("resultMsg",daoMsg);
        jsonObject.put("daoMsg",i);
        jsonObject.put("obj",whCangchu);
        return jsonObject.toString();
    }

    @RequestMapping("/updWhCangchu")
    public String updWhCangchu( WhCangchu whCangchu){
        JSONObject jsonObject = new JSONObject();
        int countbianhao = dao.xgcountbianhao(whCangchu.getBianhao(),whCangchu.getId());
        int i=0;
        if(countbianhao>0){
            i=-2;
        }else{
            i=dao.updWhCangchu(whCangchu);
        }
        String daoMsg = MsgFormatUtils.getMsgByResult(i, "更新");
        jsonObject.put("resultMsg",daoMsg);
        jsonObject.put("daoMsg",i);
        jsonObject.put("obj",whCangchu);
        return jsonObject.toString();
    }
}
