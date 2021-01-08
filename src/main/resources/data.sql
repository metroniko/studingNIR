DROP TABLE IF EXISTS strategy;

CREATE TABLE strategy (
      tactic VARCHAR(250) NOT NULL,
      technique_number VARCHAR(250) NOT NULL,
      technique_name VARCHAR(250) DEFAULT NULL,
      test_number VARCHAR(250) DEFAULT NULL,
      test_name VARCHAR(250) DEFAULT NULL,
      test_GUID VARCHAR(250) DEFAULT NULL,
      executor_name VARCHAR(250) DEFAULT NULL
) AS
SELECT *
FROM CSVREAD('src\main\resources\index.csv');

