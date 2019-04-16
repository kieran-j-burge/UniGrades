-- MySQL dump 10.13  Distrib 5.7.20, for macos10.12 (x86_64)
--
-- Host: localhost    Database: gradescalculator
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Table structure for table `tweet_msg_bgn`
--

DROP TABLE IF EXISTS `tweet_msg_bgn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tweet_msg_bgn` (
  `id` int(11) NOT NULL,
  `msg` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tweet_msg_bgn`
--

LOCK TABLES `tweet_msg_bgn` WRITE;
/*!40000 ALTER TABLE `tweet_msg_bgn` DISABLE KEYS */;
INSERT INTO `tweet_msg_bgn` VALUES (1,'University student ? '),(2,'Are you a student ? '),(3,'Are you on track for your desired final grade ?'),(4,'Need to know what your current grade is ?'),(5,'Check how well/badly you\'re doing in your degree...'),(6,'Need to know what to get in future exams to pass ?'),(7,'How far are you off a 1st ? '),(8,'Know how far you are off a 1st ?'),(9,'Want to know how hard you have to work to get a 2:1 ?'),(10,'Want to calculate your current mark ?'),(11,'Need to calculate your current mark ? '),(12,'How far are you off achieving your required grade...');
/*!40000 ALTER TABLE `tweet_msg_bgn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tweet_msg_end`
--

DROP TABLE IF EXISTS `tweet_msg_end`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tweet_msg_end` (
  `id` int(11) NOT NULL,
  `msg` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tweet_msg_end`
--

LOCK TABLES `tweet_msg_end` WRITE;
/*!40000 ALTER TABLE `tweet_msg_end` DISABLE KEYS */;
INSERT INTO `tweet_msg_end` VALUES (1,'Come join us : '),(2,'Use the tool here :'),(3,'Find your mark here :'),(4,'Use this link :'),(5,'Follow this link :');
/*!40000 ALTER TABLE `tweet_msg_end` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tweet_msg_mid`
--

DROP TABLE IF EXISTS `tweet_msg_mid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tweet_msg_mid` (
  `id` int(11) NOT NULL,
  `msg` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tweet_msg_mid`
--

LOCK TABLES `tweet_msg_mid` WRITE;
/*!40000 ALTER TABLE `tweet_msg_mid` DISABLE KEYS */;
INSERT INTO `tweet_msg_mid` VALUES (1,'Come over to GradesCalculator to calculate your current mark'),(2,'Use GradesCalculator to find out your current grade'),(3,'Jump over to GradesCalculator to work out your current progress towards your desired mark'),(4,'Find out your currnet grade on GradesCalculator'),(5,'Find out your current mark on GradesCalculator'),(6,'Use our tool on GradesCalculator to figure your mark out'),(7,'Work out your progress on GradesCalculator');
/*!40000 ALTER TABLE `tweet_msg_mid` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-27 11:22:34
