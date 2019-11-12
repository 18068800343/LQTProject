package com.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.DicDanwei;

public interface DicDanweiDao {
	
	List<DicDanwei> getAllDicDanwei();
	
	int updDicDanwei(@Param("dw")DicDanwei dw);
	
	int delDicDanwei(@Param("id")String id);
	
	int insertDicDanwei(@Param("dw")DicDanwei dw);

}
