CREATE DATABASE WITINGDB;

CREATE TABLE students (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  age INTEGER
);

INSERT INTO students (name, age) VALUES
  ('Kavya', 32),
  ('Sravya', 25),
  ('Krithya', 18);