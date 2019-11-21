package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.Constant.DateConstant;
import com.ldxx.bean.User;
import com.ldxx.dao.JiHuaZengJianDao;
import com.ldxx.util.DateUtil;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.bean.PlanProductionCount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/JiHuaZengJianController")
public class JiHuaZengJianController {


	@Resource
	private JiHuaZengJianDao dao;

	@RequestMapping("/getAllJiHuaZengJian")
	@ResponseBody
	public List<PlanProductionCount> getAllJiHuaZengJian() {
		return dao.getAllJiHuaZengJian();
	}

	@RequestMapping("/delJiHuaZengJian")
	@ResponseBody
	public int delJiHuaZengJian(String id) {
		return dao.delJiHuaZengJian(id);
	}

	@RequestMapping("/addJiHuaZengJian")
	@ResponseBody
	public String addJiHuaZengJian(@RequestBody PlanProductionCount planProductionCount,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		planProductionCount.setId(LDXXUtils.getUUID12());
		String nowDateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		planProductionCount.setDatetime(nowDateStr);
		User user = (User) session.getAttribute("user");
		int i = 0;
		try {
			i = dao.addJiHuaZengJian(planProductionCount);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("errMsg","数据库插入出错,请检查经纬度输入格式");
		}
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",planProductionCount);
		return jsonObject.toString();
	}

	@RequestMapping("/updateJiHuaZengJian")
	@ResponseBody
	public String updateJiHuaZengJian(@RequestBody PlanProductionCount planProductionCount,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		String nowDateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		planProductionCount.setDatetime(nowDateStr);
		int i = 0;
		try {
			i = dao.updateJiHuaZengJian(planProductionCount);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("errMsg","数据库插入出错,请检查经纬度输入格式");
		}
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "修改");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",planProductionCount);
		return jsonObject.toString();
	}

}