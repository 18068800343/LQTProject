package com.ldxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.DicDanwei;
import com.ldxx.dao.DicDanweiDao;

/**
 * 单位字典
 * @author hp
 *
 */

@RequestMapping("DicDanwei")
@Controller
public class DicDanweiController {
	
	@Autowired
	private DicDanweiDao dao;
	
	@RequestMapping("/getAllDicDanwei")
	@ResponseBody
	public List<DicDanwei> getAllDicDanwei(){
		return dao.getAllDicDanwei();
	}

}
