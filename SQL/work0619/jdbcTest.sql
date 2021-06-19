--2021.06.19
--JDBC test


select *from dept order by dname;

select * from dept where deptno = 10;

select e.empno, e.ename, e.job, e.sal, d.dname,d.loc
from emp e, dept d
where e.deptno = d.deptno;

create table dept01
as select * from dept where 1= 0;
select * from dept01;
-- dept01테이블에 deptno에 입력할 일련 번호 ->sequence
create sequence dept01_deptno_seq
start with 10
increment by 10;

insert into dept01 values(dept01_deptno_seq.nextval, dev, seoul);


select * from dept01;
select * from dept;