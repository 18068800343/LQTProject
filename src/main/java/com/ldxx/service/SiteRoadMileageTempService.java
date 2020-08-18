package com.ldxx.service;

import com.ldxx.bean.SiteRoadMileageTemp;

import java.util.List;

public interface SiteRoadMileageTempService {

    List<SiteRoadMileageTemp> getAllSiteRoadMileageTemp(String luduanquanxian);

    List<SiteRoadMileageTemp> getAllSiteRoadMileageTempShiro(String luduanquanxian);
    
    int updSiteRoadMileageTemp(SiteRoadMileageTemp srm);

    int delSiteRoadMileageTemp(String id);

    int insertSiteRoadMileageTemp(SiteRoadMileageTemp srm);

    List<SiteRoadMileageTemp> getByLuDuanId(String roadId);
}
