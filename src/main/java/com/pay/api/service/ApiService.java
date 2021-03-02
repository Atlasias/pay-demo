package com.pay.api.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.pay.api.domain.Api3;
import com.pay.api.domain.Api3Detail;
import com.pay.api.mapper.ApiMapper;
import com.pay.exception.exceptions.BrNotFoundException;

@Service
public class ApiService {
	
	private final Logger logger = LoggerFactory.getLogger(ApiService.class);
	
    @Autowired
    private ApiMapper apiMapper;
    
    /**
     * JSON 변환 library
     * */
    private Gson gson = new Gson();
    
    /**
     * 기능 1 수행 method
     * */
	public String selectApi1() {
		
    	List<Map<String,Object>> list = apiMapper.selectApi1();
		
    	String jsonString = gson.toJson(list);
    	return jsonString;
	}
	
	/**
     * 기능 2 수행 method
     * */
	public String selectApi2() {
    	List<Map<String,Object>> list = apiMapper.selectApi2();
		
    	String jsonString = gson.toJson(list);
    	return jsonString;
	}
	
	/**
     * 기능 3 수행 method
     * */
	public String selectApi3() {
    	List<Map<String,Object>> mapperList = apiMapper.selectApi3();
		
    	List<Api3> api3List = new LinkedList<>();//api3 results
    	
    	//기능3의 return json format에 맞추기 위해 가공
    	for(int i=0; i<mapperList.size();i++) {
    		
    		Map<String,Object> dataMap = mapperList.get(i);
    		
    		String tempYear = (String) dataMap.get("year");
    		
    		boolean insertFlag = false;
    		
    		for(int j=0; j<api3List.size();j++) {
    			
    			Api3 api3 = api3List.get(j);
    			
    			String api3Year = api3.getYear();
    			
    			if(null != api3Year && api3Year.equals(tempYear)) {
    				List<Api3Detail> dataList = api3.getDataList();
    				
    				if(dataList == null) {
    					dataList = new LinkedList<>();
    				}
    				
    				Api3Detail detail = new Api3Detail();
    				
    				detail.setBrCode((String) dataMap.get("brCode"));
        			detail.setBrName((String) dataMap.get("brName"));
        			detail.setSumAmt(Long.valueOf(String.valueOf(dataMap.get("sumAmt"))));
        			
        			dataList.add(detail);
        			
        			api3.setDataList(dataList);
        			api3List.remove(j);
        			api3List.add(j,api3);
    				insertFlag = true;
    				break;
    			}
    		}
    		
    		if(!insertFlag) {
    			Api3 api3 = new Api3();
    			api3.setYear(tempYear);
    			List<Api3Detail> dataList = new LinkedList<>();
				
				Api3Detail detail = new Api3Detail();
				
				detail.setBrCode((String) dataMap.get("brCode"));
    			detail.setBrName((String) dataMap.get("brName"));
    			detail.setSumAmt(Long.valueOf(String.valueOf(dataMap.get("sumAmt"))));
    			dataList.add(detail);
    			
    			api3.setDataList(dataList);
    			api3List.add(api3);
    			
    		}
    	}
    	
    	String jsonString = gson.toJson(api3List);
    	return jsonString;
	}
	
	/**
     * 기능 4 검증 method
     * */
	public Map<String,Object> checkApi4Group(String brNm){
		
		return apiMapper.checkApi4(brNm);
	}
	
	/**
     * 기능 4 수행 method
     * */
	public String selectApi4(String brNm) throws Exception {
		
		if("분당점".equals(brNm) ) {
			throw new BrNotFoundException("br code not found error");
		}
		
		Map<String, Object> chkResultMap = checkApi4Group(brNm);
		
		if(chkResultMap== null) {
			throw new BrNotFoundException("br code not found error");
		}
		
    	List<Map<String,Object>> list = apiMapper.selectApi4(chkResultMap);
    	String jsonString = gson.toJson(list);
    	return jsonString;
	}
}