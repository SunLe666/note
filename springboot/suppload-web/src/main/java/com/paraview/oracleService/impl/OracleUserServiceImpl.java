package com.paraview.oracleService.impl;

import com.paraview.entity.User;
import com.paraview.oracleMapper.OracleUserMapper;
import com.paraview.oracleService.OracleUserService;
import com.paraview.utils.WebConstants;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class OracleUserServiceImpl implements OracleUserService {

	private static Logger logger = LoggerFactory.getLogger(OracleUserServiceImpl.class);


	@Autowired
	private OracleUserMapper oracleUserMapper;
	

	@Override
	@Transactional(transactionManager = "mysqlTransactionManager")
	public User getUserByCode1(String code1) {
		return oracleUserMapper.getUserByCode1(code1);
	}

	@Override
	@Transactional
	public int addUser(User user) {
		oracleUserMapper.addUser(user);
		return user.getId();
	}

	@Override
	@Transactional
	public int updateUser(User user) {
		return oracleUserMapper.updateUser(user);
	}



	@Override
	@Transactional
	public void delteUserRoleByCode1(String code1) {
		oracleUserMapper.delteUserRoleByCode1(code1);
	}

	@Override
	@Transactional
	public List<User> getAllUser() {
		return oracleUserMapper.getAllUser();
	}

}
