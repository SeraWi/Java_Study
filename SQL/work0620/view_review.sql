--2021/06/20
--VIEW, SEQUENCE, INDEX 복습

--자주 사용되는
--30번 부서에 소속된 사원들의 사번과 이름과 부서번호를 출력하기 위한 
--select문을 하나의 뷰로 정의해 봅시다.

create or replace view emp_view30
as
select empno, ename, deptno
from emp
where deptno =30;

--뷰 보기
select * from emp_view30;

--뷰 삭제
drop view emp_view30;
------------------------------------------------------------------------------
--인라인뷰를 이용한 top3구하기

select rownum, ename
from emp
order by hiredate;

select rownum, ename
from(select * from emp order by ename);

--입사일이 빠른 사람 5명만 (TOP N)얻어오기
select rownum, ename
from (select * from emp order by hiredate)
where rownum <6;


create or replace view view_hir
as
select * from emp order by hiredate;

select * from view_hir;

select rownum, ename, hiredate
from view_hir
where rownum < 6
order by ename;

------------------------------------------------------------------------
--sequence
-- 숫자를 생성하는 객체
-- 설정을 통해 일련번호를 생성 -> 기본키가 대리키인 경우 입력되는 값으로 사용

--dept 테이블 복사 ->deptno에 들어갈 데이터 시퀀스 생성 ->insert테스트

create table dept01
as
select * from dept where 1 = 0;

--sequence생성
create sequence dept_deptno_seq
start with 10
increment by 10;

--insert
insert into dept01 values(dept_deptno_seq.nextval, 'dev','seoul');
select * from dept01;
--------------------------------------------------------------------------------
--index
--검색을 빠르게 하기위한 객체
--물리적인  저장 공간이 필요
--생성할 때 시간 필요
-- 많은 인덱스는 DML작업이 많은 경우 성능 저하 발생!!

drop table emp01;

create table emp01
as select * from emp;

insert into emp01 select * from emp01;

insert into emp01(empno, ename) values(7777,'KING');
insert into emp01(empno, ename) values(7777,'SON');

select * from emp01 where ename = 'SON';

-- emp01테이블에 ename 컬럼을 index로 설정
create index index_emp01_ename
on emp01(ename);

drop table emp01;