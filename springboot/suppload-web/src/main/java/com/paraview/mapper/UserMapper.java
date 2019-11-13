package com.paraview.mapper;

import com.paraview.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	
	User getUserByCode1(@Param("code1") String code1);

	int addUser(User user);

	int updateUser(User user);

	int addUserRole(List<UserAndRoleIdList> userAndRoleIdList);

	List<UserAndRoleIdList> getRoleIdListByRoleCodeList(List<String> UserList);

	void delteUserRoleByCode1(@Param("code1") String code1);

	List<User> getAllUser();

}
