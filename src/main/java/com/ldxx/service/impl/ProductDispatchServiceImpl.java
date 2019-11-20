package com.ldxx.service.impl;

import com.ldxx.bean.ProductDispatch;
import com.ldxx.dao.ProductDispatchDao;
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
        return dao.insertProductDispatch(productDispatchVo);
    }
}
