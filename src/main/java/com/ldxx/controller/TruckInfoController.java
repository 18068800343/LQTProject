package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.TruckInfo;
import com.ldxx.service.TruckInfoService;
import com.ldxx.util.LDXXUtils;

/**
 * 车辆管理
 * @author hp
 *
 */

@Controller
@RequestMapping("TruckInfo")
public class TruckInfoController {
	
	@Autowired
	private TruckInfoService service;
	
	private Map<String,Object> map=new HashMap<>();
	
	@RequestMapping("/getAllTruckInfo")
	@ResponseBody
	public List<TruckInfo> getAllTruckInfo() {
		return service.getAllTruckInfo();
	}
	
	@RequestMapping("/getTruckInfoById")
	@ResponseBody
	public TruckInfo getTruckInfoById(String id) {
		return service.getTruckInfoById(id);
	}
	
	@RequestMapping("/updTruckInfo")
	@ResponseBody
	public Map<String,Object> updTruckInfo(TruckInfo t) {
		int i= service.updTruckInfo(t);
		map.put("result", i);
		map.put("TruckInfo", t);
		return map;
	}
	
	@RequestMapping("/delTruckInfo")
	@ResponseBody
	public int delTruckInfo(String id) {
		return service.delTruckInfo(id);
	}

	@RequestMapping("/insertTruckInfo")
	@ResponseBody
	public Map<String,Object> insertTruckInfo(TruckInfo t) {
		t.setId(LDXXUtils.getUUID12());
		int i= service.insertTruckInfo(t);
		map.put("result", i);
		map.put("TruckInfo", t);
		return map;
	}
}
