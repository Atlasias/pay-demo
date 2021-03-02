package com.pay.advice;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pay.exception.BrNotFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(BrNotFoundException.class)
	public @ResponseBody Object brError(BrNotFoundException e) {

		Map<String,Object> errorMap = new LinkedHashMap<>();
		errorMap.put("http status","404");

		Map<String,Object> subErrorMap = new LinkedHashMap<>();
		subErrorMap.put("code", "404");
		subErrorMap.put("메세지", e.getMessage());
		
		errorMap.put("error", subErrorMap);
		
		return errorMap;
		
	}
	
}
