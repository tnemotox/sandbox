DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS sub_department;
DROP TABLE IF EXISTS benchmark;

CREATE TABLE employee (
  id SERIAL PRIMARY KEY,
  name VARCHAR,
  mail_address VARCHAR,
  department_id VARCHAR
);

CREATE TABLE department (
  id SERIAL PRIMARY KEY,
  name VARCHAR
);

CREATE TABLE sub_department (
  employee_id INTEGER,
  department_id INTEGER
);

CREATE TABLE benchmark (
  id SERIAL PRIMARY KEY,
  num INTEGER
);