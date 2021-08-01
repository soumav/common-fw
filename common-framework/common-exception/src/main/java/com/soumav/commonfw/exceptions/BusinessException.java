package com.soumav.commonfw.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	public BusinessException(String message, HttpStatus statusCode) {
		super(statusCode.toString() + ": " + message);
	}

}
