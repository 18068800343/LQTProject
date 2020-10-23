package com.ldxx.controller;

import com.ldxx.bean.DicStones;
import com.ldxx.dao.DicStonesDao;
import com.ldxx.util.LDXXUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("DicStones")
public class DicStonesController {

	@Autowired
	private DicStonesDao dao;

	@RequestMapping("/selectAllDicStones")
	@ResponseBody
	public List<DicStones> selectAllDicStones() {
		List<DicStones> list = dao.selectAllDicStones();
		return list;
	}

	@RequestMapping("/selectDicStonesAndDicMaterials")
	@ResponseBody
	public List<DicStones> selectDicStonesAndDicMaterials() {
		List<DicStones> list = dao.selectDicStonesAndDicMaterials();
		return list;
	}

	@RequestMapping("/addDicStones")
	@ResponseBody
	public Map<String, Object> addDicStones(DicStones dicStones) {
		Map<String, Object> map = new HashMap<String, Object>();
		dicStones.setId(LDXXUtils.getUUID12());
		int state = 0;
		DicStones d = dao.selectByName(dicStones.getStonesName());
		if (null != d && null != d.getStonesName())
		{
			state=-1;
		}else {
			state = dao.addDicStones(dicStones);
		}

		map.put("result",state);
		map.put("obj", dicStones);
		return map;
	}
	
	@RequestMapping("/updateDicStones")
	@ResponseBody
	public Map<String,Object> updateDicStones(DicStones dicStones) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state=0;
		DicStones d = dao.selectByName2(dicStones.getStonesName(),dicStones.getId());
		if(null!=d&&null!=d.getStonesName())
		{
			state=-1;
		}else {
			state = dao.updateDicStones(dicStones);
		}
		map.put("result",state);
		map.put("obj", dicStones);
		return map;
	}

	
	@RequestMapping("/delDicStones")
	@ResponseBody
	public int delDicStones(String id) {
		int state = dao.deleteDicStones(id);
		return state;
	}
}
