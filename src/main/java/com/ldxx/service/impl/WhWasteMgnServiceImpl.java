package com.ldxx.service.impl;

import com.ldxx.bean.WhWasteMgn;
import com.ldxx.dao.WhWasteMgnDao;
import com.ldxx.service.WhWasteMgnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WhWasteMgnServiceImpl implements WhWasteMgnService {

    @Autowired
    private WhWasteMgnDao dao;

    @Override
    public List<WhWasteMgn> getAllWhWasteMgn() {
        return dao.getAllWhWasteMgn();
    }

    @Override
    public int updwarningState(String id, int warningState) {
        return dao.updwarningState(id,warningState);
    }

    @Override
    public int insertWhWasteMgn(WhWasteMgn WhWasteMgn) {
        return dao.insertWhWasteMgn(WhWasteMgn);
    }
}
