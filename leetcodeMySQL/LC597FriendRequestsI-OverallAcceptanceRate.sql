use leetcode;
Create table If Not Exists friend_request ( sender_id INT NOT NULL, send_to_id INT NULL, request_date DATE NULL);
Create table If Not Exists request_accepted ( requester_id INT NOT NULL, accepter_id INT NULL, accept_date DATE NULL);
Truncate table friend_request;
insert into friend_request (sender_id, send_to_id, request_date) values ('1', '2', '2016/06/01');
insert into friend_request (sender_id, send_to_id, request_date) values ('1', '3', '2016/06/01');
insert into friend_request (sender_id, send_to_id, request_date) values ('1', '4', '2016/06/01');
insert into friend_request (sender_id, send_to_id, request_date) values ('2', '3', '2016/06/02');
insert into friend_request (sender_id, send_to_id, request_date) values ('3', '4', '2016/06/09');
insert into friend_request (sender_id, send_to_id, request_date) values ('5', '4', '2016/07/09');

Truncate table request_accepted;
insert into request_accepted (requester_id, accepter_id, accept_date) values ('1', '2', '2016/06/03');
insert into request_accepted (requester_id, accepter_id, accept_date) values ('1', '3', '2016/06/08');
insert into request_accepted (requester_id, accepter_id, accept_date) values ('2', '3', '2016/06/08');
insert into request_accepted (requester_id, accepter_id, accept_date) values ('3', '4', '2016/06/09');
insert into request_accepted (requester_id, accepter_id, accept_date) values ('3', '4', '2016/06/10');
insert into request_accepted (requester_id, accepter_id, accept_date) values ('5', '4', '2016/07/10');

# Write your MySQL query statement below
-- SELECT round(ifnull((SELECT count(*) FROM (SELECT DISTINCT requester_id, accepter_id FROM request_accepted) AS tb1) /
-- (SELECT count(*) FROM (SELECT DISTINCT sender_id, send_to_id FROM friend_request) AS tb2), 0),2) AS accept_rate; -- distinct all following colums behind



-- no subquery
 SELECT round(ifnull(((SELECT count(DISTINCT requester_id, accepter_id) FROM request_accepted) /
 (SELECT count(DISTINCT sender_id, send_to_id) FROM friend_request)), 0), 2) AS accept_rate; -- distinct all following colums behind


-- easiest way
-- contain join will lower the query speed
SELECT ifnull(round(count(DISTINCT requester_id, accepter_id) / count(DISTINCT sender_id, send_to_id), 2), 0) AS accept_rate FROM request_accepted, friend_request;


-- subquery, reference
-- select ifnull((round(accepts/requests, 2)), 0.0) as accept_rate
-- from
    -- (select count(distinct sender_id, send_to_id) as requests from friend_request) as t1,
    -- (select count(distinct requester_id, accepter_id) as accepts from request_accepted) as t2
    
    
-- Can you write a query to return the accept rate but for every month? Per month, how many accept rate
select round(c.acp/d.req,2) as accept_rate, c.month from 
 (select count(distinct requester_id, accepter_id) as acp, month(accept_date) as month from request_accepted group by month) c, 
 (select count(distinct sender_id, send_to_id) as req, Month(request_date) as month from friend_request group by month) d 
 where c.month = d.month;


-- How about the cumulative accept rate for every day?


