/*
 Navicat Premium Dump SQL

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 90100 (9.1.0)
 Source Host           : localhost:3306
 Source Schema         : yb2

 Target Server Type    : MySQL
 Target Server Version : 90100 (9.1.0)
 File Encoding         : 65001

 Date: 19/02/2025 09:55:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for branches
-- ----------------------------
DROP TABLE IF EXISTS `branches`;
CREATE TABLE `branches` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '网点编号',
  `businessNo` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `cityArea` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of branches
-- ----------------------------
BEGIN;
INSERT INTO `branches` (`id`, `businessNo`, `name`, `cityArea`, `address`, `telephone`, `summary`) VALUES (1, '111', '哈哈哈', '嗷嗷', '暗暗', '11', '111');
INSERT INTO `branches` (`id`, `businessNo`, `name`, `cityArea`, `address`, `telephone`, `summary`) VALUES (2, '111', 'ss', 'sss', 'ddd', '222', 'aaa');
INSERT INTO `branches` (`id`, `businessNo`, `name`, `cityArea`, `address`, `telephone`, `summary`) VALUES (3, '888', 'jj', 'jjjj', 'ddd', '000', 'hhh');
INSERT INTO `branches` (`id`, `businessNo`, `name`, `cityArea`, `address`, `telephone`, `summary`) VALUES (4, '111', 'jj', 'jjjj', 'ddd', '000', '');
INSERT INTO `branches` (`id`, `businessNo`, `name`, `cityArea`, `address`, `telephone`, `summary`) VALUES (5, '888', 'jj', 'jjjj', 'ddd', '', '');
INSERT INTO `branches` (`id`, `businessNo`, `name`, `cityArea`, `address`, `telephone`, `summary`) VALUES (6, '1119', 'jj', 'jjjj', 'ddd', '', '');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
