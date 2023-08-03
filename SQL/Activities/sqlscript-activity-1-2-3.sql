REM   Script: Activity_123
REM   This is activity 1

CREATE TABLE salesman (salesman_id int PRIMARY KEY,salesman_name varchar(20),salesman_city varchar(20),comission int);

CREATE TABLE salesman (salesman_id int PRIMARY KEY,salesman_name varchar(20),salesman_city varchar(20),comission int);

DESCRIBE salesman


DESCRIBE salesman


INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

CREATE TABLE salesman (salesman_id int PRIMARY KEY,salesman_name varchar(20),salesman_city varchar(20),comission int);

DESCRIBE salesman


INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

SELECT salesman_id, salesman_city FROM salesman;

SELECT salesman_id, salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

SELECT salesman_id, comission FROM salesman WHERE salesman_name='Paul Adam';

SELECT * FROM DUAL;

SELECT DISTINCT salesman_city FROM salesman;

SELECT * from DEPARTMENT;

SELECT * from CUSTOMER;

