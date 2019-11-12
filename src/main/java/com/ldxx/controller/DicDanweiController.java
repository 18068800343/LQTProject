package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.DicDanwei;
import com.ldxx.dao.DicDanweiDao;
import com.ldxx.util.LDXXUtils;

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
	
	private Map<String,Object> map=new HashMap<>();
	
	@RequestMapping("/getAllDicDanwei")
	@ResponseBody
	public List<DicDanwei> getAllDicDanwei(){
		return dao.getAllDicDanwei();
	}
	
	@RequestMapping("/insertDicDanwei")
	@ResponseBody
	public Map<String,Object> insertDicDanwei(DicDanwei dw){
		dw.setId(LDXXUtils.getUUID12());
		int i= dao.insertDicDanwei(dw);
		map.put("result", i);
		map.put("dw", dw);
		return map;
	}
	
	@RequestMapping("/updDicDanwei")
	@ResponseBody
	public Map<String,Object> updDicDanwei(DicDanwei dw){
		int i= dao.updDicDanwei(dw);
		map.put("result", i);
		map.put("dw", dw);
		return map;
	}
	
	@RequestMapping("/delDicDanwei")
	@ResponseBody
	public int delDicDanwei(String id){
		return dao.delDicDanwei(id);
	}

}
