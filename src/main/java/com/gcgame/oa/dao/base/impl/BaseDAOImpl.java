package com.gcgame.oa.dao.base.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcgame.oa.common.util.web.MyThreadLocalUtils;
import com.gcgame.oa.dao.base.BaseDAO;
import com.gcgame.oa.model.BaseBean;

public abstract class BaseDAOImpl<T extends BaseBean, PK> implements BaseDAO<T, Long> {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	protected Class<?> entityClass;

	public BaseDAOImpl() {
		super();
		//this.entityClass = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];    
	}

	public boolean beforeSave(T entity){
		
		return true;
	}
	/**
	 * 保存对象
	 */
	public T save(T entity) {
		beforeSave(entity);
		this.getMapper().insert(entity);
		afterSave(entity);
		return entity;
	}

	public boolean afterSave(T entity) {
		return true;
	}

	/**
	 * 更新对象
	 */
	@Override
	public int update(T entity) {
		return this.getMapper().update(entity);
	}

	/**
	 * 通过id修改属性值
	 */
	@Override
	public int updatePropertyById(Serializable id, String property, Serializable value) {
		return this.getMapper().updateByProperty(id, property, value);
	}

	/**
	 * 根据id删除对象
	 */
	@Override
	public int deleteById(Long id) {
		return this.getMapper().deleteById(id);

	}

	/**
	 * 根据id列表删除对象
	 */
	@Override
	public int delete(List<Long> ids) {
		return this.getMapper().delete(ids);
	}

	/**
	 * 根据属性值删除对象
	 */
	@Override
	public int deleteByProperty(String property, Serializable value) {
		return this.getMapper().deleteByProperty(property, value);
	}

	/**
	 * 根据id查找对象
	 */
	@Override
	public T getById(Long id) {
		return this.getMapper().getById(id);
	}
	/**
	 *  根据样例查找
	 * @param property
	 * @param value
	 * @return
	 */
	public List<T> getByExample(T entity){
		return this.getMapper().getByExample(entity);
	}
	/**
	 * 根据属性值查找对象
	 */
	@Override
	public List<T> getByProperty(String property, Serializable value) {
		return this.getMapper().getByProperty(property, value);
	}

	public List<T> findAllByPage() {
		return this.getMapper().findAllByPage();
	}
	public List<T> findAll() {
		return this.getMapper().findAll();
	}
	public int getLanguage(){
		String language = MyThreadLocalUtils.getRequest().getParameter("language");
		if(StringUtils.isNumeric(language)){
			return Integer.parseInt(language);
		}else{
			return 0 ;
		}
	}
	public int getDataType(){
		String dataType = MyThreadLocalUtils.getRequest().getParameter("dataType");
		if(StringUtils.isNumeric(dataType)){
			return Integer.parseInt(dataType);
		}else{
			return 0 ;
		}
	}

}