package com.pay.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApiMapper {

	/**
	 * 기능 1 조회
	 * */
	List<Map<String, Object>> selectApi1();

	/**
	 * 기능 2 조회
	 * */
	List<Map<String, Object>> selectApi2();

	/**
	 * 기능 3 조회
	 * */
	List<Map<String, Object>> selectApi3();
	
	/**
	 * 기능 4 검증
	 * @param brName : 관리점 명
	 * */
	Map<String, Object> checkApi4(String brName);

	/**
	 * 기능 4 조회
	 * @param params : 관리점 정보가 저장된 파라미터 map
	 * */
	List<Map<String, Object>> selectApi4(Map<String, Object> params);

}