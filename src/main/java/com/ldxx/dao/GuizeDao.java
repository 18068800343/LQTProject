package com.ldxx.dao;

import com.ldxx.bean.GuizeYujing;
import com.ldxx.bean.Point;
import com.ldxx.vo.GuizeCarVo;
import com.ldxx.vo.GuizeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuizeDao {

    List<GuizeVo> getAllGuizeVo();

    List<GuizeYujing> getAllGuizeYujingByCarId(String id, String startTime, String endTime);

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

    int insertGuizeYujing(GuizeYujing t);
}
