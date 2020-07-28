package com.bsth.si.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.bsth.si.dao.LeamessDao;
import com.bsth.si.entity.Leamess;
import com.bsth.si.mapper.LeamessMapper;

/**
 * @author sine
 * @version 
 */
@Repository
public class LeamessDaoImpl extends BaseDaoImpl<Leamess, LeamessMapper>
		implements LeamessDao {
	Logger logger = Logger.getLogger(this.getClass());

	public LeamessDaoImpl() {
		setMapperClass(LeamessMapper.class);
	}
}
