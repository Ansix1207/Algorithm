-- 코드를 작성해주세요
select id, 
    CASE
        WHEN SIZE_OF_COLONY > 1000 
        THEN 'HIGH'
        WHEN SIZE_OF_COLONY <=100    
        THEN 'LOW'
        ELSE 'MEDIUM'
        END AS SIZE
    FROM ECOLI_DATA
    ORDER BY ID
