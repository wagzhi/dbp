-- // First migration.
-- Migration SQL that makes the change goes here.

CREATE TABLE `user_base` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area_code` varchar(10) default '86' COMMENT '手机国家区号，默认86',
  `cellphone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `password` varchar(50) default null COMMENT '密码',
  `salt` varchar(20) default null COMMENT '密码加盐',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名称',
  `nickname` varchar(100) default null COMMENT '用户昵称',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像',
  `gender` int not null DEFAULT 0 COMMENT '性别0未知，1男，2女',
  `created_at` datetime DEFAULT current_timestamp COMMENT '创建时间',
  `updated_at` timestamp DEFAULT current_timestamp on update current_timestamp COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁字段',
  PRIMARY KEY (`id`)
) engine = InnoDB  DEFAULT CHARSET=utf8mb4;
alter table `user_base` add unique (`area_code`,`cellphone`);
alter table `user_base` add unique (`username`);

create table   `app` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `app_id` varchar(20) NOT NULL COMMENT 'appId，10以内位数字',
   `app_token` varchar(40) NOT NULL COMMENT 'appToken,含32位字符串，含小写字母和数字',
   `created_at` datetime DEFAULT current_timestamp COMMENT '创建时间',
   `updated_at` timestamp DEFAULT current_timestamp on update current_timestamp COMMENT '更新时间',
   `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
   `version` int(11) DEFAULT '0' COMMENT '乐观锁字段',
    PRIMARY KEY (`id`)
) engine = InnoDB  DEFAULT CHARSET=utf8mb4;

create table `dbp_transaction` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `transaction_id` varchar(40) NOT NULL COMMENT '交易id',
   `app_id` varchar(20) NOT NULL COMMENT '交易对应的appId',
   `timestamp` integer NOT NULL COMMENT '创建时间戳，13位数字',
   `from_mobile_area_code` varchar(20) NOT NULL DEFAULT '86' COMMENT '转出手机号区号，默认86',
   `from_mobile` varchar(20) NOT NULL COMMENT '转出手机号',
   `to_mobile_area_code` varchar(20) NOT NULL DEFAULT '86' COMMENT '转出手机号区号，默认86',
   `to_mobile` varchar(20) NOT NULL COMMENT '转入手机号',
   `order_id` varchar(100) default  null comment 'appId对应的系统的订单id，如果直接转账则没有订单号',
   `memo` varchar(20)  default NULL COMMENT '交易备注',
   `status` int(10) not null default 0 comment '订单状态，0待验证，1交易成功，2交易取消',
   `created_at` datetime DEFAULT current_timestamp COMMENT '创建时间',
   `updated_at` timestamp DEFAULT current_timestamp on update current_timestamp COMMENT '更新时间',
   `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
   `version` int(11) DEFAULT '0' COMMENT '乐观锁字段',
    PRIMARY KEY (`id`)
) engine = InnoDB  DEFAULT CHARSET=utf8mb4;

alter table `dbp_transaction` add index (`from_mobile_area_code`,`from_mobile`);
alter table `dbp_transaction` add index (`to_mobile_area_code`,`to_mobile`);


create table `user_account` (
  `uid` bigint(20) NOT NULL ,
  `balance` double NOT NULL default 0 COMMENT '账户余额，最小0.000001',
  `created_at` datetime DEFAULT current_timestamp COMMENT '创建时间',
  `updated_at` timestamp DEFAULT current_timestamp on update current_timestamp COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  `version` int(11) DEFAULT '0' COMMENT '乐观锁字段',
  PRIMARY KEY (`uid`)
) engine = InnoDB  DEFAULT CHARSET=utf8mb4;

-- //@UNDO
-- SQL to undo the change goes here.
drop table if exists  `user_base`;
drop table if exists  `app`;
drop table if exists  `dbp_transaction`;
drop table if exists  `user_account`;

