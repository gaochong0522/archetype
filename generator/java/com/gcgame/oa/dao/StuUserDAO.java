package com.gcgame.oa.dao;

import java.util.List;

import com.gcgame.oa.dao.base.BaseDAO;
import com.gcgame.oa.model.StuUser;

public interface StuUserDAO extends BaseDAO<StuUser, Long> {
	
	List<StuUser> findStuUserByPage(int max, int min);

	List<StuUser> getStuUserByPage();

}
