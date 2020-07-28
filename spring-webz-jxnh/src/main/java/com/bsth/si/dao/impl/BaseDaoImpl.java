package com.bsth.si.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.bsth.si.dao.BaseDao;
import com.bsth.si.mapper.BaseMapper;

/**
 * 数据库公共类Dao类接口实现类
 * @author sine
 * @version 
 */
public class BaseDaoImpl<T, E> extends SqlSessionDaoSupport implements BaseDao<T, E>
{
	private Class<E> mapperClass;
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	/**
	 * 设置对应的MapperClass
	 */
	public void setMapperClass(Class<E> mapperClass)
	{
		this.mapperClass = mapperClass;
	}
	
	/**
	 * 得到对应的Mapper对象
	 */
	public E getMapper()
	{
		return sessionFactory.getConfiguration().getMapper(mapperClass, getSqlSession());
	}
	
	@SuppressWarnings("unchecked")
    public BaseMapper<T> getBaseMapper()
	{
		return (BaseMapper<T>)this.getMapper();
	}
	
	/**
	 * 获取sessionFactory
	 * @return sessionFactory
	 */
	public SqlSessionFactory getSessionFactory(){
		return this.sessionFactory;
	}

	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return this.getBaseMapper().getPrimaryKey();
	}

	public int getCount(T t) {
		// TODO Auto-generated method stub
		return this.getBaseMapper().getCount(t);
	}
	
	public int getCount(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return this.getBaseMapper().getCount(map);
	}

	public void insertByEntity(T t) {
		// TODO Auto-generated method stub
		this.getBaseMapper().insertByEntity(t);
	}

	public void deleteByEntity(T t) {
		// TODO Auto-generated method stub
		this.getBaseMapper().deleteByEntity(t);
	}

	public void updateByEntity(T t) {
		// TODO Auto-generated method stub
		this.getBaseMapper().updateByEntity(t);
	}

	public T selectSingle(T t) {
		// TODO Auto-generated method stub
		return this.getBaseMapper().selectSingle(t);
	}

	public List<T> selectByObject(T t) {
		// TODO Auto-generated method stub
		return this.getBaseMapper().selectByObject(t);
	}

	public List<T> queryByObject(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return this.getBaseMapper().queryByObject(map);
	}
}
