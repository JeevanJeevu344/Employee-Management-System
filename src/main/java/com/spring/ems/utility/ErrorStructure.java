package com.spring.ems.utility;

public class ErrorStructure<A> {
	private int errorCode;
	private String errormessage;
	private A error;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public A getError() {
		return error;
	}

	public void setError(A error) {
		this.error = error;
	}

}
