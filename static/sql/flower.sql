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

 Date: 19/02/2025 14:39:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for flower
-- ----------------------------
DROP TABLE IF EXISTS `flower`;
CREATE TABLE `flower` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `nickName` varchar(255) NOT NULL,
  `property` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `production` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of flower
-- ----------------------------
BEGIN;
INSERT INTO `flower` (`id`, `name`, `nickName`, `property`, `price`, `production`) VALUES (1, '矮牵牛', '牵牛花', '茄克', 10.00, '欧洲');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
