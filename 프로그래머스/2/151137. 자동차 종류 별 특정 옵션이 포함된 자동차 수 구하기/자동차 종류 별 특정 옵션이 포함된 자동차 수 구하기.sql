-- 코드를 입력하세요
SELECT car_type, count(*)as cars FROM CAR_RENTAL_COMPANY_CAR 
WHERE OPTIONS REGEXP '가죽시트|통풍시트|열선시트'
GROUP BY CAR_TYPE order by car_type