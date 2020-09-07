package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.bean.DicPeifangjipei;
import com.ldxx.bean.DicPeifangshaikong;
import com.ldxx.bean.QualityJiPei;
import com.ldxx.dao.DicPeifangjipeiDao;
import com.ldxx.dao.QualityJiPeiDao;
import com.ldxx.util.ExcelUtils;
import com.ldxx.util.MsgFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("QualityJiPei")
@RestController
public class QualityJiPeiController {

    @Autowired
    private QualityJiPeiDao dao;
    @Autowired
    private DicPeifangjipeiDao pfjipeiDao;

    @RequestMapping("/importExcel")
    public String importExcel(String pfId,String pfName,@RequestParam("file") MultipartFile file) throws Exception{
        JSONObject jsonObject=new JSONObject();
        String name=file.getOriginalFilename();
        if(name.length()<6|| !name.substring(name.length()-5).equals(".xlsx")){
            jsonObject.put("msg","文件格式错误");
        }
        List<DicPeifangjipei> list = ExcelUtils.excelToShopIdList(file.getInputStream(),pfId,pfName);
        int i=0;
        if (list!=null&&list.size()!=0){
            i=pfjipeiDao.insertDicPeifangjipeiList(list);
        }else {
            i=-1;
        }
        String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
        jsonObject.put("resultMsg",daoMsg);
        jsonObject.put("flag",i);
        return jsonObject.toJSONString();
    }

    @RequestMapping("/getAllQualityJiPeiByPeiFang")
    public String getAllQualityJiPeiByPeiFang(String peifangName,String datetime){
        JSONObject jsonObject=new JSONObject();
        QualityJiPei list = dao.getAllQualityJiPeiByPeiFang(peifangName,datetime);
        List<DicPeifangshaikong> list2 = dao.getDicPeifangshaikongByName(peifangName);
        jsonObject.put("QualityJiPei",list);
        jsonObject.put("DicPeifangshaikong",list2);
        return jsonObject.toJSONString();
    }

    @RequestMapping("/getAllQualityJiPeiByTime")
    public List<QualityJiPei> getAllQualityJiPeiByTime(String beginTime,String endTime){
        List<QualityJiPei> list = dao.getAllQualityJiPeiByTime(beginTime,endTime);
        return list;
    }
}
