package com.ldxx.dao;

import java.util.List;

import com.ldxx.bean.USignin;

public interface USigninDao {
	public List<USignin> selectAllUSignin();

	public List<USignin> selectAllUSigninByState(String state);

}
