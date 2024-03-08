-- 코드를 작성해주세요
SELECT EMP.DEPT_ID, DEPT_NAME_EN, ROUND(AVG(SAL)) AS AVG_SAL FROM HR_EMPLOYEES EMP 
LEFT JOIN HR_DEPARTMENT DEP USING (DEPT_ID)
GROUP BY DEPT_ID
ORDER BY AVG_SAL DESC