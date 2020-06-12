package com.ldxx.bean;

/**
 * 部门
 */
public class DicDepartment {
    private String id;
    private String departmentName;
    private int deleteState ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(int deleteState) {
        this.deleteState = deleteState;
    }
}
