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
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("/NianYaSuDuController")
public class NianYaSuDuController {


	@Resource
	private NianYaSuDuDao dao;

	private Map<String,Object> map=new HashMap<>();

	@RequestMapping("/getAllNianYaSuDu")
	@ResponseBody
	public List<SiteCompactionSpeedVo> getAllNianYaSuDu(HttpSession session,String  roadquanxain) {
		String luduanquanxian="";
		if(roadquanxain!=null){
			luduanquanxian=roadquanxain;
		}else{
			User user = (User) session.getAttribute("user");
			luduanquanxian = user.getLuduanquanxian();
		}
		return dao.getAllNianYaSuDu(luduanquanxian);
	}

	@RequestMapping("/delNianYaSuDu")
	@ResponseBody
	public int delNianYaSuDu(String id) {
		return dao.delNianYaSuDu(id);
	}

	@RequestMapping("/addNianYaSuDu")
	@ResponseBody
	public Map<String,Object> addNianYaSuDu(@RequestBody SiteCompactionSpeedVo siteCompactionSpeedVo,HttpSession session) {
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
		map.put("resultMsg",daoMsg);
		map.put("daoMsg",i);
		map.put("obj",siteCompactionSpeedVo);
		return map;
	}

	@RequestMapping("/updateNianYaSuDu")
	@ResponseBody
	public Map<String,Object> updateNianYaSuDu(@RequestBody SiteCompactionSpeedVo siteCompactionSpeedVo,HttpSession session) {
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
		map.put("resultMsg",daoMsg);
		map.put("daoMsg",i);
		map.put("obj",siteCompactionSpeedVo);
		return map;
	}

	@RequestMapping("/getByLuDuanId")
	@ResponseBody
	public List<SiteCompactionSpeedVo> getByLuDuanId(String roadId) {
		return dao.getByLuDuanId(roadId);
	}


	@RequestMapping("/getnianyasuduEchars")
	@ResponseBody
	public List<SiteCompactionSpeedVo> getnianyasuduEchars(String startime,String endtime,String siteId){
		List<SiteCompactionSpeedVo> list=new ArrayList<SiteCompactionSpeedVo>();

		List<SiteCompactionSpeedVo> slist=dao.getDISTINCTDate( startime, endtime);
		if(slist!=null&&slist.size()!=0){
			for(int i=0;i<slist.size();i++){
				SiteCompactionSpeedVo ss=new SiteCompactionSpeedVo();
				String datetime = slist.get(i).getDatetime();
				ss.setDatetime(datetime);
				BigDecimal speed = new BigDecimal(0);
				SiteCompactionSpeedVo vo = dao.getnianyasuduEchars(datetime,"钢轮",siteId);
				ss.setName1("钢轮");
				if (vo != null && !"".equals(vo)){
					ss.setName1speed(vo.getCompactionspeed());
				}else{
					ss.setName1speed(speed);
				}
				SiteCompactionSpeedVo vo2 = dao.getnianyasuduEchars(datetime,"胶轮",siteId);
				ss.setName2("胶轮");
				if (vo2 != null && !"".equals(vo2)){
					ss.setName2speed(vo2.getCompactionspeed());
				}else{
					ss.setName2speed(speed);
				}

				list.add(ss);
			}
		}

		return list;
	}

}
