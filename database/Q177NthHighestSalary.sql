CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    RETURN (
        # Write your MySQL query statement below.
        select case
                   when (select count(distinct (Salary)) from Employee) < N then null
                   else
                       (select ds from (select distinct(Salary) as ds from Employee order by ds desc limit 0, N) as T order by ds limit 0,1)
                   end
        from dual
    );
END