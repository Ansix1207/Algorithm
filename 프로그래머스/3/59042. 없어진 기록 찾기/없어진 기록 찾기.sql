-- 코드를 입력하세요
# SELECT OUTS.ANIMAL_ID, OUTS.NAME FROM ANIMAL_OUTS as OUTS
# LEFT JOIN ANIMAL_INS as INS ON OUTS.ANIMAL_ID = INS.ANIMAL_ID
# WHERE INS.ANIMAL_ID IS NULL
# ORDER BY ANIMAL_ID, NAME
-- 입양을 갔는데, 보호소에 들어온 기록이 없는 동물
SELECT OUTS.ANIMAL_ID, OUTS.NAME FROM ANIMAL_OUTS AS OUTS
LEFT JOIN ANIMAL_INS AS INS ON OUTS.ANIMAL_ID = INS.ANIMAL_ID
WHERE INS.ANIMAL_ID IS NULL
ORDER BY ANIMAL_ID, NAME