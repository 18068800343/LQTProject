package com.ldxx.dao;

import com.ldxx.bean.SiteRoadMileageTemp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SiteRoadMileageTempDao {

    List<SiteRoadMileageTemp> getAllSiteRoadMileageTemp();

    int updSiteRoadMileageTemp(@Param("srm") SiteRoadMileageTemp srm);

    int delSiteRoadMileageTemp(@Param("id") String id);

    int insertSiteRoadMileageTemp(@Param("srm") SiteRoadMileageTemp srm);
}