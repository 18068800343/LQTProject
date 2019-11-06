package com.ldxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.QualityByPlateRealTimeProdocutionData;
import com.ldxx.service.QualityByPlateRealTimeProdocutionDataService;
/**
 * 逐盘拌合生产数据实时监控
 * @author hp
 *
 */
@Controller
@RequestMapping("QualityByPlateRealTimeProdocutionData")
public class QualityByPlateRealTimeProdocutionDataController {
	
	@Autowired
	private QualityByPlateRealTimeProdocutionDataService service;
	
	
	@RequestMapping("/getAllQualityByPlateRealTimeProdocutionData")
	@ResponseBody
	public List<QualityByPlateRealTimeProdocutionData> getAllQualityByPlateRealTimeProdocutionData(){
		return service.getAllQualityByPlateRealTimeProdocutionData();
	}

}
