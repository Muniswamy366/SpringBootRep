package com.arya.myapp.exceptions;

public class CustomGenericException extends RuntimeException {

	private static final long serialVersionUID = 1832789621843415226L;

	private String errMsg;
	
	private String errStatusCode;
	
	private String errApiCode;
	
	private Throwable cause;
	
	public CustomGenericException(String errMsg, String errStatusCode, String errApiCode, Throwable cause) {
		this.errMsg = errMsg;
		this.errStatusCode = errStatusCode;
		this.errApiCode = errApiCode;
		this.cause = cause;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrStatusCode() {
		return errStatusCode;
	}

	public void setErrStatusCode(String errStatusCode) {
		this.errStatusCode = errStatusCode;
	}

	public String getErrApiCode() {
		return errApiCode;
	}

	public void setErrApiCode(String errApiCode) {
		this.errApiCode = errApiCode;
	}

	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}

}
