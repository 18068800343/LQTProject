package com.ldxx.dao;

import com.ldxx.bean.WhWasteMgn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WhWasteMgnDao {

    List<WhWasteMgn> getAllWhWasteMgn();

    int updwarningState(@Param("id") String id,@Param("warningState") int warningState);

    int insertWhWasteMgn(@Param("WhWasteMgn") WhWasteMgn WhWasteMgn);
}
