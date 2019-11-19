package com.ldxx.service;

import com.ldxx.vo.SiteIncomingMaterialTempWarningVo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface LaiLiaoWenDuYuJingService {

    List<SiteIncomingMaterialTempWarningVo> getAllLaiLiaoWenDu();

    int addLaiLiaoWenDu(SiteIncomingMaterialTempWarningVo siteIncomingMaterialTempWarningVo);

    int delLaiLiaoWenDu(String id);

    int updateLaiLiaoWenDu(SiteIncomingMaterialTempWarningVo siteIncomingMaterialTempWarningVo);

    int updWarningstate(String id,int warningstate,HttpSession session);
}
