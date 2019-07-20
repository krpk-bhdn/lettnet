create sequence hibernate_sequence start 1 increment 1;

create table country (
    id varchar(8) not null,
    name varchar(128),
    primary key (id)
);

create table message (
    id int8 not null,
    publication_date timestamp,
    text varchar(4048),
    user_id varchar(255),
    primary key (id)
);

create table post (
    id int8 not null,
    publication_date timestamp,
    text varchar(16192),
    user_id varchar(255) not null,
    primary key (id)
);

create table usr (
    id varchar(255) not null,
    email varchar(255),
    last_visit timestamp,
    locale varchar(255),
    name varchar(255),
    picture varchar(255),
    primary key (id)
);

alter table if exists message
    add constraint message_user_fk
    foreign key (user_id) references usr;

alter table if exists post
    add constraint post_usr_fk
    foreign key (user_id) references usr;
