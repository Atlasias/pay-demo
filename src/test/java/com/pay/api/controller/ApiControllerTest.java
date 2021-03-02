package com.pay.api.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.google.gson.Gson;
import com.pay.Application;
import com.pay.api.service.ApiService;
import com.pay.exception.BrNotFoundException;

@DisplayName("API CONTROLLER TEST")
//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureMybatis 
@AutoConfigureMockMvc
public class ApiControllerTest {
	private static final Logger logger = LoggerFactory.getLogger(ApiControllerTest.class);
	
	@Autowired
	private MockMvc mvc;
	
	Gson gson = new Gson();
	
	//@Rule
    //public ExpectedException thrown = ExpectedException.none();
    
    @Autowired
    private ApiService apiService;

    @BeforeTestExecution
    void beforeTest() {
    	logger.info("================= test start ===============");
    }
    
    @DisplayName("API1 URL TEST")
    @Test
    void api1UrlTest() throws Exception {
    		
    	try {
			
			 final ResultActions actions = mvc.perform(get("/api/api1")
			 .contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"));
			 
			 actions 
			 .andDo(print()) 
			 .andExpect(status().isOk());
			         	
        	
    	}catch(Exception e) {
    		throw e;
    	}
        ;
		
	}
    
    @DisplayName("API2 URL TEST")
    @Test
    void api2UrlTest() throws Exception {
    	try {
    	final ResultActions actions = mvc.perform(get("/api/api2")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"));
        
    	actions
        .andDo(print())
        .andExpect(status().isOk());
    	
    	}catch(Exception e) {
    		throw e;
    	}
	}
    
    @DisplayName("API3 URL TEST")
    @Test
    void api3UrlTest() throws Exception {
    	try {
    	final ResultActions actions = mvc.perform(get("/api/api3")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"));
        
    	actions
        .andDo(print())
        .andExpect(status().isOk())
        ;
    	}catch(Exception e) {
    		throw e;
    	}
		
	}
    
    @DisplayName("API4 URL TEST (PATH)")
	@ParameterizedTest(name="brName {0}")
	@ValueSource(strings = {"판교점","분당점","강남점","잠실점","을지로점"})
    void api4UrlTest1(String brName) throws Exception {
    	try {
    	final ResultActions actions = mvc.perform(get("/api/api4"+"/"+brName)
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"));
        
    	actions
        .andDo(print())
        .andExpect(status().isOk())
        ;
    	}catch(Exception e) {
    		if(!(e instanceof BrNotFoundException)) {
    			throw e;
    		}
    	}
		
	}
    
    @DisplayName("API4 URL TEST (HEADER PARAM)")
	@ParameterizedTest(name="brName {0}")
	@ValueSource(strings = {"판교점","분당점","강남점","잠실점","을지로점"})
    void api4UrlTest2(String brName) throws Exception {
    	try {
    	final ResultActions actions = mvc.perform(get("/api/api4")
                .contentType(MediaType.APPLICATION_JSON).param("brName", brName).characterEncoding("UTF-8"));
        
    	actions
        .andDo(print())
        .andExpect(status().isOk())
        ;
    	}catch(Exception e) {
    		if(!(e instanceof BrNotFoundException)) {
    			throw e;
    		}
    	}
		
	}
    
    @DisplayName("API1 INNER TEST")
    @Test
    void api1Test() throws Exception {
        
		String result = apiService.selectApi1();
		logger.info("api1:"+result);
		assertThat(result).isNotNull();
    	
	}
    
    @DisplayName("API2 INNER TEST")
    @Test
    void api2Test() throws Exception {
		String result = apiService.selectApi2();
		logger.info("api2:"+result);
		assertThat(result).isNotNull();
	}
    
    @DisplayName("API3 INNER TEST")
    @Test
    void api3Test() throws Exception {
		String result = apiService.selectApi3();
		logger.info("api3:"+result);
		assertThat(result).isNotNull();
	}
    
	@DisplayName("API4 INNER TEST")
	@ParameterizedTest(name="brName {0}")
	@ValueSource(strings = {"판교점","분당점","강남점","잠실점","을지로점"})
    void api4Test(String brName) throws Exception {
		String result = null;
		try {
			result = apiService.selectApi4(brName);
			logger.info("api4("+brName+"):"+result);
			assertThat(result).isNotNull();
		}catch(Exception e) {
			if(!(e instanceof BrNotFoundException)) {
    			throw e;
    		}
		}
		
	}

    
}
