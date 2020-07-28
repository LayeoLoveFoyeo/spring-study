package com.bsth.si.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * 
 * @ClassName: MapToObject
 * @Description: Map 转换成 实体
 * @author sine
 * @date 2012-12-19 下午4:45:01
 * 
 */

public class MapToEntity {
	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 
	  * map2Entity
	  *
	  * @Title: map2Entity
	  * @Description: TODO
	  * @param @param type
	  * @param @param map
	  * @param @return    设定文件
	  * @return T    返回类型
	  * @throws
	 */
	public static <T> T M2O(Class<T> type, Map<String, Object> map) {
		T t = null;
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			// 获取类属性 　
			t = type.newInstance();
			for (PropertyDescriptor descriptor : beanInfo
					.getPropertyDescriptors()) {
				String propertyName = descriptor.getName();
				// 去掉 class 不作为
				if (propertyName.equals("class"))
					continue;
				if (map.containsKey(propertyName)) {
					Object o = map.get(propertyName);
					if (o != null && !o.equals("")) {
						descriptor.getWriteMethod().invoke(
								t,
								new ObjectValue().getValue(
										map.get(propertyName),
										descriptor.getPropertyType()));

					}
				}
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return t;
	}
}