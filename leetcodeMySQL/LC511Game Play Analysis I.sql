use leetcode;
Create table If Not Exists Activity (player_id int, device_id int, event_date date, games_played int);
Truncate table Activity;
insert into Activity (player_id, device_id, event_date, games_played) values ('1', '2', '2016-03-01', '5');
insert into Activity (player_id, device_id, event_date, games_played) values ('1', '2', '2016-05-02', '6');
insert into Activity (player_id, device_id, event_date, games_played) values ('2', '3', '2017-06-25', '1');
insert into Activity (player_id, device_id, event_date, games_played) values ('3', '1', '2016-03-02', '0');
insert into Activity (player_id, device_id, event_date, games_played) values ('3', '4', '2018-07-03', '5');


-- Write an SQL query that reports the first login date for each player.
select tb1.player_id, min(tb1.event_date) first_login from Activity tb1
group by tb1.player_id;

select tb2.player_id, tb2.event_date as first_login from 
(select tb1.player_id, tb1.event_date, rank() over (partition by tb1.player_id order by tb1. event_date) 
ranking from Activity tb1) as tb2 where ranking = 1; -- ranking as alis need to put out of the select

select distinct tb1.player_id, min(tb1.event_date) over (partition by tb1.player_id) first_login from Activity tb1;

-- Write a SQL query that reports the device that is first logged in for each player.
select player_id, device_id from Activity where (player_id, event_date) in -- assume only one combination, like primary key
(select player_id, min(event_date) from Activity group by player_id); 