REM   Script: Activity_4_5
REM   This is activity 4 and 5

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

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;

SELECT * FROM salesman;

SELECT * FROM Customers ORDER BY Country;

SELECT * FROM salesman ORDER BY salesman_city;

SELECT * FROM salesman ORDER BY salesman_city DESC;

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;

SELECT * FROM salesman ORDER BY salesman_city;

SELECT * FROM salesman ORDER BY salesman_city DESC;

SELECT * FROM salesman ORDER BY salesman_city, salesman_name;

SELECT * FROM salesman ORDER BY salesman_city ASC, salesman_name DESC;

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;

SELECT * FROM salesman ORDER BY salesman_city;

SELECT * FROM salesman ORDER BY salesman_city DESC;

SELECT * FROM salesman ORDER BY salesman_city, salesman_name;

SELECT * FROM salesman ORDER BY salesman_city ASC, salesman_name DESC;

SELECT DISTINCT grade FROM salesman;

SELECT DISTINCT grade FROM salesman;

SELECT DISTINCT grade FROM salesman ORDER BY grade;

SELECT salary FROM salesman WHERE grade = 200;

SELECT salesman FROM salesman WHERE grade = 200;

SELECT salesman_name FROM salesman WHERE grade = 200;

SELECT salesman_name FROM salesman WHERE grade <> 2000;

SELECT salesman_name FROM salesman WHERE grade > 200;

SELECT * FROM salesman;

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;

SELECT * FROM salesman ORDER BY salesman_city;

SELECT * FROM salesman ORDER BY salesman_city DESC;

SELECT * FROM salesman ORDER BY salesman_city, salesman_name;

SELECT * FROM salesman ORDER BY salesman_city ASC, salesman_name DESC;

SELECT DISTINCT grade FROM salesman;

SELECT DISTINCT grade FROM salesman ORDER BY grade;

SELECT salesman_name FROM salesman WHERE grade = 200;

SELECT salesman_name FROM salesman WHERE grade <> 2000;

SELECT salesman_name FROM salesman WHERE grade > 10;

SELECT salesman_name FROM salesman WHERE grade > 10;

SELECT salesman_name FROM salesman WHERE grade < 500;

SELECT salesman_name FROM salesman WHERE grade >= 10;

SELECT salesman_name ,grade FROM salesman WHERE grade >= 10;

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;

SELECT * FROM salesman ORDER BY salesman_city;

SELECT * FROM salesman ORDER BY salesman_city DESC;

SELECT * FROM salesman ORDER BY salesman_city, salesman_name;

SELECT * FROM salesman ORDER BY salesman_city ASC, salesman_name DESC;

SELECT DISTINCT grade FROM salesman;

SELECT DISTINCT grade FROM salesman ORDER BY grade;

SELECT salesman_name FROM salesman WHERE grade = 200;

SELECT salesman_name FROM salesman WHERE grade <> 2000;

SELECT salesman_name FROM salesman WHERE grade > 10;

SELECT salesman_name FROM salesman WHERE grade < 500;

SELECT salesman_name ,grade FROM salesman WHERE grade >= 10;

SELECT salesman_name ,grade FROM salesman WHERE grade <= 500;

SELECT salesman_name ,grade FROM salesman WHERE grade <= 500;

SELECT * FROM salesman;

SELECT * FROM salesman WHERE grade < 500 AND comission = 11;

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;

SELECT * FROM salesman ORDER BY salesman_city;

SELECT * FROM salesman ORDER BY salesman_city DESC;

SELECT * FROM salesman ORDER BY salesman_city, salesman_name;

SELECT * FROM salesman ORDER BY salesman_city ASC, salesman_name DESC;

SELECT DISTINCT grade FROM salesman;

SELECT DISTINCT grade FROM salesman ORDER BY grade;

SELECT salesman_name FROM salesman WHERE grade = 200;

SELECT salesman_name FROM salesman WHERE grade <> 2000;

SELECT salesman_name FROM salesman WHERE grade > 10;

SELECT salesman_name FROM salesman WHERE grade < 500;

SELECT salesman_name ,grade FROM salesman WHERE grade >= 10;

SELECT salesman_name ,grade FROM salesman WHERE grade <= 500;

SELECT * FROM salesman WHERE grade < 500 AND comission = 11;

SELECT * FROM salesman WHERE grade < 500 OR comission = 1100;

SELECT * FROM salesman WHERE grade < 500 OR comission = 1100;

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;

SELECT * FROM salesman ORDER BY salesman_city;

SELECT * FROM salesman ORDER BY salesman_city DESC;

SELECT * FROM salesman ORDER BY salesman_city, salesman_name;

SELECT * FROM salesman ORDER BY salesman_city ASC, salesman_name DESC;

SELECT DISTINCT grade FROM salesman;

SELECT DISTINCT grade FROM salesman ORDER BY grade;

SELECT salesman_name FROM salesman WHERE grade = 200;

SELECT salesman_name FROM salesman WHERE grade <> 2000;

SELECT salesman_name FROM salesman WHERE grade > 10;

SELECT salesman_name FROM salesman WHERE grade < 500;

SELECT salesman_name ,grade FROM salesman WHERE grade >= 10;

SELECT salesman_name ,grade FROM salesman WHERE grade <= 500;

SELECT * FROM salesman WHERE grade < 500 AND comission = 11;

SELECT * FROM salesman WHERE grade < 500 OR comission = 1100;

SELECT * FROM salesman WHERE grade BETWEEN 100 AND 500;

SELECT * FROM salesman WHERE grade BETWEEN 100 AND 500;

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;

SELECT * FROM salesman ORDER BY salesman_city;

SELECT * FROM salesman ORDER BY salesman_city DESC;

SELECT * FROM salesman ORDER BY salesman_city, salesman_name;

SELECT * FROM salesman ORDER BY salesman_city ASC, salesman_name DESC;

SELECT DISTINCT grade FROM salesman;

SELECT DISTINCT grade FROM salesman ORDER BY grade;

SELECT salesman_name FROM salesman WHERE grade = 200;

SELECT salesman_name FROM salesman WHERE grade <> 2000;

SELECT salesman_name FROM salesman WHERE grade > 10;

SELECT salesman_name FROM salesman WHERE grade < 500;

SELECT salesman_name ,grade FROM salesman WHERE grade >= 10;

SELECT salesman_name ,grade FROM salesman WHERE grade <= 500;

SELECT * FROM salesman WHERE grade < 500 AND comission = 11;

SELECT * FROM salesman WHERE grade < 500 OR comission = 1100;

SELECT * FROM salesman WHERE grade BETWEEN 100 AND 500;

SELECT * FROM salesman WHERE NOT grade = 300;

SELECT * FROM salesman WHERE NOT grade = 300;

