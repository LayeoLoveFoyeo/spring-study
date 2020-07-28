package com.bsth.si.service.impl;

import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsth.si.dao.ProductionclassDao;
import com.bsth.si.entity.Productionclass;
import com.bsth.si.service.ProductionclassService;
import com.bsth.si.util.ReMessage;

/**
 * @author sine
 * @version 
 */
@Service
public class ProductionclassServiceImpl extends BaseServiceImpl<Productionclass> implements
		ProductionclassService {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private ProductionclassDao productionclassDao;

	@Autowired
	public ProductionclassServiceImpl(ProductionclassDao productionclassDao) {
		setBaseDao(productionclassDao, Productionclass.class);
	}
	
	@Override
	public ReMessage add(Map<String, Object> map) {
		ReMessage reMessage = new ReMessage();
		// TODO Auto-generated method stub
		try{
			String pk = productionclassDao.getPrimaryKey();
			logger.debug("...........pk.........."+pk);
			map.put("productionclassId", pk);
			Productionclass t = M2O(map);
			productionclassDao.insertByEntity(t);
		}catch (Exception e) {
			// TODO: handle exception
			reMessage.isError = true;
			e.printStackTrace();
		}
		return reMessage;
	}
}
