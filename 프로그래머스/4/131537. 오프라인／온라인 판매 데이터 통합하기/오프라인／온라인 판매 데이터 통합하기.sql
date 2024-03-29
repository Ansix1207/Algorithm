-- 코드를 입력하세요

# SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') as sales_date, product_id, 
# IFNULL(user_id,NULL) AS USER_ID, sales_amount 
# from online_sale where MONTH(SALES_DATE) = 3
# UNION ALL
# SELECT SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT FROM OFFLINE_SALE WHERE MONTH(SALES_DATE) = 3
# ORDER BY SALES_DATE ASC, PRODUCT_ID ASC, USER_ID ASC ;



SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') as SALES_DATE, 
PRODUCT_ID,
IF(USER_ID IS NULL, NULL,USER_ID) as USER_ID,
SALES_AMOUNT FROM ONLINE_SALE WHERE MONTH(SALES_DATE) = 3
UNION ALL
SELECT SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT 
FROM OFFLINE_SALE WHERE MONTH(SALES_DATE) = 3
ORDER BY SALES_DATE ASC, PRODUCT_ID ASC, USER_ID ASC;