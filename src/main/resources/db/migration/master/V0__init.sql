-- 用户表设计：登录账号，密码，昵称，以及每次登录都需要查询的字段，在基本表，其它扩展属性在详细表。
-- flyway不支持创建数据库
-- CREATE DATABASE IF NOT EXISTS maxplus DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
-- use maxplus;

create table maxplus.test_oracle
(
  user_id   char(32) not null,
  user_name varchar2(500) not null
);
comment on table maxplus.test_oracle is 'oracle测试表';
-- Add comments to the columns
comment on column maxplus.user_id.user_id is '用户id，uuid';
comment on column maxplus.user_name.user_name is '用户名,用于登陆，唯一';



INSERT INTO maxplus.test_mysql(user_id,user_name)values(sys_guid(),'张三');
INSERT INTO maxplus.test_mysql(user_id,user_name)values(sys_guid(),'李四');
