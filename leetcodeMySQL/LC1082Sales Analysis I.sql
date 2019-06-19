use leetcode;
Create table If Not Exists Product (product_id int, product_name varchar(10), unit_price int);
Create table If Not Exists Sales (seller_id int, product_id int, buyer_id int, sale_date date, quantity int, price int);
Truncate table Product;
insert into Product (product_id, product_name, unit_price) values ('1', 'S8', '1000');
insert into Product (product_id, product_name, unit_price) values ('2', 'G4', '800');
insert into Product (product_id, product_name, unit_price) values ('3', 'iPhone', '1400');
Truncate table Sales;
insert into Sales (seller_id, product_id, buyer_id, sale_date, quantity, price) values ('1', '1', '1', '2019-01-21', '2', '2000');
insert into Sales (seller_id, product_id, buyer_id, sale_date, quantity, price) values ('1', '2', '2', '2019-02-17', '1', '800');
insert into Sales (seller_id, product_id, buyer_id, sale_date, quantity, price) values ('2', '2', '3', '2019-06-02', '1', '800');
insert into Sales (seller_id, product_id, buyer_id, sale_date, quantity, price) values ('3', '3', '4', '2019-05-13', '2', '2800');
-- Write an SQL query that reports the best seller by total sales price, If there is a tie, report them all.
select tb2.seller_id 
from Sales tb2 
group by tb2.seller_id
having sum(tb2.price) = 
(select sum(tb1.price) from Sales tb1 group by tb1.seller_id order by sum(tb1.price) desc limit 1);

-- Write an SQL query that reports the buyers who have bought S8 but not iPhone. Note that S8 and iPhone are products present in the Product table.
-- suggest first one
select tb1.buyer_id from Sales tb1
join Product tb2
on tb1.product_id = tb2.product_id
group by tb1.buyer_id
having sum(case when tb2.product_name = "S8" then 1 else 0 end) > 0 -- end to finish case when
and sum(case when tb2.product_name = "iPhone" then 1 else 0 end) = 0;

select tb1.buyer_id from Sales tb1
join Product tb2
on tb1.product_id = tb2.product_id
where tb2.product_name = "S8"
and tb1.buyer_id not in (select tb3.buyer_id from Sales tb3
join Product tb4
on tb3.product_id = tb4.product_id
where tb4.product_name = "iPhone");

-- Write an SQL query that reports the products that were only sold in spring 2019. That is, between 2019-01-01 and 2019-03-31 inclusive.
select distinct tb2.product_id, tb2.product_name from Sales tb1 join Product tb2
using (product_id)
where tb1.product_id not in
(select tb3.product_id from Sales tb3
where  tb3.sale_date not between "2019-01-01"  and "2019-03-31");

select tb3.product_id, tb3.product_name from Product tb3 where tb3.product_id in
(select tb2.product_id from Sales tb1
join Product tb2
using (product_id)
group by tb1.product_id
having sum(case when tb1.sale_date between "2019-01-01" and "2019-03-31" then 1 else 0 end) > 0
and sum(case when tb1.sale_date between "2019-01-01" and "2019-03-31" then 0 else 1 end) = 0);

-- SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

-- select tb2.product_id, tb2.product_name from Sales tb1
-- join Product tb2
-- using (product_id)
-- group by tb1.product_id, tb2.product_name
-- having sum(case when tb1.sale_date between "2019-01-01" and "2019-03-31" then 1 else 0 end) > 0
-- and sum(case when tb1.sale_date between "2019-01-01" and "2019-03-31" then 0 else 1 end) = 0;