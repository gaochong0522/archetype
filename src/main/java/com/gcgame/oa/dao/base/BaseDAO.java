package com.gcgame.oa.dao.base;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gcgame.oa.mapper.base.BaseMapper;

public interface BaseDAO<T, PK extends Serializable> {
	/**
	 *  保存
	 * @param entity
	 * @return
	 */
	public T save(T entity);

	/**
	 *  更新(强烈建议：更新单个属性，请参照方法　updatePropertyById))
	 * @param entity
	 * @return
	 */
	public int update(T entity);

	/**
	 *  更新属性值(强烈建议：一般不直接调用此方法，只用于子类的其它方法调用)
	 * @param id
	 * @param property
	 * @param value
	 * @return
	 */
	public int updatePropertyById(@Param("id") Serializable id, @Param("property") String property, @Param("value") Serializable value);

	/**
	 *  根据id删除某个对象
	 * @param id
	 * @return
	 */
	public int deleteById(@Param("id") PK id);

	/**
	 *  根据id批量删除对象
	 * @param ids
	 * @return
	 */
	public int delete(@Param("ids") List<PK> ids);

	/**
	 *  根据属性批量删除对象(强烈建议：一般不直接调用此方法，只用于子类的其它方法调用)
	 * @param property
	 * @param value
	 * @return
	 */
	public int deleteByProperty(@Param("property") String property, @Param("value") Serializable value);

	/**
	 *  根据id加载某个对象
	 * @param id
	 * @return
	 */
	public T getById(@Param("id") PK id);

	/**
	 *  根据样例查找(强烈建议：一般不直接调用此方法，只用于子类的其它方法调用)
	 * @param property
	 * @param value
	 * @return
	 */
	public List<T> getByExample(T entity);
	/**
	 *  根据属性查找(强烈建议：一般不直接调用此方法，只用于子类的其它方法调用)
	 * @param property
	 * @param value
	 * @return
	 */
	public List<T> getByProperty(@Param("property") String property, @Param("value") Serializable value);

	/**
	 *  查找所有的对象
	 * @return
	 */
	public List<T> findAllByPage();

	public BaseMapper<T, PK> getMapper();
	
	public int getLanguage();
	
	public int getDataType();

	public List<T> findAll();
}