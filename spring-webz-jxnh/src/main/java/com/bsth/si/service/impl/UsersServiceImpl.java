package com.bsth.si.service.impl;

import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsth.si.dao.UsersDao;
import com.bsth.si.entity.Users;
import com.bsth.si.service.UsersService;
import com.bsth.si.util.ReMessage;

/**
 * @author sine
 * @version 
 */
@Service
public class UsersServiceImpl extends BaseServiceImpl<Users> implements
		UsersService {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private UsersDao usersDao;

	@Autowired
	public UsersServiceImpl(UsersDao usersDao) {
		setBaseDao(usersDao, Users.class);
	}
	
	@Override
	public ReMessage add(Map<String, Object> map) {
		ReMessage reMessage = new ReMessage();
		// TODO Auto-generated method stub
		try{
			String pk = usersDao.getPrimaryKey();
			logger.debug("...........pk.........."+pk);
			map.put("usersId", pk);
			Users t = M2O(map);
			usersDao.insertByEntity(t);
		}catch (Exception e) {
			// TODO: handle exception
			reMessage.isError = true;
			e.printStackTrace();
		}
		return reMessage;
	}
}
