package com.bsth.si.util;

import java.util.Date;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

public class ObjectValue {
	Logger logger = Logger.getLogger(this.getClass());

	@SuppressWarnings("unchecked")
	public <T> T getValue(Object obj, Class<T> clz) {
		try {
			if (obj != null && !obj.toString().trim().equals("")) {
				if (clz.equals(String.class))
					return (T) obj.toString();
				else if (clz.equals(Long.class))
					return (T) Long.valueOf(obj.toString().trim());
				else if (clz.equals(Integer.class))
					return (T) Integer.valueOf(obj.toString().trim());
				else if (clz.equals(Double.class))
					return (T) Double.valueOf(obj.toString().trim());
				else if (clz.equals(Float.class))
					return (T) Float.valueOf(obj.toString().trim());
				else if (clz.equals(Date.class)) {
					String dateTime = obj.toString().trim();
					return (T) new DateTime(getTime(dateTime)).toDate();
				} else {
					logger.error("没有找到匹配的类型，不能转换");
					throw new Exception("没有匹配类型");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getObjectValue(Object obj, Class<T> clz) {
		String objStr = obj.toString();
		try {
			if (obj != null && !objStr.trim().equals("")) {
				if (clz.equals(String.class))
					return (T) objStr;
				else if (clz.equals(Long.class))
					return (T) Long.valueOf(objStr.trim());
				else if (clz.equals(Integer.class)){
					objStr = objStr.substring(0, objStr.indexOf("."));
					return (T) Integer.valueOf(objStr.trim());
				}
				else if (clz.equals(Double.class))
					return (T) Double.valueOf(objStr.trim());
				else if (clz.equals(Float.class))
					return (T) Float.valueOf(objStr.trim());
				else if (clz.equals(Date.class)) {
					String dateTime = objStr.trim();
					return (T) new DateTime(getTime(dateTime)).toDate();
				}
			} else {
				if (clz.equals(String.class))
					return null;
				else if (clz.equals(Long.class))
					return null;
				else if (clz.equals(Integer.class))
					return (T) Long.valueOf(0);
				else if (clz.equals(Double.class))
					return (T) Double.valueOf(0);
				else if (clz.equals(Float.class))
					return (T) Float.valueOf(0);
				else if (clz.equals(Date.class)) {
					return null;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	protected static String getTime(String dateStr) {
		String[] dateA = dateStr.split(" ");
		if (!dateStr.contains("T") && dateA.length > 1) {
			String newDateStr = dateA[0] + "T" + dateA[dateA.length - 1];
			return newDateStr;
		} else {
			return dateStr;
		}

	}
}
