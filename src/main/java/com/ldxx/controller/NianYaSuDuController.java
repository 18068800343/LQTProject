package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.Constant.DateConstant;
import com.ldxx.bean.User;
import com.ldxx.dao.NianYaSuDuDao;
import com.ldxx.util.DateUtil;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.vo.SiteCompactionSpeedVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/NianYaSuDuController")
public class NianYaSuDuController {


	@Resource
	private NianYaSuDuDao dao;

	@RequestMapping("/getAllNianYaSuDu")
	@ResponseBody
	public List<SiteCompactionSpeedVo> getAllNianYaSuDu() {
		return dao.getAllNianYaSuDu();
	}

	@RequestMapping("/delNianYaSuDu")
	@ResponseBody
	public int delNianYaSuDu(String id) {
		return dao.delNianYaSuDu(id);
	}

	@RequestMapping("/addNianYaSuDu")
	@ResponseBody
	public String addNianYaSuDu(@RequestBody SiteCompactionSpeedVo siteCompactionSpeedVo,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		siteCompactionSpeedVo.setId(LDXXUtils.getUUID12());
		siteCompactionSpeedVo.setDeletestate(1);
		String nowDateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		siteCompactionSpeedVo.setEditdatetime(nowDateStr);
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			siteCompactionSpeedVo.setEdituserid(user.getUserId());
			siteCompactionSpeedVo.setUname(user.getuName());
		}
		int i = 0;
		try {
			i = dao.addNianYaSuDu(siteCompactionSpeedVo);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("errMsg","数据库插入出错,请检查经纬度输入格式");
		}
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",siteCompactionSpeedVo);
		return jsonObject.toString();
	}

	@RequestMapping("/updateNianYaSuDu")
	@ResponseBody
	public String updateNianYaSuDu(@RequestBody SiteCompactionSpeedVo siteCompactionSpeedVo,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		String nowDateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		siteCompactionSpeedVo.setDatetime(nowDateStr);
		siteCompactionSpeedVo.setEditdatetime(nowDateStr);
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			siteCompactionSpeedVo.setEdituserid(user.getUserId());
			siteCompactionSpeedVo.setUname(user.getuName());
		}
		int i = 0;
		try {
			i = dao.updateNianYaSuDu(siteCompactionSpeedVo);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("errMsg","数据库插入出错,请检查经纬度输入格式");
		}
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "修改");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",siteCompactionSpeedVo);
		return jsonObject.toString();
	}

}
