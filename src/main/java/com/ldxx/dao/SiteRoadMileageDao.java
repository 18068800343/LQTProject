package com.ldxx.dao;

import com.ldxx.bean.SiteRoadMileage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SiteRoadMileageDao {
	
	List<SiteRoadMileage> selectAllSiteRoadMileage(String luduanquanxian);
	
	int updSiteRoadMileage(@Param("srm")SiteRoadMileage srm);
	
	int delSiteRoadMileage(@Param("id")String id);
	
	int insertSiteRoadMileage(@Param("srm")SiteRoadMileage srm);

	List<SiteRoadMileage>  getByLuDuanId(String roadId);

	List<SiteRoadMileage> getTanPuLiChengVoListByTime(String beginTime, String endTime,String roadId);

}
