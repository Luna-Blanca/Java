/*
테이블명 : ANIMAL
컬럼 : ANIMAL_ID (아이디)
    , ANIMAL_TYPE (생물종)
    , DATETIME (보호시작일)
    , INTAKE_CONDITION (보호시작시 상태)
    , NAME (이름)
    , SEX_UPON_INTAKE (성별 및 중성화)
문제 : ANIMAL테이블에서 INTAKE_CONDITION(보호시작시상태가) Aged(늙은)이 아닌 모든 동물들의 ID와 이름을 ID순으로 조회해보시오.
*/

SELECT ANIMAL_ID
        , NAME 
FROM ANIMAL
WHERE INTAKE_CONDITION != 'Aged'
ORDER BY ANIMAL_ID ;