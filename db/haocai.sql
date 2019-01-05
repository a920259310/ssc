/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.20-log : Database - haocai
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`haocai` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `haocai`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(8) DEFAULT NULL COMMENT '账户',
  `password` varchar(128) DEFAULT NULL COMMENT '明文密码',
  `md5` varchar(128) DEFAULT NULL COMMENT 'md5登陆密码',
  `take_password` varchar(128) DEFAULT NULL COMMENT '取款密码',
  `yu_e` double DEFAULT NULL COMMENT '余额',
  `is_active` tinyint(1) DEFAULT NULL COMMENT '是否已激活',
  `is_bang` tinyint(1) DEFAULT NULL COMMENT '是否已经绑卡',
  `card_no` varchar(128) DEFAULT NULL COMMENT '卡号',
  `is_regist` tinyint(1) DEFAULT NULL COMMENT '是否已注册',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `account` */

insert  into `account`(`id`,`user_name`,`password`,`md5`,`take_password`,`yu_e`,`is_active`,`is_bang`,`card_no`,`is_regist`) values (1,'a9202593','a19931006','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',2.65,1,1,'建行',1),(2,'b9202593','a19931006','678b557478a23722cba4e963d48bd620','a123456',2,1,1,'建行',1),(3,'q10001','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',2,1,1,'建行',1),(4,'q10002','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',2.745,1,1,'建行',1),(5,'q10003','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',2,1,0,'',1),(6,'q10004','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',2,1,0,'',1),(7,'q10005','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',2,1,0,'',1),(8,'q10006','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',2.7,1,1,'建行',1),(9,'q10007','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',2,1,0,'',1),(10,'q10008','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',2.65,1,1,'建行',1),(11,'q10009','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',2,1,0,'',1),(12,'q10010','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',2,1,0,'',1),(13,'l10001','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',0,NULL,NULL,NULL,1),(14,'l10002','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',0,NULL,NULL,NULL,1),(15,'l10003','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',0,NULL,NULL,NULL,1),(16,'l10004','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',0,NULL,NULL,NULL,1),(17,'l10005','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',0,NULL,NULL,NULL,1),(18,'l10006','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',0,NULL,NULL,NULL,1),(19,'l10007','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',0,NULL,NULL,NULL,1),(20,'l10008','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',0,NULL,NULL,NULL,1),(21,'l10009','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',0,NULL,NULL,NULL,1),(22,'l10010','a666666','f9aa4d5dee4b0b6dbe5ae4cab68e1d9b','a123456',0,NULL,NULL,NULL,1);

/*Table structure for table `account_sing` */

DROP TABLE IF EXISTS `account_sing`;

CREATE TABLE `account_sing` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_id` int(11) DEFAULT NULL COMMENT '用户外键',
  `create_date_time` varchar(19) NOT NULL DEFAULT 'CURRENT_TIMESTAMP' COMMENT '创建日期',
  `is_singe` tinyint(1) DEFAULT NULL COMMENT '是否已经签到',
  `singe_date_time` timestamp NULL DEFAULT NULL COMMENT '签到时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `account_sing` */

insert  into `account_sing`(`id`,`account_id`,`create_date_time`,`is_singe`,`singe_date_time`) values (1,1,'2019-01-05',1,'2019-01-05 15:21:50'),(2,2,'2019-01-05',1,'2019-01-05 15:21:53'),(3,3,'2019-01-05',1,'2019-01-05 16:17:37'),(4,4,'2019-01-05',1,'2019-01-05 16:20:20'),(5,5,'2019-01-05',1,'2019-01-05 08:20:47'),(6,6,'2019-01-05',1,'2019-01-05 08:21:01'),(7,7,'2019-01-05',1,'2019-01-05 08:21:02'),(8,8,'2019-01-05',1,'2019-01-05 08:21:04'),(9,9,'2019-01-05',1,'2019-01-05 08:21:05'),(10,10,'2019-01-05',1,'2019-01-05 08:21:07'),(11,11,'2019-01-05',1,'2019-01-05 08:21:07'),(12,12,'2019-01-05',1,'2019-01-05 08:21:08');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
