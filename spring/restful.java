package com.para.osc.web.contorller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.para.osc.framework.common.message.Message;
import com.para.osc.framework.common.message.MessageUtils;
import com.para.osc.framework.common.util.StringUtils;
import com.para.osc.framework.common.web.controller.OscController;
import com.para.osc.framework.exception.checked.ServiceException;
import com.para.osc.framework.security.model.PrUser;
import com.para.osc.framework.security.service.IPrUserService;
import com.para.osc.framework.security.view.UserInfo;


/**
 * 新增用户Api
 * 
 * 
 * */

@Controller
@RequestMapping(value={"/userInfoApi"})
public class UserInfoRestController extends OscController{
	
	private static final long serialVersionUID = 1L;
	private final static Logger logger = Logger.getLogger(UserInfoRestController.class);


	@Autowired
	private IPrUserService userService;
	
	
	
	@ResponseBody
	@RequestMapping(value="/doAdduser",produces="application/json;charset=utf-8")
	public Message doAdduser(@RequestBody PrUser prUser) {
		try {	
			this.checkNonEmpty(prUser);
			UserInfo userInfo = new UserInfo();
			userInfo.setUserModel(prUser);
			logger.info("接口调用:"+StringUtils.obj2Str(userInfo.getUserModel()));
			return MessageUtils.success((this.userService.doAddUserRest(userInfo)));
		} catch (ServiceException e) {
			return MessageUtils.message(e);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value="/doNewAdduser/{uid}/{userName}/{jobNum}/{orgId}/{orgName}/{companies}/{sex}/{email}/{phone}/{userType}")
	public Message doNewAdduser(@PathVariable("uid")String uid,@PathVariable("userName") String userName,@PathVariable("jobNum") String jobNum,
			@PathVariable("orgId") String orgId,@PathVariable("orgName") String orgName,@PathVariable("companies")String companies,@PathVariable("sex")String sex,
			@PathVariable("email")String email,@PathVariable("phone")String phone,@PathVariable("userType")String userType) {
		try {	
			this.checkNonEmpty(uid, userName, sex, email, phone, userType);
			UserInfo userInfo = this.assemblyInfo(uid, userName,jobNum,orgId,orgName,companies,sex, email, phone, userType);
			logger.info("接口调用:"+StringUtils.obj2Str(userInfo.getUserModel()));
			return MessageUtils.success((this.userService.doAddUserRest(userInfo)));
		} catch (ServiceException e) {
			return MessageUtils.message(e);
		}
	}
	
	
	public UserInfo assemblyInfo(String uid, String userName,String jobNum,String orgId,String orgName,String companies,String sex,String email,String phone,String userType){
		UserInfo userInfo = new UserInfo();
		PrUser prUser = new PrUser();
		prUser.setUid(uid);
		prUser.setUserName(userName);
		prUser.setJobNum(jobNum);
		prUser.setOrgId(orgId);
		prUser.setOrgName(orgName);
		prUser.setCompanies(companies);
		prUser.setSex(sex);
		prUser.setEmail(email);
		prUser.setPhone(phone);
		prUser.setUserType(userType);
		userInfo.setUserModel(prUser);
		return userInfo;
		
	}
	
	
	public void checkNonEmpty(String uid, String userName,String sex,String email,String phone,String userType) throws ServiceException{
		if (StringUtils.isEmpty(uid)) {
			logger.info("uid[" + uid + "] id null ");
			throw new ServiceException("uid is null");
		}
		if (StringUtils.isEmpty(userName)) {
			logger.info("userName[" + userName + "] is null ");
			throw new ServiceException("userName is null");
		}

		/*if (StringUtils.isEmpty(sex)) {
			logger.info("sex[" + sex + "] is null ");
			throw new ServiceException("sex is null");
		}*/
		
		if (StringUtils.isEmpty(email)) {
			logger.info("email[" + sex + "] is null ");
			throw new ServiceException("email is null");
		}
		
		/*if (StringUtils.isEmpty(phone)) {
			logger.info("phone[" + sex + "] is null ");
			throw new ServiceException("phone is null");
		}*/
		
		if (StringUtils.isEmpty(userType)) {
			logger.info("userType[" + userType + "] is null ");
			throw new ServiceException("userType is null");
		}
	}
	
	
	public void checkNonEmpty(PrUser prUser) throws ServiceException{
		if (StringUtils.isEmpty(prUser.getUid())) {
			logger.info("uid[" + prUser.getUid() + "] id null ");
			throw new ServiceException("uid is null");
		}
		if (StringUtils.isEmpty(prUser.getUserName())) {
			logger.info("userName[" + prUser.getUserName() + "] is null ");
			throw new ServiceException("userName is null");
		}

		/*if (StringUtils.isEmpty(sex)) {
			logger.info("sex[" + sex + "] is null ");
			throw new ServiceException("sex is null");
		}*/
		
		if (StringUtils.isEmpty(prUser.getEmail())) {
			logger.info("email[" + prUser.getEmail() + "] is null ");
			throw new ServiceException("email is null");
		}
		
		/*if (StringUtils.isEmpty(phone)) {
			logger.info("phone[" + sex + "] is null ");
			throw new ServiceException("phone is null");
		}*/
		
		if (StringUtils.isEmpty(prUser.getUserType())) {
			logger.info("userType[" + prUser.getUserType() + "] is null ");
			throw new ServiceException("userType is null");
		}
	}
}
