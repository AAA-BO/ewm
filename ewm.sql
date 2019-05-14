/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : ewm

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-05-06 19:58:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for e_dictionaries
-- ----------------------------
DROP TABLE IF EXISTS `e_dictionaries`;
CREATE TABLE `e_dictionaries` (
  `oid` int(10) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'department-部门，zhicheng-职称',
  `value` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of e_dictionaries
-- ----------------------------
INSERT INTO `e_dictionaries` VALUES ('42', '部门', '装修部');
INSERT INTO `e_dictionaries` VALUES ('43', '部门', '施工部');
INSERT INTO `e_dictionaries` VALUES ('44', '部门', '物料部');
INSERT INTO `e_dictionaries` VALUES ('45', '职称', '运输队队长');
INSERT INTO `e_dictionaries` VALUES ('46', '职称', '辣鸡装修工');
INSERT INTO `e_dictionaries` VALUES ('47', '职称', '装饰大师');
INSERT INTO `e_dictionaries` VALUES ('48', '职称', '一级建造师');
INSERT INTO `e_dictionaries` VALUES ('49', '职称', '搬砖大师');
INSERT INTO `e_dictionaries` VALUES ('64', 'sys_weihuItem_23', 'aaa|aaa');
INSERT INTO `e_dictionaries` VALUES ('65', 'sys_weihuItem_23', 'bbb|bbb|&area');
INSERT INTO `e_dictionaries` VALUES ('66', 'sys_weihuItem_23', 'ccc|333');
INSERT INTO `e_dictionaries` VALUES ('67', 'sys_weihuItem_23', 'ddd|2019-05-05 17:28:53');
INSERT INTO `e_dictionaries` VALUES ('68', 'sys_weihuItem_23', 'eee|e2');
INSERT INTO `e_dictionaries` VALUES ('69', 'sys_weihuItem_23', 'fff|f3');
INSERT INTO `e_dictionaries` VALUES ('70', 'sys_weihuItem_23', 'ggg|g2|g3|&');
INSERT INTO `e_dictionaries` VALUES ('71', 'sys_weihuItem_24', 'a|a');
INSERT INTO `e_dictionaries` VALUES ('72', 'sys_weihuItem_24', 'aa|aa');
INSERT INTO `e_dictionaries` VALUES ('73', 'sys_weihuItem_24', 'b|b|&area');
INSERT INTO `e_dictionaries` VALUES ('74', 'sys_weihuItem_24', 'bb|bb|&area');
INSERT INTO `e_dictionaries` VALUES ('75', 'sys_weihuItem_24', 'c|3');
INSERT INTO `e_dictionaries` VALUES ('76', 'sys_weihuItem_24', 'cc|33');
INSERT INTO `e_dictionaries` VALUES ('77', 'sys_weihuItem_24', 'd|2019-05-05 17:53:28');
INSERT INTO `e_dictionaries` VALUES ('78', 'sys_weihuItem_24', 'dd|2019-12-05 17:53:28');
INSERT INTO `e_dictionaries` VALUES ('79', 'sys_weihuItem_24', 'e|e1');
INSERT INTO `e_dictionaries` VALUES ('80', 'sys_weihuItem_24', 'ee|ee2');
INSERT INTO `e_dictionaries` VALUES ('81', 'sys_weihuItem_24', 'f|f2');
INSERT INTO `e_dictionaries` VALUES ('82', 'sys_weihuItem_24', 'ff|ff3');
INSERT INTO `e_dictionaries` VALUES ('83', 'sys_weihuItem_24', 'g|g1|g2|&');
INSERT INTO `e_dictionaries` VALUES ('84', 'sys_weihuItem_24', 'gg|gg2|gg3|&');
INSERT INTO `e_dictionaries` VALUES ('85', 'sys_weihuItem_25', '挖机头磨损|别担心，没有磨损');
INSERT INTO `e_dictionaries` VALUES ('86', 'sys_weihuItem_25', '损耗状况|严重');
INSERT INTO `e_dictionaries` VALUES ('87', 'sys_weihuItem_25', '是否正常启动|否');
INSERT INTO `e_dictionaries` VALUES ('88', 'sys_weihuItem_25', '评价|挖机很漂亮|我想开着炒菜|辣鸡挖机|&');
INSERT INTO `e_dictionaries` VALUES ('89', 'sys_weihuItem_25', '油量剩余%|80');
INSERT INTO `e_dictionaries` VALUES ('90', 'sys_weihuItem_25', '你的生日|1995-09-20 17:54:27');
INSERT INTO `e_dictionaries` VALUES ('91', 'sys_weihuItem_25', '挖机头磨损|别担心，没有磨损');
INSERT INTO `e_dictionaries` VALUES ('92', 'sys_weihuItem_25', '损耗状况|严重');
INSERT INTO `e_dictionaries` VALUES ('93', 'sys_weihuItem_25', '是否正常启动|否');
INSERT INTO `e_dictionaries` VALUES ('94', 'sys_weihuItem_25', '评价|挖机很漂亮|我想开着炒菜|辣鸡挖机|&');
INSERT INTO `e_dictionaries` VALUES ('95', 'sys_weihuItem_25', '油量剩余%|80');
INSERT INTO `e_dictionaries` VALUES ('96', 'sys_weihuItem_25', '你的生日|1995-09-20 17:54:27');
INSERT INTO `e_dictionaries` VALUES ('120', 'sys_weihuItem_26', '挖机头磨损|');
INSERT INTO `e_dictionaries` VALUES ('121', 'sys_weihuItem_26', '损耗状况|严重');
INSERT INTO `e_dictionaries` VALUES ('122', 'sys_weihuItem_26', '是否正常启动|否');
INSERT INTO `e_dictionaries` VALUES ('123', 'sys_weihuItem_26', '评价|我想开着炒菜|辣鸡挖机|挖机很漂亮|&');
INSERT INTO `e_dictionaries` VALUES ('124', 'sys_weihuItem_26', '油量剩余%|2');
INSERT INTO `e_dictionaries` VALUES ('125', 'sys_weihuItem_26', '你的生日|2019-05-06 13:09:58');
INSERT INTO `e_dictionaries` VALUES ('126', 'sys_weihuItem_26', '挖机头磨损|');
INSERT INTO `e_dictionaries` VALUES ('127', 'sys_weihuItem_26', '损耗状况|严重');
INSERT INTO `e_dictionaries` VALUES ('128', 'sys_weihuItem_26', '是否正常启动|否');
INSERT INTO `e_dictionaries` VALUES ('129', 'sys_weihuItem_26', '评价|我想开着炒菜|辣鸡挖机|挖机很漂亮|&');
INSERT INTO `e_dictionaries` VALUES ('130', 'sys_weihuItem_26', '油量剩余%|2');
INSERT INTO `e_dictionaries` VALUES ('131', 'sys_weihuItem_26', '你的生日|2019-05-06 13:09:58');
INSERT INTO `e_dictionaries` VALUES ('132', 'sys_weihuItem_27', '挖机头磨损|aaa');
INSERT INTO `e_dictionaries` VALUES ('133', 'sys_weihuItem_27', '损耗状况|轻微');
INSERT INTO `e_dictionaries` VALUES ('134', 'sys_weihuItem_27', '是否正常启动|是');
INSERT INTO `e_dictionaries` VALUES ('135', 'sys_weihuItem_27', '评价|挖机很漂亮|我想开着炒菜|&');
INSERT INTO `e_dictionaries` VALUES ('136', 'sys_weihuItem_27', '油量剩余%|12');
INSERT INTO `e_dictionaries` VALUES ('137', 'sys_weihuItem_27', '你的生日|2019-05-06 13:19:18');

-- ----------------------------
-- Table structure for e_equipment
-- ----------------------------
DROP TABLE IF EXISTS `e_equipment`;
CREATE TABLE `e_equipment` (
  `oid` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `site_id` int(10) DEFAULT NULL,
  `mubanName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of e_equipment
-- ----------------------------
INSERT INTO `e_equipment` VALUES ('14', '豪华型挖掘机', '6', '挖掘机维护通用模板');
INSERT INTO `e_equipment` VALUES ('15', '报废挖掘机', '8', null);
INSERT INTO `e_equipment` VALUES ('16', '挖掘机', '7', '挖掘机维护通用模板');
INSERT INTO `e_equipment` VALUES ('17', '大卡车', '7', null);
INSERT INTO `e_equipment` VALUES ('18', '宝马大卡车', '6', '卡车通用模板');
INSERT INTO `e_equipment` VALUES ('19', '小推车', '8', null);

-- ----------------------------
-- Table structure for e_maintaingroup
-- ----------------------------
DROP TABLE IF EXISTS `e_maintaingroup`;
CREATE TABLE `e_maintaingroup` (
  `oid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_maintaingroup
-- ----------------------------
INSERT INTO `e_maintaingroup` VALUES ('6', '豪华设备维护组', '这里的设备都是超级豪华的，一般人都不敢碰！');
INSERT INTO `e_maintaingroup` VALUES ('7', '辣鸡设备维护组', '随便摆弄，反正都是坏的');
INSERT INTO `e_maintaingroup` VALUES ('8', '一般设备维护组', '就是那些正常的设备，大家都在用');

-- ----------------------------
-- Table structure for e_maintaingroup_equipment
-- ----------------------------
DROP TABLE IF EXISTS `e_maintaingroup_equipment`;
CREATE TABLE `e_maintaingroup_equipment` (
  `equipment_id` int(10) NOT NULL,
  `maintainGroup_id` int(10) NOT NULL,
  PRIMARY KEY (`equipment_id`,`maintainGroup_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_maintaingroup_equipment
-- ----------------------------
INSERT INTO `e_maintaingroup_equipment` VALUES ('14', '6');
INSERT INTO `e_maintaingroup_equipment` VALUES ('15', '7');
INSERT INTO `e_maintaingroup_equipment` VALUES ('16', '8');
INSERT INTO `e_maintaingroup_equipment` VALUES ('17', '8');
INSERT INTO `e_maintaingroup_equipment` VALUES ('18', '6');
INSERT INTO `e_maintaingroup_equipment` VALUES ('19', '7');

-- ----------------------------
-- Table structure for e_maintaingroup_staff
-- ----------------------------
DROP TABLE IF EXISTS `e_maintaingroup_staff`;
CREATE TABLE `e_maintaingroup_staff` (
  `staff_id` int(10) NOT NULL,
  `maintainGroup_id` int(10) NOT NULL,
  PRIMARY KEY (`staff_id`,`maintainGroup_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_maintaingroup_staff
-- ----------------------------
INSERT INTO `e_maintaingroup_staff` VALUES ('1', '6');
INSERT INTO `e_maintaingroup_staff` VALUES ('1', '7');
INSERT INTO `e_maintaingroup_staff` VALUES ('1', '8');
INSERT INTO `e_maintaingroup_staff` VALUES ('49', '6');
INSERT INTO `e_maintaingroup_staff` VALUES ('49', '8');
INSERT INTO `e_maintaingroup_staff` VALUES ('50', '7');
INSERT INTO `e_maintaingroup_staff` VALUES ('50', '8');

-- ----------------------------
-- Table structure for e_muban
-- ----------------------------
DROP TABLE IF EXISTS `e_muban`;
CREATE TABLE `e_muban` (
  `oid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `filedName` varchar(50) DEFAULT NULL,
  `filedType` varchar(50) DEFAULT NULL COMMENT '文本行text 文本域textarea 数字number 日期datetime 下拉列表select 单选按钮radio 复选框checkbox',
  `filedItem` varchar(255) DEFAULT NULL COMMENT 'a|b|c',
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_muban
-- ----------------------------
INSERT INTO `e_muban` VALUES ('46', '挖掘机维护通用模板', '挖机头磨损', '文本框', '\'\'');
INSERT INTO `e_muban` VALUES ('47', '挖掘机维护通用模板', '损耗状况', '下拉列表', '轻微|中等|严重');
INSERT INTO `e_muban` VALUES ('48', '挖掘机维护通用模板', '是否正常启动', '单选按钮', '是|否');
INSERT INTO `e_muban` VALUES ('49', '挖掘机维护通用模板', '评价', '复选框', '挖机很漂亮|我想开着炒菜|辣鸡挖机');
INSERT INTO `e_muban` VALUES ('50', '挖掘机维护通用模板', '油量剩余%', '数字', '\'\'');
INSERT INTO `e_muban` VALUES ('51', '挖掘机维护通用模板', '你的生日', '日期时间', '\'\'');
INSERT INTO `e_muban` VALUES ('52', '卡车通用模板', '随便填', '日期时间', '\'\'');
INSERT INTO `e_muban` VALUES ('53', '卡车通用模板', '随便填', '文本域', '\'\'');
INSERT INTO `e_muban` VALUES ('54', '卡车通用模板', '随便填', '文本框', '\'\'');
INSERT INTO `e_muban` VALUES ('55', '卡车通用模板', '随便写', '文本域', '\'\'');
INSERT INTO `e_muban` VALUES ('56', '卡车通用模板', '测试1', '文本框', '\'\'');
INSERT INTO `e_muban` VALUES ('57', '卡车通用模板', '测试2', '文本域', '\'\'');
INSERT INTO `e_muban` VALUES ('58', '卡车通用模板', '测试3', '数字', '\'\'');
INSERT INTO `e_muban` VALUES ('59', '卡车通用模板', '测试4', '日期时间', '\'\'');
INSERT INTO `e_muban` VALUES ('60', '卡车通用模板', '测试5', '下拉列表', '5-1|5-2|5-3');
INSERT INTO `e_muban` VALUES ('61', '卡车通用模板', '测试6', '单选按钮', '6-1|6-2|6-3');
INSERT INTO `e_muban` VALUES ('62', '卡车通用模板', '测试7', '复选框', '7-1|7-2|7-3');
INSERT INTO `e_muban` VALUES ('63', '完整测试模板', 'aaa', '文本框', '\'\'');
INSERT INTO `e_muban` VALUES ('64', '完整测试模板', 'bbb', '文本域', '\'\'');
INSERT INTO `e_muban` VALUES ('65', '完整测试模板', 'ccc', '数字', '\'\'');
INSERT INTO `e_muban` VALUES ('66', '完整测试模板', 'ddd', '日期时间', '\'\'');
INSERT INTO `e_muban` VALUES ('67', '完整测试模板', 'eee', '下拉列表', 'e1|e2|e3');
INSERT INTO `e_muban` VALUES ('68', '完整测试模板', 'fff', '单选按钮', 'f1|f2|f3');
INSERT INTO `e_muban` VALUES ('69', '完整测试模板', 'ggg', '复选框', 'g1|g2|g3');
INSERT INTO `e_muban` VALUES ('70', '完整双层测试模板', 'a', '文本框', '\'\'');
INSERT INTO `e_muban` VALUES ('71', '完整双层测试模板', 'aa', '文本框', '\'\'');
INSERT INTO `e_muban` VALUES ('72', '完整双层测试模板', 'b', '文本域', '\'\'');
INSERT INTO `e_muban` VALUES ('73', '完整双层测试模板', 'bb', '文本域', '\'\'');
INSERT INTO `e_muban` VALUES ('74', '完整双层测试模板', 'c', '数字', '\'\'');
INSERT INTO `e_muban` VALUES ('75', '完整双层测试模板', 'cc', '数字', '\'\'');
INSERT INTO `e_muban` VALUES ('76', '完整双层测试模板', 'd', '日期时间', '\'\'');
INSERT INTO `e_muban` VALUES ('77', '完整双层测试模板', 'dd', '日期时间', '\'\'');
INSERT INTO `e_muban` VALUES ('78', '完整双层测试模板', 'e', '下拉列表', 'e1|e2|e3');
INSERT INTO `e_muban` VALUES ('79', '完整双层测试模板', 'ee', '下拉列表', 'ee1|ee2|ee3');
INSERT INTO `e_muban` VALUES ('80', '完整双层测试模板', 'f', '单选按钮', 'f1|f2|f3');
INSERT INTO `e_muban` VALUES ('81', '完整双层测试模板', 'ff', '单选按钮', 'ff1|ff2|ff3');
INSERT INTO `e_muban` VALUES ('82', '完整双层测试模板', 'g', '复选框', 'g1|g2|g3');
INSERT INTO `e_muban` VALUES ('83', '完整双层测试模板', 'gg', '复选框', 'gg1|gg2|gg3');
INSERT INTO `e_muban` VALUES ('84', 'aaaa', 'aaa', '文本框', '\'\'');
INSERT INTO `e_muban` VALUES ('85', 'aaaa', 'aaa', '文本框', '\'\'');
INSERT INTO `e_muban` VALUES ('86', 'aaaa', 'aaa', '文本框', '\'\'');
INSERT INTO `e_muban` VALUES ('87', 'aaaa', 'aaa', '文本框', '\'\'');
INSERT INTO `e_muban` VALUES ('88', 'sss', 'sss', '文本框', '\'\'');
INSERT INTO `e_muban` VALUES ('89', 'sss', 'sss', '文本框', '\'\'');
INSERT INTO `e_muban` VALUES ('90', 'ddd', 'ddd', '文本框', '\'\'');

-- ----------------------------
-- Table structure for e_record
-- ----------------------------
DROP TABLE IF EXISTS `e_record`;
CREATE TABLE `e_record` (
  `oid` int(10) NOT NULL AUTO_INCREMENT,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `info` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `staff_id` int(10) DEFAULT NULL,
  `equipment_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of e_record
-- ----------------------------
INSERT INTO `e_record` VALUES ('7', '2019-05-05 10:47:30', '这个挖掘机看着一般，实则确实很一般，哈哈哈', '49', '16');
INSERT INTO `e_record` VALUES ('8', '2019-05-05 10:47:41', '好吧，再加一条', '49', '16');
INSERT INTO `e_record` VALUES ('9', '2019-05-05 10:48:59', '这台机器确实很废，都启动不了！', '50', '15');
INSERT INTO `e_record` VALUES ('10', '2019-05-05 10:49:27', '启动的了，原来是我没开开关....', '50', '15');
INSERT INTO `e_record` VALUES ('12', '2019-05-05 15:41:44', 'gy', '49', '14');
INSERT INTO `e_record` VALUES ('13', '2019-05-05 15:50:24', '', '49', '14');
INSERT INTO `e_record` VALUES ('14', '2019-05-05 15:51:38', '', '49', '14');
INSERT INTO `e_record` VALUES ('15', '2019-05-05 15:53:05', '', '49', '14');
INSERT INTO `e_record` VALUES ('16', '2019-05-05 15:54:03', 'xxx', '49', '14');
INSERT INTO `e_record` VALUES ('17', '2019-05-05 16:10:52', '', '49', '14');
INSERT INTO `e_record` VALUES ('18', '2019-05-05 16:22:28', '', '49', '14');
INSERT INTO `e_record` VALUES ('19', '2019-05-05 16:22:43', '', '49', '14');
INSERT INTO `e_record` VALUES ('20', '2019-05-05 16:23:27', '', '49', '14');
INSERT INTO `e_record` VALUES ('21', '2019-05-05 16:25:01', '', '49', '14');
INSERT INTO `e_record` VALUES ('22', '2019-05-05 16:52:29', '概要信息', '49', '14');
INSERT INTO `e_record` VALUES ('23', '2019-05-05 17:29:13', '概要信息', '49', '14');
INSERT INTO `e_record` VALUES ('24', '2019-05-05 17:53:56', 'xxx', '49', '14');
INSERT INTO `e_record` VALUES ('25', '2019-05-05 17:55:34', 'sss', '49', '14');
INSERT INTO `e_record` VALUES ('27', '2019-05-06 13:19:28', 'sss', '50', '16');

-- ----------------------------
-- Table structure for e_site
-- ----------------------------
DROP TABLE IF EXISTS `e_site`;
CREATE TABLE `e_site` (
  `oid` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `info` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of e_site
-- ----------------------------
INSERT INTO `e_site` VALUES ('6', '别墅区', '800平米大别墅，住的人非富即贵');
INSERT INTO `e_site` VALUES ('7', '环湖区', '景色宜人，住这的都是爱美的人');
INSERT INTO `e_site` VALUES ('8', '贫民区', '就是一般的房子，有钱谁住着啊');

-- ----------------------------
-- Table structure for e_staff
-- ----------------------------
DROP TABLE IF EXISTS `e_staff`;
CREATE TABLE `e_staff` (
  `oid` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `age` int(3) unsigned DEFAULT NULL,
  `sex` varchar(1) COLLATE utf8_bin DEFAULT '' COMMENT '男1，女2',
  `zhicheng` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `image` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `department` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `site_id` int(10) DEFAULT NULL,
  `maintainGroup_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE,
  UNIQUE KEY `FK_1546` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of e_staff
-- ----------------------------
INSERT INTO `e_staff` VALUES ('1', 'admin', 'admin', 'admin', '1', '1', '无', '1234567890', '1234567890@163.com', null, '无', null, null);
INSERT INTO `e_staff` VALUES ('49', '王小波', 'wangxiaobo', 'wangxiaobo', '18', '女', '装饰大师,一级建造师', '18888888888', '18888888888@qq.com', null, '装修部', '6', null);
INSERT INTO `e_staff` VALUES ('50', '王博', 'wangbo', 'wangbo', '24', '男', '一级建造师,搬砖大师', '16666666666', '16666666666@163.com', null, '施工部', '7', null);

-- ----------------------------
-- Table structure for e_staff_equipment
-- ----------------------------
DROP TABLE IF EXISTS `e_staff_equipment`;
CREATE TABLE `e_staff_equipment` (
  `equipment_id` int(11) NOT NULL DEFAULT '0',
  `staff_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`staff_id`,`equipment_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of e_staff_equipment
-- ----------------------------
INSERT INTO `e_staff_equipment` VALUES ('14', '49');
INSERT INTO `e_staff_equipment` VALUES ('16', '49');
INSERT INTO `e_staff_equipment` VALUES ('17', '49');
INSERT INTO `e_staff_equipment` VALUES ('18', '49');
INSERT INTO `e_staff_equipment` VALUES ('15', '50');
INSERT INTO `e_staff_equipment` VALUES ('16', '50');
INSERT INTO `e_staff_equipment` VALUES ('17', '50');
INSERT INTO `e_staff_equipment` VALUES ('19', '50');
