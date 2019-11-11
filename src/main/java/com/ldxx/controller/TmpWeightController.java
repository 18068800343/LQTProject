package com.ldxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.TmpWeight;
import com.ldxx.dao.TmpWeightDao;

/**
 * 临时重量
 * @author hp
 *
 */
@RequestMapping("TmpWeight")
@Controller
public class TmpWeightController {
	
	@Autowired
	private TmpWeightDao dao;
	
	@RequestMapping("/getTmpWeight")
	@ResponseBody
	public List<TmpWeight> getTmpWeight(){
		return dao.getTmpWeight();
	}

}
