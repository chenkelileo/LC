use leetcode;
Create table If Not Exists Scores (Id int, Score DECIMAL(3,2));
Truncate table Scores;
insert into Scores (Id, Score) values ('1', '3.5');
insert into Scores (Id, Score) values ('2', '3.65');
insert into Scores (Id, Score) values ('3', '4.0');
insert into Scores (Id, Score) values ('4', '3.85');
insert into Scores (Id, Score) values ('5', '4.0');
insert into Scores (Id, Score) values ('6', '3.65');

select Score, (dense_rank() over (order by Score desc)) from Scores; 
 -- check no partition: remember if using partition id, it will only contain 1 since it will rank in each partition;

SELECT S1.Score AS Score, (SELECT count(DISTINCT S2.Score) FROM Scores S2 WHERE S2.Score > S1.Score) + 1 AS Ranks
FROM Scores S1 
ORDER BY S1.Score DESC;

-- if to right rank function
SELECT S1.Score AS Score, (SELECT count(S2.Score) FROM Scores S2 WHERE S2.Score > S1.Score) + 1 AS Ranks
FROM Scores S1 
ORDER BY S1.Score DESC;