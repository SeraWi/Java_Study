--2021.07.15
--review
select * from book;
select * from customer;
select * from orders;


--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(5) 박지성이구매한도서의출판사수

-- 박지성의 아이디 찾기
select custid 
from customer
where name ='박지성';

-- 박지성이 구매한 도서, 출판사
select bookname,publisher
from orders natural join book
where custid =(select custid from customer where name ='박지성');

-- 박지성이 구매한 도서의 출판사의 개수 
select count(publisher)
from orders natural join book
where custid =(select custid from customer where name ='박지성');

--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
--박지성이 구매한 도서의 이름, 가격
select bookname, (price-saleprice) as pricegap
from orders natural join book
where custid =(select custid from customer where name ='박지성');

--(7) 박지성이구매하지않은도서의이름
select bookname
from orders natural join book
where custid =(select custid from customer where name ='박지성');

select bookname
from book
where bookname not in(
    select bookname
    from orders natural join book
    where custid =(select custid from customer where name ='박지성')
);

--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
--(8) 주문하지않은고객의이름(부속질의사용)

--구매한 사람들
select distinct name
from orders natural join customer;

select name
from customer
where name not in (select distinct name
                    from orders natural join customer);
                    


--(9) 주문금액의총액과주문의평균금액
--sum, avg
select sum(saleprice), avg(saleprice)
from orders;

--(10) 고객의이름과고객별구매액
select name, sum(saleprice)
from orders natural join customer
group by name;

--(11) 고객의이름과고객이구매한도서목록
select name, bookname
from orders natural join customer natural join book;

--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문
select price, saleprice, (saleprice-price) as gap
from book natural join orders;

select *
from book natural join orders
where (price-saleprice) >= all(select (price-saleprice)
    from book natural join orders);



--​(13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름
--도서의 판매액 평균
select avg(saleprice)
from orders;

-- 고객의 구매액 평균
select name, avg(saleprice)
from orders natural join customer
group by name;

-- 풀이
select name
from orders natural join customer
group by name
having avg(saleprice) > (select avg(saleprice) from orders);


--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름

--박지성이 구매한 도서의 출판사
select publisher
from customer natural join book natural join orders
where name ='박지성';

--같은 출판사에서 도서를 구매한 고객의 이름
select name
from customer natural join book natural join orders
where publisher in(select publisher 
                   from customer natural join book natural join orders
                   where name ='박지성') and
                   name !='박지성';

--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
select name
from orders natural join customer natural join book
group by name
having count(distinct publisher) >=2;






