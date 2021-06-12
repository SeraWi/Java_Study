--2021.06.12
--function02

--변환함수
--형변환 함수
--날짜 -> 문자, 숫자->문자
--to_char(날짜 데이터,'패턴'), to_char(숫자,'패턴')

select sysdate, to_char(sysdate,'YYYY.MM.DD. HH24:MI:SS')
from dual;
--결과2021.06.12. 14:53:04

select ename, hiredate, to_char(hiredate, 'YYYY.MM.DD.')
from emp;

select * from orders;
select orderid, orderdate, to_char(orderdate,'YYYY.MM.DD')
from orders;

--숫자->문자
select to_char(123456,'0000000000'), to_char(123456,'9999999999')
from dual;
--결과 0000123456, 123456

select to_char(123456,'0,000,000,000'), to_char(123456,'L9,999,999,999')
from dual;
--결과 0,000,123,456   123,456

select ename, sal, to_char(sal*1100, 'L999,999,999')
from emp;

--문자 -> 숫자
-- to number(문자열, 패턴)
select to_number('1,000,000', '9,999,999')
from dual;

select to_number('1000000','9999999')+1000000
from dual;

select to_number('1000000')
from dual;

--문자 ->날짜
--to_date(문자열, 패턴)
select to_date('2012.05.17','YYYY.MM.DD')
from dual;

select trunc(sysdate -to_date('2012.05.17','YYYY.MM.DD'))
from dual;

--decode 함수: 분기를 위해 사용한다. switch-case유사
--decod (컬럼, =조건1 값, 조건 1이 참일 때 사용할 값,
--            = 조건2 값, 조건 2가 참일 때 사용할 값,
--            ...)

select * 
from dept;

--10 , ACCOUNTING
--20, RESEARCH
--30,SALES
--40,OPERATIONS


