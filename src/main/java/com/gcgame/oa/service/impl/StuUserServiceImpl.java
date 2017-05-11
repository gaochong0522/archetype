package com.gcgame.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gcgame.oa.dao.StuUserDAO;
import com.gcgame.oa.dao.base.BaseDAO;
import com.gcgame.oa.model.StuUser;
import com.gcgame.oa.service.StuUserService;
import com.gcgame.oa.service.base.impl.BaseServiceImpl;

@Service
public class StuUserServiceImpl extends BaseServiceImpl<StuUser,Long>  implements StuUserService{
	@Resource
	private StuUserDAO stuUserDAO;
	
	@Override
	public BaseDAO<StuUser, Long> getBaseDAO() {
		return stuUserDAO;
	}
	
	@Override
	public List<StuUser> findStuUserByPage(int max, int min) {
		return stuUserDAO.findStuUserByPage(max, min);
	}

	@Override
	public List<StuUser> getStuUserByPage() {
		return stuUserDAO.getStuUserByPage();
	}

}