package com.bsth.si.util;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class EntityToMap {
	public EntityToMap() {
		// TODO Auto-generated constructor stub
	}

	public Map O2M(Object object) {
		Map map = new HashMap();
		try {
			map = BeanUtils.describe(object);
			map.remove("class");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
