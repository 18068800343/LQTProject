package com.ldxx.service.impl;

import com.ldxx.bean.SysRoadMgn;
import com.ldxx.bean.User;
import com.ldxx.dao.SysRoadMgnDao;
import com.ldxx.dao.TanPuDiDianGuanLiDao;
import com.ldxx.dao.UserDao;
import com.ldxx.service.SysRoadMgnService;
import com.ldxx.service.UserService;
import com.ldxx.util.LDXXUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SysRoadMgnServiceImpl implements SysRoadMgnService{

	@Autowired
	SysRoadMgnDao srmDao;

	@Autowired
	TanPuDiDianGuanLiDao tpddDao;
	@Autowired
	UserService userService;
	@Autowired
	UserDao userDao;

	@Override
	public List<SysRoadMgn> getAllSysRoadMgn(String luduanquanxian) {
		List<SysRoadMgn> list = srmDao.getAllSysRoadMgn(luduanquanxian);
		return list;
	}

	@Override
	public int addSysRoadMgn(SysRoadMgn sysRoadMgn) {
		int status=0;
		sysRoadMgn.setRoadId(LDXXUtils.getUUID12());
		status = srmDao.addSysRoadMgn(sysRoadMgn);
		return status;
	}

	@Override
	public int updateSysRoadMgnById(SysRoadMgn sysRoadMgn) {
		int status=0;
		status =srmDao.updateSysRoadMgnById(sysRoadMgn);
		return status;
	}

	@Override
	public int delSysRoadMgn(String id) {
		int status=0;
		status=srmDao.delSysRoadMgn(id);
		return status;
	}

	@Override
	public SysRoadMgn getByIdSysRoadMgn(String id) {
		SysRoadMgn s=srmDao.getByIdSysRoadMgn(id);
		return s;
	}

	@Override
	@Transactional
	public int finishRoad(String roadId) {
		int state1=0;
		int state2=0;
		int state3=0;
		int state4=0;
		Map<String, List> map = userService.selectUserByRoadId(roadId);
		state1=tpddDao.finishSiteConstructionByRoadId(roadId);
		state2=srmDao.finishRoad(roadId);
		List<User> uList1 = map.get("uList1");
		List<User> uList2 = map.get("uList2");
		for(User u: uList1)
		{
			u.setLuduanquanxian(u.getLuduanquanxian().replace(" ","").replace(","+roadId,"").replace(roadId,""));
			state3 = userDao.finishUserRoadIdIsOne(u);
		}
		for(User u: uList2)
		{
			u.setLuduanquanxian(u.getLuduanquanxian().replace(" ","").replace(","+roadId,"").replace(roadId,""));
			state4 = userDao.finishUserRoadIdIsMany(u);
		}

		return (state1!=0)&&(state2!=0)&&(state3!=0)&&(state4!=0)?1:0;
	}

}
