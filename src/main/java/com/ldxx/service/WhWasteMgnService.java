package com.ldxx.service;

import com.ldxx.bean.WhWasteMgn;

import java.util.List;

public interface WhWasteMgnService {

    List<WhWasteMgn> getAllWhWasteMgn();

    int updwarningState(String id,int warningState);

    int insertWhWasteMgn(WhWasteMgn WhWasteMgn);
}
