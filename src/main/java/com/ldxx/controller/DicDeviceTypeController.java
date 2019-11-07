package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.DicDeviceType;
import com.ldxx.service.DicDeviceTypeService;
import com.ldxx.util.LDXXUtils;

@Controller
@RequestMapping("DicDeviceType")
public class DicDeviceTypeController {

	@Autowired
	private DicDeviceTypeService ddtService;
	
	@RequestMapping("/addDicDeviceType")
	@ResponseBody
	public Map<String,Object> addDicDeviceType(DicDeviceType dicDeviceType)
	{	
		Map<String, Object> map = new HashMap<String, Object>();
		dicDeviceType.setId(LDXXUtils.getUUID12());
		int state = ddtService.addDicDeviceType(dicDeviceType);
		
		map.put("result",state);
		map.put("DicDeviceType", dicDeviceType);
		return map;
	}
	
	@RequestMapping("/updateDicDeviceType")
	@ResponseBody
	public Map<String,Object> updateDicDeviceType(DicDeviceType dicDeviceType) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = ddtService.updateDicDeviceType(dicDeviceType);
		map.put("result",state);
		map.put("DicDeviceType", dicDeviceType);
		return map;
	}
	@RequestMapping("/selectAllDicDeviceType")
	@ResponseBody
	public List<DicDeviceType> selectAllDicDeviceType() {
		 List<DicDeviceType> list =  ddtService.selectAllDicDeviceType();
		return list;
	}
	
	@RequestMapping("/delDicDeviceType")
	@ResponseBody
	public int deleteDicDeviceType(String id) {
		int state = ddtService.deleteDicDeviceType(id);
		return state;
	}
}
