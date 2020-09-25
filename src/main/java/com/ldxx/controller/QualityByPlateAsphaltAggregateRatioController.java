package com.ldxx.controller;

import com.ldxx.bean.PageUtil;
import com.ldxx.bean.QualityByPlateAsphaltAggregateRatio;
import com.ldxx.dao.QualityByPlateAsphaltAggregateRatioDao;
import com.ldxx.service.QualityByPlateAsphaltAggregateRatioService;
import com.ldxx.vo.YouShiBiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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

	@Resource
	private QualityByPlateAsphaltAggregateRatioDao dao;


	@RequestMapping("/getAllQualityByPlateAsphaltAggregateRatio")
	@ResponseBody
	public List<QualityByPlateAsphaltAggregateRatio> getAllQualityByPlateAsphaltAggregateRatio() {
		List list = service.getAllQualityByPlateAsphaltAggregateRatio();
		return list;
	}

	@RequestMapping("/getAllQualityByPageCondition")
	@ResponseBody
	public List<QualityByPlateAsphaltAggregateRatio> getAllQualityByPageCondition(PageUtil pageUtil) {
		List list = dao.getAllQualityByPageCondition(pageUtil);
		return list;
	}

	@RequestMapping("/getYouShiBiVoListByTime")
	@ResponseBody
	public YouShiBiVo getYouShiBiVoListByTime(String beginTime, String endTime, String peifang) {
		List<QualityByPlateAsphaltAggregateRatio> list = dao.getYouShiBiVoListByTime(beginTime, endTime, peifang);
		YouShiBiVo youShiBiVo = new YouShiBiVo();
		youShiBiVo = youShiBiVo.getYouShiBiVoByPeiBiVoList(list);
		return youShiBiVo;
	}
}
