package com.ldxx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.TmpPlate;
import com.ldxx.dao.TmpPlateDao;

/**
 * 临时车牌
 * @author hp
 *
 */

@RequestMapping("TmpPlate")
@Controller
public class TmpPlateController {
	
	@Autowired
	private TmpPlateDao dao;
	
	@RequestMapping("/getTmpPlate")
	@ResponseBody
	public TmpPlate getTmpPlate(){
		return dao.getTmpPlate();
	}

}
