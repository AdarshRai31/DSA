# Write your MySQL query statement below
select w1.id from
Weather as w1
join Weather as w2
on date_add(w2.recordDate, interval 1 day) = w1.recordDate
where w1.Temperature > w2.Temperature;