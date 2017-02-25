/*
SQLyog Community v12.16 (64 bit)
MySQL - 5.5.46-log : Database - blood_banking
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blood_banking` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blood_banking`;

/*Table structure for table `blood_group_mst` */

DROP TABLE IF EXISTS `blood_group_mst`;

CREATE TABLE `blood_group_mst` (
  `blood_group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Blood group id',
  `blood_group_name` varchar(3) NOT NULL COMMENT 'Blood group name',
  PRIMARY KEY (`blood_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `blood_group_mst` */

insert  into `blood_group_mst`(`blood_group_id`,`blood_group_name`) values 
(1,'A+'),
(2,'A-'),
(3,'B+'),
(4,'B-'),
(5,'AB+'),
(6,'AB-'),
(7,'O+'),
(8,'O-');

/*Table structure for table `donor_bloodbank_mapping` */

DROP TABLE IF EXISTS `donor_bloodbank_mapping`;

CREATE TABLE `donor_bloodbank_mapping` (
  `donor_id` bigint(4) NOT NULL COMMENT 'donor registration id',
  `bloodbank_id` bigint(4) NOT NULL COMMENT 'bloodbank registration id',
  `blood_units` int(11) NOT NULL COMMENT 'blood units donated',
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`donor_id`,`bloodbank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `donor_bloodbank_mapping` */

/*Table structure for table `enquiry_form` */

DROP TABLE IF EXISTS `enquiry_form`;

CREATE TABLE `enquiry_form` (
  `inq_id` bigint(4) NOT NULL COMMENT 'to store the id',
  `message` varchar(255) NOT NULL COMMENT 'to store the inquiry',
  `status` int(1) NOT NULL COMMENT 'to store the status',
  `created_date` datetime NOT NULL COMMENT 'to store the date',
  PRIMARY KEY (`inq_id`),
  KEY `INQUIRY_FORM_STATUS_FK` (`status`),
  CONSTRAINT `INQUIRY_FORM_STATUS_FK` FOREIGN KEY (`status`) REFERENCES `status_mst` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `enquiry_form` */

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `fid` bigint(4) NOT NULL COMMENT 'to store the id',
  `feedback` varchar(255) NOT NULL COMMENT 'to store the feedback',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `feedback` */

/*Table structure for table `location_address` */

DROP TABLE IF EXISTS `location_address`;

CREATE TABLE `location_address` (
  `location_address_id` bigint(19) NOT NULL AUTO_INCREMENT,
  `reference_type` int(9) NOT NULL,
  `reference_id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `mobile_number` varchar(20) DEFAULT NULL,
  `email_id` varchar(30) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `pincode` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`location_address_id`),
  KEY `FK_ADDRESS_STATE` (`state`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `location_address` */

insert  into `location_address`(`location_address_id`,`reference_type`,`reference_id`,`name`,`mobile_number`,`email_id`,`address`,`state`,`city`,`pincode`) values 
(1,1,'1','Super Admin','9480242101','joebalan7@gmail.com','K.P. Agrahara','Karnataka','Bangalore','560023');

/*Table structure for table `patient_bloodbank_mapping` */

DROP TABLE IF EXISTS `patient_bloodbank_mapping`;

CREATE TABLE `patient_bloodbank_mapping` (
  `patient_id` bigint(4) NOT NULL COMMENT 'patient registration id',
  `bloodbank_id` bigint(4) NOT NULL COMMENT 'bloodbank registration id',
  `blood_units` int(11) NOT NULL COMMENT 'blood units requested',
  `status` int(1) NOT NULL COMMENT 'status - supplied/not supplied',
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`patient_id`,`bloodbank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `patient_bloodbank_mapping` */

/*Table structure for table `registration` */

DROP TABLE IF EXISTS `registration`;

CREATE TABLE `registration` (
  `registration_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'to store the reg_id',
  `blood_group` int(1) NOT NULL COMMENT 'to store the blood group',
  `birth_date` datetime NOT NULL COMMENT 'to store the birth date',
  `gender` varchar(6) NOT NULL COMMENT 'to store the gender',
  `user_name` varchar(20) NOT NULL COMMENT 'to store the user name',
  `password` varchar(20) NOT NULL COMMENT 'to store the password',
  `usertype_id` bigint(20) NOT NULL COMMENT 'reference of the user_id from usertype_mst',
  `security_que` varchar(30) NOT NULL COMMENT 'to store the security que',
  `answer` varchar(15) NOT NULL COMMENT 'to store the answer',
  `status` int(1) NOT NULL COMMENT 'to store the status',
  PRIMARY KEY (`registration_id`),
  KEY `u_id_fk` (`usertype_id`),
  KEY `REGISTRATION_STATUS_FK` (`status`),
  CONSTRAINT `REGISTRATION_STATUS_FK` FOREIGN KEY (`status`) REFERENCES `status_mst` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `registration` */

insert  into `registration`(`registration_id`,`blood_group`,`birth_date`,`gender`,`user_name`,`password`,`usertype_id`,`security_que`,`answer`,`status`) values 
(1,3,'1989-11-09 20:02:59','Male','SuperAdmin','super@123',1,'4','1960',1);

/*Table structure for table `security_question` */

DROP TABLE IF EXISTS `security_question`;

CREATE TABLE `security_question` (
  `security_question_id` int(11) NOT NULL AUTO_INCREMENT,
  `security_question` varchar(200) NOT NULL,
  PRIMARY KEY (`security_question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `security_question` */

insert  into `security_question`(`security_question_id`,`security_question`) values 
(1,'What was the name of your primary school?'),
(2,'In what city or town does your nearest sibling live?'),
(3,'What time of the day were you born? (hh:mm)'),
(4,'In what year was your father born?'),
(5,'What is your favorite person?'),
(6,'What is your pet name?');

/*Table structure for table `status_mst` */

DROP TABLE IF EXISTS `status_mst`;

CREATE TABLE `status_mst` (
  `status` int(4) NOT NULL AUTO_INCREMENT,
  `description` varchar(50) NOT NULL,
  PRIMARY KEY (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `status_mst` */

insert  into `status_mst`(`status`,`description`) values 
(1,'Active'),
(2,'Inactive'),
(3,'Deleted'),
(4,'Supplied'),
(5,'Not supplied');

/*Table structure for table `user_left_menu` */

DROP TABLE IF EXISTS `user_left_menu`;

CREATE TABLE `user_left_menu` (
  `left_menu_id` int(9) NOT NULL AUTO_INCREMENT,
  `left_menu_name` varchar(100) NOT NULL,
  `left_menu_description` varchar(255) NOT NULL,
  PRIMARY KEY (`left_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `user_left_menu` */

insert  into `user_left_menu`(`left_menu_id`,`left_menu_name`,`left_menu_description`) values 
(1,'Home','Home'),
(2,'Profile','Profile'),
(3,'Usertype','User type'),
(4,'User','User'),
(5,'BloodBank','Blood bank'),
(6,'Donor','Donor'),
(7,'Patient','Patient'),
(8,'BloodDonation','Blood donation'),
(9,'BloodRequest','Blood request'),
(10,'Feedback','Feedback'),
(11,'Enquiry','Enquiry'),
(12,'BloodBankStock','Blood bank stock'),
(13,'Report','Report');

/*Table structure for table `user_sub_menu` */

DROP TABLE IF EXISTS `user_sub_menu`;

CREATE TABLE `user_sub_menu` (
  `sub_menu_id` int(9) NOT NULL AUTO_INCREMENT,
  `sub_menu_name` varchar(100) NOT NULL,
  PRIMARY KEY (`sub_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `user_sub_menu` */

insert  into `user_sub_menu`(`sub_menu_id`,`sub_menu_name`) values 
(1,'Add'),
(2,'Edit'),
(3,'Delete'),
(4,'View'),
(5,'Detail'),
(6,'Import'),
(7,'Export');

/*Table structure for table `user_type_mapping` */

DROP TABLE IF EXISTS `user_type_mapping`;

CREATE TABLE `user_type_mapping` (
  `privilege_id` int(9) NOT NULL AUTO_INCREMENT,
  `user_type_id` int(9) NOT NULL COMMENT 'fk to user_type_mst',
  `left_menu_id` int(9) NOT NULL COMMENT 'fk to user_left_menu',
  `sub_menu_id` int(9) NOT NULL COMMENT 'fk to user_sub_menu',
  PRIMARY KEY (`privilege_id`),
  KEY `left_menu_id` (`left_menu_id`),
  KEY `sub_menu_id` (`sub_menu_id`),
  KEY `user_type_id` (`user_type_id`),
  CONSTRAINT `left_menu_id` FOREIGN KEY (`left_menu_id`) REFERENCES `user_left_menu` (`left_menu_id`),
  CONSTRAINT `sub_menu_id` FOREIGN KEY (`sub_menu_id`) REFERENCES `user_sub_menu` (`sub_menu_id`),
  CONSTRAINT `user_type_id` FOREIGN KEY (`user_type_id`) REFERENCES `user_type_mst` (`usertype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

/*Data for the table `user_type_mapping` */

insert  into `user_type_mapping`(`privilege_id`,`user_type_id`,`left_menu_id`,`sub_menu_id`) values 
(1,1,1,4),
(2,1,2,2),
(3,1,2,5),
(4,1,3,1),
(5,1,3,2),
(6,1,3,3),
(7,1,3,4),
(8,1,3,5),
(9,1,4,1),
(10,1,4,2),
(11,1,4,3),
(12,1,4,4),
(13,1,4,5),
(14,1,8,1),
(15,1,8,2),
(16,1,8,3),
(17,1,8,4),
(18,1,8,5),
(19,1,9,1),
(20,1,9,2),
(21,1,9,3),
(22,1,9,4),
(23,1,9,5),
(24,1,10,3),
(25,1,10,4),
(26,1,10,5),
(27,1,11,3),
(28,1,11,4),
(29,1,11,5),
(30,1,13,4),
(31,1,13,7),
(32,2,1,4),
(33,2,2,2),
(34,2,2,5),
(35,2,5,1),
(36,2,5,2),
(37,2,5,3),
(38,2,5,4),
(39,2,5,5),
(40,2,6,1),
(41,2,6,2),
(42,2,6,3),
(43,2,6,4),
(44,2,6,5),
(45,2,7,1),
(46,2,7,2),
(47,2,7,3),
(48,2,7,4),
(49,2,7,5),
(50,2,8,4),
(51,2,8,5),
(52,2,9,4),
(53,2,9,5),
(54,2,12,4),
(55,3,1,4),
(56,3,2,2),
(57,3,2,5),
(58,3,8,4),
(59,3,8,5),
(60,4,1,4),
(61,4,2,2),
(62,4,2,5),
(63,4,9,4),
(64,4,9,5);

/*Table structure for table `user_type_mst` */

DROP TABLE IF EXISTS `user_type_mst`;

CREATE TABLE `user_type_mst` (
  `usertype_id` int(4) NOT NULL AUTO_INCREMENT COMMENT 'To store user type id',
  `usertype_name` varchar(50) NOT NULL COMMENT 'to store user type name',
  PRIMARY KEY (`usertype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user_type_mst` */

insert  into `user_type_mst`(`usertype_id`,`usertype_name`) values 
(1,'admin'),
(2,'bloodbank'),
(3,'donor'),
(4,'patient');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
