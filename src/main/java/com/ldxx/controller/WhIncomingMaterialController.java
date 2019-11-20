package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ldxx.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.WhIncomingMaterial;
import com.ldxx.service.WhIncomingMaterialService;
import com.ldxx.util.LDXXUtils;

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
	
	private Map<String,Object> map=new HashMap<>();
	
	@RequestMapping("/getAllWhIncomingMaterial")
	@ResponseBody
	public List<WhIncomingMaterial> getAllWhIncomingMaterial(){
		return service.getAllWhIncomingMaterial();
	}
	
	@RequestMapping("/getWhIncomingMaterialById")
	@ResponseBody
	public WhIncomingMaterial getWhIncomingMaterialById(String id){
		return service.getWhIncomingMaterialById(id);
	}
	
	@RequestMapping("/updWhIncomingMaterialById")
	@ResponseBody
	public Map<String,Object> updWhIncomingMaterialById(WhIncomingMaterial wm, HttpSession session){
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			wm.setEditUserId(user.getUserId());;
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
	public Map<String,Object> insertWhIncomingMaterial(WhIncomingMaterial wm, HttpSession session){
		wm.setId(LDXXUtils.getUUID12());
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			wm.setEditUserId(user.getUserId());;
		}
		int i= service.insertWhIncomingMaterial(wm);
		map.put("result", i);
		map.put("WhIncomingMaterial", wm);
		return map;
	}

}
