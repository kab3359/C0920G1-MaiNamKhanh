DROP DATABASE IF EXISTS new_database; 
create database new_database;


use new_database;


create table categories(
id INT,
`name` varchar(50),
`description` varchar(500),
PRIMARY KEY (id)
);

create table suppliers(
id INT,
`name` varchar(100),
email varchar(50),
phone_number varchar(50),
address varchar(500)
);

create table customers(
id varchar(50),
first_name varchar(50),
last_name varchar(50),
phone_number varchar(50),
address varchar(500),
email varchar(50),
birthday date
);

create table employees(
id varchar(50),
firsrname varchar(50),
last_name varchar(50),
phone_number varchar(50),
address varchar(500),
email varchar(50),
birthday date
);

create table products(
id int,
`name` varchar(50),
umage_url varchar(1000),
price int,
discount int,
stock int,
category_id int,
supplier_id int,
`description` varchar(255)
);

create table orders(
id int,
created_date datetime,
shipped_date datetime,
`status` varchar(50),
`description` varchar(255),
shipping_address varchar(500),
shipping_city varchar(50),
payment_type varchar(20),
customer_id varchar(50),
employees_id varchar(50)
);

create table orders_details(
id int,
order_id int,
product_id int,
quantity int
);


