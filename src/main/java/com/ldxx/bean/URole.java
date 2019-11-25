package com.ldxx.bean;

/**
 * 角色管理
 */
public class URole {

    public int id;

    //权限编码
    public String roleCode;

    //角色名称
    public String roleName;

    //排序
    public String roleSort;

    //权限编码
    private String uPersmissionCoding;

    public String getuPersmissionCoding() {
        return uPersmissionCoding;
    }

    public void setuPersmissionCoding(String uPersmissionCoding) {
        this.uPersmissionCoding = uPersmissionCoding;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(String roleSort) {
        this.roleSort = roleSort;
    }
}
