package com.ldxx.controller;

import com.ldxx.bean.QualityKeyMeshPassRate;
import com.ldxx.dao.QualityKeyMeshPassRateDao;
import com.ldxx.service.QualityKeyMeshPassRateService;
import com.ldxx.vo.TongGuoLvVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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

	@Resource
	private QualityKeyMeshPassRateDao dao;

	@RequestMapping("/getAllQualityKeyMeshPassRate")
	@ResponseBody
	public List<QualityKeyMeshPassRate> getAllQualityKeyMeshPassRate(){
		List<QualityKeyMeshPassRate> list=service.getAllQualityKeyMeshPassRate();
		return list;
	}

	@RequestMapping("/getTongGuoLvVoListByTime")
	@ResponseBody
	public TongGuoLvVo getTongGuoLvVoListByTime(String beginTime, String endTime){
		List<QualityKeyMeshPassRate> list = dao.getTongGuoLvVoListByTime(beginTime,endTime);
		TongGuoLvVo tongGuoLvVo = new TongGuoLvVo();
		tongGuoLvVo  = tongGuoLvVo.getPeiBiVoByPeiBiVoList(list);
		return tongGuoLvVo;
	}

}
