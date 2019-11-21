package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.Constant.DateConstant;
import com.ldxx.bean.User;
import com.ldxx.dao.ZhiLiangYuJingDao;
import com.ldxx.util.DateUtil;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.vo.PlanProductionWarningVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/ZhiLiangYuJingController")
public class ZhiLiangYuJingController {


	@Resource
	private ZhiLiangYuJingDao dao;

	@RequestMapping("/getAllZhiLiangYuJing")
	@ResponseBody
	public Map getAllZhiLiangYuJing(HttpSession session) {
        User user = (User) session.getAttribute("user");

		Map map = new HashMap();

		map.put("list",dao.getAllZhiLiangYuJing());
		Optional.ofNullable(user)
				.ifPresent(u->{
					map.put("user",u);
				});

		return map;
	}

	@RequestMapping("/delZhiLiangYuJing")
	@ResponseBody
	public int delZhiLiangYuJing(String id) {
		return dao.delZhiLiangYuJing(id);
	}

	@RequestMapping("/addZhiLiangYuJing")
	@ResponseBody
	public String addZhiLiangYuJing(@RequestBody PlanProductionWarningVo planProductionWarningVo,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		planProductionWarningVo.setId(LDXXUtils.getUUID12());
		planProductionWarningVo.setDeletestate(1);
		String nowDateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		planProductionWarningVo.setDatetime(nowDateStr);
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			planProductionWarningVo.setSenduserid(user.getUserId());
			planProductionWarningVo.setUname(user.getuName());
		}
		int i = 0;
		try {
			i = dao.addZhiLiangYuJing(planProductionWarningVo);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("errMsg","数据库插入出错,请检查经纬度输入格式");
		}
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",planProductionWarningVo);
		return jsonObject.toString();
	}

	@RequestMapping("/updateZhiLiangYuJing")
	@ResponseBody
	public String updateZhiLiangYuJing(@RequestBody PlanProductionWarningVo planProductionWarningVo,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		String nowDateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		planProductionWarningVo.setDatetime(nowDateStr);
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			planProductionWarningVo.setUname(user.getuName());
		}
		int i = 0;
		try {
			i = dao.updateZhiLiangYuJing(planProductionWarningVo);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("errMsg","数据库插入出错,请检查经纬度输入格式");
		}
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "修改");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",planProductionWarningVo);
		return jsonObject.toString();
	}

}
