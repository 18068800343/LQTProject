package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.User;
import com.ldxx.service.UserService;
import com.ldxx.util.LDXXUtils;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	private Map<String,Object> map=new HashMap<>();
	
	@RequestMapping("/addUser")
	@ResponseBody
    public Map<String,Object> addUser(User user) {
		int i=0;
		int iscountWorkId = service.iscountWorkId(user.getWorkId());
		int iscountUName = service.iscountUName(user.getuName());
		if(iscountWorkId>0){
			i=-1;
		}else if(iscountUName>0){
			i=-2;
		}else{
			user.setUserId(LDXXUtils.getUUID12());
			i= service.addUser( user );
		}
        map.put("result", i);
        map.put("user", user);
        return map;
    }
	 
	@RequestMapping("/deleteUser")
	@ResponseBody
    public int deleteUser(String userId) {
        return service.deleteUser( userId );
    }
	
	@RequestMapping("/updateUser")
	@ResponseBody
    public Map<String,Object> updateUser(User user) {
		int i=0;
		int iscountWorkIdEdit = service.iscountWorkIdEdit(user.getWorkId(),user.getUserId());
		int iscountUNameEdit = service.iscountUNameEdit(user.getuName(),user.getUserId());
		if(iscountWorkIdEdit>0){
			i=-1;
		}else if(iscountUNameEdit>0){
			i=-2;
		}else{
			i= service.updateUser(user);
		}
        map.put("result",i);
        map.put("user",user);
        return map;
    }
	
	@RequestMapping("/updUserup")
	@ResponseBody
	public int updUserup(User user){
		return service.updUserup(user);
	}
	
	@RequestMapping("/selectAllUser")
	@ResponseBody
	public List<User> selectAllUser(){
		return service.selectAllUser();
	}
	
	@RequestMapping("/selectUserById")
	@ResponseBody
	public User selectUserById(String userId){
		return service.selectUserById(userId);
	}

	
	@RequestMapping("/getWorkIdAnduName")
	@ResponseBody
	public List<User> getWorkIdAnduName(){
		return service.getWorkIdAnduName();
	}
	
	@RequestMapping("/getWorkIdByuName")
	@ResponseBody
	public User getWorkIdByuName(String uName){
		return service.getWorkIdByuName(uName);
	}
	
	@RequestMapping("/getuNameByWorkId")
	@ResponseBody
	public User getuNameByWorkId(String workId){
		return service.getuNameByWorkId(workId);
	}
	
}
