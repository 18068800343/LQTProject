package com.ldxx.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.BatchMgt;
import com.ldxx.service.BatchMgtService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;
/**
 * 批次管理
 * @author hp
 *
 */
@Controller
@RequestMapping("BatchMgt")
public class BatchMgtController {
	
	@Autowired
	private BatchMgtService service;
	
	private Map<String,Object> map=new HashMap<>();
	
	@RequestMapping("/getAllBatchMgt")
	@ResponseBody
	public List<BatchMgt> getAllBatchMgt(){
		return service.getAllBatchMgt();
	}
	
	@RequestMapping("/getBatchMgtById")
	@ResponseBody
	public BatchMgt getBatchMgtById(String id){
		return service.getBatchMgtById(id);
	}
	
	@RequestMapping("/updBatchMgt")
	@ResponseBody
	public Map<String,Object> updBatchMgt(BatchMgt bm){
		bm.setEditDatetime(GetThisTimeUtils.getDateTime());
		int i= service.updBatchMgt(bm);
		map.put("result", i);
		map.put("BatchMgt", bm);
		return map;
	}
	
	@RequestMapping("/delBatchMgt")
	@ResponseBody
	public int delBatchMgt(String id){
		return service.delBatchMgt(id);
	}

	@RequestMapping("/insertBatchMgt")
	@ResponseBody
	public Map<String,Object> insertBatchMgt(BatchMgt bm){
		bm.setId(LDXXUtils.getUUID12());
		bm.setEditDatetime(GetThisTimeUtils.getDateTime());
		int i= service.insertBatchMgt(bm);
		map.put("result", i);
		map.put("BatchMgt", bm);
		return map;
	}
}
