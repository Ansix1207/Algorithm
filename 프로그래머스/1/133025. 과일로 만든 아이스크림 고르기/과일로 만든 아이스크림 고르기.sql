-- 코드를 입력하세요
-- 상반기 아이스크림 총 주문량이 3,000 보다 높아야 함.
-- 아이스크림 성분이 과일(fruit_based)인 아이스크림의 맛을
-- 총 주문량이 큰 순서대로 Order
SELECT FH.flavor from FIRST_HALF FH
LEFT JOIN ICECREAM_INFO II ON FH.FLAVOR = II.FLAVOR
WHERE INGREDIENT_TYPE ='fruit_based' AND TOTAL_ORDER >= 3000
ORDER BY TOTAL_ORDER DESC