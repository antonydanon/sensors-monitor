insert into user_role (name) values ('Administrator'), ('Viewer');

insert into user_account (login, password, role_id)
values ('admin', 'hashpass1', 1), ('anton', 'hashpass2', 2), ('danik', 'hashpass3', 2);

insert into sensor_unit (name) values ('bar'), ('voltage'), ('°С'), ('%');

insert into sensor_type (name) values ('Pressure'), ('Voltage'), ('Temperature'), ('Humidity');