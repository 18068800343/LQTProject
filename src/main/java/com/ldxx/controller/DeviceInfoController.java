package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Map<String,Object> addDeviceInfo(@RequestBody DeviceInfo deviceInfo){
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 0;
		state = diservice.addDeviceInfo(deviceInfo);
		map.put("result",state);
		map.put("deviceInfo", deviceInfo);
		return map;
	};
	
	@RequestMapping("/updateDeviceInfo")
	@ResponseBody
	public Map<String,Object> updateDeviceInfo(@RequestBody DeviceInfo deviceInfo){
		Map<String, Object> map = new HashMap<String, Object>();
		int state =0;
		state=diservice.updateDeviceInfo(deviceInfo);
		map.put("result",state);
		map.put("deviceInfo", deviceInfo);
		return map;
	};
	
	@RequestMapping("/deleteDeviceInfo")
	@ResponseBody
	public Map<String,Object> deleteDeviceInfo(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		int state =0;
		state=diservice.deleteDeviceInfo(id);
		map.put("result",state);
		return map;
	};
}
