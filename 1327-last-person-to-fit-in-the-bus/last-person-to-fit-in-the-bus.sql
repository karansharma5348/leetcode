# Write your MySQL query statement below
select person_name
from Queue where turn =
(select q1.turn
from Queue q1 left join
Queue q2 on q1.turn >=q2.turn
group by q1.turn
having Sum(q2.weight) <= 1000
order by Sum(q2.weight) desc
limit 1);
