package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.bean.SiteRoadSpend;
import com.ldxx.bean.User;
import com.ldxx.service.SiteRoadSpendService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 摊铺速度
 */

@RestController
@RequestMapping("SiteRoadSpend")
public class SiteRoadSpendController {

    @Autowired
    private SiteRoadSpendService service;

    @RequestMapping("/selectAllSiteRoadSpend")
    public List<SiteRoadSpend> selectAllSiteRoadSpend(HttpSession session){
        User user = (User) session.getAttribute("user");
        String luduanquanxian = user.getLuduanquanxian();
        return service.selectAllSiteRoadSpend(luduanquanxian);
    }

    @RequestMapping("/updSiteRoadSpend")
    public String updSiteRoadSpend(@RequestBody SiteRoadSpend srs,HttpSession session){
        JSONObject jsonObject=new JSONObject();
        srs.setEditDatetime2(GetThisTimeUtils.getDateTime());
        User user = (User) session.getAttribute("user");
		if(null!=user) {
			srs.setEditUserId2(user.getUserId());
		}
        int i= service.updSiteRoadSpend(srs);
        String daoMsg = MsgFormatUtils.getMsgByResult(i, "修改");
        jsonObject.put("resultMsg",daoMsg);
        jsonObject.put("daoMsg",i);
        jsonObject.put("obj",srs);
        return  jsonObject.toJSONString();
    }

    @RequestMapping("/delSiteRoadSpend")
    public int delSiteRoadSpend(String id){
        return service.delSiteRoadSpend(id);
    }

    @RequestMapping("/insertSiteRoadSpend")
    public String insertSiteRoadSpend(@RequestBody SiteRoadSpend srs,HttpSession session){
        JSONObject jsonObject=new JSONObject();
        srs.setId(LDXXUtils.getUUID12());
        srs.setEditDatetime2(GetThisTimeUtils.getDateTime());
        User user = (User) session.getAttribute("user");
		if(null!=user) {
			srs.setEditUserId2(user.getUserId());
		}
        int i= service.insertSiteRoadSpend(srs);
        String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
        jsonObject.put("resultMsg",daoMsg);
        jsonObject.put("daoMsg",i);
        jsonObject.put("obj",srs);
        return  jsonObject.toJSONString();
    }

    /**
     * 通过路段id筛选查询
     * @param roadId
     * @return
     */
    @RequestMapping("/getByLuDuanId")
    public List<SiteRoadSpend> getByLuDuanId(String roadId){
        return service.getByLuDuanId(roadId);
    }
}
