--2021.06.15

--Sub query 복습

--스칼라 부속질의: select절 안에서 사용, 단일행, 단일 열의 스칼라 값으로 반환

-- 마당 서점의 고객별 판매액을 보이시오(결과는 고객이름과 고객별 판매액을 출력)

select od.custid, sum(saleprice) as "TOTAL",
       (select name
        from customer c
        where c.custid = od.custid) as "NAME"
from orders od
group by od.custid;

--인라인 뷰:from절에서 사용되는 부속질의 , 테이블과 같은 형태로 사용할 수 있음
-- 부속질의 결과 반환 데이터는 다중행, 다중 열이어도 상관없음

--고객번호가 2 이하인 고객의 판매액을 보이시오(결과는 고객이름과 고객별 판매액)

select custid, sum(saleprice), 
      (select name from customer where customer.custid = orders.custid) as "고객이름"
from orders
where custid <=2
group by custid;

-- 고객번호가 2 이하


