package com.ldxx.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ldxx.vo.UserVo;
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
	public List<UserVo> selectAllUser(){
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

	@RequestMapping("/selectUserAndRoles")
	@ResponseBody
	public List<UserVo> selectUserAndRoles(){
		List<UserVo> list =service.selectUserAndRoles();
		return list;

	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/updatePasswordById")
	@ResponseBody
	public int updatePasswordById(String userId,String password){
		String old_password = password.split(",")[0];
		String new_password = password.split(",")[1];
		User user = service.selectUserById(userId);
		int i=0;
		if(!user.getPassword().equals(old_password)){
			i=-1;
		}else if(user.getPassword().equals(new_password)){
			i=-2;
		}else{
			i=service.updatePasswordById(userId,new_password);
		}
		return i;
	}
	
}
