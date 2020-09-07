package com.ldxx.dao;

import com.ldxx.bean.DicPeifangjipei;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DicPeifangjipeiDao {

    List<DicPeifangjipei> getAllDicPeifangjipei();

    int insertDicPeifangjipei(DicPeifangjipei DicPeifangjipei);

    int updDicPeifangjipei(DicPeifangjipei DicPeifangjipei);

    int delDicPeifangjipei(String id);

    int getCountName(@Param("name") String name, @Param("peifangId")String peifangId);

    int xg_getCountName(String name,String peifangId,String id);

    int insertDicPeifangjipeiList(@Param("DicPeifangjipei")List<DicPeifangjipei> DicPeifangjipei);
}
