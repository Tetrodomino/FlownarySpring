-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        8.0.36 - MySQL Community Server - GPL
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- flownary 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `flownary` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `flownary`;

-- 테이블 flownary.board 구조 내보내기
CREATE TABLE IF NOT EXISTS `board` (
  `bid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `title` varchar(64) DEFAULT NULL,
  `bContents` varchar(3000) DEFAULT NULL,
  `modTime` datetime DEFAULT (curtime()),
  `viewCount` int DEFAULT '0',
  `likeCount` int DEFAULT '0',
  `replyCount` int DEFAULT '0',
  `image` varchar(500) DEFAULT NULL,
  `shareUrl` varchar(100) DEFAULT NULL,
  `nickname` varchar(32) DEFAULT NULL,
  `hashTag` varchar(200) DEFAULT NULL,
  `isDeleted` int DEFAULT '0',
  `location` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`bid`),
  KEY `uid` (`uid`),
  CONSTRAINT `board_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 flownary.chat 구조 내보내기
CREATE TABLE IF NOT EXISTS `chat` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `status` int NOT NULL,
  `statusTime` datetime DEFAULT (curtime()),
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 flownary.chatuser 구조 내보내기
CREATE TABLE IF NOT EXISTS `chatuser` (
  `cid` int NOT NULL,
  `uid` int NOT NULL,
  `status` int DEFAULT '0',
  `statusTime` datetime DEFAULT (curtime()),
  `name` varchar(20) DEFAULT NULL,
  `userRank` int DEFAULT '0',
  KEY `cid` (`cid`),
  KEY `uid` (`uid`),
  CONSTRAINT `chatuser_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `chat` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `chatuser_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 flownary.declaration 구조 내보내기
CREATE TABLE IF NOT EXISTS `declaration` (
  `deid` int NOT NULL AUTO_INCREMENT,
  `bid` int NOT NULL,
  `uid` int NOT NULL,
  `dTitle` varchar(100) DEFAULT NULL,
  `dContents` varchar(3000) DEFAULT NULL,
  `state` int DEFAULT '0',
  `modTime` date DEFAULT (curdate()),
  PRIMARY KEY (`deid`),
  KEY `uid` (`uid`),
  CONSTRAINT `declaration_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 flownary.dmlist 구조 내보내기
CREATE TABLE IF NOT EXISTS `dmlist` (
  `did` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `cid` int NOT NULL,
  `dContents` varchar(500) DEFAULT NULL,
  `dTime` datetime DEFAULT (curtime()),
  `dFile` varchar(200) DEFAULT NULL,
  `isDeleted` int DEFAULT '0',
  PRIMARY KEY (`did`),
  KEY `cid` (`cid`),
  KEY `uid` (`uid`),
  CONSTRAINT `dmlist_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `chat` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `dmlist_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=254 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 flownary.family 구조 내보내기
CREATE TABLE IF NOT EXISTS `family` (
  `faid` int NOT NULL AUTO_INCREMENT,
  `status` int DEFAULT '0',
  `regTime` datetime DEFAULT (curtime()),
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`faid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 flownary.familyuser 구조 내보내기
CREATE TABLE IF NOT EXISTS `familyuser` (
  `faid` int NOT NULL,
  `uid` int NOT NULL,
  `status` int DEFAULT '0',
  `regTime` datetime DEFAULT (curtime()),
  `name` varchar(20) DEFAULT NULL,
  `message` varchar(100) DEFAULT NULL,
  KEY `faid` (`faid`),
  KEY `uid` (`uid`),
  CONSTRAINT `familyuser_ibfk_1` FOREIGN KEY (`faid`) REFERENCES `family` (`faid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `familyuser_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 flownary.follow 구조 내보내기
CREATE TABLE IF NOT EXISTS `follow` (
  `fid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `fuid` int NOT NULL,
  `time` datetime DEFAULT (curtime()),
  PRIMARY KEY (`fid`),
  KEY `fuid` (`fuid`),
  KEY `uid` (`uid`),
  CONSTRAINT `follow_ibfk_1` FOREIGN KEY (`fuid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `follow_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 flownary.like_ 구조 내보내기
CREATE TABLE IF NOT EXISTS `like_` (
  `lid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `fuid` int NOT NULL,
  `type` int DEFAULT NULL,
  `oid` int DEFAULT NULL,
  `time` datetime DEFAULT (curtime()),
  `stat` int DEFAULT '1',
  PRIMARY KEY (`lid`),
  KEY `uid` (`uid`),
  KEY `fuid` (`fuid`),
  CONSTRAINT `like__ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `like__ibfk_2` FOREIGN KEY (`fuid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 flownary.notice 구조 내보내기
CREATE TABLE IF NOT EXISTS `notice` (
  `nid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `suid` int NOT NULL,
  `type` int DEFAULT NULL,
  `oid` int DEFAULT NULL,
  `nContents` varchar(300) DEFAULT NULL,
  `regTime` datetime DEFAULT (curtime()),
  `onOff` int DEFAULT '1',
  PRIMARY KEY (`nid`),
  KEY `uid` (`uid`),
  KEY `suid` (`suid`),
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `notice_ibfk_2` FOREIGN KEY (`suid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=314 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 flownary.reply 구조 내보내기
CREATE TABLE IF NOT EXISTS `reply` (
  `rid` int NOT NULL AUTO_INCREMENT,
  `bid` int NOT NULL,
  `uid` int NOT NULL,
  `rContents` varchar(500) DEFAULT NULL,
  `modTime` datetime DEFAULT (curtime()),
  `likeCount` int DEFAULT '0',
  `nickname` varchar(32) DEFAULT NULL,
  `isDeleted` int DEFAULT '0',
  PRIMARY KEY (`rid`),
  KEY `bid` (`bid`),
  KEY `uid` (`uid`),
  CONSTRAINT `reply_ibfk_1` FOREIGN KEY (`bid`) REFERENCES `board` (`bid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `reply_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 flownary.re_reply 구조 내보내기
CREATE TABLE IF NOT EXISTS `re_reply` (
  `rrid` int NOT NULL AUTO_INCREMENT,
  `rid` int NOT NULL,
  `uid` int NOT NULL,
  `rrContents` varchar(500) DEFAULT NULL,
  `modTime` datetime DEFAULT (curtime()),
  `likeCount` int DEFAULT '0',
  `nickname` varchar(32) DEFAULT NULL,
  `isDeleted` int DEFAULT '0',
  PRIMARY KEY (`rrid`),
  KEY `rid` (`rid`),
  KEY `uid` (`uid`),
  CONSTRAINT `re_reply_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `reply` (`rid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `re_reply_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 flownary.schedule 구조 내보내기
CREATE TABLE IF NOT EXISTS `schedule` (
  `sid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `title` varchar(40) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  `place` varchar(40) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `status` int DEFAULT '0',
  PRIMARY KEY (`sid`),
  KEY `uid` (`uid`),
  CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 flownary.setting 구조 내보내기
CREATE TABLE IF NOT EXISTS `setting` (
  `uid` int NOT NULL,
  `theme` varchar(16) DEFAULT NULL,
  `accountEnableUnable` int DEFAULT '1',
  `fontSize` int DEFAULT '16',
  `blackList` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  CONSTRAINT `setting_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 flownary.todo 구조 내보내기
CREATE TABLE IF NOT EXISTS `todo` (
  `tid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `contents` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `pri` int DEFAULT '0',
  PRIMARY KEY (`tid`),
  KEY `uid` (`uid`),
  CONSTRAINT `fk_user_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `todo_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `todo_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=794 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 flownary.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `email` varchar(64) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `profile` varchar(100) DEFAULT NULL,
  `uname` varchar(32) DEFAULT NULL,
  `nickname` varchar(32) DEFAULT NULL,
  `statusMessage` varchar(300) DEFAULT NULL,
  `snsDomain` varchar(100) DEFAULT NULL,
  `status` int DEFAULT '0',
  `regDate` date DEFAULT (curdate()),
  `gender` int DEFAULT NULL,
  `provider` int DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `tel` varchar(25) DEFAULT NULL,
  `hashUid` varchar(30) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `role` int DEFAULT '0',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=100004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
