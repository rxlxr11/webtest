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

 Date: 19/02/2025 14:38:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bookmanage
-- ----------------------------
DROP TABLE IF EXISTS `bookmanage`;
CREATE TABLE `bookmanage` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `name` varchar(255) NOT NULL COMMENT '图书名称',
  `author` varchar(255) NOT NULL COMMENT '图书作者',
  `time` datetime NOT NULL COMMENT '购买时间',
  `type` int NOT NULL COMMENT '图书分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of bookmanage
-- ----------------------------
BEGIN;
INSERT INTO `bookmanage` (`id`, `name`, `author`, `time`, `type`) VALUES (2, '水浒传', '施耐庵', '2025-02-15 20:21:14', 2);
INSERT INTO `bookmanage` (`id`, `name`, `author`, `time`, `type`) VALUES (3, 'Java学习', '陈丹丹', '2025-02-15 22:13:46', 1);
INSERT INTO `bookmanage` (`id`, `name`, `author`, `time`, `type`) VALUES (4, 'Java编程思想', '埃克尔', '2025-02-15 22:14:13', 1);
INSERT INTO `bookmanage` (`id`, `name`, `author`, `time`, `type`) VALUES (5, '摄影技巧', '摄影天地', '2025-02-15 22:14:41', 3);
INSERT INTO `bookmanage` (`id`, `name`, `author`, `time`, `type`) VALUES (6, '测试案例', '李新荣', '2020-11-21 16:00:00', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
