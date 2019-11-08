package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ldxx.bean.WhWarehouseCount;
import com.ldxx.service.WhWarehouseCountService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;

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
	
	private Map<String,Object> map=new HashMap<>();
	
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
	public Map<String,Object> updWhWarehouseCountById(WhWarehouseCount wwc) {
		wwc.setEditDatetime2(GetThisTimeUtils.getDateTime());
		int i= service.updWhWarehouseCountById(wwc);
		map.put("result",i);
		map.put("WhWarehouseCount",wwc);
		return map;
	}
	
	@RequestMapping("/delWhWarehouseCountById")
	@ResponseBody
	public int delWhWarehouseCountById(String id) {
		return service.delWhWarehouseCountById(id);
	}
	
	@RequestMapping("/insertWhWarehouseCount")
	@ResponseBody
	public Map<String,Object> insertWhWarehouseCount(WhWarehouseCount wwc) {
		wwc.setId(LDXXUtils.getUUID12());
		wwc.setEditDatetime2(GetThisTimeUtils.getDateTime());
		int i= service.insertWhWarehouseCount(wwc);
		map.put("result",i);
		map.put("WhWarehouseCount",wwc);
		return map;
	}

}
