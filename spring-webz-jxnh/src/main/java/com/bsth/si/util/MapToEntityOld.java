package com.bsth.si.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.log4j.Logger;
/**
 * 
  * @ClassName: MapToEntity
  * @Description: Map 转换成  实体
  * @author sine
  * @date 2012-12-19 下午4:45:01
  *
  * @param <T>
 */
public class MapToEntityOld<T> {
	
	Logger logger = Logger.getLogger(MapToEntity.class);

	private T t;

	private Map<String, Object> map;

	
	private String className;
	
	private Class<T> tClass;

	public MapToEntityOld(Class<T> tClass, Map<String, Object> map) {
		this.map = map;
		try {
			this.t = tClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.tClass = tClass;
		this.className = tClass.getName();
	}

	@SuppressWarnings("rawtypes")
	public T getEntity() {
		boolean temp = false;
		Class c = null;
		try {
			c = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Field[] fields = c.getDeclaredFields();
		ObjectValue tool = new ObjectValue();
		for (Field field : fields) {
			if(map!=null)
			for (Map.Entry entry : map.entrySet()) {
				String key = (String) entry.getKey();
				String value = (String) (entry.getValue()+"");
				//logger.debug(" key :"+key+"    field.getname(): "+field.getName());
				if(value!=null&&!value.equals("null"))
				if (field.getName().equals(key)&&!value.equals("")) {
					logger.debug(field.getName() +"\t" +key+"\t"+value);
					temp = true;
					String prop = Character.toUpperCase(key.charAt(0))+ key.substring(1);
					String methodName = "set" + prop;
					Class[] types = new Class[] { field.getType() };
					Method method;
					try {
						method = tClass.getMethod(methodName, types);
						method.invoke(
								t,
								new Object[] { tool.getValue(value,field.getType()) });
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		logger.debug(temp);
		return temp ? t : null;
	}

}
