CREATE DATABASE IF NOT EXISTS springbootssm DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
use springbootssm;

CREATE TABLE `user_t` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`user_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`password`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`age`  int(11) NULL DEFAULT NULL ,
`version`  int(11) NULL DEFAULT NULL ,
`da`  datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
);
insert into user_t (user_name,password,age,version) values('flf','123456',12,1);
insert into user_t (user_name,password,age,version) values('flf','123456',12,1);
