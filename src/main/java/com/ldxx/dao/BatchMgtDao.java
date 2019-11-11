package com.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.BatchMgt;

public interface BatchMgtDao {
	
	List<BatchMgt> getAllBatchMgt();
	
	BatchMgt getBatchMgtById(@Param("id")String id);
	
	int updBatchMgt(@Param("bm")BatchMgt bm);
	
	int delBatchMgt(@Param("id")String id);

	int insertBatchMgt(@Param("bm")BatchMgt bm);
}
