package com.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.WhIncomingMaterial;

public interface WhIncomingMaterialDao {

	List<WhIncomingMaterial> getAllWhIncomingMaterial(String beginTime, String endTime);

	WhIncomingMaterial getWhIncomingMaterialById(@Param("id") String id);

	int updWhIncomingMaterialById(@Param("wm") WhIncomingMaterial wm);

	int delWhIncomingMaterialById(@Param("id") String id);

	int insertWhIncomingMaterial(@Param("wm") WhIncomingMaterial wm);

}
