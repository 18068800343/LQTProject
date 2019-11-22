package com.ldxx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ldxx.bean.SiteRoadMileageTemp;
import com.ldxx.bean.User;
import com.ldxx.service.SiteRoadMileageTempService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * 摊铺温度
 */

@RestController
@RequestMapping("SiteRoadMileageTemp")
public class SiteRoadMileageTempController {

    @Autowired
    private SiteRoadMileageTempService service;

    @RequestMapping("/getAllSiteRoadMileageTemp")
    public List<SiteRoadMileageTemp> getAllSiteRoadMileageTemp(){
        return service.getAllSiteRoadMileageTemp();
    }

    @RequestMapping("/updSiteRoadMileageTemp")
    public String updSiteRoadMileageTemp(@RequestBody SiteRoadMileageTemp srm,HttpSession session){
        JSONObject json=new JSONObject();
        srm.setEditDatetime(GetThisTimeUtils.getDateTime());
        User user = (User) session.getAttribute("user");
		if(null!=user) {
			srm.setEditUserId(user.getUserId());
		}
        int i= service.updSiteRoadMileageTemp(srm);
        String msg = MsgFormatUtils.getMsgByResult(i, "修改");
        json.put("msg",msg);
        json.put("result",i);
        json.put("obj",srm);
        return json.toJSONString();
    }

    @RequestMapping("/delSiteRoadMileageTemp")
    public int delSiteRoadMileageTemp(String id){
        return service.delSiteRoadMileageTemp(id);
    }

    @RequestMapping("/insertSiteRoadMileageTemp")
    public String insertSiteRoadMileageTemp(@RequestBody SiteRoadMileageTemp srm,HttpSession session){
        JSONObject json=new JSONObject();
        srm.setId(LDXXUtils.getUUID12());
        srm.setEditDatetime(GetThisTimeUtils.getDateTime());
        User user = (User) session.getAttribute("user");
		if(null!=user) {
			srm.setEditUserId(user.getUserId());
		}
        int i= service.insertSiteRoadMileageTemp(srm);
        String msg = MsgFormatUtils.getMsgByResult(i, "新增");
        json.put("msg",msg);
        json.put("result",i);
        json.put("obj",srm);
        return json.toJSONString();
    }

}
