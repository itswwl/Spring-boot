/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50632
Source Host           : localhost:3306
Source Database       : myboot

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2017-04-25 00:03:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mybatis
-- ----------------------------
DROP TABLE IF EXISTS `mybatis`;
CREATE TABLE `mybatis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mybatis` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mybatis
-- ----------------------------

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userinfo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('3', 'test');
INSERT INTO `userinfo` VALUES ('4', 'aa');
INSERT INTO `userinfo` VALUES ('5', 'bb');
INSERT INTO `userinfo` VALUES ('6', 'cc');
INSERT INTO `userinfo` VALUES ('7', 'a');
INSERT INTO `userinfo` VALUES ('8', 'c');
INSERT INTO `userinfo` VALUES ('9', 'aaaa');
INSERT INTO `userinfo` VALUES ('10', 'aa');
INSERT INTO `userinfo` VALUES ('11', 'bab');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '2', '3');
INSERT INTO `users` VALUES ('2', 'test', 'test');
INSERT INTO `users` VALUES ('3', 'ww', 'ww');
SET FOREIGN_KEY_CHECKS=1;
