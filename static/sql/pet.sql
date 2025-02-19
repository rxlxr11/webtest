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

 Date: 19/02/2025 14:39:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pet
-- ----------------------------
DROP TABLE IF EXISTS `pet`;
CREATE TABLE `pet` (
  `petId` int NOT NULL AUTO_INCREMENT,
  `petName` varchar(255) NOT NULL,
  `petBreed` varchar(255) NOT NULL,
  `petSex` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '雄',
  `birthday` date NOT NULL,
  `desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`petId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of pet
-- ----------------------------
BEGIN;
INSERT INTO `pet` (`petId`, `petName`, `petBreed`, `petSex`, `birthday`, `desc`) VALUES (1, '旺财', '狗', '雄', '2025-02-17', 'a a');
INSERT INTO `pet` (`petId`, `petName`, `petBreed`, `petSex`, `birthday`, `desc`) VALUES (2, '喵喵', '猫', '雄', '2025-02-17', NULL);
INSERT INTO `pet` (`petId`, `petName`, `petBreed`, `petSex`, `birthday`, `desc`) VALUES (3, '旺财1', '狗', '雄', '1111-11-11', '');
INSERT INTO `pet` (`petId`, `petName`, `petBreed`, `petSex`, `birthday`, `desc`) VALUES (4, '旺财2', '狗', '雄', '1111-11-11', '');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
