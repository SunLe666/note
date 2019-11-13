package com.paraview.entity;

import java.io.Serializable;

/**
 * 用户(内部用户/外部用户)
 * 
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	/** 编号 */
	private String code1;

	/** 邮箱 */
	private String userEmail;

	/** 名称 */
	private String userName;

	/** 手机 */
	private String mobile;

	/** 座机号码 */
	private String officePhone;

	/** 所属区域 */
	private String location;

	/** 所属部门 */
	private String function;

	private String lmCode1;

	private String lmName;

	private String title;

	private String codeOu;

	private String pds;

	private String oxygen;

	private String oru;

	private String costC;

	/** insert 新增 update 修改 delete 删除 */
	private String flag;

	/** 状态 0：可用 1：不可用 */
	private String status;

	/**
	 * 用户是属于那个系统( APLean:funding portal:bo PSInRebate:psi ITOP:itop
	 * MOBILE:mobile,Speaker:speaker)
	 */
	private String appCode;

	/** 角色code */
	private String roleCode;

	/** 角色name */
	private String roleName;

	/** 角色组code */
	private String roleGroupCode;

	/** 角色组name */
	private String roleGroupName;

	/** INTERNAL/EXTERNAL */
	private String userType;

	/** 外部用户-AD，内部用户-Sales，内部用户-非Sales，内部用户-Ros，外部用户-Ros，Promoter */
	private String userFlag;

	/** 工号 */
	private String employeeId;
	/** 显示名 */
	private String displayName;
	/** 描述 */
	private String description;
	/** 密码 */
	private String password;

	/** 家庭住址 */
	private String streetAddress;

	/** co */
	private String co;

	/** 所属公司 */
	private String company;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getLmCode1() {
		return lmCode1;
	}

	public void setLmCode1(String lmCode1) {
		this.lmCode1 = lmCode1;
	}

	public String getLmName() {
		return lmName;
	}

	public void setLmName(String lmName) {
		this.lmName = lmName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCodeOu() {
		return codeOu;
	}

	public void setCodeOu(String codeOu) {
		this.codeOu = codeOu;
	}

	public String getPds() {
		return pds;
	}

	public void setPds(String pds) {
		this.pds = pds;
	}

	public String getOxygen() {
		return oxygen;
	}

	public void setOxygen(String oxygen) {
		this.oxygen = oxygen;
	}

	public String getOru() {
		return oru;
	}

	public void setOru(String oru) {
		this.oru = oru;
	}

	public String getCostC() {
		return costC;
	}

	public void setCostC(String costC) {
		this.costC = costC;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleGroupCode() {
		return roleGroupCode;
	}

	public void setRoleGroupCode(String roleGroupCode) {
		this.roleGroupCode = roleGroupCode;
	}

	public String getRoleGroupName() {
		return roleGroupName;
	}

	public void setRoleGroupName(String roleGroupName) {
		this.roleGroupName = roleGroupName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
