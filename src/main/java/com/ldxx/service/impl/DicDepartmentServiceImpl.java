package com.ldxx.service.impl;

import com.ldxx.bean.DicDepartment;
import com.ldxx.dao.DicDepartmentDao;
import com.ldxx.service.DicDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DicDepartmentServiceImpl implements DicDepartmentService {

    @Autowired
    private DicDepartmentDao dao;


    @Override
    public List<DicDepartment> getAllDicDepartment() {
        return dao.getAllDicDepartment();
    }

    @Override
    public int insertDicDepartment(DicDepartment dicDepartment) {
        return dao.insertDicDepartment(dicDepartment);
    }

    @Override
    public int delDicDepartment(String id) {
        return dao.delDicDepartment(id);
    }

    @Override
    public int updateDicDepartmentById(DicDepartment dicDepartment) {
        return dao.updateDicDepartmentById(dicDepartment);
    }

    @Override
    public DicDepartment getDicDepartmentById(String id) {
        return dao.getDicDepartmentById(id);
    }

    @Override
    public DicDepartment getDicDepartmentByName(String departmentName) {
        return dao.getDicDepartmentByName(departmentName);
    }
}
