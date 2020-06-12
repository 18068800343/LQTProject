package com.ldxx.dao;

import com.ldxx.bean.DicDepartment;

import java.util.List;

public interface DicDepartmentDao {

    public List<DicDepartment> getAllDicDepartment();

    public int insertDicDepartment(DicDepartment dicDepartment);

    public int delDicDepartment(String id);

    public int updateDicDepartmentById(DicDepartment dicDepartment);

    public DicDepartment getDicDepartmentById(String id);

    public DicDepartment getDicDepartmentByName(String departmentName);
}
