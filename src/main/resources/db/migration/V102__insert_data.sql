-- login password
-- admin hashpass1
-- anton hashpass2
-- danik hashpass3

insert into user_account (login, password, role, is_enabled)
values ('admin', '$2a$10$lqPac3rrnQkYp92n6aVyRupBVjVT7F8f37yqzsQe7It2OVkte7a2i', 'ADMINISTRATOR', true),
       ('anton', '$2a$10$upm05kYyjPRT7QQEGdsv3O1qhhHcK7ALZH/bbYVmB.1KMS.0o2pX6', 'VIEWER', true),
       ('danik', '$2a$10$e6bH2DqCnQIMAijJIExudu5zx08nv9Te9IR6SbTLETFx8fdqHXkSi', 'VIEWER', true);

insert into sensor_unit (name) values ('bar'), ('voltage'), ('°С'), ('%');

insert into sensor_type (name) values ('Pressure'), ('Voltage'), ('Temperature'), ('Humidity');