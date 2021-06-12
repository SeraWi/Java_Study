--2021.06.12
-- Function01

--function: 단일행 함수, 집합(다중행)함수
--단일행 함수: 하나의 행이 포함하는 특정 컬럽의 값 하나를 처리하고 반환
--다중행(집합)함수: 여러 행의 특정 값들을 대상으로 연산하고 반환

--숫자함수
select 'Oracle'
from dual;

select *
from dual;

--abs():절대값을 구한다.
select abs(10),abs(-10)
from dual;
--결과 10,10

select floor(15.7)
from dual;

-- 반올림
select round(15.193,1), round(15.193,-1)
from dual;
--결과 15.2, 20

--버림
select trunc(15.79,1)
from dual;
--결과 15.7

--나눈 나머지
select mod(11,4)
from dual;

--사원들의 급여
select sal, mod(sal,2)
from emp
where mod(sal,2) =1;

--문자함수
--concat(문자, 문자)->''||''
select concat('abc','defg')
from dual;

--substr:문자열 추출
--substr(문자열, 시작위치, 길이)
select substr('apple',1,3)
from dual;

select substr('apple',-3)
from dual;

--replace :특정 문자열(패턴), 다른 문자열(패턴)으로 변경
select replace('JACK and JUE','J','BL')
from dual;
--결과 black and blue

select replace('JACK and JUE','J','**')
from dual;
--결과 **ACK and **UE

--오늘날짜!
select sysdate
from dual;
