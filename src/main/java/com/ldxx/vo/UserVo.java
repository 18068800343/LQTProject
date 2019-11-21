package com.ldxx.vo;

import com.ldxx.bean.User;

public class UserVo extends User {

    private String uPermissions;//权限编码

    private String userRoleNames;

    public String getuPermissions() {
        return uPermissions;
    }

    public void setuPermissions(String uPermissions) {
        this.uPermissions = uPermissions;
    }

    public String getUserRoleNames() {
        return userRoleNames;
    }

    public void setUserRoleNames(String userRoleNames) {
        this.userRoleNames = userRoleNames;
    }
}
