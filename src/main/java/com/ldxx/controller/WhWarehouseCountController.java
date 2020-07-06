package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ldxx.bean.User;
import com.ldxx.dao.WhWarehouseCountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ldxx.bean.WhWarehouseCount;
import com.ldxx.service.WhWarehouseCountService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 仓储管理
 * @author hp
 *
 */

@Controller
@RequestMapping("WhWarehouseCount")
public class WhWarehouseCountController {

	@Autowired
	private WhWarehouseCountService service;

	@Resource
	private WhWarehouseCountDao dao;

	private Map<String, Object> map = new HashMap<>();

	@RequestMapping("/getAllWhWarehouseCount")
	@ResponseBody
	public List<WhWarehouseCount> getAllWhWarehouseCount() {
		return service.getAllWhWarehouseCount();
	}

	@RequestMapping("/getWhWarehouseCountById")
	@ResponseBody
	public WhWarehouseCount getWhWarehouseCountById(String id) {
		return service.getWhWarehouseCountById(id);
	}
	
	@RequestMapping("/updWhWarehouseCountById")
	@ResponseBody
	public Map<String,Object> updWhWarehouseCountById(WhWarehouseCount wwc, HttpSession session) {
		wwc.setEditDatetime2(GetThisTimeUtils.getDateTime());
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			wwc.setEditUserId2(user.getUserId());;
		}
		int i = service.updWhWarehouseCountById(wwc);
		map.put("result", i);
		map.put("WhWarehouseCount", wwc);
		return map;
	}

	@RequestMapping("/delWhWarehouseCountById")
	@ResponseBody
	public int delWhWarehouseCountById(String id) {
		return service.delWhWarehouseCountById(id);
	}

	@RequestMapping("/getLiaoCangPanDian")
	@ResponseBody
	public List<Map> getLiaoCangPanDian() {
		return dao.getLiaoCangPanDian();
	}

	@RequestMapping("/insertWhWarehouseCount")
	@ResponseBody
	public Map<String, Object> insertWhWarehouseCount(WhWarehouseCount wwc, HttpSession session) {
		wwc.setId(LDXXUtils.getUUID12());
		wwc.setEditDatetime2(GetThisTimeUtils.getDateTime());
		User user = (User) session.getAttribute("user");
		if (null != user) {
			wwc.setEditUserId2(user.getUserId());
			;
		}
		int i= service.insertWhWarehouseCount(wwc);
		map.put("result",i);
		map.put("WhWarehouseCount",wwc);
		return map;
	}

}
