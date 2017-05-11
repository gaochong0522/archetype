package com.gcgame.oa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.gcgame.oa.dao.StuUserDAO;
import com.gcgame.oa.dao.base.impl.BaseDAOImpl;
import com.gcgame.oa.mapper.base.BaseMapper;
import com.gcgame.oa.mapper.StuUserMapper;
import com.gcgame.oa.model.StuUser;
import com.zmtech.common.page.imp.Page;

@Repository
public class StuUserDAOImpl extends BaseDAOImpl<StuUser,Long> implements StuUserDAO {

	@Resource
	private StuUserMapper stuUserMapper;

	@Override
	public BaseMapper<StuUser, Long> getMapper() {
		return stuUserMapper;
	}

	@Override
	public List<StuUser> findStuUserByPage(int max, int min) {
		 int pageSize = Page.threadLocal.get().getPageSize();
		 int dataType = this.getDataType();
		return stuUserMapper.findStuUser(dataType,max, min,pageSize);
	}

	@Override
	public List<StuUser> getStuUserByPage() {
		return stuUserMapper.getStuUserByPage();
	}
	
}
