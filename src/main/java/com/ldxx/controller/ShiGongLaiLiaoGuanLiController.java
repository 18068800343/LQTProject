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
import com.ldxx.dao.ShiGongLaiLiaoDao;
import com.ldxx.dao.TanPuDiDianGuanLiDao;
import com.ldxx.service.TanPuDiDianGuanLiService;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.vo.SiteConstructionVo;
import com.ldxx.vo.SiteFieldMaterialMgtVo;

@Controller
@RequestMapping("/ShiGongLaiLiaoGuanLi")
public class ShiGongLaiLiaoGuanLiController {
	
	
	@Autowired
	private ShiGongLaiLiaoDao dao;
	
	@RequestMapping("/getAllShiGongLaiLiao")
	@ResponseBody
    public List<SiteFieldMaterialMgtVo> getDistinctTanPuDiDian() {
        return dao.getAllShiGongLaiLiao();
    }
	
	@RequestMapping("/delShiGongLaiLiao")
	@ResponseBody
	public int delTanPuDiDian(String id) {
		return dao.delShiGongLaiLiao(id);
	}
	
	@RequestMapping("/addShiGongLaiLiao")
	@ResponseBody
	public String addShiGongLaiLiao(@RequestBody SiteFieldMaterialMgtVo siteFieldMaterialMgtVo) {
		JSONObject jsonObject = new JSONObject();
		siteFieldMaterialMgtVo.setId(LDXXUtils.getUUID12());
		siteFieldMaterialMgtVo.setDeletestate(1);
		int i = 0;
		try {
			i = dao.addShiGongLaiLiao(siteFieldMaterialMgtVo);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("errMsg","数据库插入出错,请检查经纬度输入格式");
		}
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",siteFieldMaterialMgtVo);
		return jsonObject.toString();
	}
	
	@RequestMapping("/updateTanPuDiDian")
	@ResponseBody
	public String updateTanPuDiDian(@RequestBody SiteFieldMaterialMgtVo siteFieldMaterialMgtVo) {
		JSONObject jsonObject = new JSONObject();
		int i = 0;
		try {
			i = dao.updateShiGongLaiLiao(siteFieldMaterialMgtVo);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("errMsg","数据库插入出错,请检查经纬度输入格式");
		}
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "修改");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",siteFieldMaterialMgtVo);
		return jsonObject.toString();
	}

}
