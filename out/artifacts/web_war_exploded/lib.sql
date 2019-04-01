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

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `meal`
-- ----------------------------
DROP TABLE IF EXISTS `meal`;
CREATE TABLE `meal` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `state` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `date` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of meal
-- ----------------------------
INSERT INTO `meal` VALUES ('1', '纽约', '空闲', '2016-05-04 12:00:00');
INSERT INTO `meal` VALUES ('2', '巴黎', '空闲', '2016-05-05 12:00:00');
INSERT INTO `meal` VALUES ('3', '日本', '空闲', '2016-05-05 12:00:00');
INSERT INTO `meal` VALUES ('6', '上海', '空闲', '2016-05-04 15:00:59');
INSERT INTO `meal` VALUES ('7', '北京', '空闲', '2016-05-04 15:21:39');
INSERT INTO `meal` VALUES ('8', '广州', '预定', '2016-05-04 15:43:15');

-- ----------------------------
-- Table structure for `salary`
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `price` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `date` date DEFAULT NULL,
  `own` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `id` int(36) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES ('100', '2016-05-03', '1', '1');
INSERT INTO `salary` VALUES ('200', '2016-05-04', '2', '2');

-- ----------------------------
-- Table structure for `stuff`
-- ----------------------------
DROP TABLE IF EXISTS `stuff`;
CREATE TABLE `stuff` (
  `stu_id` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '',
  `stu_name` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `stu_password` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `stu_sex` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `stu_college` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `stu_job` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `stu_ifad` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of stuff
-- ----------------------------
INSERT INTO `stuff` VALUES ('1', 'admin', '1', '男', '555', '1', '1');
INSERT INTO `stuff` VALUES ('2', 'admin2', '2', '女', '1', '1', '0');
