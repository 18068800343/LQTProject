package com.ldxx.controller;

import com.ldxx.bean.SysFormulationManagement;
import com.ldxx.bean.User;
import com.ldxx.service.SysFormulationManagementService;
import com.ldxx.util.GetThisTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("SysFormulationManagement")
public class SysFormulationManagementController {

	@Autowired
	private SysFormulationManagementService sfmService;

	
	@RequestMapping("/addSysFormulationManagement")
	@ResponseBody
	public Map<String,Object> addSysFormulationManagement(@RequestBody SysFormulationManagement sysFormulationManagement, HttpSession session) throws ParseException {
		User user = (User) session.getAttribute("user");
		sysFormulationManagement.setLastUser(user.getUserId());
		sysFormulationManagement.setuName(user.getuName());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = formatter.parse(GetThisTimeUtils.getDateTime());
		sysFormulationManagement.setLastDate(date);
		Map<String, Object> map = new HashMap<String, Object>();
		int state=0;
		state = sfmService.addSysFormulationManagement(sysFormulationManagement);
		map.put("result",state);
		map.put("SysFormulationManagement", sysFormulationManagement);
		return map;
	}
	
	@RequestMapping("/updateSysFormulationManagement")
	@ResponseBody
	public Map<String,Object> updateSysFormulationManagement(@RequestBody SysFormulationManagement sysFormulationManagement, HttpSession session) throws ParseException {
		User user = (User) session.getAttribute("user");
		sysFormulationManagement.setLastUser(user.getUserId());
		sysFormulationManagement.setuName(user.getuName());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = formatter.parse(GetThisTimeUtils.getDateTime());
		sysFormulationManagement.setLastDate(date);
		Map<String, Object> map = new HashMap<String, Object>();
		int state=0;
		state = sfmService.updateSysFormulationManagement(sysFormulationManagement);
		map.put("result",state);
		map.put("SysFormulationManagement", sysFormulationManagement);
		return map;
	}
	
	@RequestMapping("/deleteSysFormulationManagement")
	@ResponseBody
	public Map<String,Object> deleteSysFormulationManagement(String id, HttpSession session) throws ParseException {
		User user = (User) session.getAttribute("user");
		String lastUserId=user.getUserId();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = formatter.parse(GetThisTimeUtils.getDateTime());
		Map<String, Object> map = new HashMap<String, Object>();
		int state=0;
		state = sfmService.deleteSysFormulationManagement(id,lastUserId,date);
		map.put("result",state);
		return map;
	}
	
	@RequestMapping("/selectAllSysFormulationManagement")
	@ResponseBody
	public List<SysFormulationManagement> selectAllSysFormulationManagement() {
		List<SysFormulationManagement> slist = sfmService.selectAllSysFormulationManagement();
		return slist;
	}
	
	@RequestMapping("/selectByIdSysFormulationManagement")
	@ResponseBody
	public SysFormulationManagement selectByIdSysFormulationManagement(String id) {
		SysFormulationManagement s =sfmService.selectByIdSysFormulationManagement(id);
		return s;
	}
	
	@RequestMapping("/getFlName")
	@ResponseBody
	public List<SysFormulationManagement> getFlName(){
		List<SysFormulationManagement> s =sfmService.getFlName();
		return s;
	}
}
