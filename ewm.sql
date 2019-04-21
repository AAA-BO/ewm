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

 Date: 17/04/2019 21:24:13
*/

-- SET NAMES utf8mb4;
-- SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for e_equipment
-- ----------------------------
DROP TABLE IF EXISTS `e_equipment`;
CREATE TABLE `e_equipment`  (
  `oid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of e_equipment
-- ----------------------------
INSERT INTO `e_equipment` VALUES (10, '挖掘机sd');
INSERT INTO `e_equipment` VALUES (11, '推土机');
INSERT INTO `e_equipment` VALUES (19, 'a');
INSERT INTO `e_equipment` VALUES (20, 'a');
INSERT INTO `e_equipment` VALUES (21, 'a');
INSERT INTO `e_equipment` VALUES (22, 'aa');
INSERT INTO `e_equipment` VALUES (23, 'a');
INSERT INTO `e_equipment` VALUES (24, 'a');
INSERT INTO `e_equipment` VALUES (25, 'a');
INSERT INTO `e_equipment` VALUES (28, 'a');
INSERT INTO `e_equipment` VALUES (29, 'a');
INSERT INTO `e_equipment` VALUES (30, 'a');
INSERT INTO `e_equipment` VALUES (31, 'a');
INSERT INTO `e_equipment` VALUES (32, 'a');
INSERT INTO `e_equipment` VALUES (33, 'a');
INSERT INTO `e_equipment` VALUES (34, 'a');
INSERT INTO `e_equipment` VALUES (35, 'a');
INSERT INTO `e_equipment` VALUES (36, 'a');
INSERT INTO `e_equipment` VALUES (37, 'a');
INSERT INTO `e_equipment` VALUES (38, 'a');
INSERT INTO `e_equipment` VALUES (39, 'a');
INSERT INTO `e_equipment` VALUES (40, 'a');
INSERT INTO `e_equipment` VALUES (41, 'a');
INSERT INTO `e_equipment` VALUES (42, 'a');
INSERT INTO `e_equipment` VALUES (43, 'a');
INSERT INTO `e_equipment` VALUES (44, 'ss');

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
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of e_record
-- ----------------------------
INSERT INTO `e_record` VALUES (1, '2019-04-12 17:37:36', '维护记录维护记录维护记录维护记录维护记录维护记录维维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录维护记录', 3, 10);
INSERT INTO `e_record` VALUES (3, '2019-04-14 12:25:01', 'asdsd', 3, 10);
INSERT INTO `e_record` VALUES (5, '2019-04-17 19:24:53', 'sad', 3, 11);
INSERT INTO `e_record` VALUES (6, '2019-04-14 12:26:23', 'asdqwe', 3, 10);
INSERT INTO `e_record` VALUES (7, '2019-04-17 20:21:36', 'sad', 4, 11);
INSERT INTO `e_record` VALUES (8, '2019-04-14 16:32:26', 'asdsadasd', 3, 10);
INSERT INTO `e_record` VALUES (9, '2019-04-17 20:03:10', 'asd', 3, 10);
INSERT INTO `e_record` VALUES (10, '2019-04-17 20:21:33', 'eee', 22, 11);
INSERT INTO `e_record` VALUES (11, '2019-04-17 20:03:11', 'eee', 3, 10);
INSERT INTO `e_record` VALUES (12, '2019-04-17 20:03:12', 'eee', 3, 10);
INSERT INTO `e_record` VALUES (13, '2019-04-17 20:03:12', 'eee', 3, 10);
INSERT INTO `e_record` VALUES (14, '2019-04-17 20:03:12', 'eee', 3, 10);
INSERT INTO `e_record` VALUES (15, '2019-04-17 20:03:13', 'aaa', 3, 10);
INSERT INTO `e_record` VALUES (16, '2019-04-17 20:03:14', 'bbb', 3, 10);
INSERT INTO `e_record` VALUES (17, '2019-04-14 22:00:43', 'ccc', 22, 10);
INSERT INTO `e_record` VALUES (18, '2019-04-14 22:10:51', 'sss', 4, 10);
INSERT INTO `e_record` VALUES (19, '2019-04-14 22:10:54', 'bbb', 4, 10);
INSERT INTO `e_record` VALUES (20, '2019-04-14 22:47:22', '111', 22, 10);
INSERT INTO `e_record` VALUES (21, '2019-04-14 22:53:28', 'ads', 22, 10);
INSERT INTO `e_record` VALUES (22, '2019-04-14 22:53:29', 'asqwe', 22, 10);
INSERT INTO `e_record` VALUES (23, '2019-04-14 22:53:30', 'qwewqe', 22, 10);
INSERT INTO `e_record` VALUES (24, '2019-04-14 22:53:31', 'qweqwe', 22, 10);
INSERT INTO `e_record` VALUES (25, '2019-04-14 22:53:32', 'qweqwe', 22, 10);
INSERT INTO `e_record` VALUES (26, '2019-04-14 22:53:33', 'qewqwe', 22, 10);
INSERT INTO `e_record` VALUES (27, '2019-04-14 22:53:34', 'qweqwe', 22, 10);
INSERT INTO `e_record` VALUES (28, '2019-04-17 21:06:11', 'asd', 22, 11);
INSERT INTO `e_record` VALUES (29, '2019-04-17 21:06:48', 'asdasd', 22, 11);
INSERT INTO `e_record` VALUES (30, '2019-04-17 21:06:55', 'asdasd', 22, 11);
INSERT INTO `e_record` VALUES (31, '2019-04-17 21:07:04', 'asdasd', 22, 11);
INSERT INTO `e_record` VALUES (32, '2019-04-17 21:17:59', 'asda', 22, 11);
INSERT INTO `e_record` VALUES (33, '2019-04-17 21:18:15', '123456', 22, 11);

-- ----------------------------
-- Table structure for e_staff
-- ----------------------------
DROP TABLE IF EXISTS `e_staff`;
CREATE TABLE `e_staff`  (
  `oid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`oid`) USING BTREE,
  UNIQUE INDEX `FK_1546`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of e_staff
