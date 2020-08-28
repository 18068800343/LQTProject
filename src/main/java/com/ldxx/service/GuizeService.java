package com.ldxx.service;


import com.ldxx.vo.GuizeVo;

import java.util.List;

public interface GuizeService {

    List<GuizeVo> getAllGuizeVo();

    GuizeVo getGuizeVoById(String id);

    int updGuizeVo(GuizeVo t);

    int delGuizeVo(String id);

    int insertGuizeVo(GuizeVo t);

    int deleteGuizeAndCarsAndPoints(String id);

    int updateGuizeVo(GuizeVo t);

}
