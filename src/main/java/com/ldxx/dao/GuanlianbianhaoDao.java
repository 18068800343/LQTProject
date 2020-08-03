package com.ldxx.dao;

import com.ldxx.bean.Guanlianbianhao;

public interface GuanlianbianhaoDao {

    int insertGuanlianbianhao(Guanlianbianhao guanlianbianhao);
    int updGuanlianbianhao(Guanlianbianhao guanlianbianhao);
    Guanlianbianhao getcountBysiteIdAndDate(String siteId,String datetime);
}