-- ----------------------------
INSERT INTO `e_staff` VALUES (3, '张三sds', 'aaa', 'aaa');
INSERT INTO `e_staff` VALUES (4, '李四sdb', 'bbb', 'bbb');
INSERT INTO `e_staff` VALUES (12, 'a', 'bb', 'bb');
INSERT INTO `e_staff` VALUES (15, 'sss', 'b', 'b');
INSERT INTO `e_staff` VALUES (16, 'sss', 'bd', 'dd');
INSERT INTO `e_staff` VALUES (17, 'sss', 'd', 's');
INSERT INTO `e_staff` VALUES (18, 'ddd', 'ds', 'qw');
INSERT INTO `e_staff` VALUES (19, 'sss', 'qweqwe', 'eqweqw');
INSERT INTO `e_staff` VALUES (22, 'eee', 'eee', 'eee');
INSERT INTO `e_staff` VALUES (23, 'qqq', 'qqq', 'qqq');

-- ----------------------------
-- Table structure for e_staff_equipment
-- ----------------------------
DROP TABLE IF EXISTS `e_staff_equipment`;
CREATE TABLE `e_staff_equipment`  (
  `e_id` int(11) NOT NULL,
  `s_id` int(11) NOT NULL,
  PRIMARY KEY (`s_id`, `e_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of e_staff_equipment
-- ----------------------------
INSERT INTO `e_staff_equipment` VALUES (11, 3);
INSERT INTO `e_staff_equipment` VALUES (19, 3);
INSERT INTO `e_staff_equipment` VALUES (20, 3);
INSERT INTO `e_staff_equipment` VALUES (21, 3);
INSERT INTO `e_staff_equipment` VALUES (22, 3);
INSERT INTO `e_staff_equipment` VALUES (23, 3);
INSERT INTO `e_staff_equipment` VALUES (24, 3);
INSERT INTO `e_staff_equipment` VALUES (25, 3);
INSERT INTO `e_staff_equipment` VALUES (28, 3);
INSERT INTO `e_staff_equipment` VALUES (29, 3);
INSERT INTO `e_staff_equipment` VALUES (30, 3);
INSERT INTO `e_staff_equipment` VALUES (31, 3);
INSERT INTO `e_staff_equipment` VALUES (32, 3);
INSERT INTO `e_staff_equipment` VALUES (33, 3);
INSERT INTO `e_staff_equipment` VALUES (34, 3);
INSERT INTO `e_staff_equipment` VALUES (35, 3);
INSERT INTO `e_staff_equipment` VALUES (36, 3);
INSERT INTO `e_staff_equipment` VALUES (37, 3);
INSERT INTO `e_staff_equipment` VALUES (38, 3);
INSERT INTO `e_staff_equipment` VALUES (39, 3);
INSERT INTO `e_staff_equipment` VALUES (40, 3);
INSERT INTO `e_staff_equipment` VALUES (41, 3);
INSERT INTO `e_staff_equipment` VALUES (42, 3);
INSERT INTO `e_staff_equipment` VALUES (43, 3);
INSERT INTO `e_staff_equipment` VALUES (44, 3);
INSERT INTO `e_staff_equipment` VALUES (10, 4);
INSERT INTO `e_staff_equipment` VALUES (11, 4);
INSERT INTO `e_staff_equipment` VALUES (19, 4);
INSERT INTO `e_staff_equipment` VALUES (20, 4);
INSERT INTO `e_staff_equipment` VALUES (21, 4);
INSERT INTO `e_staff_equipment` VALUES (22, 4);
INSERT INTO `e_staff_equipment` VALUES (23, 4);
INSERT INTO `e_staff_equipment` VALUES (24, 4);
INSERT INTO `e_staff_equipment` VALUES (25, 4);
INSERT INTO `e_staff_equipment` VALUES (28, 4);
INSERT INTO `e_staff_equipment` VALUES (29, 4);
INSERT INTO `e_staff_equipment` VALUES (30, 4);
INSERT INTO `e_staff_equipment` VALUES (31, 4);
INSERT INTO `e_staff_equipment` VALUES (32, 4);
INSERT INTO `e_staff_equipment` VALUES (33, 4);
INSERT INTO `e_staff_equipment` VALUES (34, 4);
INSERT INTO `e_staff_equipment` VALUES (35, 4);
INSERT INTO `e_staff_equipment` VALUES (36, 4);
INSERT INTO `e_staff_equipment` VALUES (37, 4);
INSERT INTO `e_staff_equipment` VALUES (38, 4);
INSERT INTO `e_staff_equipment` VALUES (39, 4);
INSERT INTO `e_staff_equipment` VALUES (40, 4);
INSERT INTO `e_staff_equipment` VALUES (41, 4);
INSERT INTO `e_staff_equipment` VALUES (42, 4);
INSERT INTO `e_staff_equipment` VALUES (43, 4);
INSERT INTO `e_staff_equipment` VALUES (44, 4);
INSERT INTO `e_staff_equipment` VALUES (10, 12);
INSERT INTO `e_staff_equipment` VALUES (11, 12);
INSERT INTO `e_staff_equipment` VALUES (19, 12);
INSERT INTO `e_staff_equipment` VALUES (20, 12);
INSERT INTO `e_staff_equipment` VALUES (21, 12);
INSERT INTO `e_staff_equipment` VALUES (22, 12);
INSERT INTO `e_staff_equipment` VALUES (23, 12);
INSERT INTO `e_staff_equipment` VALUES (24, 12);
INSERT INTO `e_staff_equipment` VALUES (25, 12);
INSERT INTO `e_staff_equipment` VALUES (28, 12);
INSERT INTO `e_staff_equipment` VALUES (29, 12);
INSERT INTO `e_staff_equipment` VALUES (30, 12);
INSERT INTO `e_staff_equipment` VALUES (31, 12);
INSERT INTO `e_staff_equipment` VALUES (32, 12);
INSERT INTO `e_staff_equipment` VALUES (33, 12);
INSERT INTO `e_staff_equipment` VALUES (34, 12);
INSERT INTO `e_staff_equipment` VALUES (35, 12);
INSERT INTO `e_staff_equipment` VALUES (36, 12);
INSERT INTO `e_staff_equipment` VALUES (37, 12);
INSERT INTO `e_staff_equipment` VALUES (38, 12);
INSERT INTO `e_staff_equipment` VALUES (39, 12);
INSERT INTO `e_staff_equipment` VALUES (40, 12);
INSERT INTO `e_staff_equipment` VALUES (41, 12);
INSERT INTO `e_staff_equipment` VALUES (42, 12);
INSERT INTO `e_staff_equipment` VALUES (43, 12);
INSERT INTO `e_staff_equipment` VALUES (44, 12);
INSERT INTO `e_staff_equipment` VALUES (11, 15);
INSERT INTO `e_staff_equipment` VALUES (19, 15);
INSERT INTO `e_staff_equipment` VALUES (20, 15);
INSERT INTO `e_staff_equipment` VALUES (21, 15);
INSERT INTO `e_staff_equipment` VALUES (22, 15);
INSERT INTO `e_staff_equipment` VALUES (23, 15);
INSERT INTO `e_staff_equipment` VALUES (24, 15);
INSERT INTO `e_staff_equipment` VALUES (25, 15);
INSERT INTO `e_staff_equipment` VALUES (28, 15);
INSERT INTO `e_staff_equipment` VALUES (29, 15);
INSERT INTO `e_staff_equipment` VALUES (30, 15);
INSERT INTO `e_staff_equipment` VALUES (31, 15);
INSERT INTO `e_staff_equipment` VALUES (32, 15);
INSERT INTO `e_staff_equipment` VALUES (33, 15);
INSERT INTO `e_staff_equipment` VALUES (34, 15);
INSERT INTO `e_staff_equipment` VALUES (35, 15);
INSERT INTO `e_staff_equipment` VALUES (36, 15);
INSERT INTO `e_staff_equipment` VALUES (37, 15);
INSERT INTO `e_staff_equipment` VALUES (38, 15);
INSERT INTO `e_staff_equipment` VALUES (39, 15);
INSERT INTO `e_staff_equipment` VALUES (40, 15);
INSERT INTO `e_staff_equipment` VALUES (41, 15);
INSERT INTO `e_staff_equipment` VALUES (42, 15);
INSERT INTO `e_staff_equipment` VALUES (43, 15);
INSERT INTO `e_staff_equipment` VALUES (44, 15);
INSERT INTO `e_staff_equipment` VALUES (10, 16);
INSERT INTO `e_staff_equipment` VALUES (11, 16);
INSERT INTO `e_staff_equipment` VALUES (19, 16);
INSERT INTO `e_staff_equipment` VALUES (20, 16);
INSERT INTO `e_staff_equipment` VALUES (21, 16);
INSERT INTO `e_staff_equipment` VALUES (22, 16);
INSERT INTO `e_staff_equipment` VALUES (23, 16);
INSERT INTO `e_staff_equipment` VALUES (24, 16);
INSERT INTO `e_staff_equipment` VALUES (25, 16);
INSERT INTO `e_staff_equipment` VALUES (28, 16);
INSERT INTO `e_staff_equipment` VALUES (29, 16);
INSERT INTO `e_staff_equipment` VALUES (30, 16);
INSERT INTO `e_staff_equipment` VALUES (31, 16);
INSERT INTO `e_staff_equipment` VALUES (32, 16);
INSERT INTO `e_staff_equipment` VALUES (33, 16);
INSERT INTO `e_staff_equipment` VALUES (34, 16);
INSERT INTO `e_staff_equipment` VALUES (35, 16);
INSERT INTO `e_staff_equipment` VALUES (36, 16);
INSERT INTO `e_staff_equipment` VALUES (37, 16);
INSERT INTO `e_staff_equipment` VALUES (38, 16);
INSERT INTO `e_staff_equipment` VALUES (39, 16);
INSERT INTO `e_staff_equipment` VALUES (40, 16);
INSERT INTO `e_staff_equipment` VALUES (41, 16);
INSERT INTO `e_staff_equipment` VALUES (42, 16);
INSERT INTO `e_staff_equipment` VALUES (43, 16);
INSERT INTO `e_staff_equipment` VALUES (44, 16);
INSERT INTO `e_staff_equipment` VALUES (10, 17);
INSERT INTO `e_staff_equipment` VALUES (11, 17);
INSERT INTO `e_staff_equipment` VALUES (19, 17);
INSERT INTO `e_staff_equipment` VALUES (20, 17);
INSERT INTO `e_staff_equipment` VALUES (21, 17);
INSERT INTO `e_staff_equipment` VALUES (22, 17);
INSERT INTO `e_staff_equipment` VALUES (23, 17);
INSERT INTO `e_staff_equipment` VALUES (24, 17);
INSERT INTO `e_staff_equipment` VALUES (25, 17);
INSERT INTO `e_staff_equipment` VALUES (28, 17);
INSERT INTO `e_staff_equipment` VALUES (29, 17);
INSERT INTO `e_staff_equipment` VALUES (30, 17);
INSERT INTO `e_staff_equipment` VALUES (31, 17);
INSERT INTO `e_staff_equipment` VALUES (32, 17);
INSERT INTO `e_staff_equipment` VALUES (33, 17);
INSERT INTO `e_staff_equipment` VALUES (34, 17);
INSERT INTO `e_staff_equipment` VALUES (35, 17);
INSERT INTO `e_staff_equipment` VALUES (36, 17);
INSERT INTO `e_staff_equipment` VALUES (37, 17);
INSERT INTO `e_staff_equipment` VALUES (38, 17);
INSERT INTO `e_staff_equipment` VALUES (39, 17);
INSERT INTO `e_staff_equipment` VALUES (40, 17);
INSERT INTO `e_staff_equipment` VALUES (41, 17);
INSERT INTO `e_staff_equipment` VALUES (42, 17);
INSERT INTO `e_staff_equipment` VALUES (43, 17);
INSERT INTO `e_staff_equipment` VALUES (44, 17);
INSERT INTO `e_staff_equipment` VALUES (10, 18);
INSERT INTO `e_staff_equipment` VALUES (11, 18);
INSERT INTO `e_staff_equipment` VALUES (19, 18);
INSERT INTO `e_staff_equipment` VALUES (20, 18);
INSERT INTO `e_staff_equipment` VALUES (21, 18);
INSERT INTO `e_staff_equipment` VALUES (22, 18);
INSERT INTO `e_staff_equipment` VALUES (23, 18);
INSERT INTO `e_staff_equipment` VALUES (24, 18);
INSERT INTO `e_staff_equipment` VALUES (25, 18);
INSERT INTO `e_staff_equipment` VALUES (28, 18);
INSERT INTO `e_staff_equipment` VALUES (29, 18);
INSERT INTO `e_staff_equipment` VALUES (30, 18);
INSERT INTO `e_staff_equipment` VALUES (31, 18);
INSERT INTO `e_staff_equipment` VALUES (32, 18);
INSERT INTO `e_staff_equipment` VALUES (33, 18);
INSERT INTO `e_staff_equipment` VALUES (34, 18);
INSERT INTO `e_staff_equipment` VALUES (35, 18);
INSERT INTO `e_staff_equipment` VALUES (36, 18);
INSERT INTO `e_staff_equipment` VALUES (37, 18);
INSERT INTO `e_staff_equipment` VALUES (38, 18);
INSERT INTO `e_staff_equipment` VALUES (39, 18);
INSERT INTO `e_staff_equipment` VALUES (40, 18);
INSERT INTO `e_staff_equipment` VALUES (41, 18);
INSERT INTO `e_staff_equipment` VALUES (42, 18);
INSERT INTO `e_staff_equipment` VALUES (43, 18);
INSERT INTO `e_staff_equipment` VALUES (44, 18);
INSERT INTO `e_staff_equipment` VALUES (10, 19);
INSERT INTO `e_staff_equipment` VALUES (11, 19);
INSERT INTO `e_staff_equipment` VALUES (19, 19);
INSERT INTO `e_staff_equipment` VALUES (20, 19);
INSERT INTO `e_staff_equipment` VALUES (21, 19);
INSERT INTO `e_staff_equipment` VALUES (22, 19);
INSERT INTO `e_staff_equipment` VALUES (23, 19);
INSERT INTO `e_staff_equipment` VALUES (24, 19);
INSERT INTO `e_staff_equipment` VALUES (25, 19);
INSERT INTO `e_staff_equipment` VALUES (28, 19);
INSERT INTO `e_staff_equipment` VALUES (29, 19);
INSERT INTO `e_staff_equipment` VALUES (30, 19);
INSERT INTO `e_staff_equipment` VALUES (31, 19);
INSERT INTO `e_staff_equipment` VALUES (32, 19);
INSERT INTO `e_staff_equipment` VALUES (33, 19);
INSERT INTO `e_staff_equipment` VALUES (34, 19);
INSERT INTO `e_staff_equipment` VALUES (35, 19);
INSERT INTO `e_staff_equipment` VALUES (36, 19);
INSERT INTO `e_staff_equipment` VALUES (37, 19);
INSERT INTO `e_staff_equipment` VALUES (38, 19);
INSERT INTO `e_staff_equipment` VALUES (39, 19);
INSERT INTO `e_staff_equipment` VALUES (40, 19);
INSERT INTO `e_staff_equipment` VALUES (41, 19);
INSERT INTO `e_staff_equipment` VALUES (42, 19);
INSERT INTO `e_staff_equipment` VALUES (43, 19);
INSERT INTO `e_staff_equipment` VALUES (44, 19);
INSERT INTO `e_staff_equipment` VALUES (10, 22);
INSERT INTO `e_staff_equipment` VALUES (11, 22);
INSERT INTO `e_staff_equipment` VALUES (19, 22);
INSERT INTO `e_staff_equipment` VALUES (20, 22);
INSERT INTO `e_staff_equipment` VALUES (21, 22);
INSERT INTO `e_staff_equipment` VALUES (22, 22);
INSERT INTO `e_staff_equipment` VALUES (23, 22);
INSERT INTO `e_staff_equipment` VALUES (24, 22);
INSERT INTO `e_staff_equipment` VALUES (25, 22);
INSERT INTO `e_staff_equipment` VALUES (28, 22);
INSERT INTO `e_staff_equipment` VALUES (29, 22);
INSERT INTO `e_staff_equipment` VALUES (30, 22);
INSERT INTO `e_staff_equipment` VALUES (31, 22);
INSERT INTO `e_staff_equipment` VALUES (32, 22);
INSERT INTO `e_staff_equipment` VALUES (33, 22);
INSERT INTO `e_staff_equipment` VALUES (34, 22);
INSERT INTO `e_staff_equipment` VALUES (35, 22);
INSERT INTO `e_staff_equipment` VALUES (36, 22);
INSERT INTO `e_staff_equipment` VALUES (37, 22);
INSERT INTO `e_staff_equipment` VALUES (38, 22);
INSERT INTO `e_staff_equipment` VALUES (39, 22);
INSERT INTO `e_staff_equipment` VALUES (40, 22);
INSERT INTO `e_staff_equipment` VALUES (41, 22);
INSERT INTO `e_staff_equipment` VALUES (42, 22);
INSERT INTO `e_staff_equipment` VALUES (43, 22);
INSERT INTO `e_staff_equipment` VALUES (44, 22);
INSERT INTO `e_staff_equipment` VALUES (10, 23);
INSERT INTO `e_staff_equipment` VALUES (11, 23);
INSERT INTO `e_staff_equipment` VALUES (19, 23);
INSERT INTO `e_staff_equipment` VALUES (20, 23);
INSERT INTO `e_staff_equipment` VALUES (21, 23);
INSERT INTO `e_staff_equipment` VALUES (22, 23);
INSERT INTO `e_staff_equipment` VALUES (23, 23);
INSERT INTO `e_staff_equipment` VALUES (24, 23);
INSERT INTO `e_staff_equipment` VALUES (25, 23);
INSERT INTO `e_staff_equipment` VALUES (28, 23);
INSERT INTO `e_staff_equipment` VALUES (29, 23);
INSERT INTO `e_staff_equipment` VALUES (30, 23);
INSERT INTO `e_staff_equipment` VALUES (31, 23);
INSERT INTO `e_staff_equipment` VALUES (32, 23);
INSERT INTO `e_staff_equipment` VALUES (33, 23);
INSERT INTO `e_staff_equipment` VALUES (34, 23);
INSERT INTO `e_staff_equipment` VALUES (35, 23);
INSERT INTO `e_staff_equipment` VALUES (36, 23);
INSERT INTO `e_staff_equipment` VALUES (37, 23);
INSERT INTO `e_staff_equipment` VALUES (38, 23);
INSERT INTO `e_staff_equipment` VALUES (39, 23);
INSERT INTO `e_staff_equipment` VALUES (40, 23);
INSERT INTO `e_staff_equipment` VALUES (41, 23);
INSERT INTO `e_staff_equipment` VALUES (42, 23);
INSERT INTO `e_staff_equipment` VALUES (43, 23);
INSERT INTO `e_staff_equipment` VALUES (44, 23);

SET FOREIGN_KEY_CHECKS = 1;
