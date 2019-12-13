package com.ldxx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping("/")
	public String index(){
		return "redirect:/view/WEB/login.html";
	} 
	@RequestMapping("/index")
	public String index2(){
		return "redirect:/view/WEB/login.html";
	} 
}
