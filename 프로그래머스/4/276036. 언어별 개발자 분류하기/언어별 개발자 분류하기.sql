-- 코드를 작성해주세요
# select * from developers
# where skill_code &&
# (select sum(code) from skillcodes where name in ('C++'))
WITH FE AS 
    (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End')
, GRADES AS 
    (SELECT CASE 
        WHEN SKILL_CODE & (SELECT * FROM FE) 
            AND SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'Python')
        THEN 'A'
        WHEN SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#')
        THEN 'B'
        WHEN SKILL_CODE & (SELECT * FROM FE)
        THEN 'C'
     END AS GRADE, ID, EMAIL FROM DEVELOPERS
    )

SELECT GRADE, ID, EMAIL FROM GRADES WHERE GRADE IS NOT NULL
ORDER BY GRADE,ID