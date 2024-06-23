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

MERGE INTO customer
    KEY(id)
VALUES ('4e519c68-9562-405d-8254-19c7d2925169', 'Dragon', 'Knight', 'Firestorm''s', '+7 999 000 00 01', 'ул. Какая-та, дом 23, кв. 11', 'dk@example.com'),
    ('aedf455a-c9d9-4911-ad5e-4b8883615ccb', 'Omni', 'Knight', 'Guardian''s', '+7 999 000 00 02', 'пр-кт Какой-то, дом 1, кв. 65', 'omni@example.com'),
    ('61c33025-043e-452f-bf1b-dc92978a9496', 'Chaos', 'Knight', 'Phantasm''s', '+7 999 000 00 03', 'переулок Такой-то, дом 4, кв. 22', 'ck@example.com');

