package com.ldxx.controller;

import java.util.*;

import com.ldxx.Constant.DateConstant;
import com.ldxx.bean.User;
import com.ldxx.bean.WhCangchu;
import com.ldxx.dao.WhCangchuDao;
import com.ldxx.dao.WhIncomingMaterialDao;
import com.ldxx.dao.WhWarehouseCountDao;
import com.ldxx.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.WhIncomingMaterial;
import com.ldxx.service.WhIncomingMaterialService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 进料监控报表
 * @author hp
 *
 */
@Controller
@RequestMapping("WhIncomingMaterial")
public class WhIncomingMaterialController {

	@Autowired
	private WhIncomingMaterialService service;
	//仓储管理dao
	@Resource
	private WhIncomingMaterialDao dao;
	//仓储管理dao
	@Resource
	private WhCangchuDao whCangchuDao;
	private Map<String, Object> map = new HashMap<>();

	@RequestMapping("/getAllWhIncomingMaterial")
	@ResponseBody
	public List<WhIncomingMaterial> getAllWhIncomingMaterial(String beginTime, String endTime) {
		return dao.getAllWhIncomingMaterial(beginTime, endTime);
	}

	@RequestMapping("/getWhIncomingMaterialById")
	@ResponseBody
	public WhIncomingMaterial getWhIncomingMaterialById(String id) {
		return service.getWhIncomingMaterialById(id);
	}


	@RequestMapping("/getWhCangChuByCailiao")
	@ResponseBody
	public List<WhCangchu> getWhCangChuByCailiao(String cailiao) {
		return whCangchuDao.getWhCangchuListByCaiLiao(cailiao);
	}

	@RequestMapping("/updWhIncomingMaterialById")
	@ResponseBody
	public Map<String, Object> updWhIncomingMaterialById(WhIncomingMaterial wm, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (null != user) {
			wm.setEditUserId(user.getUserId());
			wm.setEditDatetime(GetThisTimeUtils.getDateTime());
			wm.setuName(user.getuName());
		}
		int i= service.updWhIncomingMaterialById(wm);
		map.put("result", i);
		map.put("WhIncomingMaterial", wm);
		return map;
	}
	
	@RequestMapping("/delWhIncomingMaterialById")
	@ResponseBody
	public int delWhIncomingMaterialById(String id){
		return service.delWhIncomingMaterialById(id);
	}
	
	@RequestMapping("/insertWhIncomingMaterial")
	@ResponseBody
	public Map<String,Object> insertWhIncomingMaterial(WhIncomingMaterial wm, HttpSession session) {
		wm.setId(LDXXUtils.getUUID12());
		User user = (User) session.getAttribute("user");
		String jhDateTime = DateUtil.getDateStrByPattern(DateConstant.DATE14_, new Date());
		jhDateTime = jhDateTime + new Random().nextInt(100);
		wm.setNo(jhDateTime);
		if (null != user) {
			wm.setEditUserId(user.getUserId());
			wm.setEditDatetime(GetThisTimeUtils.getDateTime());
			wm.setuName(user.getuName());
		}
		int i = service.insertWhIncomingMaterial(wm);
		map.put("result", i);
		map.put("WhIncomingMaterial", wm);
		return map;
	}

}
