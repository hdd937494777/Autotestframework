-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `request_queue`
--

DROP TABLE IF EXISTS `request_queue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request_queue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `service_id` int(11) DEFAULT NULL COMMENT '服务id',
  `service_name` varchar(45) DEFAULT NULL COMMENT '服务名称',
  `request_time` datetime DEFAULT NULL COMMENT '请求时间',
  `request_url` varchar(45) DEFAULT NULL COMMENT '请求地址',
  `request_type` varchar(45) DEFAULT NULL COMMENT '请求类型',
  `request_data` varchar(500) DEFAULT NULL COMMENT '请求数据',
  `response_time` datetime DEFAULT NULL COMMENT '响应时间',
  `response_status` varchar(45) DEFAULT NULL COMMENT '响应状态',
  `response_data` varchar(500) DEFAULT NULL COMMENT '响应数据',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_queue`
--

LOCK TABLES `request_queue` WRITE;
/*!40000 ALTER TABLE `request_queue` DISABLE KEYS */;
/*!40000 ALTER TABLE `request_queue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `response_data`
--

DROP TABLE IF EXISTS `response_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `response_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `service_id` varchar(45) DEFAULT NULL COMMENT '服务id',
  `service_name` varchar(45) DEFAULT NULL COMMENT '服务名称',
  `response_time` datetime DEFAULT NULL COMMENT '响应时间',
  `request_time` datetime DEFAULT NULL COMMENT '请求时间',
  `response_status` varchar(45) DEFAULT NULL COMMENT '响应状态',
  `response_data` varchar(500) DEFAULT NULL COMMENT '响应数据',
  `request_id` int(11) DEFAULT NULL COMMENT '请求id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response_data`
--

LOCK TABLES `response_data` WRITE;
/*!40000 ALTER TABLE `response_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `response_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_config`
--

DROP TABLE IF EXISTS `service_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `service_id` int(11) NOT NULL,
  `time_out` int(11) DEFAULT NULL COMMENT '超时时间',
  `concurrent_count` int(11) DEFAULT NULL COMMENT '并发数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_config`
--

LOCK TABLES `service_config` WRITE;
/*!40000 ALTER TABLE `service_config` DISABLE KEYS */;
INSERT INTO `service_config` VALUES (1,'2017-06-05 11:08:17',NULL,1,10,2);
/*!40000 ALTER TABLE `service_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `request_url` varchar(150) NOT NULL COMMENT '请求地址',
  `request_type` varchar(45) NOT NULL COMMENT '请求类型:GET,POST',
  `data_url` varchar(150) DEFAULT NULL COMMENT '数据源地址',
  `service_name` varchar(45) DEFAULT NULL COMMENT '服务名称',
  `description` varchar(50) DEFAULT NULL COMMENT '服务描述',
  `need_parameter` varchar(15) DEFAULT NULL COMMENT '是否需要参数',
  `project` varchar(45) DEFAULT NULL COMMENT '所属项目',
  `operator_name` varchar(45) DEFAULT NULL,
  `operator_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'2017-06-05 11:02:46','2017-06-05 11:02:46','http://121.43.148.191:8136/bank/list','GET','F:\\unbinded_banklist.txt','bank_list','查询银行卡列表','Y','收银台','黄玉婷','1');
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-06 10:05:16
