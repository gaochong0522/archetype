package com.gcgame.oa.service.base.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcgame.oa.service.base.BaseService;

public abstract class BaseServiceImpl<T, PK> implements BaseService<T, Long> {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 保存对象
	 */
	public T save(T entity) {
		return this.getBaseDAO().save(entity);
	}

	/**
	 * 更新对象
	 */
	@Override
	public int update(T entity) {
		return this.getBaseDAO().update(entity);

	}

	/**
	 * 根据ID删除对象
	 */
	@Override
	public int deleteById(Long id) {
		return this.getBaseDAO().deleteById(id);

	}

	/**
	 * 根据ID批量删除对象
	 */
	@Override
	public int delete(List<Long> ids) {
		return this.getBaseDAO().delete(ids);

	}

	/**
	 *根据ID查找对象
	 */
	@Override
	public T getById(Long id) {
		return this.getBaseDAO().getById(id);
	}

	/**
	 * 查找所有对象
	 */
	public List<T> findAllByPage() {
		return this.getBaseDAO().findAllByPage();
	}
	/**
	 * 查找所有对象
	 */
	public List<T> findAll() {
		return this.getBaseDAO().findAll();
	}

}
