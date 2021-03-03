1. [프로젝트 구성]

>1. FRAMEWORK : SPRING BOOT</br>
>2. DATABASE : H2</br>
>          -url : [jdbc:h2:mem:pay]</br>
>          -username : sa</br>
>          -password : 없음</br>
>          -schema 스크립트 위치 : src/main/resources &gt; schema.sql</br>
>3. BUILD : MAVEN</br>
>4. SERVER : EMBEDDED TOMCAT</br>
>          -기본 port : 8080</br>
>5. SQL : MYBATIS</br>
>      mapper 경로 : src/main/resources &gt; mapper</br>

2. [실행방법]
>		
>	1. [압축파일]
>		- 압축파일을 풀고 난뒤 [ECLIPSE]에서 File > [Open Projects From File System...] 클릭 후 압축이 풀린 폴더에서 [demo]폴더를 지정하여 project import
>		- [프로젝트 우클릭] > [RUN AS] > [MAVEN BUILD] 클릭
>		- eclipse 에서 import 후 [Boot Dashboard] 탭에서 demo 실행<br>
>		- ※해당 프로젝트가 [Boot Dashboard]탭에 없으면 없으면 프로젝트 우클릭 &gt; run as &gt; Run Configurations 클릭 &gt; 새창 좌측 항목 중에 Spring Boot App 클릭 &gt; Main type에 [com.pay.Application] 기입 후 하단의 Run 버튼 실행
>		
>	2. [GITHUB]
>		- [https://github.com/Atlasias/pay-demo.git] 경로상의 프로젝트를 로컬로 내려 받아서 이용
>		- eclipse 에서 import 후 [Boot Dashboard] 탭에서 demo 실행<br>
>		- ※해당 프로젝트가 [Boot Dashboard]탭에 없으면 없으면 프로젝트 우클릭 &gt; run as &gt; Run Configurations 클릭 &gt; 새창 좌측 항목 중에 Spring Boot App 클릭 &gt; Main type에 [com.pay.Application] 기입 후 하단의 Run 버튼 실행
>		
>	3. [JAR 파일 실행]
>		>상기 항목중 하나라도 완료가 된 경우
>		- [프로젝트 우클릭] > [RUN AS] > [MAVEN BUILD] 클릭
>		- 프로젝트 > [target] 폴더 내부에 있는 [demo.0.0.1-SNAPSHOT.jar] 파일 클릭 또는 [console]창에서 [demo.0.0.1-SNAPSHOT.jar] 가 있는 폴더로 이동 &gt; [java -jar demo.0.0.1-SNAPSHOT.jar] 입력
>		>상기 항목중 하나라도 완료하지 못한 경우
>		- 압축을 푼 폴더에서 [demo.0.0.1-SNAPSHOT.jar] 파일 클릭 또는 [console]창에서 [demo.0.0.1-SNAPSHOT.jar] 가 있는 폴더로 이동 &gt; [java -jar demo.0.0.1-SNAPSHOT.jar] 입력

3. [API 호출 경로]
>	- API 기본 설정 
>>	url : localhost:8080<br>
>>	http.GET방식<br>
	
	    기능 1번: [url]/api/api1
	    기능 2번: [url]/api/api2
	    기능 3번: [url]/api/api3
	    기능 4번: 
		(1) [url]/api/api4/{brName}, url parameter 값 입력
		(2) [url]/api/api4, header parameter에 brName 추가

4. [테스트 실행] 
>	1. [ECLIPSE] 
>		- src/test/java &gt; com.pay.api.controller.ApiControllerTest 우클릭 &gt; run as &gt; JUnit Test 클릭

5. [API 해결방법]
>
>	(0) [공통]
>> - 자료구조를 json 변환하기 위해 Gson을 사용하였음 <br>
>> - 기능1,기능2,기능3은 범위가 제한되어 있기 때문에 parameter 없이 동작 <br>
>> - 취소 구분이 'Y'인 항목은 제외하고 계산하였음 <br>
>> 
>	(1) [기능1]
>>
>	(2) [기능2]
>>
>	(3) [기능3]
>> - response json 구문을 생성하기 위해 domain에 Api3,Api3Detail 객체를 구현하여 json을 생성 <br>
>> 
>	(4) [기능4]
>> - 기능4의 error handling은 custom exception인 BrNotFoundException을 구현, ExceptionController로 에러문구 생성 <br>
>> - 제시된 에러구문은 json format만족하지 않아 약간의 수정을 통해 구현 <br>
>

6. [테이블 정의]
>
>-거래내역 정보 table : DEAL_HIST
>|컬럼명|자료형|컬럼설명|
>|------|---|---|
>|BIZDATE|VARCHAR(8)|거래일|
>|ACCT_NO|VARCHAR(8)|계좌번호|
>|USR_DEAL_NO|NUMBER|거래번호|
>|AMT|NUMBER|금액|
>|VAT|NUMBER|수수료|
>|CANCEL_YN|CHAR(1)|취소여부|
> 
>-계좌 정보 table : ACC_HIST
>|컬럼명|자료형|컬럼설명|
>|------|---|---|
>|ACCT_NO|VARCHAR(8)|계좌번호|
>|ACCT_NM|VARCHAR(500)|계좌명|
>|BR_CODE|VARCHAR(10)|관리점코드|
>
>-관리점 정보 BR_HIST
>|컬럼명|자료형|컬럼설명|
>|------|---|---|
>|BR_CODE|VARCHAR(10)|관리점코드|
>|BR_NAME|VARCHAR(500)|관리점명|
>

