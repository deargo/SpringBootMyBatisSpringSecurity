drop table demo_security_user ;
create table RM.demo_security_user(
	EID NUMBER(18) not null,
	EITIME DATE  default sysdate ,
	EUTIME DATE  default sysdate ,
	username VARCHAR2(16) default '' not null,
	password VARCHAR2(16) default ''not null,
	access_level NUMBER(2) default 2 not null,
	description VARCHAR2(64) default ''
);

comment on table RM.demo_security_user is 'springsecurity测试表';
comment on column RM.demo_security_user.EID is '系统物理主键';
comment on column RM.demo_security_user.EITIME is '数据入库时间';
comment on column RM.demo_security_user.EUTIME is '数据修改时间';
comment on column RM.demo_security_user.username is '用户名';
comment on column RM.demo_security_user.password is '用户密码';
comment on column RM.demo_security_user.access_level is '用户权限';
comment on column RM.demo_security_user.description is '用户说明';

alter table RM.demo_security_user add constraint PK_EMHK_RM_demo_security_user primary key(EID) using index tablespace tbs_unvidx;
grant insert,update,delete on RM.demo_security_user to RM;

select username, password, access_level,description from rm.demo_security_user t
		where 1=1;

insert into RM.demo_security_user(eid,eitime,eutime,username,password,access_level,description)
values(RM.SEQ_EID.nextval,sysdate,sysdate,'username1','password1',0,'description1');
insert into RM.demo_security_user(EID,EITIME,EUTIME,username,password,access_level,description)
values(RM.SEQ_EID.nextval,sysdate,sysdate,'username2','password2',1,'description2');
insert into RM.demo_security_user(EID,EITIME,EUTIME,username,password,access_level,description)
values(RM.SEQ_EID.nextval,sysdate,sysdate,'username3','password3',1,'description3');
insert into RM.demo_security_user(EID,EITIME,EUTIME,username,password,access_level,description)
values(RM.SEQ_EID.nextval,sysdate,sysdate,'admin','admin',0,'admin');
insert into RM.demo_security_user(EID,EITIME,EUTIME,username,password,access_level,description)
values(RM.SEQ_EID.nextval,sysdate,sysdate,'user','user',1,'user');