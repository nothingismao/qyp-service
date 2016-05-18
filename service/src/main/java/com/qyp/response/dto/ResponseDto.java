package com.qyp.response.dto;

import java.io.Serializable;

public class ResponseDto implements Serializable {
	private static final long serialVersionUID = 6475436331826926367L;
	protected boolean success = true;
	protected String errorMessage;
	private Object data;

	public static ResponseDto create(boolean success, String errorMessage) {
		ResponseDto response = new ResponseDto();
		response.setSuccess(success);
		response.setErrorMessage(errorMessage);
		return response;
	}

	public static ResponseDto create(boolean success, String errorMessage,
			Object data) {
		ResponseDto response = new ResponseDto();
		response.setSuccess(success);
		response.setErrorMessage(errorMessage);
		response.setData(data);
		return response;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
