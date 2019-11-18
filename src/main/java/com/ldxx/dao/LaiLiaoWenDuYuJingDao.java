package com.ldxx.dao;

import com.ldxx.vo.SiteFieldMaterialMgtVo;
import com.ldxx.vo.SiteIncomingMaterialTempWarningVo;

import java.util.List;

public interface  LaiLiaoWenDuYuJingDao {
	
	
	List<SiteIncomingMaterialTempWarningVo> getAllLaiLiaoWenDuYu();

	
	int addLaiLiaoWenDuYu(SiteFieldMaterialMgtVo siteFieldMaterialMgtVo);

	int delLaiLiaoWenDuYu(String id);
	
	int updateLaiLiaoWenDuYu(SiteFieldMaterialMgtVo siteFieldMaterialMgtVo);
	
}
