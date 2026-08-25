# Write your MySQL query statement below
select a2.employee_id,a2.name,count(a1.reports_to) as reports_count, round(avg(a1.age),0) as average_age
from Employees a1 inner join 
Employees a2 on 
a1.reports_to = a2.employee_id
group by a2.employee_id, a2.name
order by a2.employee_id;