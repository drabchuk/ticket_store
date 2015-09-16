# Host: localhost  (Version: 5.6.25-log)
# Date: 2015-09-16 20:15:19
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "trips"
#

DROP TABLE IF EXISTS `trips`;
CREATE TABLE `trips` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `route` int(11) DEFAULT NULL,
  `departure` datetime DEFAULT NULL,
  `arrival` datetime DEFAULT NULL,
  `bus` int(11) DEFAULT NULL,
  `seats_aviliable` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `route` (`route`),
  KEY `trips_ibfk_1` (`bus`),
  CONSTRAINT `trips_ibfk_1` FOREIGN KEY (`bus`) REFERENCES `buses` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trips_ibfk_2` FOREIGN KEY (`route`) REFERENCES `routes` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

#
# Data for table "trips"
#

INSERT INTO `trips` VALUES (1,1,'2015-09-14 08:00:00','2015-09-14 18:00:00',1,4),(2,2,'2015-09-14 08:00:00','2015-09-14 18:00:00',14,5),(3,1,'2015-09-14 09:00:00','2015-09-14 19:00:00',15,2);
