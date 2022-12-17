DROP TABLE IF EXISTS strategy_in_pattern;
DROP TABLE IF EXISTS strategy;
DROP TABLE IF EXISTS pattern;

CREATE TABLE strategy (
  tactic VARCHAR(250) NOT NULL,
  technique_number VARCHAR(250) NOT NULL,
  technique_name VARCHAR(250) DEFAULT NULL,
  test_number VARCHAR(250) DEFAULT NULL,
  test_name VARCHAR(250) DEFAULT NULL,
  test_GUID VARCHAR(250) DEFAULT NULL,
  executor_name VARCHAR(250) DEFAULT NULL
);

COPY strategy FROM 'D:\index.csv' WITH (FORMAT csv);
CREATE TABLE pattern
(
    pattern_GUID VARCHAR(250) DEFAULT NULL,
    pattern_name VARCHAR(250) DEFAULT NULL
);

CREATE TABLE strategy_in_pattern
(
    strategy_in_pattern_id VARCHAR(250) DEFAULT NULL,
    test_GUID VARCHAR(250) DEFAULT NULL,
    pattern_GUID VARCHAR(250) DEFAULT NULL,
    count VARCHAR(250) DEFAULT 1

);
insert into pattern(pattern_GUID, pattern_name) values ('1', 'Higaisa Паттерн Уровень приложения');
insert into pattern(pattern_GUID, pattern_name) values ('2', 'Calypso Пaттерн');
insert into pattern(pattern_GUID, pattern_name) values ('3', 'Winnti Пaттерн');
insert into pattern(pattern_GUID, pattern_name) values ('4', 'Goblin Panda Пaттерн');
insert into pattern(pattern_GUID, pattern_name) values ('5', 'RTM Пaттерн');
insert into pattern(pattern_GUID, pattern_name) values ('6', 'Silence Пaттерн');
insert into pattern(pattern_GUID, pattern_name) values ('7', 'Cobalt Пaттерн');

insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('114ccff9-ae6d-4547-9ead-4cd69f687306', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('9e8894c0-50bd-4525-a96c-d4ac78ece388', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('1620de42-160a-4fe5-bbaf-d3fef0181ce9', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('99be2089-c52d-4a4a-b5c3-261ee42c8b62', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('2382dee2-a75f-49aa-9378-f52df6ed3fb1', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('ed366cde-7d12-49df-a833-671904770b9f', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('65526037-7079-44a9-bda1-2cb624838040', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('dc6fe391-69e6-4506-bd06-ea5eeb4082f8', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('9dee89bd-9a98-4c4f-9e2d-4256690b0e72', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('f70974c8-c094-4574-b542-2c545af95a32', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('d9b633ca-8efb-45e6-b838-70f595c6ae26', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('2158908e-b7ef-4c21-8a83-3ce4dd05a924', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('4b467538-f102-491d-ace7-ed487b853bf5', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('9c780d3d-3a14-4278-8ee5-faaeb2ccfbe0', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('81c13829-f6c9-45b8-85a6-053366d55297', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('1164f70f-9a88-4dff-b9ff-dc70e7bf0c25', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('2158908e-b7ef-4c21-8a83-3ce4dd05a924', '1');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('2158908e-b7ef-4c21-8a83-3ce4dd05a924', '1');


insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('eb44f842-0457-4ddc-9b92-c4caa144ac42', '2');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('af9fd58f-c4ac-4bf2-a9ba-224b71ff25fd', '2');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('a50d5a97-2531-499e-a1de-5544c74432c6', '2');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('66fb0bc1-3c3f-47e9-a298-550ecfefacbc', '2');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('ae4b6361-b5f8-46cb-a3f9-9cf108ccfe7b', '2');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('d696a3cb-d7a8-4976-8eb5-5af4abf2e3df', '2');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('1b0814d1-bb24-402d-9615-1b20c50733fb', '2');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('69bd4abe-8759-49a6-8d21-0f15822d6370', '2');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('dbf38128-7ba7-4776-bedf-cc2eed432098', '2');
insert into strategy_in_pattern(test_GUID, pattern_GUID) values ('3f1b5096-0139-4736-9b78-19bcb02bb1cb', '2');


