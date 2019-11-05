package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.SysWarningSet;
import com.ldxx.service.SysWarningSetService;
import com.ldxx.util.LDXXUtils;
/**
 * 预警管理
 * @author hp
 *
 */
@Controller
@RequestMapping("SysWarningSet")
public class SysWarningSetController {
	
	@Autowired
	private SysWarningSetService service;
	
	private Map<String,Object> map =new HashMap<>();
	
	@RequestMapping("/addSysWarningSet")
	@ResponseBody
	public Map<String,Object> addSysWarningSet(SysWarningSet ss){
		ss.setId(LDXXUtils.getUUID12());
		int i=service.addSysWarningSet(ss);
		map.put("result",i);
		map.put("SysWarningSet", ss);
		return map;
	}
	
	@RequestMapping("/updateSysWarningSetById")
	@ResponseBody
	public Map<String,Object> updateSysWarningSetById(SysWarningSet ss){
		int i = service.updateSysWarningSetById(ss);
		map.put("result",i);
		map.put("SysWarningSet", ss);
		return map;
	}
	
	@RequestMapping("/getAllSysWarningSet")
	@ResponseBody
	public List<SysWarningSet> getAllSysWarningSet(){
		List<SysWarningSet> list= service.getAllSysWarningSet();
		return list;
	}
	
	@RequestMapping("/delSysWarningSet")
	@ResponseBody
	public int delSysWarningSet(String id){
		return service.delSysWarningSet(id);
	}

}
