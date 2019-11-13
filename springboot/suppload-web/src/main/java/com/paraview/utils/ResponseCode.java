package com.paraview.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class ResponseCode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	private String message;

	public ResponseCode() {
		this.code = StringUtils.isEmpty(this.code) ? ResponseStatusEnum.SUCCESS.getResultCode() : this.getCode();
		this.message = StringUtils.isEmpty(this.message) ? WebConstants.success : this.getMessage();
	}

	public ResponseCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
