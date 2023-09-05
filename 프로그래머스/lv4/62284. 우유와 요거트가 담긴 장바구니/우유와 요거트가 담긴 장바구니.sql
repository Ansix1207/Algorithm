-- 코드를 입력하세요
SELECT cart_id  from cart_products where name = 'Yogurt' and cart_id IN(select cart_id from cart_products where name = 'Milk')