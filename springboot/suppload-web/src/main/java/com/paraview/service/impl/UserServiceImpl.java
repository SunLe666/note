package com.paraview.service.impl;

import com.paraview.entity.User;
import com.paraview.mapper.UserMapper;
import com.paraview.service.UserService;
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
public class UserServiceImpl implements UserService {

	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;
	


	@Override
	@Transactional(transactionManager = "mysqlTransactionManager")
	public User getUserByCode1(String code1) {
		return userMapper.getUserByCode1(code1);
	}

	@Override
	@Transactional
	public int addUser(User user) {
		userMapper.addUser(user);
		return user.getId();
	}

	@Override
	@Transactional
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}


	@Override
	@Transactional
	public void delteUserRoleByCode1(String code1) {
		userMapper.delteUserRoleByCode1(code1);
	}

	@Override
	@Transactional
	public List<User> getAllUser() {
		return userMapper.getAllUser();
	}

}
