package com.ldxx.dao;

import com.ldxx.vo.ChenBenJinDuVo;

import java.util.List;
import java.util.Map;

public interface ChenBenJinDuDao {

    public List<ChenBenJinDuVo> getDistinctDatetime();

    public ChenBenJinDuVo getAllpdNeed(String datetime);

    public ChenBenJinDuVo getAllchenneng(String datetime);

    public ChenBenJinDuVo getAllfeiliao(String datetime);

    public List<ChenBenJinDuVo> getAllMonth();

    public ChenBenJinDuVo getchannengBymonth(String datetime);

    public List<ChenBenJinDuVo> getchannengWeek(String datetime);

    public List<Map> getDayCount(String datetime);
}
