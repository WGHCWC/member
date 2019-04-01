/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : lib

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001
lib
Date: 2016-05-04 15:50:23
*/

SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `MemberInfo`;
CREATE TABLE `MemberInfo`
(
  `member_id`        varchar(10)                       NOT NULL AUTO_INCREMENT,
  `level`            varchar(10)                       NOT NULL,
  `member_name`      varchar(50) COLLATE utf8_bin  NOT NULL,
  `member_address`   varchar(500) COLLATE utf8_bin NOT NULL,
  `member_phone`     varchar(36) COLLATE utf8_bin  NOT NULL,
  `member_job`       varchar(36) COLLATE utf8_bin  NOT NULL,
  `member_introduce` varchar(500) COLLATE utf8_bin,
  `member_mail`      varchar(50) COLLATE utf8_bin  NOT NULL,
  `member_sexual`    varchar(10) COLLATE utf8_bin  NOT NULL,
  `member_password`  varchar(50) COLLATE utf8_bin  NOT NULL,
  PRIMARY KEY (`member_id`)

) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

insert into Persons values (345,'sasa','guangd','四川');