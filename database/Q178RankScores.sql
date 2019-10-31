select s.score, t.rank
from Scores s
         left join (select s1.score, @myid := @myid + 1 as rank from (select distinct (score) from Scores) s1, (SELECT @myid := 0) r order by s1.score desc) t
                   on s.score = t.score
order by s.score desc;