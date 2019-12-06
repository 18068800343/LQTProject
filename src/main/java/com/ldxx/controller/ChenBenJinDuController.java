package com.ldxx.controller;

import com.ldxx.dao.ChenBenJinDuDao;
import com.ldxx.vo.ChenBenJinDuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 成本进度管理
 */
@RestController
@RequestMapping("ChenBenJinDu")
public class ChenBenJinDuController {

    @Autowired
    private ChenBenJinDuDao dao;

    @RequestMapping("/getAllChenBenJinDu")
    public List<ChenBenJinDuVo> getAllChenBenJinDu() {
        List<ChenBenJinDuVo> chenBenJinDuVoList = new ArrayList<>();
        //查询去重后的时间（年月日）
        List<ChenBenJinDuVo> list = dao.getDistinctDatetime();
        for (int i = 0; i < list.size(); i++) {
            ChenBenJinDuVo cbvo = new ChenBenJinDuVo();
            String datetime = list.get(i).getDatetime();
            cbvo.setDatetime(datetime);

            //查询每天的总成品需要量（日供料计划）
            ChenBenJinDuVo chengpinliang = dao.getAllpdNeed(datetime);
            if (chengpinliang != null && !"".equals(chengpinliang)) {
                cbvo.setPdNeed(chengpinliang.getPdNeed());
            }
            //查询每天产能
            BigDecimal cn = new BigDecimal(0);
            ChenBenJinDuVo channeng = dao.getAllchenneng(datetime);
            if (channeng != null && !"".equals(channeng)) {
                cbvo.setChenneng(channeng.getChenneng());
                cn = channeng.getChenneng();
            }

            //查询废料
            BigDecimal fl = new BigDecimal(0);
            ChenBenJinDuVo feiliao = dao.getAllfeiliao(datetime);
            if (feiliao != null && !"".equals(feiliao)) {
                cbvo.setFeiliao(feiliao.getFeiliao());
                fl = feiliao.getFeiliao();
            }
            //废料比=每日废料/每日实际产能
            if (fl.compareTo(BigDecimal.ZERO)!=0 && cn.compareTo(BigDecimal.ZERO)!=0) {
                cbvo.setFeiliaobi(fl.divide(cn,2, BigDecimal.ROUND_HALF_UP));
            }

            chenBenJinDuVoList.add(cbvo);
        }

        return chenBenJinDuVoList;
    }

}
