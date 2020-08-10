package com.ldxx.controller;

import com.ldxx.bean.Guanlianbianhao;
import com.ldxx.dao.GuanlianbianhaoDao;
import com.ldxx.util.GetThisTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Guanlianbianhao")
public class GuanlianbianhaoController {

    @Autowired
    private GuanlianbianhaoDao dao;

    @RequestMapping("/getcountBysiteIdAndDate")
    public Guanlianbianhao getcountBysiteIdAndDate( String siteId){
        String datetime="%" + GetThisTimeUtils.getDate() + "%";
        Guanlianbianhao guanlianbianhao = dao.getcountBysiteIdAndDate(siteId, datetime);
        return guanlianbianhao;
    }

    @RequestMapping("/getBysiteIdAndDate")
    public Guanlianbianhao getcountBysiteIdAndDate( String siteId,String editDate){
        String datetime="%" +editDate.split(" ")[0] + "%";
        Guanlianbianhao guanlianbianhao = dao.getcountBysiteIdAndDate(siteId, datetime);
        return guanlianbianhao;
    }

}
