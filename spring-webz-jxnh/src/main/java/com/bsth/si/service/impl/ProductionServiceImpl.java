package com.bsth.si.service.impl;

import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsth.si.dao.ProductionDao;
import com.bsth.si.entity.Production;
import com.bsth.si.service.ProductionService;
import com.bsth.si.util.ReMessage;

/**
 * @author sine
 * @version 
 */
@Service
public class ProductionServiceImpl extends BaseServiceImpl<Production> implements
		ProductionService {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private ProductionDao productionDao;

	@Autowired
	public ProductionServiceImpl(ProductionDao productionDao) {
		setBaseDao(productionDao, Production.class);
	}
	
	@Override
	public ReMessage add(Map<String, Object> map) {
		ReMessage reMessage = new ReMessage();
		// TODO Auto-generated method stub
		try{
			String pk = productionDao.getPrimaryKey();
			logger.debug("...........pk.........."+pk);
			map.put("productionId", pk);
			Production t = M2O(map);
			productionDao.insertByEntity(t);
		}catch (Exception e) {
			// TODO: handle exception
			reMessage.isError = true;
			e.printStackTrace();
		}
		return reMessage;
	}
}
