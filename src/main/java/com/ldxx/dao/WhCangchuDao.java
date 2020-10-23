package com.ldxx.dao;

import com.ldxx.bean.WhCangchu;

import java.util.List;

public interface WhCangchuDao {

    List<WhCangchu> getAllWhCangchu();

    List<WhCangchu> getWhCangchuListByCaiLiao(String cailiao);

    int addWhCangchu(WhCangchu whCangchu);

    int updWhCangchu(WhCangchu whCangchu);

    int delWhCangchu(String id);

    WhCangchu getWhCangchuById(String id);

    int countbianhao(String bianhao);

    int xgcountbianhao(String bianhao, String id);
}
