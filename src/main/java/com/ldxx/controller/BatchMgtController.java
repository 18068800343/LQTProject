package com.ldxx.controller;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ldxx.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldxx.bean.BatchMgt;
import com.ldxx.dao.BatchMgtDao;
import com.ldxx.service.BatchMgtService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;
import com.ldxx.vo.BatchMgtVo;

import javax.servlet.http.HttpSession;

/**
 * 批次管理
 * @author hp
 *
 */
@RestController
@RequestMapping("BatchMgt")
public class BatchMgtController {
	
	@Autowired
	private BatchMgtService service;
	
	@Autowired
	private BatchMgtDao dao;
	
	private Map<String,Object> map=new HashMap<>();
	
	@RequestMapping("/getAllBatchMgt")
	public List<BatchMgtVo> getAllBatchMgt(){
		return service.getAllBatchMgt();
	}
	
	@RequestMapping("/getBatchMgtById")
	public BatchMgt getBatchMgtById(String id){
		return service.getBatchMgtById(id);
	}
	
	@RequestMapping("/getBatchMgtVoById")
	public BatchMgtVo getBatchMgtVoById(String id){
		return dao.getBatchMgtVoById(id);
	}
	
	@RequestMapping("/updBatchMgt")
	public Map<String,Object> updBatchMgt(BatchMgt bm, HttpSession session){
		bm.setEditDatetime(GetThisTimeUtils.getDateTime());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String formatStr =formatter.format(bm.getDatetimeOut());
		String sj = formatStr.replace(":", "").replace("-", "").replace(" ", "");
		bm.setBatch(bm.getLicencePlate()+sj);
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			bm.setEditUserId(user.getUserId());;
		}
		bm.setuName(user.getuName());
		int i= service.updBatchMgt(bm);
		map.put("result", i);
		map.put("BatchMgt", bm);
		return map;
	}
	
	@RequestMapping("/delBatchMgt")
	public int delBatchMgt(String id){
		return service.delBatchMgt(id);
	}

	@RequestMapping("/insertBatchMgt")
	public Map<String,Object> insertBatchMgt(BatchMgt bm, HttpSession session){
		bm.setId(LDXXUtils.getUUID12());
		bm.setEditDatetime(GetThisTimeUtils.getDateTime());
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			bm.setEditUserId(user.getUserId());
		}
		bm.setuName(user.getuName());
		int i= service.insertBatchMgt(bm);
		map.put("result", i);
		map.put("BatchMgt", bm);
		return map;
	}
	
	@RequestMapping("/getBatchMgtByPlate")
	public BatchMgt getBatchMgtByPlate(String licencePlate){
		BatchMgt bm = service.getBatchMgtByPlate(licencePlate);
		return bm;
	}
}
