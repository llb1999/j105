/*
SQLyog Enterprise v12.2.6 (64 bit)
MySQL - 5.5.62 : Database - courseselection
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`courseselection` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `courseselection`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`username`,`password`) values 
(1,'admin','admin');

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  `course_score` varchar(255) DEFAULT NULL,
  `course_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`id`,`course_name`,`teacher_name`,`course_score`,`course_time`) values 
(1,'JAVA EE','曾志皓','5','12'),
(13,'熬夜梦游概论','贺俊文','4','16'),
(14,'熬夜梦游说梦话大咖','贺俊文','3','22'),
(15,'JAVA SE','曾志皓','5','12'),
(17,'JAVA SE','贺俊文','5','18'),
(18,'JAVA EE','贺俊文','3','22'),
(19,'王者荣耀','曾志皓','2','26'),
(20,'刺激战场','张国峰','2','22'),
(21,'CF','李建设','2','20'),
(22,'DATA5','吴大维','3','42'),
(23,'健康概论','张国峰','5','22');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `class` varchar(255) DEFAULT NULL,
  `college` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`stu_id`,`username`,`password`,`age`,`class`,`college`,`phonenumber`) values 
(1,10001,'陈','123456','14','软工1701','野鸡大学','110'),
(2,10002,'贺俊文','123456','12','软工1701','野鸡大学','11234'),
(3,10003,'谷涛','123456','15','软工1701','垃圾大学','244221'),
(4,10004,'张俊文','123456','16','网工1501','菜鸡大学','32113'),
(5,10005,'谷三','123456','18','网工1501','野鸡大学','75344'),
(6,10006,'张八','123456','22','物联网1901','菜鸡大学','23412');

/*Table structure for table `student_course` */

DROP TABLE IF EXISTS `student_course`;

CREATE TABLE `student_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(255) NOT NULL,
  `course_name` varchar(255) NOT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

/*Data for the table `student_course` */

insert  into `student_course`(`id`,`student_name`,`course_name`,`teacher_name`,`score`) values 
(26,'陈','JAVA EE','曾志皓',100),
(27,'陈','JAVA SE','曾志皓',12),
(28,'陈','微机原理','邱老师',67),
(29,'陈','王者荣耀','曾志皓',83),
(30,'陈','CF','李建设',74),
(31,'陈','DATA5','吴大维',85),
(33,'贺俊文','王者荣耀','曾志皓',72),
(34,'贺俊文','刺激战场','张国峰',69),
(35,'贺俊文','CF','李建设',43),
(36,'贺俊文','DATA5','吴大维',88),
(37,'谷涛','JAVA SE','曾志皓',72),
(38,'谷涛','JAVA EE','曾志皓',23),
(39,'谷涛','王者荣耀','曾志皓',84),
(40,'谷涛','CF','李建设',78),
(41,'谷涛','DATA5','吴大维',92),
(42,'张俊文','JAVA EE','曾志皓',100),
(43,'张俊文','刺激战场','张国峰',57),
(44,'张俊文','王者荣耀','曾志皓',87),
(45,'谷三','王者荣耀','曾志皓',78),
(46,'谷三','CF','李建设',57),
(47,'张八','CF','李建设',99),
(48,'张八','刺激战场','张国峰',100),
(49,'陈','刺激战场','张国峰',NULL);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_id` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `college` varchar(255) DEFAULT NULL,
  `professionaltitle` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`id`,`tea_id`,`username`,`password`,`age`,`college`,`professionaltitle`,`phonenumber`) values 
(1,80001,'曾志皓','123456','18','野鸡大学','dwad','110'),
(2,80002,'贺俊文','123456','15','野鸡大学','dwad','110'),
(3,80003,'张国峰','123456','12','菜鸡大学','dwad','123142'),
(4,80004,'李建设','123456','10','菜鸡大学','32fs','1232'),
(5,80005,'吴大维','123456','28','野鸡大学','2312','f32432');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
