package com.ldxx.service.impl;

import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.bean.User;
import com.ldxx.dao.LaiLiaoWenDuYuJingDao;
import com.ldxx.dao.WhWasteMgnDao;
import com.ldxx.service.LaiLiaoWenDuYuJingService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;
import com.ldxx.vo.SiteIncomingMaterialTempWarningVo;
import com.ldxx.vo.WhWasteMgnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional
public class LaiLiaoWenDuYuJingServiceImpl implements LaiLiaoWenDuYuJingService {

    @Autowired
    private LaiLiaoWenDuYuJingDao dao;
    @Autowired
    private WhWasteMgnDao wmdao;

    @Override
    public List<SiteIncomingMaterialTempWarningVo> getAllLaiLiaoWenDu() {
        return dao.getAllLaiLiaoWenDu();
    }

    @Override
    public int addLaiLiaoWenDu(SiteIncomingMaterialTempWarningVo siteIncomingMaterialTempWarningVo) {
        return dao.addLaiLiaoWenDu(siteIncomingMaterialTempWarningVo);
    }

    @Override
    public int delLaiLiaoWenDu(String id) {
        return dao.delLaiLiaoWenDu(id);
    }

    @Override
    public int updateLaiLiaoWenDu(SiteIncomingMaterialTempWarningVo siteIncomingMaterialTempWarningVo) {
        return dao.updateLaiLiaoWenDu(siteIncomingMaterialTempWarningVo);
    }

    @Override
    public int updWarningstate(String id, int warningstate, HttpSession session) {
        int i = dao.updWarningstate(id,warningstate);
        if(warningstate==2 && i>0){
            //做废料时要新增一条废料管理
            //获取生产计划的id和单价
            PlanProductionCollection shengchanjihua = dao.getshengchanjihua(id);
            //获取批次的id
            SiteIncomingMaterialTempWarningVo siteIncomingMaterialTempWarningVo = dao.getPiciId(id);
            //获取预警内容(报废原因)、报废重量、报废类型、
            WhWasteMgnVo wm= dao.getWeightandType(id);
            WhWasteMgnVo WhWasteMgn=new WhWasteMgnVo();
            WhWasteMgn.setId(LDXXUtils.getUUID12());
            WhWasteMgn.setWasteNo("FL"+ GetThisTimeUtils.getDateTime().replace(" ","").replace(":","").replace("-",""));
            WhWasteMgn.setPlanId(shengchanjihua.getPlanid());
            WhWasteMgn.setUnitPrice(shengchanjihua.getPrice());
            WhWasteMgn.setBatchId(siteIncomingMaterialTempWarningVo.getBatchId());
            WhWasteMgn.setReason(wm.getReason());
            WhWasteMgn.setPitchWeight(wm.getPitchWeight());
            WhWasteMgn.setPitchType(wm.getPitchType());
            WhWasteMgn.setWarningState(0);
            WhWasteMgn.setDealTime(GetThisTimeUtils.getDateTime());
            User user = (User) session.getAttribute("user");
            if(null!=user) {
                WhWasteMgn.setDealUserId(user.getUserId());
                WhWasteMgn.setUname(user.getuName());
            }
            i=wmdao.insertWhWasteMgn(WhWasteMgn);
        }
        return i;
    }

	@Override
	public SiteIncomingMaterialTempWarningVo getLaiLiaoWenDuByBatch(String batch) {
		return dao.getLaiLiaoWenDuByBatch(batch);
	}

    @Override
    public List<SiteIncomingMaterialTempWarningVo> getByLuDuanId(String roadId) {
        return dao.getByLuDuanId(roadId);
    }
}
