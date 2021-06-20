--2021.06.20
--DML

drop table dept01;
create table dept01
as
select * from dept where 1 =0;


desc dept01;
insert into dept01 (deptno, dname, loc)
values(10,'개발팀','서울');
select * from dept01;

insert into dept01 values (20, '마케팅','부산');

drop table dept02;
create table dept02
as
select * from dept where 1=0;
select * from dept02;

--dept 정보를 dept02로 넣기
insert into dept02
select * from dept;

---------------------------------------------------------------------
--데이터를 변경
--UPDATE

create table dept03
as select * from dept;

select * from dept03;

--모든 부서를 seoul로 변경
update dept03
set loc = 'seoul';
rollback;

-- 10번 부서의 위치를 busan으로 변경, 부서이름도 dev로 변경
update dept03
set loc ='busan' , dname = 'dev'
where deptno = 10;

-- 서브 쿼리를 이용한 데이터 수정
--  20번 부서의 지역명을 40번 부서의 지역명으로 변경
update dept01
set loc = (select loc from dept01 where deptno = 40)
where deptno =20;
rollback;
select * from dept01;

-- 부서번호가 20인 부서의 부서명과 지역명을 
--부서번호가 10번인 부서와 동일하게 변경
update dept01
set (dname,loc) = (select dname,loc from dept01 where deptno = 10)
where deptno = 20;

select * from dept01;
-----------------------------------------------------------------------------
--데이터의 삭제:행단위 삭제
-- delete from 테이블명 where 조건;

--dept01데이터 모두 삭제
delete from dept01;
select * from dept01;

create table emp01
as select * from emp;

--이름이 SCOTT인 사원을 삭제
delete from emp01
where ename ='SCOTT';

select *from emp01;




