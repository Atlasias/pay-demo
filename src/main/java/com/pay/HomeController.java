package com.pay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/")
public class HomeController {
	private final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response) {
		logger.info("hi this is main");
		return "hello world!";
	}
		
}
