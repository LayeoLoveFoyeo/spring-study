package com.bsth.si.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsth.si.entity.Users;
import com.bsth.si.service.BaseService;
import com.bsth.si.util.PageObject;
import com.bsth.si.util.ReMessage;

public class BaseController<T> {

	Logger logger = Logger.getLogger(this.getClass());

	private BaseService<T> baseService;

	public void setBaseService(BaseService<T> baseService) {
		this.baseService = baseService;
	}

	/**
	 * ===== 接受的数据是 MAP use for json =====
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> query(@RequestParam Map<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		ReMessage reMessage = new ReMessage();
		try {
			List<T> list = baseService.query(map);
			modelMap.put("dataList", list);
			modelMap.put("msg", reMessage);
		} catch (Exception e) {
			reMessage.isError = true;
			modelMap.put("msg", reMessage);
			e.printStackTrace();
		}
		return modelMap;
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> detail(@RequestParam Map<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		ReMessage reMessage = new ReMessage();
		try {
			modelMap.put("data", baseService.detail(map));
			modelMap.put("msg", reMessage);
		} catch (Exception e) {
			reMessage.isError = true;
			modelMap.put("msg", reMessage);
			e.printStackTrace();
		}
		return modelMap;
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> del(@RequestParam Map<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		logger.debug("===="+map);
		modelMap.put("msg", baseService.delete(map));
		return modelMap;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> add(@RequestParam Map<String, Object> map,
			@ModelAttribute("currUser") Users currUser) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		logger.debug("currentUserId:  "+ currUser.getId());
		map.put("createBy", currUser.getId());
		map.put("createDate", new DateTime());
		modelMap.put("msg", baseService.add(map));
		return modelMap;
	}

	@RequestMapping(value = "/upd", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> update(@RequestParam Map<String, Object> map,
			@ModelAttribute("currUser") Users currUser) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		logger.debug("currentUserId:  "+ currUser.getId());
		map.put("updateBy", currUser.getId());
		map.put("updateDate", new DateTime());
		modelMap.put("msg", baseService.update(map));
		return modelMap;
	}

	@RequestMapping(value = "/pagequery", method = RequestMethod.POST)
	public @ResponseBody
	PageObject<T> PageQuery(@RequestParam Map<String, Object> map) {
		PageObject<T> pageObject = null;
		try {
			pageObject = baseService.Pagequery(map);
			logger.debug(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageObject;
	}
	/**
	 * ==========================================================
	 */
}
