-- Create customer table
CREATE TABLE IF NOT EXISTS customer (
  id UUID PRIMARY KEY,
  first_name VARCHAR(128),
  last_name VARCHAR(128),
  patronymic VARCHAR(128),
  phone VARCHAR(32),
  address VARCHAR(256),
  email VARCHAR(64)
);

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

MERGE INTO customer
    KEY(id)
VALUES ('4e519c68-9562-405d-8254-19c7d2925169', 'Dragon', 'Knight', 'Firestorm''s', '+7 999 000 00 01', 'ул. Какая-та, дом 23, кв. 11', 'dk@example.com'),
    ('aedf455a-c9d9-4911-ad5e-4b8883615ccb', 'Omni', 'Knight', 'Guardian''s', '+7 999 000 00 02', 'пр-кт Какой-то, дом 1, кв. 65', 'omni@example.com'),
    ('61c33025-043e-452f-bf1b-dc92978a9496', 'Chaos', 'Knight', 'Phantasm''s', '+7 999 000 00 03', 'переулок Такой-то, дом 4, кв. 22', 'ck@example.com');

MERGE INTO employer
    KEY(id)
VALUES ('a76ea85c-9244-46df-8046-d1c25317be01', 'Chandler', 'Bing', 'John''s', '+7 999 000 00 04', 'ул. Какая-та, дом 24, кв. 12', 'chanbing@example.com'),
    ('b56022a1-0472-4892-bc93-b059f51d6fd8', 'Joey', 'Tribbiani', 'Mario''s', '+7 999 000 00 05', 'пр-кт Какой-то, дом 2, кв. 66', 'jtri@example.com'),
    ('87144aea-7a67-435d-95ef-e7582d17cdcb', 'Monica', 'Gelar', 'Jim''s', '+7 999 000 00 06', 'переулок Такой-то, дом 5, кв. 23', 'mongal@example.com');