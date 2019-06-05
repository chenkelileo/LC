Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department (Id int, Name varchar(255));
Truncate table Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '85000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Max', '90000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('5', 'Janet', '69000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('6', 'Randy', '85000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('7', 'Will', '70000', '1');
Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');

SELECT Department, Employee, Salary FROM (SELECT D.Name Department, E.Name Employee, E.Salary, dense_rank() OVER (PARTITION BY E.DepartmentId ORDER BY E.Salary DESC) Ranks
FROM Employee E, Department D WHERE E.DepartmentId = D.Id) tb1 WHERE tb1.Ranks < 4; -- can use tb1.Ranks, but not Ranks itself for new identifed variable?
-- cuz order?
-- cuz ;

Use leetcode;
SELECT D.Name, E1.Name, E1.Salary FROM Employee E1 
JOIN Department D ON E1.DepartmentId = D.Id
WHERE (SELECT count(DISTINCT E2.Salary) FROM Employee E2
WHERE E2.Salary > E1.Salary and E1.DepartmentId = E2.DepartmentId) < 3;