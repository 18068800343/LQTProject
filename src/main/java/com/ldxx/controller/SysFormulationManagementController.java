package com.ldxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.SysFormulationManagement;
import com.ldxx.service.SysFormulationManagementService;

@Controller
@RequestMapping("SysFormulationManagement")
public class SysFormulationManagementController {

	@Autowired
	private SysFormulationManagementService sfmService;
	
	@RequestMapping("/addSysFormulationManagement")
	@ResponseBody
	public int addSysFormulationManagement(SysFormulationManagement sysFormulationManagement) {
		int num = sfmService.addSysFormulationManagement(sysFormulationManagement);
		return num;
	}
	
	@RequestMapping("/updateSysFormulationManagement")
	@ResponseBody
	public int updateSysFormulationManagement(SysFormulationManagement sysFormulationManagement) {
		int num = sfmService.updateSysFormulationManagement(sysFormulationManagement);
		return num;
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
