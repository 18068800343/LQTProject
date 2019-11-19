package com.ldxx.service;

import com.ldxx.bean.WhWasteMgn;
import com.ldxx.vo.WhWasteMgnVo;

import java.util.List;

public interface WhWasteMgnService {

    List<WhWasteMgnVo> getAllWhWasteMgn();

    int updwarningState(String id,int warningState,String batchId);

    int insertWhWasteMgn(WhWasteMgn WhWasteMgn);
}
