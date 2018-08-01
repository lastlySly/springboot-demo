/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : ssmdemo

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 31/07/2018 19:47:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account_sheet
-- ----------------------------
DROP TABLE IF EXISTS `account_sheet`;
CREATE TABLE `account_sheet`  (
  `account_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `account_money` double(255, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`account_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account_sheet
-- ----------------------------
INSERT INTO `account_sheet` VALUES (1, 'lastly', 1000);
INSERT INTO `account_sheet` VALUES (2, 'cote', 1000);
INSERT INTO `account_sheet` VALUES (3, 'kagari', 1000);

-- ----------------------------
-- Table structure for permission_sheet
-- ----------------------------
DROP TABLE IF EXISTS `permission_sheet`;
CREATE TABLE `permission_sheet`  (
  `permission_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission_role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission_sheet
-- ----------------------------
INSERT INTO `permission_sheet` VALUES (1, 'admin', 'user:delete');
INSERT INTO `permission_sheet` VALUES (2, 'user', 'user:select');

-- ----------------------------
-- Table structure for role_sheet
-- ----------------------------
DROP TABLE IF EXISTS `role_sheet`;
CREATE TABLE `role_sheet`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_sheet
-- ----------------------------
INSERT INTO `role_sheet` VALUES (1, 'cote', 'user');
INSERT INTO `role_sheet` VALUES (2, 'lastly', 'admin');
INSERT INTO `role_sheet` VALUES (3, 'lastly', 'user');

-- ----------------------------
-- Table structure for userinfo_sheet
-- ----------------------------
DROP TABLE IF EXISTS `userinfo_sheet`;
CREATE TABLE `userinfo_sheet`  (
  `user_id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_login_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户登陆账户',
  `user_nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户登陆密码',
  `user_password_salt` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码加盐',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_login_id_unique`(`user_login_id`) USING BTREE COMMENT '用户登录账号唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo_sheet
-- ----------------------------
INSERT INTO `userinfo_sheet` VALUES (1, 'lastly', NULL, 'f8b5b7a90d38a1162b5b00e4ce1b4704', 'lastly');
INSERT INTO `userinfo_sheet` VALUES (2, 'cote', NULL, 'c83c73dc29b9f60e40dfdec8ee04dc8d', 'cote');

SET FOREIGN_KEY_CHECKS = 1;
