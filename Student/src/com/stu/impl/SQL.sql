delete from stu where id>1;
select * from stu;
select * from user;
create table user(uname varchar(10), pword varchar(16))
alter table user change uname uname varchar(10) primary key;
desc user;
insert into user(uname,pword) values("sehw", "mima");
alter table user change uword upass varchar(10);
select * from user where uname like "sehw";
alter table user change upass upass varchar(64);
delete from user;