package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldxx.bean.SiteRoadMileage;
import com.ldxx.service.SiteRoadMileageService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;

/**
 * 摊铺里程
 * @author hp
 *
 */

@RestController
@RequestMapping("SiteRoadMileage")
public class SiteRoadMileageController {
	
	@Autowired
	private SiteRoadMileageService service;
	
	private Map<String,Object> map=new HashMap<>();
	
	@RequestMapping("/selectAllSiteRoadMileage")
	public List<SiteRoadMileage> selectAllSiteRoadMileage(){
		return service.selectAllSiteRoadMileage();
	}
	
	@RequestMapping("/updSiteRoadMileage")
	public Map<String,Object> updSiteRoadMileage(SiteRoadMileage srm){
		int i= service.updSiteRoadMileage(srm);
		map.put("result", i);
		map.put("obj", srm);
		return map;
	}
	
	@RequestMapping("/delSiteRoadMileage")
	public int delSiteRoadMileage(String id){
		int i= service.delSiteRoadMileage(id);
		return i;
	}
	
	@RequestMapping("/insertSiteRoadMileage")
	public Map<String,Object> insertSiteRoadMileage(SiteRoadMileage srm){
		srm.setId(LDXXUtils.getUUID12());
		srm.setEditDatetime2(GetThisTimeUtils.getDateTime());
		int i= service.insertSiteRoadMileage(srm);
		map.put("result", i);
		map.put("obj", srm);
		return map;
	}

}
