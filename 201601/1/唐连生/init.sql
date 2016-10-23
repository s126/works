
grant dba to vip identified by vip;


create table account
(
	username varchar2(20) primary key,
	password varchar2(20) not null,
	acctype int not null,
	lastlogin timestamp,
	status int default 1,
	birthday date,
	email varchar2(20) ,
	phone varchar2(11) ,
	sex  varchar2(5) check(sex = '男' or sex = '女')
);

drop table vip.account;
create table emp as select * from scott.emp;


commit;

