--2021-07-18
--프로그래머스
--이름이 있는 동물의 아이디
--동물 보호소에 들어온 동물 중, 이름이 있는 동물의 ID를 조회하는 SQL 문을 작성해주세요. 
--단, ID는 오름차순 정렬되어야 합니다.
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
ORDER BY ANIMAL_ID ASC;

--입양 게시판에 동물 정보를 게시하려 합니다. 
--동물의 생물 종, 이름, 성별 및 중성화 여부를 아이디 순으로 조회하는 SQL문을 작성해주세요. 
--이때 프로그래밍을 모르는 사람들은 NULL이라는 기호를 모르기 때문에, 
--이름이 없는 동물의 이름은 "No name"으로 표시해 주세요.
SELECT ANIMAL_TYPE, NVL(NAME,'No name'), SEX_UPON_INTAKE
FROM ANIMAL_INS
order by ANIMAL_ID ASC;

--천재지변으로 인해 일부 데이터가 유실되었습니다. 
--입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성해주세요.
SELECT o.animal_id, o.name
from animal_ins i, animal_outs o
where i.animal_id(+) = o.animal_id
and i.animal_id is null
order by animal_id;

--관리자의 실수로 일부 동물의 입양일이 잘못 입력되었습니다. 
--보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문을 작성해주세요. 
--이때 결과는 보호 시작일이 빠른 순으로 조회해야합니다.
SELECT i.animal_id, i.name
from animal_ins i, animal_outs o
where i.animal_id = o.animal_id 
and i.datetime > o.datetime
order by i.datetime;

--아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 
--보호 시작일을 조회하는 SQL문을 작성해주세요. 
--이때 결과는 보호 시작일 순으로 조회해야 합니다.

--풀이 
-- ins에는 있지만 outs에는 없다 ->아직 입양 못감
-- 그 중에서 datetime이 가장 옛날인 동물
 
-- 내풀이 틀림
select *
from (select i.animal_id, i.datetime
      from animal_ins i, animal_outs o
      where i.animal_id = o.animal_id
      order by i.datetime asc)
where rownum <4;

-- 다른 풀이
SELECT *
  FROM (
        SELECT NAME
             , DATETIME
          FROM ANIMAL_INS
         WHERE ANIMAL_ID NOT IN (SELECT ANIMAL_ID FROM ANIMAL_OUTS)
         ORDER BY DATETIME ASC
       )
 WHERE ROWNUM <= 3
;


--보호소에서 중성화 수술을 거친 동물 정보를 알아보려 합니다. 
--호소에 들어올 당시에는 중성화1되지 않았지만,
--보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문을 작성해주세요.

-- animal_ins에서는 intact
-- animal_outs에서는 spayed or neutered 

select o.animal_id, o.animal_type, o.name
from animal_outs o, animal_ins i
where o.animal_id = i.animal_id
and (o.sex_upon_outcome like 'Spayed%'
or o.sex_upon_outcome like 'Neutered%')
and i.sex_upon_intake like 'Intact%';

--동물 보호소에 들어온 동물 중 이름이 Lucy, Ella, Pickle, Rogan, Sabrina, Mitty인 
--동물의 아이디와 이름, 성별 및 중성화 여부를 조회하는 SQL 문을 작성해주세요.

-- animal_ins 중 이름 조회
SELECT animal_id, name, sex_upon_intake
from animal_ins
where name in ('Lucy','Ella','Pickle','Rogan','Sabrina','Mitty')
order by animal_id asc;



