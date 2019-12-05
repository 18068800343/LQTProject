package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.bean.SiteRoadMileageTemp;
import com.ldxx.bean.User;
import com.ldxx.dao.SiteRoadMileageTempDao;
import com.ldxx.service.SiteRoadMileageTempService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.vo.TanPuWenDuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 摊铺温度
 */

@RestController
@RequestMapping("SiteRoadMileageTemp")
public class SiteRoadMileageTempController {

    @Autowired
    private SiteRoadMileageTempService service;

    @Resource
    private SiteRoadMileageTempDao dao;

    @RequestMapping("/getAllSiteRoadMileageTemp")
    public List<SiteRoadMileageTemp> getAllSiteRoadMileageTemp(HttpSession session){
        User user = (User) session.getAttribute("user");
        String luduanquanxian = user.getLuduanquanxian();
        return service.getAllSiteRoadMileageTemp(luduanquanxian);
    }

    @RequestMapping("/updSiteRoadMileageTemp")
    public String updSiteRoadMileageTemp(@RequestBody SiteRoadMileageTemp srm,HttpSession session){
        JSONObject json=new JSONObject();
        srm.setEditDatetime(GetThisTimeUtils.getDateTime());
        User user = (User) session.getAttribute("user");
		if(null!=user) {
			srm.setEditUserId(user.getUserId());
		}
        int i= service.updSiteRoadMileageTemp(srm);
        String msg = MsgFormatUtils.getMsgByResult(i, "修改");
        json.put("msg",msg);
        json.put("result",i);
        json.put("obj",srm);
        return json.toJSONString();
    }

    @RequestMapping("/delSiteRoadMileageTemp")
    public int delSiteRoadMileageTemp(String id){
        return service.delSiteRoadMileageTemp(id);
    }

    @RequestMapping("/insertSiteRoadMileageTemp")
    public String insertSiteRoadMileageTemp(@RequestBody SiteRoadMileageTemp srm,HttpSession session){
        JSONObject json=new JSONObject();
        srm.setId(LDXXUtils.getUUID12());
        srm.setEditDatetime(GetThisTimeUtils.getDateTime());
        User user = (User) session.getAttribute("user");
		if(null!=user) {
			srm.setEditUserId(user.getUserId());
		}
        int i= service.insertSiteRoadMileageTemp(srm);
        String msg = MsgFormatUtils.getMsgByResult(i, "新增");
        json.put("msg",msg);
        json.put("result",i);
        json.put("obj",srm);
        return json.toJSONString();
    }

    /**
     * 通过路段ID筛选查询
     * @param roadId
     * @return
     */
    @RequestMapping("/getByLuDuanId")
    public List<SiteRoadMileageTemp> getByLuDuanId(String roadId) {
        return service.getByLuDuanId(roadId);
    }

    @RequestMapping("/getTanPuWenDuVoListByTime")
    @ResponseBody
    public TanPuWenDuVo getTanPuWenDuVoListByTime(String beginTime, String endTime, String roadId){
        List<SiteRoadMileageTemp> list = dao.getTanPuWenDuVoListByTime(beginTime,endTime,roadId);
        TanPuWenDuVo TanPuWenDuVo = new TanPuWenDuVo();
        TanPuWenDuVo  = TanPuWenDuVo.getTanPuWenDuVoByPeiBiVoList(list);
        return TanPuWenDuVo;
    }
}
