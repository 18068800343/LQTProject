package com.ldxx.service.impl;

import com.ldxx.Constant.DateConstant;
import com.ldxx.dao.GuizeDao;
import com.ldxx.service.GuizeService;
import com.ldxx.util.DateUtil;
import com.ldxx.vo.GuizeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class GuizeServiceImpl implements GuizeService {

	@Resource
	private GuizeDao dao;

	@Override
	public List<GuizeVo> getAllGuizeVo() {
		return dao.getAllGuizeVo();
	}

	@Override
	public GuizeVo getGuizeVoById(String id) {
		// TODO Auto-generated method stub
		return dao.getGuizeVoById(id);
	}

	@Override
	@Transactional
	public int updGuizeVo(GuizeVo t) {
		// TODO Auto-generated method stub
		return dao.updGuizeVo(t);
	}

	@Override
	@Transactional
	public int delGuizeVo(String id) {
		// TODO Auto-generated method stub
		return dao.delGuize(id);
	}

	@Override
	@Transactional
	public int insertGuizeVo(GuizeVo t) {
        // TODO Auto-generated method stub

        String time = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
        t.setTime(time);
        int i = dao.insertGuize(t);
        if (i > 0) {
            i = dao.insertGuizeLnglat(t);
            if (i > 0) {
                i = dao.insertGuizeCar(t);
            }
        }
        return i;
    }

	@Override
	@Transactional
	public int updateGuizeVo(GuizeVo t) {
        // TODO Auto-generated method stub
        String time = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
        t.setTime(time);
        int i = dao.delGuize(t.getId());
        if (i > 0) {
            i = dao.delGuizeCar(t.getId());
            i = dao.delGuizeLnglat(t.getId());
            i = dao.insertGuize(t);
            i = dao.insertGuizeLnglat(t);
            if (i > 0) {
                i = dao.insertGuizeCar(t);
            }
        }
		return i;
	}

}
