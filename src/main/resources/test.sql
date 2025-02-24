CREATE TABLE Employees (
                           EmployeeID INT PRIMARY KEY,
                           FirstName VARCHAR(50),
                           LastName VARCHAR(50),
                           DepartmentID INT,
                           Salary DECIMAL(10,2)
);

CREATE TABLE Departments (
                             DepartmentID INT PRIMARY KEY,
                             DepartmentName VARCHAR(50)
);

-- Write a query to count the number of employees in each department, displaying the `DepartmentName` and `EmployeeCount`

select d.DepartmentName as DepartmentName, count(e) as EmployeeCount
from Departments d left join Employees e on e.DepartmentID = d.DepartmentID group by d.DepartmentName;

------------------------------------------------------------------------------------------------------------------------

-- INIT database
CREATE TABLE salary_info (
                             worker_id INTEGER,
                             first_name VARCHAR,
                             last_name VARCHAR,
                             salary DECIMAL,
                             department VARCHAR,
                             region VARCHAR,
                             PRIMARY KEY (worker_id)
);

-- Total salaries by department
INSERT INTO salary_info (worker_id, first_name, last_name, salary, department, region)
VALUES
    (1, 'Bob', 'Builder', 100000.05, 'Operations', 'North'),
    (2, 'Bob2', 'Builder', 50000, 'Operations', 'North'),
    (3, 'John', 'Doe', 50000, 'Sales', 'South'),
    (4, 'John2', 'Doe', 40000, 'Sales', 'North'),
    (5, 'Jane', 'Doe', 50000, 'Sales', 'South')
;

-- To get the total salary by department where the department has more than 2 workers, use this query:
select department, sum(si.salary) as salary from salary_info si group by si.department having count(worker_id) > 2;

SELECT department, SUM(salary) AS total_salary
FROM salary_info
GROUP BY department
HAVING COUNT(worker_id) > 2;

