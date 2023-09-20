-- 코드를 입력하세요
SELECT i.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, round(avg(review_score),2) as SCORE
from rest_info i, rest_review r where i.address LIKE '서울%' and i.rest_id= r.rest_id group by rest_id order by SCORE desc,favorites desc;