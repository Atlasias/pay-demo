/*관리점정보*/
DROP TABLE IF EXISTS BR_HIST;

CREATE TABLE BR_HIST
(
	BR_CODE VARCHAR(10) NOT NULL,
	BR_NAME VARCHAR(500)
) AS
SELECT * FROM
CSVREAD('classpath:/static/데이터_관리점정보.csv', null, 'charset=UTF-8');

/*계좌정보*/
DROP TABLE IF EXISTS ACC_HIST;

CREATE TABLE ACC_HIST
(
	ACCT_NO VARCHAR(8) NOT NULL,
	ACCT_NM VARCHAR(500) NOT NULL,
	BR_CODE VARCHAR(10) NOT NULL
) AS
SELECT * FROM
CSVREAD('classpath:/static/데이터_계좌정보.csv', null, 'charset=UTF-8');

/*거래정보*/
DROP TABLE IF EXISTS DEAL_HIST;
CREATE TABLE DEAL_HIST
(
	BIZDATE VARCHAR(8) NOT NULL,
	ACCT_NO VARCHAR(8) NOT NULL,
	USR_DEAL_NO NUMBER,
	AMT NUMBER,
	VAT NUMBER,
	CANCEL_YN CHAR(1) DEFAULT 'N'
			
) AS
SELECT * 
FROM
CSVREAD('classpath:/static/데이터_거래내역.csv', null, 'charset=UTF-8');

