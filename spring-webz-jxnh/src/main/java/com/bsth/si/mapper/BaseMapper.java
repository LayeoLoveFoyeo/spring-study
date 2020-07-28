package com.bsth.si.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sine
 * @version 
 */
public interface BaseMapper<T> {
	
	/**
	 * 获取主键
	 * @return String
	 */
	String getPrimaryKey(); 
	
	/**
	 * 获取总数
	 * @return int
	 */
	int getCount(T t);
	int getCount(Map<String,Object> map);
	
	/**
	 * 插入数据
	 * @param t
	 */
	void insertByEntity(T t);
	
	/**
	 * 删除数据
	 * @param t
	 */
	void deleteByEntity(T t);
	
	/**
	 * 更新数据
	 * @param examuser
	 */
	void updateByEntity(T t);
	
	/**
	 * 单条记录选取
	 * @param t
	 * @return T
	 */
	T selectSingle(T t);
	
	/**
	 * 多条选择
	 * @param examuser
	 * @return List<T>
	 */
	List<T> selectByObject(T t);
	
	/**
	 * 分页查询
	 * @param map
	 * @return List<ExamUser>
	 */
	List<T> queryByObject(HashMap<String,Object> map);
	
}