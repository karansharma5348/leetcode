# Write your MySQL query statement below
select e.employee_id,e.department_id
from Employee e
left join
(select employee_id,count(department_id) as num_dept
from Employee group by
employee_id) T
on e.employee_id=T.employee_id
where T.num_dept=1 
or (T.num_dept>1 and e.primary_flag = 'Y');