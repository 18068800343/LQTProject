package com.ldxx.controller;

import com.ldxx.bean.QualityByPlateRealTimeProdocutionData;
import com.ldxx.dao.QualityByPlateRealTimeProdocutionDataDao;
import com.ldxx.service.QualityByPlateRealTimeProdocutionDataService;
import com.ldxx.vo.PeiBiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
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

	@Resource
	private QualityByPlateRealTimeProdocutionDataDao dao;

	
	@RequestMapping("/getAllQualityByPlateRealTimeProdocutionData")
	@ResponseBody
	public List<QualityByPlateRealTimeProdocutionData> getAllQualityByPlateRealTimeProdocutionData() {
		List<QualityByPlateRealTimeProdocutionData> list = service.getAllQualityByPlateRealTimeProdocutionData();
		return list;
	}


	@RequestMapping("/getPeiBiVoListByTime")
	@ResponseBody
	public PeiBiVo getPeiBiVoListByTime(String beginTime, String endTime, String peifang) {
		List<QualityByPlateRealTimeProdocutionData> list = dao.getPeiBiVoListByTime(beginTime, endTime, peifang);
		PeiBiVo peiBiVo = new PeiBiVo();
		peiBiVo = peiBiVo.getPeiBiVoByPeiBiVoList(list);
		return peiBiVo;
	}

	@RequestMapping("/getPeiBiTimeListByTime")
	@ResponseBody
	public List getPeiBiTimeListByTime(String beginTime, String endTime, String peifang) {
		List<QualityByPlateRealTimeProdocutionData> list = dao.getPeiBiVoListByTime(beginTime, endTime,peifang);
		//倒序
		Collections.reverse(list);
		return list;
	}

	@RequestMapping("/getPeiBiOneByTime")
	@ResponseBody
	public QualityByPlateRealTimeProdocutionData getPeiBiOneByTime(String time) {
		time=time+"%";
		QualityByPlateRealTimeProdocutionData one = dao.getPeiBiOneByTime(time);
		return one;
	}

}
