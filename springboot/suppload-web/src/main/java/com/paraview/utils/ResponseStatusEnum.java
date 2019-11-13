package com.paraview.utils;

/**
 * 通用返回错误码
 *
 */
public enum ResponseStatusEnum {

	FAIL("0", "失败"),
	SUCCESS("1", "成功"),
	ERROR("-1", "未知错误");
	
	private ResponseStatusEnum(String resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}
	
	private String resultCode;
	
	private String resultMsg;

	public String getResultCode() {
		return resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}
	
}