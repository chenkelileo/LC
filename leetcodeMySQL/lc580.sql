CREATE TABLE IF NOT EXISTS student (student_id INT,student_name VARCHAR(45), gender VARCHAR(6), dept_id INT);
CREATE TABLE IF NOT EXISTS department (dept_id INT, dept_name VARCHAR(255));
Truncate table student;
insert into student (student_id, student_name, gender, dept_id) values ('1', 'Jack', 'M', '1');
insert into student (student_id, student_name, gender, dept_id) values ('2', 'Jane', 'F', '1');
insert into student (student_id, student_name, gender, dept_id) values ('3', 'Mark', 'M', '2');
Truncate table department;
insert into department (dept_id, dept_name) values ('1', 'Engineering');
insert into department (dept_id, dept_name) values ('2', 'Science');
insert into department (dept_id, dept_name) values ('3', 'Law');

SELECT DISTINCT department.dept_name, count(student.student_id) OVER (PARTITION BY department.dept_id ) AS student_number FROM student
RIGHT JOIN department  -- keep in mind use count(xx) will take account of null to 0
ON student.dept_id = department.dept_id
ORDER BY student_number DESC, department.dept_name;

-- write not window function version

SELECT D.dept_name, count(S.student_id) AS student_number FROM Department D
LEFT JOIN Student S -- only can use join ,not where D, S keep in mind
ON D.dept_id = S.dept_id
GROUP BY D.dept_name
ORDER BY student_number DESC, D.dept_name;



