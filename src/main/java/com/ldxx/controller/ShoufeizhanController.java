package com.ldxx.controller;

import com.ldxx.bean.Shoufeizhan;
import com.ldxx.dao.ShoufeizhanDao;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("shoufeizhan")
@RestController
public class ShoufeizhanController {

    @Autowired
    private ShoufeizhanDao dao;

    private Map<String,Object> map=new HashMap<>();


    @RequestMapping("/getAllshoufeizhan")
    public List<Shoufeizhan> getAllshoufeizhan(){
        return dao.getAllshoufeizhan();
    }

    @RequestMapping("/addShoufeizhan")
    public Map<String,Object> addShoufeizhan(Shoufeizhan shoufeizhan){
        shoufeizhan.setId(LDXXUtils.getUUID12());
        //int i = dao.addShoufeizhan(shoufeizhan);
        int i=0;
        int d = dao.getCountName(shoufeizhan.getName());
        if(d>0)
        {
            i=-1;
        }else {
            i= dao.addShoufeizhan(shoufeizhan);
        }
        String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
        map.put("resultMsg",daoMsg);
        map.put("result",i);
        map.put("obj",shoufeizhan);
        return map;
    }

    @RequestMapping("/updShoufeizhan")
    public Map<String,Object> updShoufeizhan( Shoufeizhan shoufeizhan){
        //int i = dao.updShoufeizhan(shoufeizhan);
        int i=0;
        int d = dao.xggetCountName(shoufeizhan);
        if(d>0)
        {
            i=-1;
        }else {
            i= dao.updShoufeizhan(shoufeizhan);
        }
        String daoMsg = MsgFormatUtils.getMsgByResult(i, "更新");
        map.put("resultMsg",daoMsg);
        map.put("result",i);
        map.put("obj",shoufeizhan);
        return map;
    }

    @RequestMapping("/delShoufeizhan")
    public int delShoufeizhan(String id){
        return dao.delShoufeizhan(id);
    }
}
