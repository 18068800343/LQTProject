package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.DicMaterials;
import com.ldxx.service.DicMaterialsService;
import com.ldxx.util.LDXXUtils;

@Controller
@RequestMapping("DicMaterials")
public class DicMaterialsController {

	@Autowired
	private DicMaterialsService dicmService;
	
	@RequestMapping("/addDicMaterials")
	@ResponseBody
	public Map<String,Object> addDicMaterials(DicMaterials dicMaterials)
	{	
		Map<String, Object> map = new HashMap<String, Object>();
		dicMaterials.setId(LDXXUtils.getUUID12());
		int state = dicmService.addDicMaterials(dicMaterials);
		
		map.put("result",state);
		map.put("DicMaterials", dicMaterials);
		return map;
	}
	
	@RequestMapping("/updateDicMaterials")
	@ResponseBody
	public Map<String,Object> updateDicMaterials(DicMaterials dicMaterials) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = dicmService.updateDicMaterials(dicMaterials);
		map.put("result",state);
		map.put("DicMaterials", dicMaterials);
		return map;
	}
	@RequestMapping("/selectAllDicMaterials")
	@ResponseBody
	public List<DicMaterials> selectAllDicMaterials() {
		 List<DicMaterials> list =  dicmService.selectAllDicMaterials();
		return list;
	}
	
	@RequestMapping("/delDicMaterials")
	@ResponseBody
	public int deleteDicMaterials(String id) {
		int state = dicmService.deleteDicMaterials(id);
		return state;
	}
}
