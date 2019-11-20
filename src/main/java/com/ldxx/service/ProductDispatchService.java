package com.ldxx.service;

import com.ldxx.bean.ProductDispatch;
import com.ldxx.vo.ProductDispatchVo;

import java.util.List;

public interface ProductDispatchService {

    List<ProductDispatchVo> getAllProductDispatch();

    int delProductDispatch(String id);

    int insertProductDispatch(ProductDispatchVo productDispatchVo);
}
