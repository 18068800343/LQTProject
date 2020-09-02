package com.ldxx.dao;

import com.ldxx.bean.DicPeifangshaikong;
import com.ldxx.bean.QualityJiPei;

import java.util.List;

public interface QualityJiPeiDao {

     List<QualityJiPei> getAllQualityJiPeiByTime(String beginTime,String endTime);

     QualityJiPei getAllQualityJiPeiByPeiFang(String peifangName,String datetime);

     List<DicPeifangshaikong> getDicPeifangshaikongByName(String peifangName);
}
