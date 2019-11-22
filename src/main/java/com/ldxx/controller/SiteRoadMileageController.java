package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.util.MsgFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldxx.bean.SiteRoadMileage;
import com.ldxx.bean.User;
import com.ldxx.service.SiteRoadMileageService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;

/**
 * 摊铺里程
 * @author hp
 *
 */

@RestController
@RequestMapping("SiteRoadMileage")
public class SiteRoadMileageController {
	
	@Autowired
	private SiteRoadMileageService service;
	
	@RequestMapping("/selectAllSiteRoadMileage")
	public List<SiteRoadMileage> selectAllSiteRoadMileage(){
		return service.selectAllSiteRoadMileage();
	}
	
	@RequestMapping("/updSiteRoadMileage")
	public String updSiteRoadMileage(@RequestBody SiteRoadMileage srm ,HttpSession session){
		JSONObject jsonObject = new JSONObject();
        srm.setEditDatetime2(GetThisTimeUtils.getDateTime());
        User user = (User) session.getAttribute("user");
		if(null!=user) {
			srm.setEditUserId2(user.getUserId());
			srm.setEditDatetime2(GetThisTimeUtils.getDateTime());
		}
		int i= service.updSiteRoadMileage(srm);
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "修改");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",srm);
		return jsonObject.toJSONString();
	}
	
	@RequestMapping("/delSiteRoadMileage")
	public int delSiteRoadMileage(String id){
		int i= service.delSiteRoadMileage(id);
		return i;
	}
	
	@RequestMapping("/insertSiteRoadMileage")
	public String insertSiteRoadMileage(@RequestBody SiteRoadMileage srm,HttpSession session){
		JSONObject jsonObject = new JSONObject();
		srm.setId(LDXXUtils.getUUID12());
		srm.setEditDatetime2(GetThisTimeUtils.getDateTime());
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			srm.setEditUserId2(user.getUserId());
			srm.setEditDatetime2(GetThisTimeUtils.getDateTime());
		}
		int i= service.insertSiteRoadMileage(srm);
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",srm);
		return jsonObject.toJSONString();
	}

}
