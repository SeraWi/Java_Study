--2021.06.15 복습
--DDL 데이터 정의어
--테이블 생성 : create table
--테이블 수정 : alter table
--테이블 삭제 : drop table


-- 사원, 테이블과 유사한 구조의 
--사원번호, 사원이름, 급여 3개의 컬럼으로 구성된
--emp01 테이블을 생성해 봅시다.

create table emp01(
    empno number(4),
    ename varchar2(20),
    sal number(6,2)
);

desc emp01;

--서브 쿼리를 이용해서 기존 테이블의 구조를 복사하고 해당 튜플도 복사
create table emp02
as
select * from emp;
desc emp02;
---------------------------------------
create table emp03
as
select empno, ename, sal from emp;

select * from emp03;
----------------------------------------
create table emp04
as
select * from emp where 1 =2; --모든 행이 false
--즉 구조만 가져온다
select * from emp04;

drop table emp04;
------------------------------------------
--테이블 변경 : alter table
-- add
-- modify
-- drop
------------------------------------------
--emp01테이블에 job컬럼을 추가해보자
alter table emp01
add(job varchar2(9));
desc emp01;
--emp01테이블에 job컬럼의 사이즈를 수정 9->30
alter table emp01
modify(job varchar2(30) not null);

-- emp01테이블의 job컬럼을 삭제
alter table emp01
drop column job;
select * from emp01;

-- 테이블 삭제
drop table emp02;

--새로운 테이블을 생성
create table emp02
as
select * from emp;
select * from emp02;

--모든행을 삭제하는 truncate:롤백이 안된다
truncate table emp02;
--결과:table emp02가 잘렸습니다/스키마만 남아있다(구조만 있다)
select * from emp02;

--테이블의 이름 변경-> reanme 현재이름 to 새로운 이름
rename emp01 to test;

drop table test;
------------------------------------------------------------------------------

create table emp02
as
select empno, ename, sal, job from emp where 1=0;
desc emp02;

insert into emp02(empno,ename,sal,job) values (null,null,10000,'MANAGER');
insert into emp02 values(null,null, 10000,'MANAGER'); --생략가능

select * from emp02;
drop table emp02;
-------------------------------------------------------------------------------

-- NOT NULL
create table emp02(
    empno number(4) not null,
    ename varchar2(20) not null,
    sal number(6,2),
    job varchar(20)
);

insert into emp02(empno,ename,sal,job) values (1000,'son',1000,'MANAGER');
select * from emp02;
drop table emp02;
-------------------------------------------------------------------------------

--UNIQUE
create table emp02(
    empno number(4) not null unique,
    ename varchar2(20) not null,
    sal number(6,2),
    job varchar(20)
);
insert into emp02(empno,ename,sal,job) values (1000,'son',1000,'MANAGER');
---------------------------------------------------------------------------------

--primary key
create table emp02(
    empno number(4) primary key,
    ename varchar2(20) not null,
    sal number(6,2),
    job varchar(20)
);

desc emp02;
-----------------------------------------------------------------------
--check/ default
create table emp02(
    empno number(4) primary key,
    ename varchar2(20) not null,
    sal number(6,2) check(sal > 500 and sal <5000),
    job varchar(20) default '미지정'
);

drop table emp02;

insert into emp02(empno, ename, sal, job) values (1000,'SON',3000,'MANAGER');
insert into emp02(empno, ename, sal) values (2000,'S',3000); 

select * from emp02;
---------------------------------------------------------------------------
-외래키
create table emp02(
    empno number(4) primary key,
    ename varchar2(20) not null,
    sal number(6,2) check(sal > 500 and sal <5000),
    job varchar(20) default '미지정',
    deptno number references dept(deptno)
);
drop table emp02;

insert into emp02(empno, ename, sal, job, deptno)
values (2000,'SON',3000,'MANAGER',50); --에러

insert into emp02(empno, ename, sal, job, deptno)
         values (2000,'SON',3000,'MANAGER',40);
         
select * from emp02;
-----------------------------------------------------------------


