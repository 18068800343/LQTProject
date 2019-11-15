package com.ldxx.dao;

import com.ldxx.bean.SiteRoadSpend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SiteRoadSpendDao {

    List<SiteRoadSpend> selectAllSiteRoadSpend();

    int updSiteRoadSpend(@Param("srs") SiteRoadSpend srs);

    int delSiteRoadSpend(@Param("id")String id);

    int insertSiteRoadSpend(@Param("srs")SiteRoadSpend srs);
}
