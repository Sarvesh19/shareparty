package com.shareparty.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class EmailExistsException extends Exception{

	
	private static final long serialVersionUID = -2048724935502028581L;

	public EmailExistsException(String message) {
		super(message);
	}
	
	

}
