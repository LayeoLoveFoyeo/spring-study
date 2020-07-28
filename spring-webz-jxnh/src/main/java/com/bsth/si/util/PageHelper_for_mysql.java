package com.bsth.si.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class PageHelper_for_mysql {
	Logger logger = Logger.getLogger(PageHelper_for_mysql.class);
	
	private Map<String, Object> map;
	private int totalData = 0;
	private int curPage =1;
	private int pageData=1;

	public PageHelper_for_mysql(int totalData,Map<String, Object> map) {
		this.totalData = totalData;
		this.map = map;
	}

	public HashMap<String, Object> getMap() {
		if(map.get("curPage")!=null){
			curPage = Integer.valueOf((String) map.get("curPage"));
			pageData = Integer.valueOf((String) map.get("pageData"));
			logger.debug("curPage:"+curPage+"  pageData:"+pageData);
			map.put("MAX", curPage * pageData);
			int min = (curPage - 1) * pageData-1;
			map.put("MIN", min);
			map.put("MIN_FOR_MYSQL", (min+1)<0?0:(min+1));
			//让pageData变成INT
			map.put("pageData",pageData);
		}
		return (HashMap<String, Object>) map;
	}
	
	public PageObject getPageObject(){
		PageObject pageObject = new PageObject(totalData,curPage,pageData);
		return pageObject;
	}
}
