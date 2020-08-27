package com.ldxx.dao;

import com.ldxx.bean.Point;
import com.ldxx.vo.GuizeCarVo;
import com.ldxx.vo.GuizeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuizeDao {

    List<GuizeVo> getAllGuizeVo();

    String getDistinctAllCar();

    List<Point> getPointsByCarId(String id);

    GuizeVo getGuizeVoById(String id);

    int updGuizeVo(GuizeVo t);

    int delGuize(String id);

    int delGuizeCar(String id);

    int delGuizeLnglat(String id);

    int insertGuize(GuizeVo t);

    int insertGuizeLnglat(GuizeVo t);

    int insertGuizeCar(GuizeVo t);
}
