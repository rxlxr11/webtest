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

 Date: 19/02/2025 14:39:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for games
-- ----------------------------
DROP TABLE IF EXISTS `games`;
CREATE TABLE `games` (
  `gameId` bigint NOT NULL AUTO_INCREMENT,
  `gameName` varchar(255) NOT NULL,
  `gameType` varchar(255) DEFAULT NULL,
  `gameCompany` varchar(255) DEFAULT NULL,
  `gameYear` int DEFAULT NULL,
  PRIMARY KEY (`gameId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of games
-- ----------------------------
BEGIN;
INSERT INTO `games` (`gameId`, `gameName`, `gameType`, `gameCompany`, `gameYear`) VALUES (1, '黑神话', '魂', '游戏科学', 2024);
INSERT INTO `games` (`gameId`, `gameName`, `gameType`, `gameCompany`, `gameYear`) VALUES (2, '三国杀', '卡牌', '有卡', 1999);
INSERT INTO `games` (`gameId`, `gameName`, `gameType`, `gameCompany`, `gameYear`) VALUES (3, '测试', '测试', '测试', 1998);
INSERT INTO `games` (`gameId`, `gameName`, `gameType`, `gameCompany`, `gameYear`) VALUES (4, '黑神话', '魂', '游戏科学', 2024);
INSERT INTO `games` (`gameId`, `gameName`, `gameType`, `gameCompany`, `gameYear`) VALUES (5, '黑神话', '魂', '游戏科学', 2024);
INSERT INTO `games` (`gameId`, `gameName`, `gameType`, `gameCompany`, `gameYear`) VALUES (6, '黑神话2', '魂', '游戏科学', 2024);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
