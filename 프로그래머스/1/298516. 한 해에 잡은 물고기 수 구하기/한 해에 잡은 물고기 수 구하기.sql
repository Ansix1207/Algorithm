-- 코드를 작성해주세요
SELECT COUNT(*) as fish_count FROM FISH_INFO
WHERE DATE_FORMAT(TIME,'%Y') = '2021'