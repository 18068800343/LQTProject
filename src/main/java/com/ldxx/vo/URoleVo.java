package com.ldxx.vo;

import com.ldxx.bean.URole;

import java.util.List;

public class URoleVo extends URole {

    private String text;
    private String parentRoleCode;
    private List<URoleVo> nodes;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getParentRoleCode() {
        return parentRoleCode;
    }

    public void setParentRoleCode(String parentRoleCode) {
        this.parentRoleCode = parentRoleCode;
    }

    public List<URoleVo> getNodes() {
        return nodes;
    }

    public void setNodes(List<URoleVo> nodes) {
        this.nodes = nodes;
    }
}
