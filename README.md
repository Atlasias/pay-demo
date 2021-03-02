[프로젝트 구성]
FRAMEWORK : SPRING BOOT
DATABASE : H2
           schema 스크립트 위치 : src/main/resources > schema.sql
BUILD : MAVEN
SERVER : EMBEDDED TOMCAT
SQL : MYBATIS
      mapper 경로 : src/main/resources > mapper

[실행방법]
	[ZIP FILE]
		압축파일을 풀고 난뒤 eclipse에서 File > Open Projects From File System... 클릭 후 압축이 풀린 폴더를 지정하여 project import
		
	[GITHUB]
		[https://github.com/Atlasias/pay-demo.git] 경로상의 프로젝트를 로컬로 checkout 받아서 이용
		
		eclipse 에서 import 후 [Boot Dashboard] 탭에서 demo 실행
		    ※해당 프로젝트 실행이 없으면 프로젝트 우클릭 > run as > Run Configurations 클릭 > 좌측 항목 중에 Spring Boot App 클릭 > Main type에 [com.pay.Application] 기입 후 하단의 Run 버튼 실행
		
[API 호출] 
	URL([url]은 실행되는 url + port, 기본: localhost:8080)
	
		기능 1번: [url]/api/api1
	    기능 2번: [url]/api/api2
	    기능 3번: [url]/api/api3
	    기능 4번: 
	           (1) [url]/api/api4/{brName}, url parameter 값 입력
			   (2) [url]/api/api4, header parameter에 brName 추가
			   
[테스트 실행] 
	src/test/java > com.pay.api.controller.ApiControllerTest 우클릭 > run as > JUnit Test 클릭


[API 해결방법]

	(1) 취소 거래가 'Y'인 경우 일치하는 일자의 거래번호와 -SUM 해야하는지 불분명하여 'Y'인 항목은 제외하고 계산하였음.
	(2) 자료구조를 json 변환하기 위해 Gson을 사용하였음.
	(3) 기능1,기능2,기능3은 조회조건이 따로 없어 api상으로도 parameter없이 동작
	(4) 기능3의 response json 구문을 생성하기 위해 domain에 Api3,Api3Detail 객체를 구현하여 json을 생성
	(5) 기능4의 error handling은 custom exception인 BrNotFoundException을 구현, ExceptionController로 에러문구 생성.
		에러구문은 json format에 맞출수 없어 약간의 수정을 통해 구현
	(6) 거래내역 정보 table : DEAL_HIST, 계좌 정보 table : ACC_HIST,관리점 정보 table : BR_HIST 로 구성