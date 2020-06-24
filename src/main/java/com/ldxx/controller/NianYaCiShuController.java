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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/NianYaCiShuController")
public class NianYaCiShuController {


	@Resource
	private NianYaCiShuDao dao;

	private Map<String,Object> map=new HashMap<>();

	@RequestMapping("/getAllNianYaCiShu")
	@ResponseBody
	public List<SiteCompactionNumVo> getAllNianYaCiShu(HttpSession session,String  roadquanxain) {
		String luduanquanxian="";
		if(roadquanxain!=null){
			luduanquanxian=roadquanxain;
		}else{
			User user = (User) session.getAttribute("user");
			luduanquanxian = user.getLuduanquanxian();
		}
		return dao.getAllNianYaCiShu(luduanquanxian);
	}

	@RequestMapping("/delNianYaCiShu")
	@ResponseBody
	public int delNianYaCiShu(String id) {
		return dao.delNianYaCiShu(id);
	}

	@RequestMapping("/addNianYaCiShu")
	@ResponseBody
	public Map<String,Object> addNianYaCiShu(@RequestBody SiteCompactionNumVo siteCompactionNumVo,HttpSession session) {
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
		map.put("resultMsg",daoMsg);
		map.put("daoMsg",i);
		map.put("obj",siteCompactionNumVo);
		return map;
	}

	@RequestMapping("/updateNianYaCiShu")
	@ResponseBody
	public Map<String,Object> updateNianYaCiShu(@RequestBody SiteCompactionNumVo siteCompactionNumVo,HttpSession session) {
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
		map.put("resultMsg",daoMsg);
		map.put("daoMsg",i);
		map.put("obj",siteCompactionNumVo);
		return map;
	}

	@RequestMapping("/getByLuDuanId")
	@ResponseBody
	public List<SiteCompactionNumVo> getByLuDuanId(String roadId) {
		return dao.getByLuDuanId(roadId);
	}

}
