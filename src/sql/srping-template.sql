CREATE DATABASE  IF NOT EXISTS `spring-test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `spring-test`;
-- MySQL dump 10.13  Distrib 5.7.10, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: spring-test
-- ------------------------------------------------------
-- Server version	5.7.10

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
-- Table structure for table `mng_menu`
--

DROP TABLE IF EXISTS `mng_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mng_menu` (
  `id` int(11) NOT NULL,
  `menu_name` varchar(45) DEFAULT NULL,
  `menu_path` varchar(200) DEFAULT NULL,
  `parent_id` varchar(45) DEFAULT NULL,
  `sequence` int(2) DEFAULT NULL,
  `menu_class` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mng_menu`
--

LOCK TABLES `mng_menu` WRITE;
/*!40000 ALTER TABLE `mng_menu` DISABLE KEYS */;
INSERT INTO `mng_menu` VALUES (1,'一级菜单',NULL,NULL,1,'fa-book '),(2,'一级菜单2','',NULL,2,'fa-user-md '),(3,'二级菜单1','/app/test.html?menuId=3','1',1,NULL),(4,'二级菜单2','/app/test2.html?menuId=4','1',2,NULL);
/*!40000 ALTER TABLE `mng_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mng_role`
--

DROP TABLE IF EXISTS `mng_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mng_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) DEFAULT NULL,
  `role_desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mng_role`
--

LOCK TABLES `mng_role` WRITE;
/*!40000 ALTER TABLE `mng_role` DISABLE KEYS */;
INSERT INTO `mng_role` VALUES (1,'ADMIN','管理员');
/*!40000 ALTER TABLE `mng_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mng_role_menu`
--

DROP TABLE IF EXISTS `mng_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mng_role_menu` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(20) DEFAULT NULL,
  `menu_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mng_role_menu`
--

LOCK TABLES `mng_role_menu` WRITE;
/*!40000 ALTER TABLE `mng_role_menu` DISABLE KEYS */;
INSERT INTO `mng_role_menu` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4);
/*!40000 ALTER TABLE `mng_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mng_user`
--

DROP TABLE IF EXISTS `mng_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mng_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `display_name` varchar(45) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `enable` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mng_user`
--

LOCK TABLES `mng_user` WRITE;
/*!40000 ALTER TABLE `mng_user` DISABLE KEYS */;
INSERT INTO `mng_user` VALUES (1,'admin','admin','$2a$10$gZKVfSc8x/BRkNSf3vxqlOqFd3iTDDbLEYAX4BJrPhX7AHCOFTv1y','1');
/*!40000 ALTER TABLE `mng_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mng_user_role`
--

DROP TABLE IF EXISTS `mng_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mng_user_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `role_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mng_user_role`
--

LOCK TABLES `mng_user_role` WRITE;
/*!40000 ALTER TABLE `mng_user_role` DISABLE KEYS */;
INSERT INTO `mng_user_role` VALUES (1,'admin','1');
/*!40000 ALTER TABLE `mng_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-22 11:58:33
