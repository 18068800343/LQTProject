package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.Constant.DateConstant;
import com.ldxx.bean.User;
import com.ldxx.dao.NianYaCiShuDao;
import com.ldxx.util.DateUtil;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.vo.SiteCompactionNumVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/NianYaCiShuController")
public class NianYaCiShuController {


	@Resource
	private NianYaCiShuDao dao;

	@RequestMapping("/getAllNianYaCiShu")
	@ResponseBody
	public List<SiteCompactionNumVo> getAllNianYaCiShu(HttpSession session) {
		User user = (User) session.getAttribute("user");
		String luduanquanxian = user.getLuduanquanxian();
		return dao.getAllNianYaCiShu(luduanquanxian);
	}

	@RequestMapping("/delNianYaCiShu")
	@ResponseBody
	public int delNianYaCiShu(String id) {
		return dao.delNianYaCiShu(id);
	}

	@RequestMapping("/addNianYaCiShu")
	@ResponseBody
	public String addNianYaCiShu(@RequestBody SiteCompactionNumVo siteCompactionNumVo,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		siteCompactionNumVo.setId(LDXXUtils.getUUID12());
		siteCompactionNumVo.setDeletestate(1);
		String nowDateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		siteCompactionNumVo.setEditdatetime(nowDateStr);
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			siteCompactionNumVo.setEdituserid(user.getUserId());
			siteCompactionNumVo.setUname(user.getuName());
		}
		int i = 0;
		try {
			i = dao.addNianYaCiShu(siteCompactionNumVo);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("errMsg","数据库插入出错,请检查经纬度输入格式");
		}
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",siteCompactionNumVo);
		return jsonObject.toString();
	}

	@RequestMapping("/updateNianYaCiShu")
	@ResponseBody
	public String updateNianYaCiShu(@RequestBody SiteCompactionNumVo siteCompactionNumVo,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		String nowDateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		siteCompactionNumVo.setDatetime(nowDateStr);
		siteCompactionNumVo.setEditdatetime(nowDateStr);
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			siteCompactionNumVo.setEdituserid(user.getUserId());
			siteCompactionNumVo.setUname(user.getuName());
		}
		int i = 0;
		try {
			i = dao.updateNianYaCiShu(siteCompactionNumVo);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("errMsg","数据库插入出错,请检查经纬度输入格式");
		}
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "修改");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",siteCompactionNumVo);
		return jsonObject.toString();
	}

	@RequestMapping("/getByLuDuanId")
	@ResponseBody
	public List<SiteCompactionNumVo> getByLuDuanId(String roadId) {
		return dao.getByLuDuanId(roadId);
	}

}
