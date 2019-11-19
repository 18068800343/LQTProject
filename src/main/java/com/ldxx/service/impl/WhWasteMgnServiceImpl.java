package com.ldxx.service.impl;

import com.ldxx.bean.WhWasteMgn;
import com.ldxx.dao.LaiLiaoWenDuYuJingDao;
import com.ldxx.dao.WhWasteMgnDao;
import com.ldxx.service.WhWasteMgnService;
import com.ldxx.vo.WhWasteMgnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WhWasteMgnServiceImpl implements WhWasteMgnService {

    @Autowired
    private WhWasteMgnDao dao;
    @Autowired
    private LaiLiaoWenDuYuJingDao laidao;

    @Override
    public List<WhWasteMgnVo> getAllWhWasteMgn() {
        return dao.getAllWhWasteMgn();
    }

    @Override
    public int updwarningState(String id, int warningState,String batchId) {
        int i = dao.updwarningState(id,warningState);
        if(warningState==1 && i>0){
            //完全废弃
        }else if(warningState==2 && i>0){
            //调度
        }else if(warningState==3 && i>0){
            //取消，修改来料温度预警状态为取消(0:未操作；1:已取消;2:以废料
            i=laidao.updWarningstateBybatchId(batchId,1);
        }

        return i;
    }

    @Override
    public int insertWhWasteMgn(WhWasteMgn WhWasteMgn) {
        return dao.insertWhWasteMgn(WhWasteMgn);
    }
}
