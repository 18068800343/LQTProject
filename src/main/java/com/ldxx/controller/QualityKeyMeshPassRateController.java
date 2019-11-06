package com.ldxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.QualityKeyMeshPassRate;
import com.ldxx.service.QualityKeyMeshPassRateService;

/**
 * 关键筛孔通过率
 * @author hp
 *
 */

@Controller
@RequestMapping("QualityKeyMeshPassRate")
public class QualityKeyMeshPassRateController {
	
	@Autowired
	private QualityKeyMeshPassRateService service;
	
	@RequestMapping("/getAllQualityKeyMeshPassRate")
	@ResponseBody
	public List<QualityKeyMeshPassRate> getAllQualityKeyMeshPassRate(){
		List<QualityKeyMeshPassRate> list=service.getAllQualityKeyMeshPassRate();
		return list;
	}

}
