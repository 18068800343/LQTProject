package com.ldxx.controller;

import com.ldxx.bean.QualityJiPei;
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
	public List<QualityJiPei> getAllQualityKeyMeshPassRate(){
		List<QualityJiPei> list=service.getAllQualityKeyMeshPassRate();
		for(QualityJiPei q:list)
		{
			q.setDatetime(q.getDatetime().substring(0,q.getDatetime().indexOf(".")));
		}
		return list;
	}

	@RequestMapping("/getTongGuoLvVoListByTime")
	@ResponseBody
	public TongGuoLvVo getTongGuoLvVoListByTime(String beginTime, String endTime, String peifang){
		List<QualityJiPei> list = dao.getTongGuoLvVoListByTime(beginTime,endTime,peifang);
		for(QualityJiPei q:list)
		{
			q.setDatetime(q.getDatetime().substring(0,q.getDatetime().indexOf(".")));
		}
		TongGuoLvVo tongGuoLvVo = new TongGuoLvVo();
		tongGuoLvVo  = tongGuoLvVo.getPeiBiVoByPeiBiVoList(list);
		return tongGuoLvVo;
	}

	@RequestMapping("/getDISTINCTPeiFangByTime")
	@ResponseBody
	public List<QualityJiPei> getDISTINCTPeiFangByTime(String startime, String endTime){
		return dao.getDISTINCTPeiFangByTime(startime,endTime);
	}

}
