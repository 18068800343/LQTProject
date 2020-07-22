package com.ldxx.controller;

import com.ldxx.bean.QualityRealtimeDeviation;
import com.ldxx.dao.QualityRealtimeDeviationDao;
import com.ldxx.service.QualityRealtimeDeviationService;
import com.ldxx.vo.PianChaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
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

	@Resource
	private QualityRealtimeDeviationDao dao;

	@RequestMapping("/getAllQualityRealtimeDeviation")
	@ResponseBody
	public List<QualityRealtimeDeviation> getAllQualityRealtimeDeviation(){
		return service.getAllQualityRealtimeDeviation();
	}

	@RequestMapping("/getPianChaVoListByTime")
	@ResponseBody
	public PianChaVo getPianChaVoListByTime(String beginTime, String endTime, String peifang){
		List<QualityRealtimeDeviation> list = dao.getPianChaVoListByTime(beginTime,endTime,peifang);
		PianChaVo pianChaVo = new PianChaVo();
		pianChaVo  = pianChaVo.getPianChaVoByPianChaVoList(list);
		return pianChaVo;
	}
}
