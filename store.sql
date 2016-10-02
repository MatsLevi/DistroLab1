drop database store;

create database if not exists store;
use store;

create table if not exists Login(
username varchar(50) not null unique,
pw varchar(50) not null,
id int not null auto_increment primary key);

create table if not exists Item(
itemname varchar(50) not null,
item_type varchar(50) not null,
price int not null,
quantity int not null,
id int not null auto_increment primary key);
