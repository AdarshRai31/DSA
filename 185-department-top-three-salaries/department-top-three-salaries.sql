# Write your MySQL query statement below
WITH RankedSalary AS (
    SELECT 
        d.name AS Department, 
        e.name AS Employee, 
        e.salary AS Salary,
        DENSE_RANK() OVER (
            PARTITION BY e.departmentId 
            ORDER BY e.salary DESC
        ) as SalaryRank
    FROM Employee e
    JOIN Department d 
    ON e.departmentId = d.id
)
select Department, Employee, Salary 
from  RankedSalary
where SalaryRank <= 3;