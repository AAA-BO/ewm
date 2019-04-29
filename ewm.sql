/*
 Navicat Premium Data Transfer

 Source Server         : 本地连接
 Source Server Type    : MySQL
 Source Server Version : 50549
 Source Host           : localhost:3306
 Source Schema         : ewm

 Target Server Type    : MySQL
 Target Server Version : 50549
 File Encoding         : 65001

 Date: 29/04/2019 18:45:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for e_equipment
-- ----------------------------
DROP TABLE IF EXISTS `e_equipment`;
CREATE TABLE `e_equipment`  (
  `oid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of e_equipment
-- ----------------------------
INSERT INTO `e_equipment` VALUES (3, 'aa');
INSERT INTO `e_equipment` VALUES (4, 'ss');

-- ----------------------------
-- Table structure for e_record
-- ----------------------------
DROP TABLE IF EXISTS `e_record`;
CREATE TABLE `e_record`  (
  `oid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `staff_id` int(11) DEFAULT NULL,
  `equipment_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for e_staff
-- ----------------------------
DROP TABLE IF EXISTS `e_staff`;
CREATE TABLE `e_staff`  (
  `oid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sex` int(1) UNSIGNED DEFAULT 0 COMMENT '未知0，男1，女2',
  `zhicheng` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `image` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `department` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE,
  UNIQUE INDEX `FK_1546`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of e_staff
-- ----------------------------
INSERT INTO `e_staff` VALUES (13, 'aaa', 'aaa', 'aaa', 1, '初级建造师,中级建造师,高级建造师', '1234567890', '123456789@163.com', '', '设备一部');

-- ----------------------------
-- Table structure for e_staff_equipment
-- ----------------------------
DROP TABLE IF EXISTS `e_staff_equipment`;
CREATE TABLE `e_staff_equipment`  (
  `e_id` int(11) NOT NULL,
  `s_id` int(11) NOT NULL,
  PRIMARY KEY (`s_id`, `e_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
