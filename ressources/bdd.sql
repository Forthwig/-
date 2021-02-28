CREATE DATABASE  IF NOT EXISTS `junia_lab` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `junia_lab`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: junia_lab03
-- ------------------------------------------------------
-- Server version	5.6.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
                             `id` bigint(20) NOT NULL,
                             `image` varchar(255) DEFAULT NULL,
                             `mail` varchar(255) DEFAULT NULL,
                             `password` varchar(255) DEFAULT NULL,
                             `promo` varchar(255) DEFAULT NULL,
                             `enable` int(1) DEFAULT NULL,
                             `role` varchar(255) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,NULL,'matthieu.desmarescaux@isen.yncrea.fr','matthieu',null,1,'ROLE_STUDENT'),
                             (2,NULL,'thomas.dubois@isen.yncrea.fr','thomas',null,1,'ROLE_STUDENT');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
                           `id` bigint(20) NOT NULL,
                           `surnom` varchar DEFAULT NULL,
                           `mail` varchar(255) DEFAULT NULL,
                           `password` varchar(255) DEFAULT NULL,
                           `enable` int(1) DEFAULT NULL,
                           `role` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'MatD3mons','matthieu.desmarescaux@yncrea.fr','matthieu',1,'ROLE_TEACHER'),
                             (2,NULL,'thomas.dubois@yncrea.fr','thomas',1,'ROLE_TEACHER');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson` (
                        `id` bigint(20) NOT NULL,
                        `language` varchar(255) DEFAULT NULL,
                        `title` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
INSERT INTO `lesson` VALUES (1,'FR','Angular: Up and Running'),
                            (2,'FR','Architecting Modern Java EE applications'),
                            (3,'EN','Automate it!'),
                            (4,'EN','Building Webapps with Spring 5 and Angular'),
                            (5,'EN','CSS Pocket Reference, 5th Edition'),
                            (6,'EN','CSS: The Definitive Guide, 4th Edition'),
                            (7,'EN','Cloud Foundry : The definitive guide'),
                            (8,'EN','Cloud native infrastructure'),
                            (9,'EN','Cloud-Native Applications in Java'),
                            (10,'EN','Continuous Delivery with Docker and Jenkins');
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
                          `id` bigint(20) NOT NULL,
                          `dateOfReview` datetime DEFAULT NULL,
                          `text` varchar(255) NOT NULL,
                          `student_id` int(11) NOT NULL,
                          `lesson_id` bigint(20) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (245,'2019-10-06 18:38:48','tu pu',1,169),
                            (266,'2019-10-06 19:00:33','tu pu',1,169),
                            (282,'2019-10-06 19:03:17','tu pu',1,167);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson_teacher`
--

DROP TABLE IF EXISTS `lesson_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson_teacher` (
                            `lesson_id` bigint(20) NOT NULL,
                            `teacher_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson_teacher`
--

LOCK TABLES `lesson_teacher` WRITE;
/*!40000 ALTER TABLE `lesson_teacher` DISABLE KEYS */;
INSERT INTO `lesson_teacher` VALUES (244,41);
/*!40000 ALTER TABLE `lesson_teacher` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `lesson_tag_student`
--

DROP TABLE IF EXISTS `lesson_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson_student` (
                                      `lesson_id` bigint(20) NOT NULL,
                                      `student_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson_student`
--

LOCK TABLES `lesson_student` WRITE;
/*!40000 ALTER TABLE `lesson_student` DISABLE KEYS */;
INSERT INTO `lesson_student` VALUES (244,41);
/*!40000 ALTER TABLE `lesson_student` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Dumping events for database 'junia_lab'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-21 23:38:14
