-- 코드를 입력하세요
SELECT USER_ID,NICKNAME, CONCAT(CITY,' ', STREET_ADDRESS1,' ',STREET_ADDRESS2) AS 전체주소
, CONCAT(SUBSTR(TLNO,1,3),'-',SUBSTR(TLNO,4,4),'-',SUBSTR(TLNO,8,4)) '전화번호'
from used_goods_user 
where user_id in (
    select WRITER_ID FROM USED_GOODS_BOARD GROUP BY WRITER_ID HAVING COUNT(*) >= 3
) 
order by user_id desc