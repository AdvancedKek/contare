-- Create customer table
CREATE TABLE IF NOT EXISTS "USER" (
  id UUID PRIMARY KEY,
  first_name VARCHAR(128),
  last_name VARCHAR(128),
  patronymic VARCHAR(128),
  phone VARCHAR(32),
  address VARCHAR(256),
  email VARCHAR(64)
);


MERGE INTO "USER"
    KEY(id)
VALUES ('4658c7d5-f3f6-4898-ac12-72026d6e6036', 'Sheldon', 'Cooper', 'George''s', '+7 999 654 00 01', 'ул. Какая-та, дом 23, кв. 11', 'dk@example.com'),
    ('e6d2a0ef-c8a4-4463-863d-90e658a8ff6d', 'Leonard', 'Hofstadter', 'Alfred''s', '+7 999 156 00 02', 'пр-кт Какой-то, дом 1, кв. 65', 'omni@example.com'),
    ('bedea02a-84c2-4826-82b0-e8467b26f671', 'Howard', 'Wolowitz', 'Debbie''s', '+7 999 789 00 03', 'переулок Такой-то, дом 4, кв. 22', 'ck@example.com');




-- Create employer table
CREATE TABLE IF NOT EXISTS employer (
  id UUID PRIMARY KEY,
  first_name VARCHAR(128),
  last_name VARCHAR(128),
  patronymic VARCHAR(128),
  phone VARCHAR(32),
  address VARCHAR(256),
  email VARCHAR(64)
);

MERGE INTO employer
    KEY(id)
VALUES ('09e6f3ce-0295-47c6-a71b-9fdb5f7be5d9', 'Mario', 'Plumber', 'Antonio''s', '+7 999 000 00 04', 'ул. Какая-та, дом 24, кв. 12', 'ma@example.com'),
    ('e943e8ae-3451-41f9-b1a8-7190fda7a589', 'Luigi', 'Plumber', 'Antonio''s', '+7 999 000 00 05', 'пр-кт Какой-то, дом 2, кв. 66', 'la@example.com'),
    ('7aec1816-1a0e-4b30-b108-c921225f6b0f', 'Bowser', 'Dragon', 'Snake''s', '+7 999 000 00 06', 'переулок Такой-то, дом 5, кв. 26', 'bd@example.com');


-- Create provider table
CREATE TABLE IF NOT EXISTS provider (
  id UUID PRIMARY KEY,
  name VARCHAR(128),
  phone VARCHAR(32),
  address VARCHAR(256),
  email VARCHAR(64)
);

MERGE INTO provider
    KEY(id)
VALUES ('5c8ec258-e7b3-4dcd-8e0a-46d77a840edb', 'Bosh', '+7 999 000 00 44', 'ул. Какая-та, дом 36, кв. 12', 'bosh@example.com'),
    ('2a72bd42-ea00-487a-a406-94173e5ba865', 'SungYong', '+7 999 000 00 45', 'пр-кт Какой-то, дом 22, кв. 66', 'sa@example.com'),
    ('aa888c2d-4413-4008-a908-f55338753599', 'Masuma', '+7 999 000 00 46', 'переулок Такой-то, дом 25, кв. 26', 'masuma@example.com');




-- Create product table
CREATE TABLE IF NOT EXISTS product (
  id UUID PRIMARY KEY,
  name VARCHAR(128),
  description VARCHAR(128),
  price VARCHAR(32)
);

MERGE INTO product
    KEY(id)
VALUES ('f70abd93-122c-4b94-8cdb-34e9aa11b503', 'Oil change', 'Remove the old oil and add a new one', '300'),
    ('27fb01fe-bf8d-4d06-a74f-4227f73fc326', 'Break pads', 'Remove the old break pads and install a new ones', '500'),
    ('b6419f08-a1ca-4e28-b7ea-00f08b85a5ee', 'Engine change', 'Remove the old engine and install a new one', '3000');



-- Create task table
CREATE TABLE IF NOT EXISTS task (
  id UUID PRIMARY KEY,
  employer_id UUID,
  name VARCHAR(128),
  description VARCHAR(128),
  price VARCHAR(32),
  employee_price VARCHAR(32),
  service_price VARCHAR(32)
);


MERGE INTO task
    KEY(id)
VALUES ('70d33a4f-9683-4d8d-96e9-c92fe7b890e2', '09e6f3ce-0295-47c6-a71b-9fdb5f7be5d9', 'Oil change', 'Oil change', '300', '100', '200'),
    ('bb599787-f6f5-4bc1-8431-91c2920852a5', 'e943e8ae-3451-41f9-b1a8-7190fda7a589', 'Gas pump change', 'Gas pump change', '3000', '1000', '2000'),
    ('0eac4e6c-3515-43a5-a407-757e8f3a4fde', '7aec1816-1a0e-4b30-b108-c921225f6b0f', 'Windscreen change', 'Windscreen change', '7000', '3000', '4000');
