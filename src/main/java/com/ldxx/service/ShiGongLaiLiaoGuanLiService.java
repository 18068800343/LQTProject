package com.ldxx.service;

import com.ldxx.vo.SiteFieldMaterialMgtVo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ShiGongLaiLiaoGuanLiService {

    public List<SiteFieldMaterialMgtVo> getAllShiGongLaiLiao();

    public int delShiGongLaiLiao(String id);

    public int addShiGongLaiLiao(SiteFieldMaterialMgtVo siteFieldMaterialMgtVo,HttpSession session);

    public int updateShiGongLaiLiao(SiteFieldMaterialMgtVo siteFieldMaterialMgtVo);

    List<SiteFieldMaterialMgtVo> getByLuDuanId(String roadId);
}
