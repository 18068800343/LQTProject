package com.ldxx.service;

import com.ldxx.bean.DicDepartment;

import java.util.List;

public interface DicDepartmentService {

    public List<DicDepartment> getAllDicDepartment();

    public int insertDicDepartment(DicDepartment dicDepartment);

    public int delDicDepartment(String id);

    public int updateDicDepartmentById(DicDepartment dicDepartment);

    public DicDepartment getDicDepartmentById(String id);

    public DicDepartment getDicDepartmentByName(String departmentName);

}
