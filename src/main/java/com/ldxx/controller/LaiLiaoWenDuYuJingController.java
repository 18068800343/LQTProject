package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.Constant.DateConstant;
import com.ldxx.bean.User;
import com.ldxx.service.LaiLiaoWenDuYuJingService;
import com.ldxx.util.DateUtil;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.vo.SiteIncomingMaterialTempWarningVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/LaiLiaoWenDuYuJing")
public class LaiLiaoWenDuYuJingController {


    @Autowired
    private LaiLiaoWenDuYuJingService service;

    @RequestMapping("/getAllLaiLiaoWenDu")
    @ResponseBody
    public List<SiteIncomingMaterialTempWarningVo> getAllLaiLiaoWenDu(HttpSession session ,String  roadquanxain) {
    	String luduanquanxian="";
		if(roadquanxain!=null){
			luduanquanxian=roadquanxain;
		}else{
			User user = (User) session.getAttribute("user");
	        luduanquanxian = user.getLuduanquanxian();
		}
        
        return service.getAllLaiLiaoWenDu(luduanquanxian);
    }

    @RequestMapping("/delLaiLiaoWenDu")
    @ResponseBody
    public int delLaiLiaoWenDu(String id) {
        return service.delLaiLiaoWenDu(id);
    }

    @RequestMapping("/addLaiLiaoWenDu")
    @ResponseBody
    public String addLaiLiaoWenDu(@RequestBody SiteIncomingMaterialTempWarningVo siteIncomingMaterialTempWarningVo,HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        siteIncomingMaterialTempWarningVo.setId(LDXXUtils.getUUID12());
        siteIncomingMaterialTempWarningVo.setDeletestate(1);
        String nowDateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
        siteIncomingMaterialTempWarningVo.setDatetime(nowDateStr);
        siteIncomingMaterialTempWarningVo.setEditdatetime(nowDateStr);
        User user = (User) session.getAttribute("user");
        if(null!=user) {
            siteIncomingMaterialTempWarningVo.setEdituserid(user.getUserId());
            siteIncomingMaterialTempWarningVo.setUname(user.getuName());
        }
        int i = 0;
        try {
            i = service.addLaiLiaoWenDu(siteIncomingMaterialTempWarningVo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("errMsg","数据库插入出错,请检查经纬度输入格式");
        }
        String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
        jsonObject.put("resultMsg",daoMsg);
        jsonObject.put("daoMsg",i);
        jsonObject.put("obj",siteIncomingMaterialTempWarningVo);
        return jsonObject.toString();
    }

    @RequestMapping("/updateLaiLiaoWenDu")
    @ResponseBody
    public String updateLaiLiaoWenDu(@RequestBody SiteIncomingMaterialTempWarningVo siteIncomingMaterialTempWarningVo,HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        String nowDateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
        siteIncomingMaterialTempWarningVo.setDatetime(nowDateStr);
        siteIncomingMaterialTempWarningVo.setEditdatetime(nowDateStr);
        User user = (User) session.getAttribute("user");
        if(null!=user) {
            siteIncomingMaterialTempWarningVo.setEdituserid(user.getUserId());
            siteIncomingMaterialTempWarningVo.setUname(user.getuName());
        }
        int i = 0;
        try {
            i = service.updateLaiLiaoWenDu(siteIncomingMaterialTempWarningVo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("errMsg","数据库插入出错,请检查经纬度输入格式");
        }
        String daoMsg = MsgFormatUtils.getMsgByResult(i, "修改");
        jsonObject.put("resultMsg",daoMsg);
        jsonObject.put("daoMsg",i);
        jsonObject.put("obj",siteIncomingMaterialTempWarningVo);
        return jsonObject.toString();
    }

    /**
     * 修改预警状态
     * @param id
     * @return
     */
    @RequestMapping("/updWarningstate")
    @ResponseBody
    public int updWarningstate(String id,int warningstate, HttpSession session) {
        int i= service.updWarningstate(id,warningstate,session);
        return i;
    }
    
    @RequestMapping("/getLaiLiaoWenDuByBatch")
    @ResponseBody
    public SiteIncomingMaterialTempWarningVo getLaiLiaoWenDuByBatch(String batch) {
        return service.getLaiLiaoWenDuByBatch(batch);
    }

    @RequestMapping("/getByLuDuanId")
    @ResponseBody
    public List<SiteIncomingMaterialTempWarningVo> getByLuDuanId(String roadId) {
        return service.getByLuDuanId(roadId);
    }
}
