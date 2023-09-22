-- 코드를 입력하세요
# SELECT
#   car_id,
#   count(car_id),
#   day(start_date)
#   ,day(end_date)
#  # (day(start_date) - day(end_date)) / COUNT(*) AS average_duration
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# GROUP BY car_id ;
# GROUP BY car_id order by average_duration desc, car_id desc;

SELECT CAR_ID,    
# ROUND(AVG(DATEDIFF(END_DATE,START_DATE)+1), 1) AS AVERAGE_DURATION 
ROUND(((SUM(DATEDIFF(END_DATE,START_DATE)) / COUNT(*)) +1), 1) AS AVERAGE_DURATION 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY GROUP BY CAR_ID HAVING AVERAGE_DURATION>=7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC;