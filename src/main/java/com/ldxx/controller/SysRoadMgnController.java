package com.ldxx.controller;

import com.ldxx.bean.SysRoadMgn;
import com.ldxx.bean.SysRoadMgnLowcase;
import com.ldxx.dao.SysRoadMgnDao;
import com.ldxx.service.SysRoadMgnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/SysRoadMgnController")
public class SysRoadMgnController {
	
	@Autowired
	private SysRoadMgnService srmService;

	@Resource
	private SysRoadMgnDao dao;
    @RequestMapping("/getAllSysRoadMgn")
    @ResponseBody
    public List<SysRoadMgn> getAllSysRoadMgn(){ 
        return srmService.getAllSysRoadMgn();
    }

    @RequestMapping("/getAllSysRoadMgnLowcase")
    @ResponseBody
    public List<SysRoadMgnLowcase> getAllSysRoadMgnLowcase(){
        return dao.getAllSysRoadMgnLowcase();
    }
    
    @RequestMapping("/addSysRoadMgn")
    @ResponseBody
    public Map<String,Object> addSysRoadMgn(@RequestBody SysRoadMgn sysRoadMgn) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = srmService.addSysRoadMgn(sysRoadMgn);
		
		map.put("result",state);
		map.put("sysRoadMgn", sysRoadMgn);
		return map;
    }
    
    @RequestMapping("/updateSysRoadMgnById")
    @ResponseBody
	public Map<String,Object> updateSysRoadMgnById(@RequestBody SysRoadMgn sysRoadMgn) {
    	Map<String, Object> map = new HashMap<String, Object>();
		int state = srmService.updateSysRoadMgnById(sysRoadMgn);
		
		map.put("result",state);
		map.put("sysRoadMgn", sysRoadMgn);
		return map;
    }
    
    @RequestMapping("/delSysRoadMgn")
    @ResponseBody
	public Map<String,Object> delSysRoadMgn(String id) {
    	Map<String, Object> map = new HashMap<String, Object>();
		int state = srmService.delSysRoadMgn(id);
		
		map.put("result",state);
		return map;
    }
    
    @RequestMapping("/getByIdSysRoadMgn")
    @ResponseBody
	public Map<String,Object> getByIdSysRoadMgn(String id) {
    	Map<String, Object> map = new HashMap<String, Object>();
		int state = srmService.getByIdSysRoadMgn(id);
		
		map.put("result",state);
		return map;
    }
}
