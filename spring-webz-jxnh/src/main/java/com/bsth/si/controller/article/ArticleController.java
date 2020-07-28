package com.bsth.si.controller.article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bsth.si.controller.BaseController;
import com.bsth.si.entity.Article;
import com.bsth.si.service.ArticleService;
import com.bsth.si.util.ReMessage;

@Controller
@RequestMapping("/Article/*")
@SessionAttributes("currUser")
public class ArticleController extends BaseController<Article> {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private ArticleService service;

	@Autowired
	public ArticleController(ArticleService service) {
		setBaseService(service);
	}

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(@RequestParam Map<String, Object> map) {
		logger.debug(map);
		ModelAndView andView = new ModelAndView();
		andView.addAllObjects(map);
		andView.setViewName("/pages/article/list.jsp");
		logger.debug(andView);
		return andView;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam Map<String, Object> map) {
		logger.debug(map);
		ModelAndView andView = new ModelAndView();
		andView.addAllObjects(map);
		andView.setViewName("/pages/article/edit.jsp");
		logger.debug(andView);
		return andView;
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> check(@RequestParam Map<String, Object> map) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		ReMessage reMessage = new ReMessage();
		try {
			String checkId = (String) map.get("checkId");
			List<Article> checkList = service.query(map);
			int count = 0;
			if(checkId.equals("")){
				count= checkList.size();
			}else{
				for (Article temp : checkList) {
					if(!temp.getArticleId().equals(Long.valueOf(checkId))){
						count++;
					}
				}
			}
			if(count>0){
				reMessage.setError(true);
				reMessage.setMessage("存在相同！");
			}
			
			modelMap.put("msg", reMessage);
		} catch (Exception e) {
			reMessage.isError = true;
			modelMap.put("msg", reMessage);
			e.printStackTrace();
		}
		return modelMap;
	}
	
	
}
