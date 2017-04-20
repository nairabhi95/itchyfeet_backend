create table user (
	id int not null auto_increment primary key,
	first_name varchar(50),
	last_name varchar(50),
	email_id varchar(50),
	password varchar(50),
	contact_number int
	)engine=INNODB;