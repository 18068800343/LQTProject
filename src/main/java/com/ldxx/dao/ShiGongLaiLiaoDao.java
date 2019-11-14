package com.ldxx.dao;

import java.util.List;
import java.util.Map;

import com.ldxx.bean.SiteConstruction;
import com.ldxx.vo.SiteConstructionVo;
import com.ldxx.vo.SiteFieldMaterialMgtVo;

public interface  ShiGongLaiLiaoDao {
	
	
	List<SiteFieldMaterialMgtVo> getAllShiGongLaiLiao();
	
	int addShiGongLaiLiao(SiteFieldMaterialMgtVo siteFieldMaterialMgtVo);
	
	int delShiGongLaiLiao(String id);
	
	int updateShiGongLaiLiao(SiteFieldMaterialMgtVo siteFieldMaterialMgtVo);
	
}
