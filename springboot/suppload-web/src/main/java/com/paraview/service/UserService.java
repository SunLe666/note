package com.paraview.service;

import com.paraview.entity.User;

import java.util.List;

public interface UserService {


	User getUserByCode1(String code1);

	int addUser(User user);

	int updateUser(User user);

	void delteUserRoleByCode1(String code1);

	List<User> getAllUser();
	
}
