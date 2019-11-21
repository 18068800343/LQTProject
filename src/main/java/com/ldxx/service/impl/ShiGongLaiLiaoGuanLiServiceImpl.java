package com.ldxx.service.impl;

import com.ldxx.Constant.DateConstant;
import com.ldxx.bean.User;
import com.ldxx.dao.LaiLiaoWenDuYuJingDao;
import com.ldxx.dao.ShengChanJiHuaDao;
import com.ldxx.dao.ShiGongLaiLiaoDao;
import com.ldxx.service.ShiGongLaiLiaoGuanLiService;
import com.ldxx.util.DateUtil;
import com.ldxx.util.LDXXUtils;
import com.ldxx.vo.PianChaLiangVo;
import com.ldxx.vo.SiteFieldMaterialMgtVo;
import com.ldxx.vo.SiteIncomingMaterialTempWarningVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ShiGongLaiLiaoGuanLiServiceImpl implements ShiGongLaiLiaoGuanLiService {

    @Autowired
    private ShiGongLaiLiaoDao dao;
    @Autowired
    private LaiLiaoWenDuYuJingDao laidao;
    @Autowired
    private ShengChanJiHuaDao shengChanJiHuaDao;

    @Override
    public List<SiteFieldMaterialMgtVo> getAllShiGongLaiLiao() {
        return dao.getAllShiGongLaiLiao();
    }

    @Override
    public int delShiGongLaiLiao(String id) {
        return dao.delShiGongLaiLiao(id);
    }

    @Override
    public int addShiGongLaiLiao(SiteFieldMaterialMgtVo siteFieldMaterialMgtVo, HttpSession session) {
        int i = dao.addShiGongLaiLiao(siteFieldMaterialMgtVo);
        //PianChaLiangVo piancha = dao.getPiancha(siteFieldMaterialMgtVo.getBatchid(),siteFieldMaterialMgtVo.getTemp());
        PianChaLiangVo piancha = shengChanJiHuaDao.getPiancha(siteFieldMaterialMgtVo);
        //piancha1=来料温度-生产计划的到场温度要求
        BigDecimal piancha1 = piancha.getPianCha();
        //施工偏差的到场温度要求
        BigDecimal piancha2 = piancha.getArriveTempOffset();
        if(piancha1.compareTo(piancha2)==1){
            //piancha1>piancha2；新增来料温度预警
            SiteIncomingMaterialTempWarningVo sv=new SiteIncomingMaterialTempWarningVo();
            sv.setId(LDXXUtils.getUUID12());
            sv.setDeletestate(1);
            String nowDateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
            sv.setDatetime(nowDateStr);
            sv.setEditdatetime(nowDateStr);
            sv.setFieid(siteFieldMaterialMgtVo.getId());
            sv.setWarningcontent("大于施工偏差要求的到场温度"+piancha1.subtract(piancha2)+"度");
            sv.setWarningstate(0);
            User user = (User) session.getAttribute("user");
            if(null!=user) {
                sv.setEdituserid(user.getUserId());
                sv.setUname(user.getuName());
            }
            i = laidao.addLaiLiaoWenDu(sv);
        }
        return i;
    }

    @Override
    public int updateShiGongLaiLiao(SiteFieldMaterialMgtVo siteFieldMaterialMgtVo) {
        return dao.updateShiGongLaiLiao(siteFieldMaterialMgtVo);
    }
}