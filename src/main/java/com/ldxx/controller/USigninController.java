package com.ldxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ldxx.bean.USignin;
import com.ldxx.service.USigninService;

@Controller
@RequestMapping("USignin")
public class USigninController {
	@Autowired
	USigninService usService;
	
	@RequestMapping("/selectAllUSignin")
	public List<USignin> selectAllUSignin(){
		List<USignin> usList = usService.selectAllUSignin();
		return usList;
	}
}
