package com.ldxx.dao;

import java.util.List;

public interface StateRoleLinkDao {


	List<Integer> getStateRoleByUserId(String userId);
}
