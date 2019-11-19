package com.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.DicZhiwu;

public interface DicZhiwuDao {
	
	List<DicZhiwu> getAllDicZhiwu();
	
	int updDicZhiwu(@Param("zw")DicZhiwu zw);
	
	int delDicZhiwu(@Param("id")String id);
	
	int insertDicZhiwu(@Param("zw")DicZhiwu zw); 
	
	public DicZhiwu selectByName(String name);

}
