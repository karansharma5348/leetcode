# Write your MySQL query statement below
select s.product_id,T.first_year,s.quantity,s.price
from Sales s
left join
(select product_id ,min(year) as first_year
from Sales group by 
product_id) T
on s.product_id=T.product_id
where s.year=T.first_year;
