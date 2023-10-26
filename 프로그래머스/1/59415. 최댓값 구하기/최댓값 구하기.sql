-- 코드를 입력하세요
SELECT MAX(datetime) as "time" from animal_ins;

SELECT DATETIME as "time" FROM ANIMAL_INS WHERE DATETIME = (SELECT MAX(DATETIME) FROM ANIMAL_INS);