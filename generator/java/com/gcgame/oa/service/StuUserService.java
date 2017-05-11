package com.gcgame.oa.service;

import java.util.List;

import com.gcgame.oa.model.StuUser;
import com.gcgame.oa.service.base.BaseService;

public interface StuUserService extends BaseService<StuUser, Long>{

	List<StuUser> findStuUserByPage(int max, int min);

	List<StuUser> getStuUserByPage();

}
