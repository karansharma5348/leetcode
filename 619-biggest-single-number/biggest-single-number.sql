# Write your MySQL query statement below
select max(T.num) as num
from
(select num 
from Mynumbers group by
num having count(*)=1) T;