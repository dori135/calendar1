create schema project;

USE project;

CREATE TABLE users
(
    id          bigint auto_increment comment '유저 별 id'
        primary key,
    name        varchar(50)  not null comment '유저명',
    email       varchar(100) not null unique comment '이메일',
    created_at  datetime default current_timestamp comment '작성일',
    updated_at  datetime default current_timestamp comment '수정일'
);

CREATE TABLE schedules
(
    id          bigint auto_increment comment '일정 별 id'
        primary key,
    user_id     bigint comment '유저 별 id',
    title       varchar(100) not null comment '할일 제목',
    contents    text         comment '할일 내용',
    created_at  datetime default current_timestamp comment '작성일',
    updated_at  datetime default current_timestamp comment '수정일',
    foreign key (user_id) references users(id)
);

CREATE TABLE comments
(
    id          bigint auto_increment comment '댓글 별 id'
        primary key,
    schedule_id bigint comment '일정 별 id',
    content     text comment '댓글 내용',
    name        varchar(50) not null comment '작성 유저명',
    created_at  datetime default current_timestamp comment '작성일',
    updated_at  datetime default current_timestamp comment '수정일',
    foreign key (schedule_id) references schedules(id)
);

CREATE TABLE schedule_permission
(
    user_id     bigint comment '유저 별 id',
    schedule_id bigint comment '일정 별 id',
    primary key (user_id, schedule_id),
    foreign key (user_id) references users(id),
    foreign key (schedule_id) references schedules(id)
);

