package com.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.SiteRoadMileage;

public interface SiteRoadMileageDao {
	
	List<SiteRoadMileage> selectAllSiteRoadMileage();
	
	int updSiteRoadMileage(@Param("srm")SiteRoadMileage srm);
	
	int delSiteRoadMileage(@Param("id")String id);
	
	int insertSiteRoadMileage(@Param("srm")SiteRoadMileage srm);

}
