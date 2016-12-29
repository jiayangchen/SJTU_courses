/*
Navicat MySQL Data Transfer

Source Server         : ChenJiayang
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : mystore

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2016-06-14 19:06:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `administrator`
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('1', '5140379036', 'root');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `BookID` int(11) NOT NULL,
  `BookName` varchar(255) DEFAULT NULL,
  `Author` varchar(255) DEFAULT NULL,
  `Category` varchar(255) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`BookID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'Readers', 'NULL', 'Literature', '4', '10');
INSERT INTO `book` VALUES ('2', 'MarsTask', 'Lisa', 'Fiction', '56', '20');
INSERT INTO `book` VALUES ('4', 'Internet+', 'Yang', 'Science', '25', '30');
INSERT INTO `book` VALUES ('5', 'DB', 'Kan', 'IT', '108', '20');
INSERT INTO `book` VALUES ('6', 'CSAPP', 'Byrant', 'IT', '100', '10');

-- ----------------------------
-- Table structure for `myorder`
-- ----------------------------
DROP TABLE IF EXISTS `myorder`;
CREATE TABLE `myorder` (
  `OrderID` int(11) NOT NULL AUTO_INCREMENT,
  `BookID` int(11) DEFAULT NULL,
  `UserID` int(11) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`OrderID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of myorder
-- ----------------------------
INSERT INTO `myorder` VALUES ('9', '1', '2', '1', '2016-06-10');
INSERT INTO `myorder` VALUES ('10', '1', '2', '1', '2016-06-10');
INSERT INTO `myorder` VALUES ('11', '1', '2', '1', '2016-06-10');
INSERT INTO `myorder` VALUES ('12', '1', '2', '1', '2016-06-10');
INSERT INTO `myorder` VALUES ('13', '1', '2', '1', '2016-06-11');
INSERT INTO `myorder` VALUES ('14', '1', '2', '1', '2016-06-11');
INSERT INTO `myorder` VALUES ('15', '6', '2', '1', '2016-06-11');
INSERT INTO `myorder` VALUES ('16', '1', '2', '1', '2016-06-11');
INSERT INTO `myorder` VALUES ('17', '1', '4', '2', '2016-06-12');
INSERT INTO `myorder` VALUES ('18', '2', '4', '1', '2016-06-12');
INSERT INTO `myorder` VALUES ('19', '4', '4', '1', '2016-06-12');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '5140379040', 'cao');
INSERT INTO `user` VALUES ('3', '5140379030', 'hanyikai');
INSERT INTO `user` VALUES ('4', 'Eason', '123');

-- ----------------------------
-- Function structure for `fn_category`
-- ----------------------------
DROP FUNCTION IF EXISTS `fn_category`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fn_category`(`bid` int) RETURNS int(100)
BEGIN
	#Routine body goes here...
	SELECT Category into @cate FROM book where BookID = bid;
	RETURN @cate;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `fn_order`
-- ----------------------------
DROP FUNCTION IF EXISTS `fn_order`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fn_order`(`bid` int) RETURNS int(100)
BEGIN
	#Routine body goes here...
	SELECT count(*) INTO @result from myorder WHERE BookID = bid;
	RETURN @result;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `fn_users`
-- ----------------------------
DROP FUNCTION IF EXISTS `fn_users`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fn_users`(`userid` int) RETURNS int(100)
BEGIN
	#Routine body goes here...
	SELECT count(*) INTO @result FROM myorder where UserID = userid;
	RETURN @result;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `updateStock`;
DELIMITER ;;
CREATE TRIGGER `updateStock` AFTER INSERT ON `myorder` FOR EACH ROW begin
update book
set Quantity = Quantity - new.Amount where BookID = new.BookID;
end
;;
DELIMITER ;
