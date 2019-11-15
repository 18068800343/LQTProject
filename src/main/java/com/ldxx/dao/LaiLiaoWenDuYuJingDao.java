package com.ldxx.dao;

import com.ldxx.vo.SiteFieldMaterialMgtVo;
import com.ldxx.vo.SiteIncomingMaterialTempWarningVo;

import java.util.List;

public interface  LaiLiaoWenDuYuJingDao {
	
	
	List<SiteIncomingMaterialTempWarningVo> getAllLaiLiaoWenDuYu();
	
	int addShiGongLaiLiao(SiteFieldMaterialMgtVo siteFieldMaterialMgtVo);
	
	int delShiGongLaiLiao(String id);
	
	int updateShiGongLaiLiao(SiteFieldMaterialMgtVo siteFieldMaterialMgtVo);
	
}
