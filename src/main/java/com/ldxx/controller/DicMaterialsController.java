package com.ldxx.controller;

import java.util.List;

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
	public int addDicMaterials(DicMaterials dicMaterials)
	{	
		dicMaterials.setId(LDXXUtils.getUUID12());
		int state = dicmService.addDicMaterials(dicMaterials);
		return state;
	}
	
	@RequestMapping("/updateDicMaterials")
	@ResponseBody
	public int updateDicMaterials(DicMaterials dicMaterials) {
		int state = dicmService.updateDicMaterials(dicMaterials);
		return state;
	}
	@RequestMapping("/selectAllDicMaterials")
	@ResponseBody
	public List<DicMaterials> selectAllDicMaterials() {
		 List<DicMaterials> list =  dicmService.selectAllDicMaterials();
		return list;
	}
	
	@RequestMapping("/deleteDicMaterials")
	@ResponseBody
	public int deleteDicMaterials(String id) {
		int state = dicmService.deleteDicMaterials(id);
		return state;
	}
}
