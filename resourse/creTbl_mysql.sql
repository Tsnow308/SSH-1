create table t_product
(
    id integer primary key auto_increment,
    name varchar(32) not null,
    description varchar(100),
    price decimal(10,2) not null
);

insert into t_product values(1,'pencil','pencil',2.00);
insert into t_product values(2,'pen','pen',5.00);
insert into t_product values(3,'rubber','rubber',1.00);
insert into t_product values(4,'notebook','notebook',2.00);
insert into t_product values(5,'gluewater','gluewater',5.00);
insert into t_product values(6,'pencilcase','pencilcase',10.00);
insert into t_product values(7,'ballpen','ballpen',2.00);

create table t_user
(
    id integer primary key auto_increment,
    name varchar(32),
    password  varchar(16),
    address varchar(100),
    postcode varchar(10),
    email varchar(50),
    homephone varchar(32),
    cellphone varchar(32),
    officephone varchar(32)
);
insert into t_user values(1,'8k','8k','chengdu','100081','8k@163.com','121231231','121231231','121231231');

create table t_order(
	id integer primary key auto_increment,
	status integer,
	user_id integer references t_user(id),
	cost decimal(10,2)
);

create table t_order_item(
	id integer primary key auto_increment,
	amount integer,
	product_id integer references t_product(id),
	order_id integer references t_order(id)
);
