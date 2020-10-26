package com.ldxx.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.ldxx.bean.WhCangchu;
import com.ldxx.vo.WhCangChuVo;
import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.WhWarehouseCount;

public interface WhWarehouseCountDao {

	List<WhWarehouseCount> getAllWhWarehouseCount();

	List<WhCangChuVo> initCangChuGuanLi();

	WhWarehouseCount getWhWarehouseCountById(@Param("id") String id);

	int updWhWarehouseCountById(@Param("wwc") WhWarehouseCount wwc);

	int delWhWarehouseCountById(@Param("id") String id);

	int insertWhWarehouseCount(@Param("wwc") WhWarehouseCount wwc);

	WhWarehouseCount getWhWarehouseCountByStorNo(@Param("storNo") String storNo);

	WhCangchu getWhCangChuByStorNo(String storNo);

	List<Map> getLiaoCangPanDian();

	Double getLaiLiaoWeightByTime(String startTime, String endTime);

	Double getYongLiaoWeightByTime(String startTime, String endTime);

	Double getNearPanDianAllWeight();

	Double getAllCangKuWeight();

	String getProductEndTime(String time);

	String getLaiLiaoTime();

}
