-- set @var1 = 1;
-- set @var2 = @var1 + 10;

-- select @var1, @var2;

-- SELECT @var3 :=5 AS var3;

use leetcode;
Create table If Not Exists test_groups(
name varchar(40),
test_value integer);
Truncate table test_groups;

insert into test_groups (name, test_value) values ('performance', 15);
insert into test_groups (name, test_value) values ('corner cases', 10);
insert into test_groups (name, test_value) values ('numerical stability', 20);
insert into test_groups (name, test_value) values ('memory usage', 10);

CREATE table If Not Exists test_cases(
id integer not null,
group_name varchar(40) not null,
status varchar(5) not null,
unique(id)
);

-- check count ????

insert into test_cases (id, group_name, status) values (13, 'memory usage', 'OK');
insert into test_cases (id, group_name, status) values (14, 'numerical stability', 'OK');
insert into test_cases (id, group_name, status) values (15, 'memory usage', 'ERROR');
insert into test_cases (id, group_name, status) values (16, 'numerical stability', 'OK');
insert into test_cases (id, group_name, status) values (17, 'numerical stability', 'OK');
insert into test_cases (id, group_name, status) values (18, 'performance', 'ERROR');
insert into test_cases (id, group_name, status) values (19, 'performance', 'ERROR');
insert into test_cases (id, group_name, status) values (20, 'memory usage', 'OK');
insert into test_cases (id, group_name, status) values (21, 'numerical stability', 'OK');


SELECT tb1.name AS name,
sum(CASE WHEN tb2.group_name IS NULL THEN 0 ELSE 1 END)  AS all_test_cases,
sum(CASE WHEN tb2.status = "OK" THEN 1 ELSE 0 END)  AS passed_test_cases,
sum(CASE WHEN tb2.status = "OK" THEN tb1.test_value ELSE 0 END)  AS total_value
FROM test_groups tb1
LEFT JOIN test_cases tb2
ON tb1.name = tb2.group_name
GROUP BY tb1.name
ORDER BY total_value DESC, name ASC;


SELECT * FROM test_groups tb1
LEFT JOIN test_cases tb2
ON tb1.name = tb2.group_name;
