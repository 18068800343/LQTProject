package com.ldxx.dao;

import com.ldxx.vo.SiteCompactionSpeedVo;

import java.util.List;

public interface NianYaSuDuDao {


	List<SiteCompactionSpeedVo> getAllNianYaSuDu();


	int addNianYaSuDu(SiteCompactionSpeedVo siteCompactionSpeedVo);

	int delNianYaSuDu(String id);

	int updateNianYaSuDu(SiteCompactionSpeedVo siteCompactionSpeedVo);

}