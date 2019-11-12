package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.DicZhiwu;
import com.ldxx.dao.DicZhiwuDao;
import com.ldxx.util.LDXXUtils;

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
	
	private Map<String,Object> map=new HashMap<>();
	
	@RequestMapping("/getAllDicZhiwu")
	@ResponseBody
	public List<DicZhiwu> getAllDicZhiwu(){
		return dao.getAllDicZhiwu();
	}
	
	@RequestMapping("/updDicZhiwu")
	@ResponseBody
	public Map<String,Object> updDicZhiwu(DicZhiwu zw){
		int i= dao.updDicZhiwu(zw);
		map.put("result", i);
		map.put("zw", zw);
		return map;
	}
	
	@RequestMapping("/delDicZhiwu")
	@ResponseBody
	public int delDicZhiwu(String id){
		return dao.delDicZhiwu(id);
	}

	@RequestMapping("/insertDicZhiwu")
	@ResponseBody
	public Map<String,Object> insertDicZhiwu(DicZhiwu zw){
		zw.setId(LDXXUtils.getUUID12());
		int i= dao.insertDicZhiwu(zw);
		map.put("result", i);
		map.put("zw", zw);
		return map;
	}
}
