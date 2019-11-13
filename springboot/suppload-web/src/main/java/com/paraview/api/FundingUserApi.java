package com.paraview.api;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.paraview.entity.User;
import com.paraview.oracleService.OracleUserService;
import com.paraview.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user/v1/")
@Api("swaggerFundingUserApi相关的api")
public class FundingUserApi {

	private static Logger logger = LoggerFactory.getLogger(FundingUserApi.class);

	@Autowired
	private UserService userService;

	@Autowired
	private OracleUserService oracleUserService;

    @ApiOperation(value = "获取用户信息接口", notes = "获取用户信息接口。。")
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public User getUser(HttpServletRequest request) {
		User user = new User();
		logger.info("getUser  start");
		try {
			String code1 = request.getParameter("code1");
			user = userService.getUserByCode1(code1);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.info("getUser end");
		return user;
	}



	@RequestMapping(value = "/getOracleUser", method = RequestMethod.GET)
	public User getOracleUser(HttpServletRequest request) {
		User user = new User();
		logger.info("getUser  start");
		try {
			String code1 = request.getParameter("code1");
			user = oracleUserService.getUserByCode1(code1);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.info("getUser end");
		return user;
	}



	@ApiOperation(value = "获取所有用户信息接口", notes = "获取所有用户信息接口。。")
	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
	public PageInfo<User> getAllUser(HttpServletRequest request) {
		logger.info("getAllUser  start");
		int pageNum = 2;
		int pageSize = 10;
		List<User> userList = new ArrayList<>();
		PageInfo<User> pageInfoUserList = new  PageInfo<User>();
		try {
			Page<User> page = PageHelper.startPage(pageNum, pageSize);
			logger.info("总条数：{}",page.getTotal());
			userList = userService.getAllUser();
		    pageInfoUserList = new PageInfo<User>(userList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.info("getAllUser end");
		return pageInfoUserList;
	}
	
	@RequestMapping(value="/updateUser")
	public String updateUser(){
		User user = new User();
		user.setCode1("310214502");
		user.setUserEmail("sunle@gmail.com");
		user.setUserName("sunle");
		user.setId(Integer.parseInt("1"));
		try {
			userService.updateUser(user);
			logger.info("update userinfo success!!");
		} catch (Exception e) {
			logger.error("update userinfo fail", e.getMessage());
		}
		return null;
	}
	
}
