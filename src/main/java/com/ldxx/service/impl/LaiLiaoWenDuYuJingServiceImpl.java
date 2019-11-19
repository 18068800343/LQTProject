package com.ldxx.service.impl;

import com.ldxx.bean.WhWasteMgn;
import com.ldxx.dao.LaiLiaoWenDuYuJingDao;
import com.ldxx.dao.WhWasteMgnDao;
import com.ldxx.service.LaiLiaoWenDuYuJingService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;
import com.ldxx.vo.SiteIncomingMaterialTempWarningVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class LaiLiaoWenDuYuJingServiceImpl implements LaiLiaoWenDuYuJingService {

    @Autowired
    private LaiLiaoWenDuYuJingDao dao;
    @Autowired
    private WhWasteMgnDao whWasteMgnDao;

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
    public int updWarningstate(String id, int warningstate) {
        int i = dao.updWarningstate(id,warningstate);
        if(warningstate==2){
            //做废料时要新增一条废料管理
            WhWasteMgn WhWasteMgn=new WhWasteMgn();
            WhWasteMgn.setId(LDXXUtils.getUUID12());
            WhWasteMgn.setWasteNo("FK"+ GetThisTimeUtils.getDateTime().replace(" ","").replace(":","").replace("-",""));

        }
        return i;
    }
}
