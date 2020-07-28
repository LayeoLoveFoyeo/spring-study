package com.bsth.si.service;

import java.util.List;
import java.util.Map;

import com.bsth.si.dao.BaseDao;
import com.bsth.si.mapper.BaseMapper;
import com.bsth.si.util.PageObject;
import com.bsth.si.util.ReMessage;

/**
 * @author sine
 * @version 
 */
public interface BaseService<T> {
	
	void setBaseDao(BaseDao<T, ? extends BaseMapper<T>> baseDao,Class<T> tClass);
	
	List<T> query(Map<String, Object> map);

	ReMessage delete(Map<String, Object> map);
	
	ReMessage delete(T t);

	ReMessage add(Map<String, Object> map);
	
	ReMessage add(T t);

	ReMessage update(Map<String, Object> map);
	
	ReMessage update(T t);

	T detail(Map<String, Object> map);
	
	T M2O (Map<String, Object> map);
	
	public PageObject<T> Pagequery(Map<String, Object> map);
}
