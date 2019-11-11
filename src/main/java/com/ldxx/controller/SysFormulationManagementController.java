package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.SysFormulationManagement;
import com.ldxx.bean.SysMaterialAttached;
import com.ldxx.service.SysFormulationManagementService;
import com.ldxx.util.LDXXUtils;


@Controller
@RequestMapping("SysFormulationManagement")
public class SysFormulationManagementController {

	@Autowired
	private SysFormulationManagementService sfmService;
	
	@RequestMapping("/addSysFormulationManagement")
	@ResponseBody
	public Map<String,Object> addSysFormulationManagement(@RequestBody SysFormulationManagement sysFormulationManagement) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int state=0;
		sysFormulationManagement.setFlId(LDXXUtils.getUUID12());
		state = sfmService.addSysFormulationManagement(sysFormulationManagement);
		map.put("result",state);
		map.put("SysFormulationManagement", sysFormulationManagement);
		return map;
	}
	
	@RequestMapping("/updateSysFormulationManagement")
	@ResponseBody
	public Map<String,Object> updateSysFormulationManagement(SysFormulationManagement sysFormulationManagement) {
		Map<String, Object> map = new HashMap<String, Object>();
		sysFormulationManagement.setFlId(LDXXUtils.getUUID12());
		int state = sfmService.updateSysFormulationManagement(sysFormulationManagement);
		map.put("result",state);
		map.put("SysFormulationManagement", sysFormulationManagement);
		return map;
	}
	
	@RequestMapping("/deleteSysFormulationManagement")
	@ResponseBody
	public int deleteSysFormulationManagement(String id) {
		int num = sfmService.deleteSysFormulationManagement(id);
		return num;
	}
	
	@RequestMapping("/selectAllSysFormulationManagement")
	@ResponseBody
	public List<SysFormulationManagement> selectAllSysFormulationManagement() {
		List<SysFormulationManagement> slist = sfmService.selectAllSysFormulationManagement();
		return slist;
	}
	
	@RequestMapping("/selectByIdSysFormulationManagement")
	@ResponseBody
	public SysFormulationManagement selectByIdSysFormulationManagement() {
		SysFormulationManagement s =sfmService.selectByIdSysFormulationManagement();
		return s;
	}
	
	@RequestMapping("/getFlName")
	@ResponseBody
	public List<SysFormulationManagement> getFlName(){
		List<SysFormulationManagement> s =sfmService.getFlName();
		return s;
	}
}
