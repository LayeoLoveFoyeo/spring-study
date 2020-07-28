package com.bsth.si.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.bsth.si.dao.ProductionDao;
import com.bsth.si.entity.Production;
import com.bsth.si.mapper.ProductionMapper;

/**
 * @author sine
 * @version 
 */
@Repository
public class ProductionDaoImpl extends BaseDaoImpl<Production, ProductionMapper>
		implements ProductionDao {
	Logger logger = Logger.getLogger(this.getClass());

	public ProductionDaoImpl() {
		setMapperClass(ProductionMapper.class);
	}
}
