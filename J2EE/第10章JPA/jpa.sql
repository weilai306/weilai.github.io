
#
# Structure for table "address"
#

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `detail` varchar(50) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `Zip` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

#
# Data for table "address"
#

INSERT INTO `address` VALUES (5,'吉林省长春市前进大街2699号计算机学院',NULL,NULL,NULL),(6,'吉林省长春市前进大街2699号',NULL,NULL,NULL),(7,'吉林省长春市前进大街2699号',NULL,NULL,NULL),(8,'吉林省长春市前进大街2699号',NULL,NULL,NULL),(9,'吉林省长春市前进大街2699号',NULL,NULL,NULL),(10,'吉林省长春市前进大街2699号',NULL,NULL,NULL),(11,'吉林省长春市前进大街2699号',NULL,NULL,NULL),(12,'吉林省长春市前进大街2699号','吉林省','长春市','130012'),(13,'吉林省长春市前进大街2699号','吉林省','长春市','130012'),(14,'吉林省长春市前进大街2699号','吉林省','长春市','130012'),(15,'吉林省长春市前进大街2699号',NULL,NULL,NULL),(16,'吉林省长春市前进大街2699号','吉林省','长春市','130012');

#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `major` varchar(50) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_student` (`address_id`),
  CONSTRAINT `fk_student` FOREIGN KEY (`address_id`) REFERENCES `address` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

#
# Data for table "student"
#

INSERT INTO `student` VALUES (17,'wangwu6','male','computer',11),(18,'wangwu6','male','computer',12),(19,'wangwu6','male','computer',13),(20,'wangwu6','male','computer',14),(21,'wangwu6','male','computer',15),(22,'wangwu6','male','computer',16);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "teacher"
#

