--2021.06.20  
--JOIN 복습

--non equi join
-- 동등 비교가 아닌 크다 작다와 같은 비교로 조인의 조건을 작성
select *
from emp e, salgrade s
order by e.ename;

select * from salgrade;
-- sal에 따라 등급 알아보기
select e.ename, e.sal, s.grade, s.losal, s.hisal
from emp e, salgrade s
where sal between s.losal and s.hisal
order by e.ename;

-- ANSI CROSS JOIN
select * 
from emp cross join dept;

-- 구매내역(orders), 구매자 이름(customer), 책이름(book)
select o.orderid, c.name, b.bookname
from orders o, customer c, book b
where o.custid = c.custid and o.bookid = b.bookid
order by o.orderid;

-- ANSI Inner JOIN
--ORACLE equi join과 같다
select  *
from emp, dept
where emp.deptno = dept.deptno;

--ANSI
select *
from emp e inner join dept d
on e.deptno = d.deptno;

--이름이 SCOOTT인 사람의 부서명 출력
--EQUI
select e.ename, d.dname
from emp e , dept d
where e.deptno = d.deptno and e.ename ='SCOTT';
--ANSI
select *
from emp e inner join dept d
on e.deptno = d.deptno
where e.ename ='SCOTT';

--비교하는 컬럼의 이름이 같을 때
--on 절을 생략하고 ->using을 이용하면 조건식을 간략하게 처리할 수 있다.
select *
from emp e inner join dept d
--on e.deptno = d.deptno
using(deptno)
where e.ename ='SCOTT';

--NATURAL JOIN
select *
from emp natural join dept;

--SELF JOIN
select e.empno, e.ename, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno(+);
-- null값을 가지는 위치에 (+)

--OUTER JOIN
select e.ename, e.mgr,m.ename as "관리자"
from emp e left outer join emp m
on e.mgr = m.empno;

--회원별
select c.name, count(o.orderid)as "구매횟수", avg(saleprice)
from orders o, customer c
where o.custid(+) = c.custid
group by c.name;

-----------------------------------------------------------------
-- sub query
-- 스칼라 부속 질의 :select 절 이후에 사용
-- 단일 행 단일 열 값이 사용된다. 
select * from orders;

select o.custid, (select c.name
                    from customer c
                    where o.custid = c.custid) as "name"
from orders o;

--emp 테이블만 사용해서 사원이름과 부서이름을 출력
select e.ename, (select d.dname
                 from dept d
                 where e.deptno = d.deptno) as "dname"
from emp e;

-- 마당서점의 고객별 판매액을 보이시오
select c.name , sum(o.saleprice) as "판매액"
from orders o , customer c
where o.custid = c.custid
group by c.name;
--sub query
select custid, (select name 
                from customer c
                where o.custid = c.custid) as "이름",
                sum(o.saleprice) as "구매액"
from orders o
group by custid;

--인라인 뷰:from 절 뒤에서 사용되는 부속 질의
--고객 번호가 2이하인 고객의 판매액을 보이시오

select * from customer where custid <= 2;

select o.custid, c.name, sum(o.saleprice)
from (select * from customer where custid <= 2) c, orders o
where c.custid = o.custid
group by o.custid, c.name;

--중첩 질의 :where 절 뒤에 사용하는 부속 질의
-- 평균 급여보다 더 많은 급여를 받는 사원을 검색
select * 
from emp
where sal > (select avg(sal) from emp)
order by sal;

--평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오
select orderid, saleprice
from orders
where saleprice < (select avg(saleprice) from orders);

-- 3000이상 받는 사원이 소속된 부서(10번, 20번)와 동일한 부서에서 근무하는 사원 리스트 출력
select *
from emp
where sal >= 3000;

select * 
from emp 
where deptno in(select distinct deptno from emp where sal > = 3000);

-- 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액
select sum(saleprice)
from orders
where 대한민국에 거주하는 고객 아이디;

select custid
from customer
where address like '%대한민국%';

select sum(saleprice)
from orders
where custid in (select custid from customer where address like '%대한민국%');


--3번 고객이 주문한 도서의 최고 금액보다
-- 더 비싼 도서를 구입한 주문의 주문번호와 금액을 보이시오. 

select orderid, saleprice
from orders
where saleprice > 3번 고객이 주문한 도서의 최고 금액;

select max(saleprice)
from orders
where custid = 3;

select orderid, saleprice
from orders
where saleprice > (select max(saleprice) from orders where custid = 3);

--ALL
select *
from orders
where saleprice > all( select saleprice from orders where custid = 3);

--EXISTS 연산자로 대한민국에 거주하는 고객에게
--판매한 도서의 총 판매액을 구하시오.

select sum(saleprice)
from orders
where 대한민국에 거주하는 고객;

select sum(saleprice)
from orders o
where exists(
        select *
        from customer c
        where o.custid = c.custid
        and c.address like '%대한민국%');
        
