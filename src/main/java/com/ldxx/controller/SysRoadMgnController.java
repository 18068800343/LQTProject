package com.ldxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldxx.bean.SysRoadMgn;
import com.ldxx.dao.SysRoadMgnDao;

@RestController
@RequestMapping("/SysRoadMgnController")
public class SysRoadMgnController {
	
	@Autowired
	private SysRoadMgnDao dao;
	
    @RequestMapping("/getAllSysRoadMgn")
    public List<SysRoadMgn> getAllSysRoadMgn(){ 
        return dao.getAllSysRoadMgn();
    }
    
}
