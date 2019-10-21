package com.ldxx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
    @RequestMapping("/index")
    public String test(){ 
        return "WEB/index";
    }
}
