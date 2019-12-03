package com.ldxx.dao;

import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.vo.SiteIncomingMaterialTempWarningVo;
import com.ldxx.vo.WhWasteMgnVo;

import java.util.List;

public interface  LaiLiaoWenDuYuJingDao {


	List<SiteIncomingMaterialTempWarningVo> getAllLaiLiaoWenDu(String luduanquanxian);


	int addLaiLiaoWenDu(SiteIncomingMaterialTempWarningVo siteIncomingMaterialTempWarningVo);

	int delLaiLiaoWenDu(String id);

	int updateLaiLiaoWenDu(SiteIncomingMaterialTempWarningVo siteIncomingMaterialTempWarningVo);

    int updWarningstate(String id,int warningstate);

	PlanProductionCollection getshengchanjihua(String id);

	SiteIncomingMaterialTempWarningVo getPiciId(String id);

	WhWasteMgnVo getWeightandType(String id);

	int updWarningstateBybatchId(String id,int warningState);
	
	SiteIncomingMaterialTempWarningVo getLaiLiaoWenDuByBatch(String batch);

    List<SiteIncomingMaterialTempWarningVo> getByLuDuanId(String roadId);
}
