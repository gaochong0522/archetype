package com.gcgame.oa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.gcgame.oa.mapper.base.BaseMapper;
import com.gcgame.oa.model.StuUser;

public interface StuUserMapper extends BaseMapper<StuUser, Long> {

	public List<StuUser> findStuUser(@Param("dataType") int dataType,@Param("max") int max, @Param("min") int min, @Param("pageSize") int pageSize);

	public List<StuUser> getStuUserByPage();

}