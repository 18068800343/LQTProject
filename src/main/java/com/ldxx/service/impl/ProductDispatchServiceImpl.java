package com.ldxx.service.impl;

import com.ldxx.bean.ProductDispatch;
import com.ldxx.dao.ProductDispatchDao;
import com.ldxx.dao.WhWasteMgnDao;
import com.ldxx.service.ProductDispatchService;
import com.ldxx.vo.ProductDispatchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductDispatchServiceImpl implements ProductDispatchService {

    @Autowired
    private ProductDispatchDao dao;

    //废料管理
    @Autowired
    private WhWasteMgnDao wwmdao;

    @Override
    public List<ProductDispatchVo> getAllProductDispatch() {
        return dao.getAllProductDispatch();
    }

    @Override
    public int delProductDispatch(String id) {
        return dao.delProductDispatch(id);
    }

    @Override
    public int insertProductDispatch(ProductDispatchVo productDispatchVo) {
        int i= dao.insertProductDispatch(productDispatchVo);
        if(i>0){
            //调度成功去修改废料管理的废料状态为已调度
            i=wwmdao.updwarningState(productDispatchVo.getFeiliaoId(),2);
        }
        return i;
    }
}
