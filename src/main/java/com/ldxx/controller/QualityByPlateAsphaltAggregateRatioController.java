package com.ldxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.QualityByPlateAsphaltAggregateRatio;
import com.ldxx.service.QualityByPlateAsphaltAggregateRatioService;

/**
 * 逐盘油石比
 * @author hp
 *
 */

@Controller
@RequestMapping("QualityByPlateAsphaltAggregateRatio")
public class QualityByPlateAsphaltAggregateRatioController {
	
	@Autowired
	private QualityByPlateAsphaltAggregateRatioService service;
	
	
	@RequestMapping("/getAllQualityByPlateAsphaltAggregateRatio")
	@ResponseBody
	public List<QualityByPlateAsphaltAggregateRatio> getAllQualityByPlateAsphaltAggregateRatio(){
		return service.getAllQualityByPlateAsphaltAggregateRatio();
	}

}
