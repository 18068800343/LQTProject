package com.ldxx.dao;

import com.ldxx.vo.SiteIncomingMaterialTempWarningVo;

import java.util.List;

public interface  LaiLiaoWenDuYuJingDao {


	List<SiteIncomingMaterialTempWarningVo> getAllLaiLiaoWenDu();


	int addLaiLiaoWenDu(SiteIncomingMaterialTempWarningVo siteIncomingMaterialTempWarningVo);

	int delLaiLiaoWenDu(String id);

	int updateLaiLiaoWenDu(SiteIncomingMaterialTempWarningVo siteIncomingMaterialTempWarningVo);

    int updWarningstate(String id,int warningstate);
}
