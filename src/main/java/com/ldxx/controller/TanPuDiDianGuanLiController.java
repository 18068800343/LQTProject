package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.bean.SiteConstruction;
import com.ldxx.dao.TanPuDiDianGuanLiDao;
import com.ldxx.service.TanPuDiDianGuanLiService;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.vo.SiteConstructionVo;

@Controller
@RequestMapping("/TanPuDiDianGuanLi")
public class TanPuDiDianGuanLiController {
	
	@Autowired
	private TanPuDiDianGuanLiService service;
	
	@Autowired
	private TanPuDiDianGuanLiDao dao;
	
	@RequestMapping("/getDistinctTanPuDiDian")
	@ResponseBody
    public List<SiteConstruction> getDistinctTanPuDiDian() {
        return service.getDistinctTanPuDiDian();
    }
	
	@RequestMapping("/getAllTanPuDiDian")
	@ResponseBody
	public List<SiteConstructionVo> getAllTanPuDiDian() {
		return dao.getAllTanPuDiDian();
	}
	
	@RequestMapping("/delTanPuDiDian")
	@ResponseBody
	public int delTanPuDiDian(String id) {
		return dao.delTanPuDiDian(id);
	}
	
	@RequestMapping("/addTanPuDiDian")
	@ResponseBody
	public String addTanPuDiDian(@RequestBody SiteConstructionVo siteConstructionVo) {
		JSONObject jsonObject = new JSONObject();
		siteConstructionVo.setId(LDXXUtils.getUUID12());
		siteConstructionVo.setDeletestate(1);
		int i = 0;
		try {
			i = dao.addTanPuDiDian(siteConstructionVo);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("errMsg","数据库插入出错,请检查经纬度输入格式");
		}
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",siteConstructionVo);
		return jsonObject.toString();
	}
	
	@RequestMapping("/updateTanPuDiDian")
	@ResponseBody
	public String updateTanPuDiDian(@RequestBody SiteConstructionVo siteConstructionVo) {
		JSONObject jsonObject = new JSONObject();
		int i = 0;
		try {
			i = dao.updateTanPuDiDian(siteConstructionVo);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("errMsg","数据库插入出错,请检查经纬度输入格式");
		}
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "修改");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",siteConstructionVo);
		return jsonObject.toString();
	}
	
	@RequestMapping("/getBiaoDuanByLuDuan")
	@ResponseBody
	public List<SiteConstruction> getBiaoDuanByLuDuan(String roadno) {
		Map<String, String> map = new HashMap<>();
		map.put("roadno", roadno);
		return service.getBiaoDuanByLuDuan(map);
	}

	/**
	 * 通过路段roadId获取标段信息
	 * @param roadId
	 * @return
	 */
	@RequestMapping("/getByLuDuanId")
	@ResponseBody
	public List<SiteConstruction> getByLuDuanId(String roadId) {
		Map<String, String> map = new HashMap<>();
		map.put("roadId", roadId);
		return service.getByLuDuanId(map);
	}
	/**
	 * 通获取所有路段（去重）
	 * @return
	 */
	@RequestMapping("/getIDisroadName")
	@ResponseBody
	public List<SiteConstructionVo> getIDisroadName() {
		return dao.getIDisroadName();
	}

}
