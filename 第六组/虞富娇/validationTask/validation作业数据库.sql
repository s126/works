create table account(
  username varchar2(20) primary key,
  password varchar2(20) not null,
  acctype int not null,
  sex int default(1),
  email varchar2(32) not null,
  phoneCode varchar2(20),
  status int default 1, 
  constraint fk_acctype foreign key (acctype) references types(tid)
);
alter table account add constraints ck_sex check(sex=1 or sex=0);
drop table account;


create table types(
   tid number primary key,
   tname varchar2(30)
);
insert into types(tid,tname) values(1,'学生');
insert into types(tid,tname) values(2,'老师');
insert into types(tid,tname) values(3,'校长');
commit;

insert into account values ('usera', 'aaa', 1, 1, '2396807313@qq.com','14777142820',default);
insert into account values ('userb', 'bbb', 2, 0, '15018339643@163.com','14777142820',default);
commit;

select * from account;
select * from types;
