package com.bsth.si.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.bsth.si.dao.ArticleDao;
import com.bsth.si.entity.Article;
import com.bsth.si.mapper.ArticleMapper;

/**
 * @author sine
 * @version 
 */
@Repository
public class ArticleDaoImpl extends BaseDaoImpl<Article, ArticleMapper>
		implements ArticleDao {
	Logger logger = Logger.getLogger(this.getClass());

	public ArticleDaoImpl() {
		setMapperClass(ArticleMapper.class);
	}
}
