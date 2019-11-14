package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.DeviceInfo;
import com.ldxx.service.DeviceInfoService;

@Controller
@RequestMapping("DeviceInfo")
public class DeviceInfoController {
	
	@Autowired
	DeviceInfoService diservice;
	@RequestMapping("/selectAllDeviceInfo")
	@ResponseBody
	public List<DeviceInfo> selectAllDeviceInfo(){
		List<DeviceInfo> list = diservice.selectAllDeviceInfo();
		return list;
	};
	
	@RequestMapping("/selectByIdDeviceInfo")
	@ResponseBody
	public Map<String,Object> selectByIdDeviceInfo(String id){
		Map<String, Object> map = new HashMap<String, Object>();
	//	map.put("result",state);
	//	map.put("DicDeviceType", dicDeviceType);
		return map;
	};
	
	@RequestMapping("/addDeviceInfo")
	@ResponseBody
	public Map<String,Object> addDeviceInfo(DeviceInfo deviceInfo){
		Map<String, Object> map = new HashMap<String, Object>();
	//	map.put("result",state);
	//	map.put("DicDeviceType", dicDeviceType);
		return map;
	};
	
	@RequestMapping("/updateDeviceInfo")
	@ResponseBody
	public Map<String,Object> updateDeviceInfo(DeviceInfo deviceInfo){
		Map<String, Object> map = new HashMap<String, Object>();
	//	map.put("result",state);
	//	map.put("DicDeviceType", dicDeviceType);
		return map;
	};
	
	@RequestMapping("/deleteDeviceInfo")
	@ResponseBody
	public Map<String,Object> deleteDeviceInfo(String id){
		Map<String, Object> map = new HashMap<String, Object>();
	//	map.put("result",state);
	//	map.put("DicDeviceType", dicDeviceType);
		return map;
	};
}
