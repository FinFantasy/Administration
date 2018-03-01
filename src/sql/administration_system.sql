drop database if exists `administration`;
create database `administration`;

-- ---------------------------
-- Table structure for college
-- ---------------------------
drop table if exists `college`;
create table `college` (
    `collegeID` int(11) not null,
    `collegeName` varchar(200) not null comment '系名',
    primary key (`collegeID`)
) engine= InnoDB default charset=utf8;

-- ---------------------------
-- Records of college
-- ---------------------------
insert into `college` values ('1', '计算机系');
insert into `college` values ('2', '设计系');
insert into `college` values ('3', '财经系');

-- ---------------------------
-- Table structure for course
-- ---------------------------
drop table if exists `course`;
