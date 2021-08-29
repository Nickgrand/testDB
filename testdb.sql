/*
 Navicat Premium Data Transfer

 Source Server         : connect
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : testdb

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 29/08/2021 23:20:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for testtable
-- ----------------------------
DROP TABLE IF EXISTS `testtable`;
CREATE TABLE `testtable`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `createTime` datetime NULL DEFAULT NULL,
  `deleted` tinyint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of testtable
-- ----------------------------
INSERT INTO `testtable` VALUES (1, '华*', 123, '2021-08-29 23:18:29', 0);
INSERT INTO `testtable` VALUES (2, '你*', 663, '2021-08-29 23:18:29', 2);
INSERT INTO `testtable` VALUES (3, '测**', 62, '2021-08-29 23:18:29', 0);
INSERT INTO `testtable` VALUES (4, '测**', 62, '2021-08-29 23:18:29', 1);
INSERT INTO `testtable` VALUES (5, '测**', 62, '2021-08-29 23:18:29', 1);
INSERT INTO `testtable` VALUES (6, '两*', 62, '2021-08-29 23:18:29', 1);
INSERT INTO `testtable` VALUES (7, '', 62, '2021-08-29 23:18:29', 1);

SET FOREIGN_KEY_CHECKS = 1;
