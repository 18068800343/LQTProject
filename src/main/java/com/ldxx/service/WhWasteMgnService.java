package com.ldxx.service;

import com.ldxx.bean.WhWasteMgn;
import com.ldxx.vo.WhWasteMgnVo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface WhWasteMgnService {

    List<WhWasteMgnVo> getAllWhWasteMgn();

    int updwarningState(String id,int warningState,HttpSession session);

    int insertWhWasteMgn(WhWasteMgn WhWasteMgn);
}
