package com.ldxx.dao;

import com.ldxx.vo.GuizeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuizeDao {

	List<GuizeVo> getAllGuizeVo();

	GuizeVo getGuizeVoById(String id);

	int updGuizeVo(GuizeVo t);

	int delGuizeVo(String id);

	int insertGuize(GuizeVo t);

	int insertGuizeLnglat(GuizeVo t);

	int insertGuizeCar(GuizeVo t);
}
