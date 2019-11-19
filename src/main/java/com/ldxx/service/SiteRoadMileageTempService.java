package com.ldxx.service;

import com.ldxx.bean.SiteRoadMileageTemp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SiteRoadMileageTempService {

    List<SiteRoadMileageTemp> getAllSiteRoadMileageTemp();

    int updSiteRoadMileageTemp(SiteRoadMileageTemp srm);

    int delSiteRoadMileageTemp(String id);

    int insertSiteRoadMileageTemp(SiteRoadMileageTemp srm);
}
