drop table if exists user_meeting_room;
create table user_meeting_room(
    user_id int generated  by default as identity primary key ,
    name varchar(255) not null,
    password varchar(255) not null unique

);