package com.bsth.si.service.impl;

import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsth.si.dao.LeamessDao;
import com.bsth.si.entity.Leamess;
import com.bsth.si.service.LeamessService;
import com.bsth.si.util.ReMessage;

/**
 * @author sine
 * @version 
 */
@Service
public class LeamessServiceImpl extends BaseServiceImpl<Leamess> implements
		LeamessService {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private LeamessDao leamessDao;

	@Autowired
	public LeamessServiceImpl(LeamessDao leamessDao) {
		setBaseDao(leamessDao, Leamess.class);
	}
	
	@Override
	public ReMessage add(Map<String, Object> map) {
		ReMessage reMessage = new ReMessage();
		// TODO Auto-generated method stub
		try{
			String pk = leamessDao.getPrimaryKey();
			logger.debug("...........pk.........."+pk);
			map.put("leamessId", pk);
			Leamess t = M2O(map);
			leamessDao.insertByEntity(t);
		}catch (Exception e) {
			// TODO: handle exception
			reMessage.isError = true;
			e.printStackTrace();
		}
		return reMessage;
	}
}
