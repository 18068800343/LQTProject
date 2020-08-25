package com.ldxx.dao;

import com.ldxx.bean.Shoufeizhan;

import java.util.List;

public interface ShoufeizhanDao {

    List<Shoufeizhan> getAllshoufeizhan();
    int addShoufeizhan(Shoufeizhan shoufeizhan);
    int updShoufeizhan(Shoufeizhan shoufeizhan);
    int delShoufeizhan(String id);
    int getCountName(String name);
    int xggetCountName(Shoufeizhan shoufeizhan);
}
