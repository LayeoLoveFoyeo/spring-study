package com.bsth.si.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.bsth.si.dao.ProductionclassDao;
import com.bsth.si.entity.Productionclass;
import com.bsth.si.mapper.ProductionclassMapper;

/**
 * @author sine
 * @version 
 */
@Repository
public class ProductionclassDaoImpl extends BaseDaoImpl<Productionclass, ProductionclassMapper>
		implements ProductionclassDao {
	Logger logger = Logger.getLogger(this.getClass());

	public ProductionclassDaoImpl() {
		setMapperClass(ProductionclassMapper.class);
	}
}
