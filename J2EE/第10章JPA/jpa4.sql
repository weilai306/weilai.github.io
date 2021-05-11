# Host: localhost  (Version: 5.6.14)
# Date: 2014-12-07 21:19:27
# Generator: MySQL-Front 5.3  (Build 4.187)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "ref_teacher_student"
#

DROP TABLE IF EXISTS `ref_teacher_student`;
CREATE TABLE `ref_teacher_student` (
  `teacher_id` int(20) NOT NULL,
  `student_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "ref_teacher_student"
#

INSERT INTO `ref_teacher_student` VALUES (1,1),(2,1),(5,4),(4,4),(6,5),(7,5);

#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `major` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "student"
#

INSERT INTO `student` VALUES (1,'赵二','male','computer technology'),(4,'赵二','male','computer technology'),(5,'赵二','male','computer technology');

#
# Structure for table "teacher"
#

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `teacherName` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "teacher"
#

INSERT INTO `teacher` VALUES (1,31,'male','王一'),(2,36,'female','王二'),(4,36,'female','王二'),(5,31,'male','王一'),(6,31,'male','王一'),(7,36,'female','王二');
