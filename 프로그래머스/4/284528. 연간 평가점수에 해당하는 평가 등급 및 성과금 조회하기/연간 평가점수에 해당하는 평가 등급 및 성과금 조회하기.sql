-- 코드를 작성해주세요
WITH CTE AS (SELECT EMP_NO,
         AVG(SCORE),
         CASE 
            WHEN AVG(SCORE) >= 96 THEN 'S'
            WHEN AVG(SCORE) >= 90 THEN 'A'
            WHEN AVG(SCORE) >= 80 THEN 'B'
            ELSE 'C'
         END AS 'GRADE',
        CASE 
            WHEN AVG(SCORE) >= 96 THEN 0.2
            WHEN AVG(SCORE) >= 90 THEN 0.15
            WHEN AVG(SCORE) >= 80 THEN 0.1
            ELSE 0
         END AS 'BONUS'
         FROM HR_GRADE
GROUP BY EMP_NO)
SELECT H.EMP_NO, EMP_NAME, GRADE, H.SAL*BONUS AS BONUS FROM HR_EMPLOYEES AS H
LEFT JOIN CTE USING(EMP_NO)
ORDER BY H.EMP_NO ASC;