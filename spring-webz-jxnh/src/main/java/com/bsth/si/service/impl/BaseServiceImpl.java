package com.bsth.si.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.bsth.si.dao.BaseDao;
import com.bsth.si.mapper.BaseMapper;
import com.bsth.si.service.BaseService;
import com.bsth.si.util.MapToEntity;
import com.bsth.si.util.PageHelper;
import com.bsth.si.util.PageObject;
import com.bsth.si.util.ReMessage;

/**
 * @author sine
 * @version
 */
public class BaseServiceImpl<T> implements BaseService<T> {
	Logger logger = Logger.getLogger(BaseServiceImpl.class);

	private BaseDao<T, ? extends BaseMapper<T>> baseDao;

	private T t;

	private Class<T> tClass;

	public void setBaseDao(BaseDao<T, ? extends BaseMapper<T>> baseDao,
			Class<T> tClass) {
		// TODO Auto-generated method stub
		this.baseDao = baseDao;
		this.tClass = tClass;
	}

	public List<T> query(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.baseDao.selectByObject(M2O(map));
	}

	public ReMessage delete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		ReMessage reMessage = new ReMessage();
		T t = M2O(map);
		if (t != null) {
			try {
				this.baseDao.deleteByEntity(t);
			} catch (Exception e) {
				// TODO: handle exception
				reMessage.isError = true;
				e.printStackTrace();
			}
		}else{
			reMessage.isError = true;
		}
		return reMessage;
	}
	
	@Override
	public ReMessage delete(T t) {
		// TODO Auto-generated method stub
		ReMessage reMessage = new ReMessage();
		if (t != null) {
			try {
				this.baseDao.deleteByEntity(t);
			} catch (Exception e) {
				// TODO: handle exception
				reMessage.isError = true;
				e.printStackTrace();
			}
		}else{
			reMessage.isError = true;
		}
		return reMessage;
	}

	public ReMessage add(Map<String, Object> map) {
		ReMessage reMessage = new ReMessage();
		// TODO Auto-generated method stub
		try {
			this.baseDao.insertByEntity(M2O(map));
		} catch (Exception e) {
			// TODO: handle exception
			reMessage.isError = true;
			e.printStackTrace();
		}
		return reMessage;
	}
	
	@Override
	public ReMessage add(T t) {
		// TODO Auto-generated method stub
		ReMessage reMessage = new ReMessage();
		try {
			this.baseDao.insertByEntity(t);
		} catch (Exception e) {
			reMessage.isError = true;
			e.printStackTrace();
		}
		return reMessage;
	}

	public ReMessage update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		ReMessage reMessage = new ReMessage();
		try {
			this.baseDao.updateByEntity(M2O(map));
		} catch (Exception e) {
			reMessage.isError = true;
			e.printStackTrace();
		}
		return reMessage;
	}
	
	@Override
	public ReMessage update(T t) {
		// TODO Auto-generated method stub
		ReMessage reMessage = new ReMessage();
		try {
			this.baseDao.updateByEntity(t);
		} catch (Exception e) {
			reMessage.isError = true;
			e.printStackTrace();
		}
		return reMessage;
	}

	public T detail(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.baseDao.selectSingle(M2O(map));
	}
	
	public T detail(T t) {
		// TODO Auto-generated method stub
		return this.baseDao.selectSingle(t);
	}

	@SuppressWarnings("unchecked")
	public PageObject<T> Pagequery(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int totalData = this.baseDao.getCount(map);
		PageHelper pageHelper = new PageHelper(totalData, map);
		List<T> list = this.baseDao.queryByObject(pageHelper.getMap());
		PageObject<T> pageObject = pageHelper.getPageObject();
		pageObject.setDataList(list);
		return pageObject;
	}

	@Override
	public T M2O(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		return (T) MapToEntity.M2O(tClass, map);
	}
}
