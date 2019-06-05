use leetcode;
Create table Person (PersonId int, FirstName varchar(255), LastName varchar(255));
Create table Address (AddressId int, PersonId int, City varchar(255), State varchar(255));
Truncate table Person;
insert into Person (PersonId, LastName, FirstName) values ('1', 'Wang', 'Allen');
Truncate table Address;
insert into Address (AddressId, PersonId, City, State) values ('1', '2', 'New York City', 'New York');

SELECT tb1.FirstName, tb1.LastName, tb2.City, tb2.State 
FROM Person tb1
LEFT JOIN Address tb2
ON tb1.PersonId = tb2.PersonId;