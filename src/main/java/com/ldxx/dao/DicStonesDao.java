package com.ldxx.dao;

import com.ldxx.bean.DicStones;

import java.util.List;

public interface DicStonesDao {

	public List<DicStones> selectAllDicStones();

	public int addDicStones(DicStones dicStones);

	public int deleteDicStones(String id);

	public int updateDicStones(DicStones dicStones);
	
	public DicStones selectByName(String name);

	DicStones selectByName2(String stonesName, String id);
}
