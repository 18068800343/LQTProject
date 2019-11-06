package com.ldxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.QualityRealtimeDeviation;
import com.ldxx.service.QualityRealtimeDeviationService;
/**
 * 逐盘生产偏差分析
 * @author hp
 *
 */
@Controller
@RequestMapping("QualityRealtimeDeviation")
public class QualityRealtimeDeviationController {
	
	@Autowired
	private QualityRealtimeDeviationService service;
	
	@RequestMapping("/getAllQualityRealtimeDeviation")
	@ResponseBody
	public List<QualityRealtimeDeviation> getAllQualityRealtimeDeviation(){
		return service.getAllQualityRealtimeDeviation();
	}

}
