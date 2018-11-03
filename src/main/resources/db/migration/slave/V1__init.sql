-- 用户表设计：登录账号，密码，昵称，以及每次登录都需要查询的字段，在基本表，其它扩展属性在详细表。
-- flyway不支持创建数据库
-- CREATE DATABASE IF NOT EXISTS maxplus DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
-- use maxplus;

CREATE TABLE `maxplus`.`test_mysql` (
`user_id` char(32)  NOT NULL  COMMENT '用户id，uuid',
`user_name` varchar(500) COLLATE utf8_general_ci NOT NULL COMMENT '用户名,用于登陆，唯一',
PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

INSERT INTO maxplus.test_mysql(user_id,user_name)values(UUID().'王五');
INSERT INTO maxplus.test_mysql(user_id,user_name)values(UUID().'赵六');
