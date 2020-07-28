package com.bsth.si.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.bsth.si.dao.UsersDao;
import com.bsth.si.entity.Users;
import com.bsth.si.mapper.UsersMapper;

/**
 * @author sine
 * @version 
 */
@Repository
public class UsersDaoImpl extends BaseDaoImpl<Users, UsersMapper>
		implements UsersDao {
	Logger logger = Logger.getLogger(this.getClass());

	public UsersDaoImpl() {
		setMapperClass(UsersMapper.class);
	}
}
