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
                             `surnom` varchar(255) DEFAULT NULL,
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
INSERT INTO `student` VALUES (1,NULL,NULL,'alexis.bard@isen.yncrea.fr','alexis','PROMO62',1,'ROLE_STUDENT'),
                             (2,NULL,NULL,'martin.Barres@isen.yncrea.fr','martin','PROMO62',1,'ROLE_STUDENT'),
                             (3,NULL,NULL,'nils.charrier@isen.yncrea.fr','nils','PROMO62',1,'ROLE_STUDENT'),
                             (4,NULL,NULL,'valentin.chivet@isen.yncrea.fr','valentin','PROMO62',1,'ROLE_STUDENT'),
                             (5,NULL,NULL,'anthony.coupeybraeckman@isen.yncrea.fr','anthony','PROMO62',1,'ROLE_STUDENT'),
                             (6,NULL,NULL,'hector.courouble@isen.yncrea.fr','hector','PROMO62',1,'ROLE_STUDENT'),
                             (7,NULL,NULL,'françois.cresson@isen.yncrea.fr','françois','PROMO62',1,'ROLE_STUDENT'),
                             (8,NULL,NULL,'max.croquet@isen.yncrea.fr','max','PROMO62',1,'ROLE_STUDENT'),
                             (9,NULL,NULL,'jean-hadrien.damay@isen.yncrea.fr','jean-hadrien','PROMO62',1,'ROLE_STUDENT'),
                             (10,NULL,NULL,'louis.delannoy@isen.yncrea.fr','louis','PROMO62',1,'ROLE_STUDENT'),
                             (11,NULL,NULL,'adrien.delaurens@isen.yncrea.fr','adrien','PROMO62',1,'ROLE_STUDENT'),
                             (12,NULL,'MatD3mons','matthieu.desmarescaux@isen.yncrea.fr','matthieu','PROMO62',1,'ROLE_STUDENT'),
                             (13,NULL,NULL,'gabriel.desmullier@isen.yncrea.fr','gabriel','PROMO62',1,'ROLE_STUDENT'),
                             (14,NULL,NULL,'dimitri.dochy@isen.yncrea.fr','dimitri','PROMO62',1,'ROLE_STUDENT'),
                             (15,NULL,NULL,'thomas.dubois@isen.yncrea.fr','thomas','PROMO62',1,'ROLE_STUDENT'),
                             (16,NULL,NULL,'noé.esparsa@isen.yncrea.fr','noé','PROMO62',1,'ROLE_STUDENT'),
                             (17,NULL,NULL,'matthieu.heras@isen.yncrea.fr','matthieu','PROMO62',1,'ROLE_STUDENT'),
                             (18,NULL,NULL,'matthieu.hue@isen.yncrea.fr','matthieu','PROMO62',1,'ROLE_STUDENT'),
                             (19,NULL,NULL,'Lina.kada@isen.yncrea.fr','lina','PROMO62',1,'ROLE_STUDENT'),
                             (20,NULL,NULL,'théophile.louchart@isen.yncrea.fr','théophile','PROMO62',1,'ROLE_STUDENT');

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
INSERT INTO `teacher` VALUES (1,'Amaury.willemant@yncrea.fr','amaury',1,'ROLE_TEACHER'),
                             (2,'remi.auguste@yncrea.fr','remi',1,'ROLE_TEACHER'),
                             (3,'dominique.delannoy@yncrea.fr','dominique',1,'ROLE_TEACHER'),
                             (4,'benjamin.dubreu@yncrea.fr','benjamin',1,'ROLE_TEACHER'),
                             (5,'mouhamad.dimassi@yncrea.fr','mouhamad',1,'ROLE_TEACHER'),
                             (6,'arthur.pate@yncrea.fr','arthur',1,'ROLE_TEAHCER');
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
INSERT INTO `lesson` VALUES (1,'FR','Module de Base Développement JEE'),
                            (2,'FR','Module de Base Interface Homme Machine'),
                            (3,'EN','Module Transversal Sécurité des Données Personnelles'),
                            (4,'FR','Module de Base Intelligence Articielle Avancé'),
                            (5,'FR','Module de Base Business Intelligence'),
                            (6,'FR','Module de Base Operating Systems'),
                            (7,'FR','Module de Base Network and Systems Base'),
                            (8,'FR','Module de Base Environnements Sonores');

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
                          `title` varchar(255) NOT NULL,
                          `dateOfReview` datetime DEFAULT NULL,
                          `text` varchar(255) NOT NULL,
                          `student_id` int(11) NOT NULL,
                          `teacher_id` bigint(20) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'c''est la fin, adieu','2019-10-06 18:38:48','L''année scolaire touchant à sa fin, nous tenions à vous dire que vous avez été un excellent professeur ! Nous vous remercions d''avoir partagé vos connaissances avec nous, d''avoir toujours été juste dans votre éducation et de nous avoir toujours soutenus et aidés. Merci encore de la part de tous vos élèves.',1,1),
                            (2,'à la fois prochaine','2019-10-06 18:38:48','La fin de l''année se termine et il est temps pour vos élèves d''attribuer une note à leur professeur : 20/20. Merci pour votre enseignement !',2,3),
                            (3,'j''aime la physique','2019-10-06 18:38:48',' Je suis sûre que vous savez ce que signifie cobalt et tyngstène.',9,2),
                            (4,'merci à vous','2019-10-06 18:38:48','Merci d''avoir été si patient avec moi et de m''avoir aidé dans les moments les plus difficiles. Vous êtes un excellent professeur que beaucoup d''élèves aimeraient avoir.',6,3),
                            (5,'Méga prof!','2019-10-06 18:38:48','La passion pour votre travail et pour les mathématiques est contagieuse ! C''est avec un réel plaisir que nous sommes venus assister à tous vos cours cette année. Un grand MERCI de la part de vos élèves.',9,2),
                            (6,'une bière ?','2019-10-06 18:38:48','Nous vous remercions d''avoir partagé avec nous votre passion pour l''enseignement. Nous avons grandement apprécié votre soutien, votre implication et votre expérience tout au long de l''année. ',15,1),
                            (7,'une lettre','2019-10-06 18:38:48','Nous tenions à vous écrire un « Merci » sincère pour votre soutien, votre enseignement et vos conseils tout au long de cette année qui vient de s''écouler. Nous voulions que vous sachiez que vos élèves garderont toute leur vie un très bon souvenir de cette année d''étude.',9,2),
                            (8,'courage','2019-10-06 18:38:48','Votre travail est stressant. Vous ne comptez plus les heures. Et pourtant vous avez toujours été attentif et compréhensif. Nous tenions à vous remercier pour votre engagement à nos côtés, pour votre enseignement et votre soutien tout au long de l''année.',18,3),
                            (9,'super prof','2019-10-06 18:38:48','Nous vous remercions d''avoir enrichi nos connaissances et de nous avoir guidé durant toute cette année. ',16,6),
                            (10,'hyper prof','2019-10-06 18:38:48',' Vous êtes le professeur qui a réussi à m''inspirer, à me donner confiance en moi et en l''avenir mais aussi qui a réussi à me donner l''envie d''apprendre. Merci pour tout ce que vous avez fait !',12,1),
                            (11,'le savoir c''est vous','2019-10-06 18:38:48','Merci de nous avoir montré les clés du succès : avoir confiance en soi et en ses capacités, croire en soi et toujours tenter de se dépasser. Merci.',13,6),
                            (12,'le prof de l''année','2019-10-06 18:38:48','Merci pour tout !! Une prof comme vous je ne l''oublierais jamais !',9,1),
                            (13,'toujour plus haut! ','2019-10-06 18:38:48','J''espère avoir été à la hauteur des plus complexes devoirs que vous m''avez donnés cette année : me surpasser, croire en moi et ne jamais baisser les bras. Merci pour votre travail acharné à mes côtés !',20,1);
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
INSERT INTO `lesson_teacher` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,3),(7,3),(8,6);
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
INSERT INTO `lesson_student` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),
                                    (2,1),(2,2),(2,3),(2,4),(2,5),(2,6),(2,7),(2,8),(2,9),(2,10),(2,11),(2,12),(2,13),(2,14),(2,15),(2,16),(2,17),(2,18),(2,19),(2,20),
                                    (3,1),(3,2),(3,3),(3,4),(3,5),(3,6),(3,7),(3,8),(3,9),(3,10),(3,11),(3,12),(3,13),(3,14),(3,15),(3,16),(3,17),(3,18),(3,19),(3,20),
                                    (4,1),(4,2),(4,3),(4,4),(4,5),(4,6),(4,7),(4,8),(4,9),(4,10),(4,11),(4,12),(4,13),(4,14),(4,15),(4,16),(4,17),(4,18),(4,19),(4,20),
                                    (5,1),(5,2),(5,3),(5,4),(5,5),(5,6),(5,7),(5,8),(5,9),(5,10),(5,11),(5,12),(5,13),(5,14),(5,15),(5,16),(5,17),(5,18),(5,19),(5,20),
                                    (6,1),(6,2),(6,3),(6,4),(6,5),(6,6),(6,7),(6,8),(6,9),(6,10),(6,11),(6,12),(6,13),(6,14),(6,15),(6,16),(6,17),(6,18),(6,19),(6,20),
                                    (7,1),(7,2),(7,3),(7,4),(7,5),(7,6),(7,7),(7,8),(7,9),(7,10),(7,11),(7,12),(7,13),(7,14),(7,15),(7,16),(7,17),(7,18),(7,19),(7,20),
                                    (8,1),(8,2),(8,3),(8,4),(8,5),(8,6),(8,7),(8,8),(8,9),(8,10),(8,11),(8,12),(8,13),(8,14),(8,15),(8,16),(8,17),(8,18),(8,19),(8,20);
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
