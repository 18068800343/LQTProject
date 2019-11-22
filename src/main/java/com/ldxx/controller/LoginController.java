package com.ldxx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.User;
import com.ldxx.service.UserService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
    @RequestMapping("/index")
    public String test(){ 
        return "WEB/index";
    }
    
    @RequestMapping("/login")
    public String login(){ 
        return "redirect:../view/WEB/login.html";
    }
    
    @RequestMapping(value="/userlogin",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> userlogin(User user,HttpServletRequest request){
    	int state=0;
    	User loginUser=null;
    	Map<String,Object> map=new HashMap<>();
		HttpSession session = request.getSession();
		if(null!=user&&null!=user.getUsername()&&null!=user.getPassword()&&!"".equals(user.getUsername())&&!"".equals(user.getPassword())) {
			loginUser=userService.selectUserByUsername(user.getUsername());
			if(null!=loginUser&&null!=loginUser.getUsername())
			{
				if(user.getPassword().equals(loginUser.getPassword()))
				{//成功登陆
					session.setAttribute("user",loginUser);
					state=1;
				}else {state=-3;}//用户密码错误
			}else {state=-2;}//该用户不存在
		}else {state=-1;}//用户名或密码为空
		
		map.put("result", state);
		map.put("user", loginUser);
		return map;
    }
    
    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(HttpServletRequest request){
    	User user=(User) request.getSession().getAttribute("user");
    	return user;
    }
    
    @RequestMapping("/exit")//退出
	@ResponseBody
	public void exit(HttpServletRequest request){
		request.getSession().removeAttribute("user");
	}
    
}
