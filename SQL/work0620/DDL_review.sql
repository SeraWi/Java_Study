--2021/06/20
--DDL복습


-- DDL:데이터 정의어
-- 테이블 생성: create table
-- 테이블 수정: alter table
-- 테이블 삭제 : drop table

create table emp01(
empno number(4),
ename varchar2(20),
sal number(6,2)
);
select * from emp01;

-- 기존 테이블 복사하기
create table emp02
as
select * from emp;

create table emp03
as
select empno, ename, sal from emp;

create table emp04
as
select * from emp where deptno = 30;

-- 기존 테이블의 구조만 가져오기
create table emp05
as
select * from emp where 1= 0; -- 모든 행이 false

select * from emp05;

-------------------------------------------------------------------------------
--테이블의 변경 alter table
-- alter table 테이블 이름 add, modify, drop

--emp01테이블에 job 컬럼을 추가해보자
alter table emp01
add(job varchar2(9));
desc emp01;

--job 컬럼의 사이즈를 수정하자
alter table emp01
modify(job varchar2(30) not null);
desc emp01;

--테이블 삭제
drop table emp01;

--모든행을 삭제하는 truncate :롤백이 안된다
-- 스키마만 남는다
create table emp01
as
select * from emp;

select * from emp01;
truncate table emp01;

--테이블의 이름 변경
-- rename 현재 일므 to 새로운 이름
rename emp01 to test;
drop table test;

------------------------------------------------------------------------------
drop table emp02;
create table emp02(
empno number(4) primary key,
ename varchar2(20) not null,
sal number(6,2) check (sal > 500 and sal <5000),
job varchar(20) default '미지정',
deptno number references dept(deptno) -- dept를 참조
);
desc emp02;
insert into emp02(empno, ename, sal, job) values(1000, 'son',3000,'manager');
insert into emp02(empno, ename, sal) values(2000, 'son2',3000);
insert into emp02(empno, ename, sal, job, deptno) values(3000, 'son2',3000,'manager',40);
insert into emp02(empno, ename, sal, job, deptno) values(4000, 'son3',3000,'manager',50);
select *  from emp02;

-------------------------------------------------------------------------------
-- 제약 사항 정의
drop table emp02;
create table emp02(
empno number(4) constraint emp02_empno_pk primary key,
ename varchar2(20) constraint emp02_ename_nn not null,
sal number(6,2) constraint emp02_sal_ck check(sal > 500 and sal <5000),
job varchar2(20) default '미지정',
deptno number constraint emp02_deptno_fk references dept(deptno)
);
insert into emp02(empno, ename, sal, job, deptno)
values (1000,'son',3000,'manager',40);
select * from emp02;

