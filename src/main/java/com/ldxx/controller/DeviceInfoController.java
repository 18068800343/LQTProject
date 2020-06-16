package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.bean.Accessory;
import com.ldxx.bean.DeviceInfo;
import com.ldxx.bean.User;
import com.ldxx.service.DeviceInfoService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.getWebFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		DeviceInfo deviceInfo = diservice.selectByIdDeviceInfo(id);
		map.put("deviceInfo", deviceInfo);
		return map;
	};
	
	@RequestMapping("/addDeviceInfo")
	@ResponseBody
	public Map<String,Object> addDeviceInfo(String deviceInfo,HttpSession session,@RequestParam("file") MultipartFile[] file) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		DeviceInfo dt=JSONObject.parseObject(deviceInfo,DeviceInfo.class);
		String id = LDXXUtils.getUUID12();
		int state = 0;
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			dt.setEditUserId(user.getUserId());
		}
		dt.setEditDatetime(GetThisTimeUtils.getDateTime());
		dt.setId(id);

		String webFile = getWebFileUtils.getWebFile();
		String path=webFile+"shebeiguanli_File";
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int j=0;j<file.length;j++){
				Accessory accessory=new Accessory();
				String fileName=file[j].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[j].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("设备合同附件");
				list.add(accessory);
			}
			dt.setAccessory(list);
		}

		state = diservice.addDeviceInfo(dt);
		map.put("result",state);
		map.put("deviceInfo", dt);
		return map;
	};
	
	@RequestMapping("/updateDeviceInfo")
	@ResponseBody
	public Map<String,Object> updateDeviceInfo(String  deviceInfo,HttpSession session,@RequestParam("file") MultipartFile[] file) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		DeviceInfo dt=JSONObject.parseObject(deviceInfo,DeviceInfo.class);
		int state =0;
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			dt.setEditUserId(user.getUserId());
		}
		dt.setEditDatetime(GetThisTimeUtils.getDateTime());

		String webFile = getWebFileUtils.getWebFile();
		String path=webFile+"shebeiguanli_File";
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int j=0;j<file.length;j++){
				Accessory accessory=new Accessory();
				String fileName=file[j].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[j].transferTo(f2);
				accessory.setaId(dt.getId());
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("设备合同附件");
				list.add(accessory);
			}
			dt.setAccessory(list);
		}
		state=diservice.updateDeviceInfo(dt);
		map.put("result",state);
		map.put("deviceInfo", dt);
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
