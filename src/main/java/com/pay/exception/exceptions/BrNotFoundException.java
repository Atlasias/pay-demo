package com.pay.exception.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="br code not found error")
public class BrNotFoundException extends RuntimeException { 
	
	public BrNotFoundException(String msg) {
		super(msg);
	}
}
