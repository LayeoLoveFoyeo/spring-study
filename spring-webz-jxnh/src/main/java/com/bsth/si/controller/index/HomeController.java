package com.bsth.si.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	/**
	 * 主页
	 */
	@RequestMapping("/aboutus")
	public String index() {
		// 转到登录页面
		return "/pages/company/aboutus";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView rlzyIndex(ModelMap model) {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("system/index");
		return andView;
	}
}
