package com.ldxx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
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
	
	 @RequestMapping("/addUser")
	 @ResponseBody
    public int addUser() {
		 User user=new User();
		 user.setUserId(LDXXUtils.getUUID12());
		 user.setuName("lisi");
        return service.addUser( user );
    }

}
