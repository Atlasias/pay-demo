package com.pay.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pay.api.service.ApiService;

@RestController
@RequestMapping("/api")
public class ApiController {
	private final Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	String result = "";
	
	@Autowired
	ApiService apiService;
	
	/**
	 * 기능 1 수행 controller method
	 * */
	@RequestMapping(value = "/api1", method = RequestMethod.GET)
	public String getApi1(HttpServletRequest request, HttpServletResponse response) {
		
		result = apiService.selectApi1();
		
		return result;
	}
	
	/**
	 * 기능 2 수행 controller method
	 * */
	@RequestMapping(value = "/api2", method = RequestMethod.GET)
	public String getApi2(HttpServletRequest request, HttpServletResponse response) {
		
		result = apiService.selectApi2();
		
		return result;
	}
	
	/**
	 * 기능 3 수행 controller method
	 * */
	@RequestMapping(value = "/api3", method = RequestMethod.GET)
	public String getApi3(HttpServletRequest request, HttpServletResponse response) {
		
		result = apiService.selectApi3();
		
		return result;
	}

	/**
	 * 기능 4 pathVariable 수행 controller method
	 * */
	@RequestMapping(value = "/api4/{brName}", method = RequestMethod.GET)
	public String getApi4Path(HttpServletRequest request, HttpServletResponse response
				,@PathVariable("brName") String brNm) throws Exception {
		
		result = apiService.selectApi4(brNm);
		
		return result;
	}
	
	/**
	 * 기능 4 parameter 수행 controller method
	 * */
	@RequestMapping(value = "/api4", method = RequestMethod.GET)
	public String getApi4Param(HttpServletRequest request, HttpServletResponse response
				,@RequestParam("brName") String brNm) throws Exception {
		
		result = apiService.selectApi4(brNm);
		
		return result;
	}
}
