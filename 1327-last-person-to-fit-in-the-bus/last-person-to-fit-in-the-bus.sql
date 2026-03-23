# Write your MySQL query statement below
select person_name 
from (
    select person_name, sum(weight) over (order by turn) as tweight 
    from Queue
) as rt
where tweight <= 1000
order by tweight desc
limit 1;