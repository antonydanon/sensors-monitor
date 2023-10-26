create table if not exists user_role
(
    id      bigserial primary key,
    name    varchar(15)
);

create table if not exists user_account
(
    id         bigserial primary key,
    login      varchar(20),
    password   varchar(255),
    role_id    bigserial,

    foreign key (role_id) references user_role (id)
    on delete restrict
    on update cascade
);

create table if not exists sensor_unit
(
    id      bigserial primary key,
    name    varchar(15)
);

create table if not exists sensor_type
(
    id      bigserial primary key,
    name    varchar(15)
);

create table if not exists sensor
(
    id              bigserial primary key,
    name            varchar(30),
    model           varchar(15),
    range_from      integer,
    range_to        integer,
    type_id         bigserial,
    unit_id         bigserial,
    location        varchar(40),
    description     varchar(200),

    foreign key (unit_id) references sensor_unit (id)
    on delete restrict
    on update cascade,
    foreign key (type_id) references sensor_type (id)
    on delete restrict
    on update cascade
);