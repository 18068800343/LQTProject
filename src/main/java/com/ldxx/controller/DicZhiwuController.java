package com.ldxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.DicZhiwu;
import com.ldxx.dao.DicZhiwuDao;

/**
 * 职务字典
 * @author hp
 *
 */

@Controller
@RequestMapping("DicZhiwu")
public class DicZhiwuController {
	
	@Autowired
	private DicZhiwuDao dao;
	
	@RequestMapping("/getAllDicZhiwu")
	@ResponseBody
	public List<DicZhiwu> getAllDicZhiwu(){
		return dao.getAllDicZhiwu();
	}

}
