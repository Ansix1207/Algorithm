WITH MAX_SIZE AS (
SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR, MAX(SIZE_OF_COLONY) AS MAX_SIZE FROM ECOLI_DATA
GROUP BY YEAR
)
SELECT MS.YEAR, (MS.MAX_SIZE - SIZE_OF_COLONY) AS YEAR_DEV, ID FROM ECOLI_DATA
LEFT JOIN MAX_SIZE MS ON (YEAR(DIFFERENTIATION_DATE) = YEAR)
ORDER BY 1 ASC, 2 ASC