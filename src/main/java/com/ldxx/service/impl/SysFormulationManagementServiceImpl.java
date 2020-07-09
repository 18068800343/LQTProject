package com.ldxx.service.impl;

import com.ldxx.bean.SysFormulationManagement;
import com.ldxx.bean.SysMaterialAttached;
import com.ldxx.dao.SysFormulationManagementDao;
import com.ldxx.service.SysFormulationManagementService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SysFormulationManagementServiceImpl implements SysFormulationManagementService{

	@Autowired
	private SysFormulationManagementDao sdao;
	@Override
	public int addSysFormulationManagement(SysFormulationManagement sysFormulationManagement) {
		String str ="PF"+GetThisTimeUtils.getDateTimeNumber();
		sysFormulationManagement.setFlNo(str);
		sysFormulationManagement.setFlId(LDXXUtils.getUUID12());
		int num = sdao.addSysFormulationManagement(sysFormulationManagement);
		List<SysMaterialAttached> fslist = sysFormulationManagement.getFsclList();
		for(SysMaterialAttached sma : fslist)
		{
			sma.setFlId(sysFormulationManagement.getFlId());
		}
		List<SysMaterialAttached> fsclList = sysFormulationManagement.getFsclList();
		if(fsclList!=null&&fsclList.size()!=0){
			sdao.addFuShuCaiLiao(fsclList);
		}
		return num;
	}

	@Override
	public int updateSysFormulationManagement(SysFormulationManagement sysFormulationManagement) {
		int num = sdao.updateSysFormulationManagement(sysFormulationManagement);
		sdao.deleteByIdFuShuCaiLiao(sysFormulationManagement.getFlId());
		sdao.addFuShuCaiLiao(sysFormulationManagement.getFsclList());
		return num;
	}

	@Override
	public int deleteSysFormulationManagement(String id) {
		int num = sdao.deleteSysFormulationManagement(id);
		return num;
	}

	@Override
	public List<SysFormulationManagement> selectAllSysFormulationManagement() {
		List<SysFormulationManagement> slist = sdao.selectAllSysFormulationManagement();
		List<SysMaterialAttached> fscl= sdao.selectAllFuShuCaiLiao();
		for(SysFormulationManagement s : slist)
		{
			for(SysMaterialAttached sf :fscl)
			{
				if(s.getFlId().equals(sf.getFlId()))
				{
					if(null==s.getFsclList())
					{
						List<SysMaterialAttached> list = new ArrayList<SysMaterialAttached>();
						s.setFsclList(list);
					}
					s.getFsclList().add(sf);
				}
			}
		}
		return slist;
	}

	@Override
	public SysFormulationManagement selectByIdSysFormulationManagement(String id) {
		SysFormulationManagement s =sdao.selectByIdSysFormulationManagement(id);
		s.setFsclList(sdao.selectByIdFuShuCaiLiao(s.getFlId()));
		return s;
	}

	@Override
	public List<SysFormulationManagement> getFlName() {
		return sdao.getFlName();
	}

}
