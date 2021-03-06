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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map getAllQualityByPageCondition(PageUtil pageUtil) {
		Map map = new HashMap();
		List list = dao.getAllQualityByPageCondition(pageUtil);
		Integer count = dao.getQualityCount(pageUtil);
		pageUtil.setCount(count);
		map.put("obj", list);
		map.put("pageInfo", pageUtil);
		return map;
	}

	@RequestMapping("/getYouShiBiVoListByTime")
	@ResponseBody
	public YouShiBiVo getYouShiBiVoListByTime(String beginTime, String endTime, String peifang) {
		List<QualityByPlateAsphaltAggregateRatio> list = dao.getYouShiBiVoListByTime(beginTime, endTime, peifang);
		YouShiBiVo youShiBiVo = new YouShiBiVo();
		youShiBiVo = youShiBiVo.getYouShiBiVoByPeiBiVoList(list);
		return youShiBiVo;
	}

	@RequestMapping("/getDistincePeiFangByTime")
	@ResponseBody
	public List<QualityByPlateAsphaltAggregateRatio> getDistincePeiFangByTime(String beginTime, String endTime){
		return dao.getDistincePeiFangByTime(beginTime,endTime);
	}
}
