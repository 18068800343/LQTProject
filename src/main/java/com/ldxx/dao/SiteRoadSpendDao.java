package com.ldxx.dao;

import com.ldxx.bean.SiteRoadSpend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SiteRoadSpendDao {

    List<SiteRoadSpend> selectAllSiteRoadSpend(String luduanquanxian);

    int updSiteRoadSpend(@Param("srs") SiteRoadSpend srs);

    int delSiteRoadSpend(@Param("id")String id);

    int insertSiteRoadSpend(@Param("srs")SiteRoadSpend srs);

    List<SiteRoadSpend> getByLuDuanId(String roadId);

    List<SiteRoadSpend> getTanPuSuDuVoListByTime(String beginTime, String endTime, String roadId);
}
