/*
Navicat MySQL Data Transfer

Source Server         : localconn
Source Server Version : 50532
Source Host           : localhost:3306
Source Database       : mlcss

Target Server Type    : MYSQL
Target Server Version : 50532
File Encoding         : 65001

Date: 2013-08-01 00:05:40
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `courses`
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `createby` int(11) DEFAULT NULL,
  `classhours` int(11) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_courses_createby` (`createby`) USING BTREE,
  CONSTRAINT `fk_courses_createby` FOREIGN KEY (`createby`) REFERENCES `users` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courses
-- ----------------------------

-- ----------------------------
-- Table structure for `courseschatrecords`
-- ----------------------------
DROP TABLE IF EXISTS `courseschatrecords`;
CREATE TABLE `courseschatrecords` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coursesId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `content` varchar(120) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `isReceived` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `idx_cosChatReco_coursesID` (`coursesId`) USING BTREE,
  KEY `idx_cosChatReco_userId` (`userId`) USING BTREE,
  CONSTRAINT `fk_cosChatReco_coursesID` FOREIGN KEY (`coursesId`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cosChatReco_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courseschatrecords
-- ----------------------------

-- ----------------------------
-- Table structure for `coursesfollow`
-- ----------------------------
DROP TABLE IF EXISTS `coursesfollow`;
CREATE TABLE `coursesfollow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coursesId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_coursesFlw_coursesId` (`coursesId`) USING BTREE,
  KEY `idx_coursesFlw_userId` (`userId`) USING BTREE,
  CONSTRAINT `fk_coursesFlw_coursesId` FOREIGN KEY (`coursesId`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_coursesFlw_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coursesfollow
-- ----------------------------

-- ----------------------------
-- Table structure for `coursesnotice`
-- ----------------------------
DROP TABLE IF EXISTS `coursesnotice`;
CREATE TABLE `coursesnotice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coursesId` int(11) DEFAULT NULL,
  `noticeTitle` varchar(25) DEFAULT NULL,
  `content` varchar(50) DEFAULT NULL,
  `noticeTime` datetime DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_cosnotice_coursesId` (`coursesId`) USING BTREE,
  KEY `idx_cosnotice_userId` (`userId`) USING BTREE,
  CONSTRAINT `fk_cosnotice_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cosnotice_coursesId` FOREIGN KEY (`coursesId`) REFERENCES `courses` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coursesnotice
-- ----------------------------

-- ----------------------------
-- Table structure for `coursesschedule`
-- ----------------------------
DROP TABLE IF EXISTS `coursesschedule`;
CREATE TABLE `coursesschedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `coursesId` int(11) DEFAULT NULL,
  `coursesTime` datetime DEFAULT NULL,
  `coursesPlace` varchar(25) DEFAULT NULL,
  `isUsed` bit(1) DEFAULT b'0',
  `teatherId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_cosSche_userId` (`userId`) USING BTREE,
  KEY `idx_cosSche_coursesId` (`coursesId`) USING BTREE,
  KEY `idx_cosSche_teacherId` (`teatherId`) USING BTREE,
  CONSTRAINT `fk_cosSche_coursesId` FOREIGN KEY (`coursesId`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cosSche_teacherId` FOREIGN KEY (`teatherId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cosSche_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coursesschedule
-- ----------------------------

-- ----------------------------
-- Table structure for `coursesuserinfo`
-- ----------------------------
DROP TABLE IF EXISTS `coursesuserinfo`;
CREATE TABLE `coursesuserinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `coursesId` int(11) DEFAULT NULL,
  `remark` varchar(25) DEFAULT NULL,
  `role` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_cosUInfo_userId` (`userId`) USING BTREE,
  KEY `idx_cosUInfo_coursesId` (`coursesId`) USING BTREE,
  CONSTRAINT `fk_cosUInfo_coursesId` FOREIGN KEY (`coursesId`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cosUInfo_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coursesuserinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `questionask`
-- ----------------------------
DROP TABLE IF EXISTS `questionask`;
CREATE TABLE `questionask` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coursesid` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createby` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_questionAsk_createby` (`createby`) USING BTREE,
  KEY `idx_questionAsk_coursesid` (`coursesid`) USING BTREE,
  CONSTRAINT `fk_questionAsk_coursesid` FOREIGN KEY (`coursesid`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_questionAsk_createby` FOREIGN KEY (`createby`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questionask
-- ----------------------------

-- ----------------------------
-- Table structure for `questionreply`
-- ----------------------------
DROP TABLE IF EXISTS `questionreply`;
CREATE TABLE `questionreply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questionId` int(11) DEFAULT NULL,
  `usreId` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_quReply_quId` (`questionId`) USING BTREE,
  KEY `idx_quReply_userId` (`usreId`) USING BTREE,
  CONSTRAINT `fk_quReply_quId` FOREIGN KEY (`questionId`) REFERENCES `questionask` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_quReply_userId` FOREIGN KEY (`usreId`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questionreply
-- ----------------------------

-- ----------------------------
-- Table structure for `reminduser`
-- ----------------------------
DROP TABLE IF EXISTS `reminduser`;
CREATE TABLE `reminduser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `receiverId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `content` varchar(120) DEFAULT NULL,
  `identifying` bit(1) DEFAULT NULL,
  `isRecevied` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `idx_uRemind_userId` (`receiverId`) USING BTREE,
  CONSTRAINT `fk_uRemind_userId` FOREIGN KEY (`receiverId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reminduser
-- ----------------------------

-- ----------------------------
-- Table structure for `systemmessages`
-- ----------------------------
DROP TABLE IF EXISTS `systemmessages`;
CREATE TABLE `systemmessages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `receiverId` int(11) DEFAULT NULL,
  `content` varchar(120) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `isReceived` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `idx_sysMsg_receiverId` (`receiverId`) USING BTREE,
  CONSTRAINT `fk_sysMsg_receiverId` FOREIGN KEY (`receiverId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemmessages
-- ----------------------------

-- ----------------------------
-- Table structure for `userchatrecords`
-- ----------------------------
DROP TABLE IF EXISTS `userchatrecords`;
CREATE TABLE `userchatrecords` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `friendId` int(11) DEFAULT NULL,
  `content` varchar(120) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `isReceived` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `idx_uChatReco_userId` (`userId`) USING BTREE,
  KEY `idx_uChatReco_friendId` (`friendId`) USING BTREE,
  CONSTRAINT `fk_uChatReco_friendId` FOREIGN KEY (`friendId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_uChatReco_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userchatrecords
-- ----------------------------

-- ----------------------------
-- Table structure for `usergroups`
-- ----------------------------
DROP TABLE IF EXISTS `usergroups`;
CREATE TABLE `usergroups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `groupName` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_ugroup_userId` (`userId`) USING BTREE,
  CONSTRAINT `fk_ugroup_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usergroups
-- ----------------------------

-- ----------------------------
-- Table structure for `usernotes`
-- ----------------------------
DROP TABLE IF EXISTS `usernotes`;
CREATE TABLE `usernotes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `title` varchar(25) DEFAULT NULL,
  `content` varchar(120) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `isshared` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `idx_unote_userId` (`userId`) USING BTREE,
  CONSTRAINT `fk_unote_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usernotes
-- ----------------------------

-- ----------------------------
-- Table structure for `userrelationship`
-- ----------------------------
DROP TABLE IF EXISTS `userrelationship`;
CREATE TABLE `userrelationship` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `friendId` int(11) DEFAULT NULL,
  `groupId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_userrela_userId` (`userId`) USING BTREE,
  KEY `idx_userrela_friendId` (`friendId`) USING BTREE,
  KEY `idx_userrela_groupId` (`groupId`) USING BTREE,
  CONSTRAINT `fk_userrela_friendId` FOREIGN KEY (`friendId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_userrela_groupId` FOREIGN KEY (`groupId`) REFERENCES `usergroups` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_userrela_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userrelationship
-- ----------------------------

-- ----------------------------
-- Table structure for `userremarks`
-- ----------------------------
DROP TABLE IF EXISTS `userremarks`;
CREATE TABLE `userremarks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `title` varchar(25) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `remindTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_userremarks_userId` (`userId`) USING BTREE,
  CONSTRAINT `fk_userremarks_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userremarks
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `userIcon` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO users VALUES ('8', '123', 'ICy5YqxZB1uWSwcVLSNLcA==', 'abc@fsdf.com', null, null);
INSERT INTO users VALUES ('9', 'ming', '111111', '12323@qq.com', null, null);
