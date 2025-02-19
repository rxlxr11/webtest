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

 Date: 19/02/2025 14:38:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for studentInfo
-- ----------------------------
DROP TABLE IF EXISTS `studentInfo`;
CREATE TABLE `studentInfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sname` varchar(255) NOT NULL,
  `sgender` varchar(255) NOT NULL,
  `sage` int NOT NULL,
  `saddress` varchar(255) DEFAULT NULL,
  `semail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of studentInfo
-- ----------------------------
BEGIN;
INSERT INTO `studentInfo` (`id`, `sname`, `sgender`, `sage`, `saddress`, `semail`) VALUES (1, '李新荣', '男', 11, 'ss', 'dd');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
