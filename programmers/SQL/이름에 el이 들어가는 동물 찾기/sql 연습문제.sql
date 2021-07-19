-- 2021-07-19
--EL이 들어간 이름 
--보호소에 돌아가신 할머니가 기르던 개를 찾는 사람이 찾아왔습니다. 
--이 사람이 말하길 할머니가 기르던 개는 이름에 'el'이 들어간다고 합니다.
--동물 보호소에 들어온 동물 이름 중, 이름에 "EL"이 들어가는 개의 아이디와 이름을 조회하는 SQL문을 작성해주세요. 
--이때 결과는 이름 순으로 조회해주세요. 
--단, 이름의 대소문자는 구분하지 않습니다.

-- 대소문자 구분하지 않기
-- 대문자 변환 함수 :upper()
-- 소문자 변환 함수 :lower()

SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE LOWER(NAME) LIKE LOWER('%EL%') AND ANIMAL_TYPE ='Dog'
ORDER BY NAME ASC;

-- 중성화 여부 파악하기
--보호소의 동물이 중성화되었는지 아닌지 파악하려 합니다. 
--중성화된 동물은 SEX_UPON_INTAKE 컬럼에 'Neutered' 또는 'Spayed'라는 단어가 들어있습니다. 
--동물의 아이디와 이름, 중성화 여부를 
--아이디 순으로 조회하는 SQL문을 작성해주세요.
--이때 중성화가 되어있다면 'O', 아니라면 'X'라고 표시해주세요.

SELECT ANIMAL_ID, NAME
     , CASE WHEN SEX_UPON_INTAKE LIKE 'Spayed%' 
            OR SEX_UPON_INTAKE LIKE 'Neutered%' THEN 'O'
         ELSE 'X'
         END 중성화
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

--case when
-- case when 조건식 then참일 때 값




