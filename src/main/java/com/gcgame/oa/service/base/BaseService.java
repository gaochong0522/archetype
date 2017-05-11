package com.gcgame.oa.service.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gcgame.oa.dao.base.BaseDAO;

public interface BaseService<T, PK extends Serializable> {
	/**
	 *  保存
	 * @param entity
	 * @return
	 */
	@Transactional(readOnly = false, rollbackFor = Exception.class)  
	public T save(T entity);

	/**
	 *  更新
	 * @param entity
	 * @return
	 */
	@Transactional(readOnly = false, rollbackFor = Exception.class)  
	public int update(T entity);

	/**
	 *  根据id删除某个对象
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = false, rollbackFor = Exception.class)  
	public int deleteById(PK id);

	/**
	 *  根据id批量删除对象
	 * @param ids
	 * @return
	 */
	@Transactional(readOnly = false, rollbackFor = Exception.class)  
	public int delete(List<PK> ids);

	/**
	 *  根据id加载某个对象
	 * @param id
	 * @return
	 */
	public T getById(PK id);

	/**
	 *  查找所有的对象
	 * @return
	 */
	public List<T> findAllByPage();
	
	public List<T> findAll();

	public BaseDAO<T, PK> getBaseDAO();

}
