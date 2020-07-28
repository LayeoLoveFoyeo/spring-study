package com.bsth.si.service.impl;

import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsth.si.dao.ArticleDao;
import com.bsth.si.entity.Article;
import com.bsth.si.service.ArticleService;
import com.bsth.si.util.ReMessage;

/**
 * @author sine
 * @version 
 */
@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements
		ArticleService {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private ArticleDao articleDao;

	@Autowired
	public ArticleServiceImpl(ArticleDao articleDao) {
		setBaseDao(articleDao, Article.class);
	}
	
	@Override
	public ReMessage add(Map<String, Object> map) {
		ReMessage reMessage = new ReMessage();
		// TODO Auto-generated method stub
		try{
			String pk = articleDao.getPrimaryKey();
			logger.debug("...........pk.........."+pk);
			map.put("articleId", pk);
			Article t = M2O(map);
			articleDao.insertByEntity(t);
		}catch (Exception e) {
			// TODO: handle exception
			reMessage.isError = true;
			e.printStackTrace();
		}
		return reMessage;
	}
}
