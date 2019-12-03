package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.Constant.DateConstant;
import com.ldxx.bean.User;
import com.ldxx.service.ShiGongLaiLiaoGuanLiService;
import com.ldxx.util.DateUtil;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.vo.SiteFieldMaterialMgtVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/ShiGongLaiLiaoGuanLi")
public class ShiGongLaiLiaoGuanLiController {
	
	
	@Autowired
	private ShiGongLaiLiaoGuanLiService service;
	
	@RequestMapping("/getAllShiGongLaiLiao")
	@ResponseBody
    public List<SiteFieldMaterialMgtVo> getDistinctTanPuDiDian(HttpSession session) {
		User user = (User) session.getAttribute("user");
		String luduanquanxian = user.getLuduanquanxian();
        return service.getAllShiGongLaiLiao(luduanquanxian);
    }
	
	@RequestMapping("/delShiGongLaiLiao")
	@ResponseBody
	public int delTanPuDiDian(String id) {
		return service.delShiGongLaiLiao(id);
	}
	
	@RequestMapping("/addShiGongLaiLiao")
	@ResponseBody
	public String addShiGongLaiLiao(@RequestBody SiteFieldMaterialMgtVo siteFieldMaterialMgtVo,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		siteFieldMaterialMgtVo.setId(LDXXUtils.getUUID12());
		siteFieldMaterialMgtVo.setDeletestate(1);
		String nowDateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		siteFieldMaterialMgtVo.setDatetime(nowDateStr);
		siteFieldMaterialMgtVo.setEditdatetime(nowDateStr);
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			siteFieldMaterialMgtVo.setEdituserid(user.getUserId());
			siteFieldMaterialMgtVo.setUname(user.getuName());
		}
		int i = 0;
		try {
			i = service.addShiGongLaiLiao(siteFieldMaterialMgtVo, session);
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
	
	@RequestMapping("/updateShiGongLaiLiao")
	@ResponseBody
	public String updateShiGongLaiLiao(@RequestBody SiteFieldMaterialMgtVo siteFieldMaterialMgtVo,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		String nowDateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		siteFieldMaterialMgtVo.setDatetime(nowDateStr);
		siteFieldMaterialMgtVo.setEditdatetime(nowDateStr);
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			siteFieldMaterialMgtVo.setEdituserid(user.getUserId());
			siteFieldMaterialMgtVo.setUname(user.getuName());
		}
		int i = 0;
		try {
			i = service.updateShiGongLaiLiao(siteFieldMaterialMgtVo);
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

	/**
	 * 通过路段id筛选查询
	 * @param roadId
	 * @return
	 */
	@RequestMapping("/getByLuDuanId")
	@ResponseBody
	public List<SiteFieldMaterialMgtVo> getByLuDuanId(String roadId) {
		return service.getByLuDuanId(roadId);
	}

}
