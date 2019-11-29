package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.bean.SiteRoadMileage;
import com.ldxx.bean.User;
import com.ldxx.service.SiteRoadMileageService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

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
	public List<SiteRoadMileage> selectAllSiteRoadMileage(HttpSession session){
		User user = (User) session.getAttribute("user");
		String luduanquanxian = user.getLuduanquanxian();
		return service.selectAllSiteRoadMileage(luduanquanxian);
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

	/**
	 * 通过路段roadId获取信息
	 * @param roadId
	 * @return
	 */
	@RequestMapping("/getByLuDuanId")
	public List<SiteRoadMileage> getByLuDuanId(String roadId) {
		return service.getByLuDuanId(roadId);
	}

}
