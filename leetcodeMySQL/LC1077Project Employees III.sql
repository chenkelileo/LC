use leetcode;
Create table If Not Exists Project (project_id int, employee_id int);
Create table If Not Exists Employee (employee_id int, name varchar(10), experience_years int);
Truncate table Project;
insert into Project (project_id, employee_id) values ('1', '1');
insert into Project (project_id, employee_id) values ('1', '2');
insert into Project (project_id, employee_id) values ('1', '3');
insert into Project (project_id, employee_id) values ('2', '1');
insert into Project (project_id, employee_id) values ('2', '4');
Truncate table Employee;
insert into Employee (employee_id, name, experience_years) values ('1', 'Khaled', '3');
insert into Employee (employee_id, name, experience_years) values ('2', 'Ali', '2');
insert into Employee (employee_id, name, experience_years) values ('3', 'John', '3');
insert into Employee (employee_id, name, experience_years) values ('4', 'Doe', '2');

select tb1.project_id, tb2.employee_id from Project tb1 join Employee tb2
on tb1.employee_id = tb2.employee_id where (tb1.project_id, tb2.experience_years)
in (select tb3.project_id, max(tb4.experience_years) from Project tb3 join Employee tb4
on tb3.employee_id = tb4.employee_id
group by tb3.project_id)

