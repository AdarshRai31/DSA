# Write your MySQL query statement below
WITH FirstYearSales AS (
    SELECT
        s.product_id,
        MIN(s.year) AS first_year
    FROM Sales s
    GROUP BY s.product_id
)
SELECT
    fys.product_id,
    fys.first_year,
    s.quantity,
    s.price
FROM FirstYearSales fys
JOIN Sales s ON fys.product_id = s.product_id AND fys.first_year = s.year
ORDER BY fys.product_id;