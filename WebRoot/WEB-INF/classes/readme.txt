 create table
SQL> create table book(
  2  id number(22) primary key,
  3  name varchar2(100) not null,
  4  price number(10,2));



SQL> create table customer(
  2  id number(22) primary key,
  3  name varchar2(20) not null,
  4  password varchar2(20) not null,
  5  zip varchar2(20),
  6  address varchar2(20),
  7  telephone varchar2(20),
  8  email varchar2(30));

SQL> create table orderform(
  2  id number(22) primary key,
  3  cost number(10,2),
  4  order_date date,
  5  customer_id number(22) references customer(id));
  
  //在之前的estore项目基础上添加了 payway
  alter table orderform add payway varchar2(30);


SQL> create table orderline(
  2  id number(22) primary key,
  3  num number(22),
  4  order_id references orderform(id),
  5  book_id references book(id));
