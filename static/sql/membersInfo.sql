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

 Date: 19/02/2025 09:55:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for membersInfo
-- ----------------------------
DROP TABLE IF EXISTS `membersInfo`;
CREATE TABLE `membersInfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mname` varchar(255) NOT NULL,
  `mgender` varchar(255) DEFAULT NULL,
  `mage` tinyint NOT NULL,
  `maddress` varchar(255) DEFAULT NULL,
  `memail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of membersInfo
-- ----------------------------
BEGIN;
INSERT INTO `membersInfo` (`id`, `mname`, `mgender`, `mage`, `maddress`, `memail`) VALUES (1, 'g g', '男', 11, 'aaa', 'a a a');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
