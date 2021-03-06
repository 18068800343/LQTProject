package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.bean.SiteRoadSpend;
import com.ldxx.bean.User;
import com.ldxx.dao.SiteRoadSpendDao;
import com.ldxx.service.SiteRoadSpendService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.vo.TanPuSuDuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 摊铺速度
 */

@RestController
@RequestMapping("SiteRoadSpend")
public class SiteRoadSpendController {

    @Autowired
    private SiteRoadSpendService service;

    @Resource
    private SiteRoadSpendDao dao;

    private Map<String,Object> map=new HashMap<>();

    @RequestMapping("/selectAllSiteRoadSpend")
    public List<SiteRoadSpend> selectAllSiteRoadSpend(HttpSession session,String  roadquanxain){
    	String luduanquanxian="";
		if(roadquanxain!=null){
			luduanquanxian=roadquanxain;
		}else{
			User user = (User) session.getAttribute("user");
	        luduanquanxian = user.getLuduanquanxian();
		}
        return service.selectAllSiteRoadSpend(luduanquanxian);
    }

    @RequestMapping("/updSiteRoadSpend")
    public Map<String,Object> updSiteRoadSpend(@RequestBody SiteRoadSpend srs,HttpSession session){
        JSONObject jsonObject=new JSONObject();
        srs.setEditDatetime2(GetThisTimeUtils.getDateTime());
        User user = (User) session.getAttribute("user");
		if(null!=user) {
			srs.setEditUserId2(user.getUserId());
		}
        int i= service.updSiteRoadSpend(srs);
        String daoMsg = MsgFormatUtils.getMsgByResult(i, "修改");
        map.put("resultMsg",daoMsg);
        map.put("daoMsg",i);
        map.put("obj",srs);
        return  map;
    }

    @RequestMapping("/delSiteRoadSpend")
    public int delSiteRoadSpend(String id){
        return service.delSiteRoadSpend(id);
    }

    @RequestMapping("/insertSiteRoadSpend")
    public Map<String,Object> insertSiteRoadSpend(@RequestBody SiteRoadSpend srs,HttpSession session){
        JSONObject jsonObject=new JSONObject();
        srs.setId(LDXXUtils.getUUID12());
        srs.setEditDatetime2(GetThisTimeUtils.getDateTime());
        User user = (User) session.getAttribute("user");
		if(null!=user) {
			srs.setEditUserId2(user.getUserId());
		}
        int i= service.insertSiteRoadSpend(srs);
        String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
        map.put("resultMsg",daoMsg);
        map.put("daoMsg",i);
        map.put("obj",srs);
        return  map;
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

    @RequestMapping("/getTanPuSuDuVoListByTime")
    @ResponseBody
    public TanPuSuDuVo getTanPuSuDuVoListByTime(String beginTime, String endTime, String roadId){
        List<SiteRoadSpend> list = dao.getTanPuSuDuVoListByTime(beginTime,endTime,roadId);
        TanPuSuDuVo tanPuSuDuVo = new TanPuSuDuVo();
        tanPuSuDuVo  = tanPuSuDuVo.getTanPuSuDuVoByPeiBiVoList(list);
        return tanPuSuDuVo;
    }

}
