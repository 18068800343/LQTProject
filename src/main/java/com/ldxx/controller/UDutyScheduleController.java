package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.UDutySchedule;
import com.ldxx.bean.User;
import com.ldxx.service.UDutyScheduleService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;

/**
 * 值班管理
 * @author hp
 *
 */

@Controller
@RequestMapping("UDutySchedule")
public class UDutyScheduleController {
	
	@Autowired
	private UDutyScheduleService service;
	
	private Map<String,Object> map =new HashMap<>();
	
	@RequestMapping("/getAllUDutySchedule")
	@ResponseBody
	public List<UDutySchedule> getAllUDutySchedule(){
		return service.getAllUDutySchedule();
	}
	
	@RequestMapping("/updUDutySchedule")
	@ResponseBody
	public Map<String,Object> updUDutySchedule(UDutySchedule us,HttpSession session){
		us.setEditDatetime(GetThisTimeUtils.getDateTime());
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			us.setEditUserId(user.getUserId());
			us.setEditDatetime(GetThisTimeUtils.getDateTime());
		}
		int i=service.updUDutySchedule(us);
		map.put("result", i);
		map.put("obj", us);
		return map;
	}
	
	@RequestMapping("/delUDutySchedule")
	@ResponseBody
	public int delUDutySchedule(String id){
		return service.delUDutySchedule(id);
	}
	
	@RequestMapping("/insertUDutySchedule")
	@ResponseBody
	public Map<String,Object> insertUDutySchedule(UDutySchedule us,HttpSession session){
		us.setId(LDXXUtils.getUUID12());
		us.setEditDatetime(GetThisTimeUtils.getDateTime());
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			us.setEditUserId(user.getUserId());
			us.setEditDatetime(GetThisTimeUtils.getDateTime());
		}
		int i=service.insertUDutySchedule(us);
		map.put("result", i);
		map.put("obj", us);
		return map;
	}

}
