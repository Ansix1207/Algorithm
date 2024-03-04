-- 코드를 입력하세요
-- 음식 종류 별 (FOOD_TYPE)로 즐겨찾기수가 가장 많은 식당을 찾음.
-- 조회할 정보 == 음식종류(FOOD_TYPE) , ID, 식당이름(REST_NAME), 즐겨찾기수

select FOOD_TYPE, REST_ID, REST_NAME, FAVORITES 
from rest_info
where (FOOD_TYPE, FAVORITES) IN (
    SELECT FOOD_TYPE, MAX(FAVORITES)
    FROM REST_INFO
    GROUP BY FOOD_TYPE
)
ORDER BY FOOD_TYPE DESC