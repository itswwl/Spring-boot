/*
Navicat MySQL Data Transfer

Source Server         : NutzDemo
Source Server Version : 50632
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2017-04-21 16:41:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin');
INSERT INTO `t_role` VALUES ('2', 'company');
INSERT INTO `t_role` VALUES ('3', 'school');
INSERT INTO `t_role` VALUES ('4', 'person');
INSERT INTO `t_role` VALUES ('5', 'admin_merge');
INSERT INTO `t_role` VALUES ('6', 'company_merge');
INSERT INTO `t_role` VALUES ('7', 'schoole_merge');
INSERT INTO `t_role` VALUES ('8', 'person_merge');

-- ----------------------------
-- Table structure for t_role_source
-- ----------------------------
DROP TABLE IF EXISTS `t_role_source`;
CREATE TABLE `t_role_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) DEFAULT NULL,
  `sourceid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_source
-- ----------------------------
INSERT INTO `t_role_source` VALUES ('1', '1', '1');
INSERT INTO `t_role_source` VALUES ('2', '1', '2');
INSERT INTO `t_role_source` VALUES ('3', '1', '3');
INSERT INTO `t_role_source` VALUES ('4', '1', '4');
INSERT INTO `t_role_source` VALUES ('5', '1', '5');
INSERT INTO `t_role_source` VALUES ('6', '1', '6');
INSERT INTO `t_role_source` VALUES ('7', '1', '10');
INSERT INTO `t_role_source` VALUES ('8', '1', '11');
INSERT INTO `t_role_source` VALUES ('9', '1', '19');
INSERT INTO `t_role_source` VALUES ('10', '1', '20');
INSERT INTO `t_role_source` VALUES ('11', '1', '25');
INSERT INTO `t_role_source` VALUES ('12', '1', '7');
INSERT INTO `t_role_source` VALUES ('13', '1', '8');
INSERT INTO `t_role_source` VALUES ('14', '1', '13');
INSERT INTO `t_role_source` VALUES ('15', '1', '14');
INSERT INTO `t_role_source` VALUES ('16', '1', '15');
INSERT INTO `t_role_source` VALUES ('17', '1', '16');
INSERT INTO `t_role_source` VALUES ('18', '1', '17');
INSERT INTO `t_role_source` VALUES ('19', '1', '18');
INSERT INTO `t_role_source` VALUES ('20', '1', '21');
INSERT INTO `t_role_source` VALUES ('21', '1', '22');
INSERT INTO `t_role_source` VALUES ('22', '1', '23');
INSERT INTO `t_role_source` VALUES ('23', '1', '24');
INSERT INTO `t_role_source` VALUES ('24', '1', '26');
INSERT INTO `t_role_source` VALUES ('25', '1', '27');
INSERT INTO `t_role_source` VALUES ('26', '1', '28');
INSERT INTO `t_role_source` VALUES ('27', '1', '29');
INSERT INTO `t_role_source` VALUES ('28', '1', '30');
INSERT INTO `t_role_source` VALUES ('29', '1', '31');
INSERT INTO `t_role_source` VALUES ('30', '5', '1');
INSERT INTO `t_role_source` VALUES ('31', '5', '2');
INSERT INTO `t_role_source` VALUES ('32', '5', '3');
INSERT INTO `t_role_source` VALUES ('33', '5', '4');
INSERT INTO `t_role_source` VALUES ('34', '5', '10');
INSERT INTO `t_role_source` VALUES ('35', '5', '11');
INSERT INTO `t_role_source` VALUES ('36', '5', '13');
INSERT INTO `t_role_source` VALUES ('37', '5', '30');
INSERT INTO `t_role_source` VALUES ('38', '5', '31');
INSERT INTO `t_role_source` VALUES ('39', '2', '1');
INSERT INTO `t_role_source` VALUES ('40', '2', '2');
INSERT INTO `t_role_source` VALUES ('41', '2', '3');
INSERT INTO `t_role_source` VALUES ('42', '2', '4');
INSERT INTO `t_role_source` VALUES ('43', '2', '5');
INSERT INTO `t_role_source` VALUES ('44', '2', '6');
INSERT INTO `t_role_source` VALUES ('45', '2', '7');
INSERT INTO `t_role_source` VALUES ('46', '2', '8');
INSERT INTO `t_role_source` VALUES ('47', '2', '10');
INSERT INTO `t_role_source` VALUES ('48', '2', '13');
INSERT INTO `t_role_source` VALUES ('49', '2', '29');
INSERT INTO `t_role_source` VALUES ('50', '2', '30');

-- ----------------------------
-- Table structure for t_source
-- ----------------------------
DROP TABLE IF EXISTS `t_source`;
CREATE TABLE `t_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sourcename` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL COMMENT '父级id',
  `type` int(11) DEFAULT NULL COMMENT '等级类别',
  `permission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_source
-- ----------------------------
INSERT INTO `t_source` VALUES ('1', '基本设置', 'baseurl', '0', '1', null);
INSERT INTO `t_source` VALUES ('2', '员工管理', 'empurl', '0', '1', null);
INSERT INTO `t_source` VALUES ('3', '学生管理', 'stuurl', '0', '1', null);
INSERT INTO `t_source` VALUES ('4', '系统管理', 'sysurl', '0', '1', null);
INSERT INTO `t_source` VALUES ('5', '基本设置', 'nourl', '1', '2', null);
INSERT INTO `t_source` VALUES ('6', '账户管理', 'nourl', '1', '2', null);
INSERT INTO `t_source` VALUES ('7', '基本信息', 'baseinfo', '5', '3', null);
INSERT INTO `t_source` VALUES ('8', '组织结构', 'orginfo', '5', '3', null);
INSERT INTO `t_source` VALUES ('10', '人事管理', 'manurl', '2', '2', null);
INSERT INTO `t_source` VALUES ('11', '合同管理', 'conurl', '2', '2', null);
INSERT INTO `t_source` VALUES ('12', '其他', 'otherurl', '2', '2', null);
INSERT INTO `t_source` VALUES ('13', '入职管理', 'inurl', '10', '3', null);
INSERT INTO `t_source` VALUES ('14', '薪资管理', 'salurl', '10', '3', null);
INSERT INTO `t_source` VALUES ('15', '合同管理', 'conmanurl', '11', '3', null);
INSERT INTO `t_source` VALUES ('16', '合同续签', 'conrenewurl', '11', '3', null);
INSERT INTO `t_source` VALUES ('17', '证书管理', 'cerurl', '12', '3', null);
INSERT INTO `t_source` VALUES ('18', '社会工艺活动', 'acturl', '12', '3', null);
INSERT INTO `t_source` VALUES ('19', '学生管理', 'stumanurl', '3', '2', null);
INSERT INTO `t_source` VALUES ('20', '档案管理', 'arcurl', '3', '2', null);
INSERT INTO `t_source` VALUES ('21', '在校学生', 'curstuurl', '19', '3', null);
INSERT INTO `t_source` VALUES ('22', '历史学生', 'hisurl', '19', '3', null);
INSERT INTO `t_source` VALUES ('23', '校规校纪', 'ruleurl', '20', '3', null);
INSERT INTO `t_source` VALUES ('24', '奖学金', 'rewurl', '20', '3', null);
INSERT INTO `t_source` VALUES ('25', '系统设置', 'sysseturl', '4', '2', null);
INSERT INTO `t_source` VALUES ('26', '分类管理', 'claurl', '25', '3', null);
INSERT INTO `t_source` VALUES ('27', '资源管理', 'resurl', '25', '3', null);
INSERT INTO `t_source` VALUES ('28', '入职管理添加', null, '13', '4', 'in:add');
INSERT INTO `t_source` VALUES ('29', '入职管理修改', null, '13', '4', 'in:update');
INSERT INTO `t_source` VALUES ('30', '入职管理查看', null, '13', '4', 'in:view');
INSERT INTO `t_source` VALUES ('31', '入职管理删除', null, '13', '4', 'in:delete');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin');
INSERT INTO `t_user` VALUES ('2', 'school', 'school');
INSERT INTO `t_user` VALUES ('3', 'company', 'company');
INSERT INTO `t_user` VALUES ('4', 'person', 'person');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1');
INSERT INTO `t_user_role` VALUES ('2', '2', '2');
INSERT INTO `t_user_role` VALUES ('3', '3', '3');
INSERT INTO `t_user_role` VALUES ('4', '4', '4');
INSERT INTO `t_user_role` VALUES ('5', '1', '5');
SET FOREIGN_KEY_CHECKS=1;
