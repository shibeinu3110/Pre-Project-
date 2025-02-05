-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: l3_database
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `certificate`
--

DROP TABLE IF EXISTS `certificate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `certificate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `content` text,
  `field` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificate`
--

LOCK TABLES `certificate` WRITE;
/*!40000 ALTER TABLE `certificate` DISABLE KEYS */;
INSERT INTO `certificate` VALUES (1,4,'Java Certification','2024-01-01','Oracle Certified Java Programmer','Programming'),(3,4,'Java Certification','2024-01-01','Oracle Certified Java Programmer','Programming'),(4,4,'Java Certification','2024-01-01','Oracle Certified Java Programmer','Programming');
/*!40000 ALTER TABLE `certificate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificate_dto_mapper`
--

DROP TABLE IF EXISTS `certificate_dto_mapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `certificate_dto_mapper` (
  `dummy_id` bigint(20) NOT NULL,
  PRIMARY KEY (`dummy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificate_dto_mapper`
--

LOCK TABLES `certificate_dto_mapper` WRITE;
/*!40000 ALTER TABLE `certificate_dto_mapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `certificate_dto_mapper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `employee_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(255) DEFAULT NULL,
  `employee_code` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `team` varchar(100) DEFAULT NULL,
  `image_url` varchar(5000) DEFAULT NULL,
  `postcode` varchar(20) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `manager_created` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (4,'Nguyen Van A','EMP001','Male','1990-05-15','123 Nguyen Trai, Hanoi, Vietnam','Development','http://localhost:9000/employee-bucket/28502eb3-15c9-444e-8b32-ac7f80d34595-Nikon-D750-Image-Samples-2.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20241017%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20241017T070636Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=a72e92f93cf50369ea81a018f7159ecf727b80a553866286ace983bf0a2213e4','100000','0123456789','nguyenvana@example.com','exampleUser4'),(10,'Nguyen Van A','EMP003','Male','1990-05-15','123 Nguyen Trai, Hanoi, Vietnam','Development','http://localhost:9000/employee-bucket/ccc410cd-c66b-497c-8bc1-4d3b4e06d42d-462575570_490261083365903_1542061482513480137_n.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250204%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250204T090252Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=bf2ae4c8a491279a17c068bb493285c4b43730b570f79e7514c6494e5c3b3d25','1200090','012349678','nguyenvana3@example.com','exampleUser4'),(11,'Nguyen Van A','EMP004','Male','1990-05-15','123 Nguyen Trai, Hanoi, Vietnam','Development','http://localhost:9000/employee-bucket/529323da-c458-4316-b6c6-bbe80b1c4bf2-462575570_490261083365903_1542061482513480137_n.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250204%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250204T090549Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=48e08cca67eeb0584206b184e77864df406de566959e8b65dfdb48601ca9d8c6','1200099','012349698','nguyenvana4@example.com','exampleUser4'),(12,'Nguyen Van A','EMP005','Male','1990-05-15','123 Nguyen Trai, Hanoi, Vietnam','Development','http://localhost:9000/employee-bucket/a57ecf7a-35e2-4329-9a94-cca8f86f228c-462575570_490261083365903_1542061482513480137_n.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250204%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250204T092017Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=c32e14da1ee897b352b4a13ad6c41335c2f7f59ac326f4402638b82b589b762b','130009','012949698','nguyenvana5@example.com','exampleUser4');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_dto_mapper`
--

DROP TABLE IF EXISTS `employee_dto_mapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee_dto_mapper` (
  `dummy_id` bigint(20) NOT NULL,
  PRIMARY KEY (`dummy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_dto_mapper`
--

LOCK TABLES `employee_dto_mapper` WRITE;
/*!40000 ALTER TABLE `employee_dto_mapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_dto_mapper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile_end`
--

DROP TABLE IF EXISTS `profile_end`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `profile_end` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `registration_id` bigint(20) NOT NULL,
  `leader_id` bigint(20) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `end_by` varchar(255) DEFAULT NULL,
  `reason` text,
  `status` varchar(50) DEFAULT NULL,
  `submit_date` date DEFAULT NULL,
  `reject_date` date DEFAULT NULL,
  `reject_reason` text,
  `accept_date` date DEFAULT NULL,
  `additional_date` date DEFAULT NULL,
  `additional_reason` text,
  `storage_number` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile_end`
--

LOCK TABLES `profile_end` WRITE;
/*!40000 ALTER TABLE `profile_end` DISABLE KEYS */;
INSERT INTO `profile_end` VALUES (3,1,NULL,'2025-02-02','exampleUser4','check end profile','created',NULL,NULL,NULL,NULL,NULL,NULL,2);
/*!40000 ALTER TABLE `profile_end` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile_end_dto_mapper`
--

DROP TABLE IF EXISTS `profile_end_dto_mapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `profile_end_dto_mapper` (
  `dummy_id` bigint(20) NOT NULL,
  PRIMARY KEY (`dummy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile_end_dto_mapper`
--

LOCK TABLES `profile_end_dto_mapper` WRITE;
/*!40000 ALTER TABLE `profile_end_dto_mapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `profile_end_dto_mapper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `promotion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` bigint(20) DEFAULT NULL,
  `leader_id` bigint(20) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `reason` text,
  `status` varchar(50) DEFAULT NULL,
  `old_position` varchar(100) DEFAULT NULL,
  `new_position` varchar(100) DEFAULT NULL,
  `submit_date` date DEFAULT NULL,
  `reject_date` date DEFAULT NULL,
  `reject_reason` text,
  `accept_date` date DEFAULT NULL,
  `note` text,
  `additional_date` date DEFAULT NULL,
  `additional_reason` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
INSERT INTO `promotion` VALUES (1,9,NULL,'2024-11-10','exampleUser4','Promotion to new role updated','updated','Junior Developer','Senior Developer',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,9,0,'2024-11-13','exampleUser4','Promotion to new role updated','updated','Junior Developer','Senior Developer','2024-11-14',NULL,NULL,NULL,NULL,NULL,NULL),(4,9,NULL,'2024-11-14','exampleUser4','Promotion to new role','created','Junior Developer','Senior Developer',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion_dto_mapper`
--

DROP TABLE IF EXISTS `promotion_dto_mapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `promotion_dto_mapper` (
  `dummy_id` bigint(20) NOT NULL,
  PRIMARY KEY (`dummy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion_dto_mapper`
--

LOCK TABLES `promotion_dto_mapper` WRITE;
/*!40000 ALTER TABLE `promotion_dto_mapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `promotion_dto_mapper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proposal_advice`
--

DROP TABLE IF EXISTS `proposal_advice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proposal_advice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` bigint(20) DEFAULT NULL,
  `leader_id` bigint(20) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `content` text,
  `status` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `submit_date` date DEFAULT NULL,
  `reject_date` date DEFAULT NULL,
  `reject_reason` text,
  `accept_date` date DEFAULT NULL,
  `note` text,
  `additional_date` date DEFAULT NULL,
  `additional_reason` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proposal_advice`
--

LOCK TABLES `proposal_advice` WRITE;
/*!40000 ALTER TABLE `proposal_advice` DISABLE KEYS */;
INSERT INTO `proposal_advice` VALUES (1,4,2,'2024-11-14','exampleUser4','This is a sample content for the proposal. (updated)','additional','Approval updated','2024-11-15',NULL,NULL,NULL,'note 1 ','2024-11-15',NULL),(2,4,2,'2024-11-14','exampleUser4','This is a sample content for the proposal.','pending','Approval','2024-12-07',NULL,NULL,NULL,NULL,NULL,NULL),(3,4,NULL,'2024-11-14','exampleUser4','This is a sample content for the proposal.','created','Approval',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `proposal_advice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proposal_advice_dto_mapper`
--

DROP TABLE IF EXISTS `proposal_advice_dto_mapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proposal_advice_dto_mapper` (
  `dummy_id` bigint(20) NOT NULL,
  PRIMARY KEY (`dummy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proposal_advice_dto_mapper`
--

LOCK TABLES `proposal_advice_dto_mapper` WRITE;
/*!40000 ALTER TABLE `proposal_advice_dto_mapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `proposal_advice_dto_mapper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registration` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` bigint(20) DEFAULT NULL,
  `leader_id` bigint(20) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `content` text,
  `status` varchar(50) DEFAULT NULL,
  `submit_date` date DEFAULT NULL,
  `reject_date` date DEFAULT NULL,
  `reject_reason` text,
  `accept_date` date DEFAULT NULL,
  `note` text,
  `additional_date` date DEFAULT NULL,
  `additional_reason` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` VALUES (1,4,2,'2024-12-06','exampleUser4','This is a sample content for testing updated by manager','pending','2024-12-07',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration_dto_mapper`
--

DROP TABLE IF EXISTS `registration_dto_mapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registration_dto_mapper` (
  `dummy_id` bigint(20) NOT NULL,
  PRIMARY KEY (`dummy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration_dto_mapper`
--

LOCK TABLES `registration_dto_mapper` WRITE;
/*!40000 ALTER TABLE `registration_dto_mapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `registration_dto_mapper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relationship`
--

DROP TABLE IF EXISTS `relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `relationship` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `postcode` varchar(20) DEFAULT NULL,
  `relationship` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relationship`
--

LOCK TABLES `relationship` WRITE;
/*!40000 ALTER TABLE `relationship` DISABLE KEYS */;
INSERT INTO `relationship` VALUES (2,'hung','Male',4,'1990-01-01','100002','Brother','123 Main Street, City, Country');
/*!40000 ALTER TABLE `relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relationship_dto_mapper`
--

DROP TABLE IF EXISTS `relationship_dto_mapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `relationship_dto_mapper` (
  `dummy_id` bigint(20) NOT NULL,
  PRIMARY KEY (`dummy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relationship_dto_mapper`
--

LOCK TABLES `relationship_dto_mapper` WRITE;
/*!40000 ALTER TABLE `relationship_dto_mapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `relationship_dto_mapper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'MANAGER'),(2,'LEADER'),(3,'MANAGER'),(4,'LEADER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_dto_mapper`
--

DROP TABLE IF EXISTS `role_dto_mapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role_dto_mapper` (
  `dummy_id` bigint(20) NOT NULL,
  PRIMARY KEY (`dummy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_dto_mapper`
--

LOCK TABLES `role_dto_mapper` WRITE;
/*!40000 ALTER TABLE `role_dto_mapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_dto_mapper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_increment`
--

DROP TABLE IF EXISTS `salary_increment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `salary_increment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` bigint(20) NOT NULL,
  `leader_id` bigint(20) NOT NULL,
  `create_date` date DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `reason` text,
  `status` varchar(50) DEFAULT NULL,
  `salary_level` varchar(50) DEFAULT NULL,
  `submit_date` date DEFAULT NULL,
  `reject_date` date DEFAULT NULL,
  `reject_reason` text,
  `accept_date` date DEFAULT NULL,
  `note` text,
  `additional_date` date DEFAULT NULL,
  `additional_reason` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_increment`
--

LOCK TABLES `salary_increment` WRITE;
/*!40000 ALTER TABLE `salary_increment` DISABLE KEYS */;
INSERT INTO `salary_increment` VALUES (2,9,2,'2024-10-28','exampleUser4','Performance-based increment updated test 2','updated','Level 3','2024-10-31',NULL,NULL,NULL,'create 1st',NULL,NULL),(3,9,2,'2024-10-31','exampleUser4','Performance-based increment updated test 3','accepted','Level 3',NULL,NULL,NULL,'2024-10-31','test note',NULL,NULL),(4,9,2,'2024-10-31','exampleUser4','Annual salary increment','created','Level 3',NULL,NULL,NULL,NULL,'create 1st',NULL,NULL),(6,9,2,'2024-10-31','exampleUser4','Annual salary increment','created','Level 3',NULL,NULL,NULL,NULL,'create 1st',NULL,NULL),(7,9,2,'2024-11-01','exampleUser4','Annual salary increment','created','Level 3',NULL,NULL,NULL,NULL,'create 1st',NULL,NULL),(8,9,2,'2025-02-02','exampleUser4','Annual salary increment','created','Level 3',NULL,NULL,NULL,NULL,'create 1st',NULL,NULL),(9,9,2,'2025-02-02','exampleUser4','Annual salary increment','created','Level 3',NULL,NULL,NULL,NULL,'create 1st',NULL,NULL),(10,10,2,'2025-02-05','exampleUser4','Annual salary increment','created','Level 3',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `salary_increment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_increment_dto_mapper`
--

DROP TABLE IF EXISTS `salary_increment_dto_mapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `salary_increment_dto_mapper` (
  `dummy_id` bigint(20) NOT NULL,
  PRIMARY KEY (`dummy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_increment_dto_mapper`
--

LOCK TABLES `salary_increment_dto_mapper` WRITE;
/*!40000 ALTER TABLE `salary_increment_dto_mapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `salary_increment_dto_mapper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'exampleUser','$2a$12$pjl3w5ClSDVCSmeuu6o5Du8Bo9lw1d9NxICpbD4IkYwdBcsceQcjK',4,'Example Name','example@example.com','1234567890'),(3,'exampleUser1','$2a$12$/DilECDkQ3eETguy0evoUeM7cPB6p99AOkY2kAyR6FPHKBjwhO1oa',1,'Example Name','example@example.com','1234567890'),(4,'exampleUser3','$2a$12$i59mQoiZkT1tzKBViAepS.o5RMz9sw0jF0u6SKzYdrzmfZwdhHIXe',3,'Example Name','example@example.com','1234567890'),(5,'exampleUser4','$2a$12$ndWz/NUN3Yt7z.jrielcBOH2zWrN2Ph24c2fytJ9or2aR6XbGF1I6',3,'Example Name','example@example.com','1234567890');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_dto_mapper`
--

DROP TABLE IF EXISTS `user_dto_mapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_dto_mapper` (
  `dummy_id` bigint(20) NOT NULL,
  PRIMARY KEY (`dummy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_dto_mapper`
--

LOCK TABLES `user_dto_mapper` WRITE;
/*!40000 ALTER TABLE `user_dto_mapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_dto_mapper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'l3_database'
--
/*!50003 DROP PROCEDURE IF EXISTS `create_certificate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_certificate`(IN certificateJson VARCHAR(5000))
BEGIN
	-- DECLARE id BIGINT;
    DECLARE employeeId BIGINT;
    DECLARE certName VARCHAR(255);
    DECLARE startDate DATE;
    DECLARE content VARCHAR(255);
    DECLARE field VARCHAR(100);

	-- set id = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.id'));
    SET employeeId = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.employeeId'));
    SET certName = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.name'));
    SET startDate = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.startDate'));
    SET content = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.content'));
    SET field = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.field'));

    

    INSERT INTO certificate ( employee_id, name, start_date, content, field)
    VALUES ( employeeId, certName, startDate, content, field);
    
    SELECT * FROM certificate WHERE id = LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `create_employee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_employee`(IN employeeJson VARCHAR(5000))
BEGIN
    #DECLARE employeeId BIGINT;
    DECLARE employeeName VARCHAR(255);
    DECLARE employeeCode VARCHAR(50);
    DECLARE gender VARCHAR(10);
    DECLARE dateOfBirth DATE;
    DECLARE address VARCHAR(255);
    DECLARE team VARCHAR(100);
    DECLARE imageUrl VARCHAR(5000);
    DECLARE postcode VARCHAR(20);
    DECLARE phoneNumber VARCHAR(20);
    DECLARE email VARCHAR(255);
    DECLARE managerCreated VARCHAR(255);

    #SET employeeId = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.employeeId'));
    SET employeeName = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.employeeName'));
    SET employeeCode = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.employeeCode'));
    SET gender = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.gender'));
    SET dateOfBirth = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.dateOfBirth'));
    SET address = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.address'));
    SET team = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.team'));
    SET imageUrl = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.imageUrl'));
    SET postcode = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.postcode'));
    SET phoneNumber = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.phoneNumber'));
    SET email = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.email'));
    SET managerCreated = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.managerCreated')); 
    
#employee_id,employeeId,
    INSERT INTO employee ( employee_name, employee_code, gender, date_of_birth, address, team, image_url, postcode, phone_number, email, manager_created)
    VALUES ( employeeName, employeeCode, gender, dateOfBirth, address, team, imageUrl, postcode, phoneNumber, email, managerCreated);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `create_profile_end` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_profile_end`(IN profile_end_json VARCHAR(500))
BEGIN
    DECLARE registrationId BIGINT;
    DECLARE endDate DATE;
    DECLARE endBy VARCHAR(200);
    DECLARE reason VARCHAR(200);
    DECLARE status VARCHAR(100);
    declare storageNumber BIGINT;

    SET registrationId = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.registrationId'));
    SET endDate = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.endDate'));
    SET endBy = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.endBy'));
    SET reason = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.reason'));
    SET status = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.status'));
    SET storageNumber = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.storageNumber'));
    
    
    insert into profile_end (registration_id, end_date, end_by, reason, status, storage_number)
    values (registrationId, endDate, endBy, reason, status, storageNumber);
    
    SELECT * FROM profile_end WHERE id = LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `create_promotion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_promotion`(IN promotionJson VARCHAR(5000))
BEGIN
	
    
    DECLARE employeeId BIGINT;
    #declare leaderId BIGINT;
    DECLARE createDate DATE;
    declare createdBy VARCHAR(50);
    DECLARE reason VARCHAR(200);
    DECLARE status VARCHAR(100);
    DECLARE oldPosition VARCHAR(255);
	DECLARE newPosition VARCHAR(255);
/*
    DECLARE submitDate DATE;
    DECLARE rejectDate DATE;
    DECLARE rejectReason VARCHAR(255);
    DECLARE acceptDate DATE;
    DECLARE note VARCHAR(255);
    DECLARE additionalDate DATE;
    DECLARE additionalReason VARCHAR(255);*/

    SET employeeId = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.employeeId'));
    #SET leaderId = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.leaderId'));
    SET createDate = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.createDate'));
    SET createdBy = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.createdBy'));
    SET reason = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.reason'));
    SET status = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.status'));
    SET oldPosition = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.oldPosition'));
	SET newPosition = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.newPosition'));

    
    /*SET submitDate = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.submitDate'));
    SET rejectDate = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.rejectDate'));
    SET rejectReason = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.rejectReason'));
    SET acceptDate = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.acceptDate'));
    SET note = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.note'));
    SET additionalDate = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.additionalDate'));
    SET additionalReason = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.additionalReason'));
    */
    

    INSERT INTO 
    promotion(employee_id, create_date, created_by, reason, status, old_position, new_position)
    VALUES (employeeId, createDate, createdBy, reason, status, oldPosition, newPosition);
    
    SELECT * FROM promotion WHERE id = LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `create_proposal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_proposal`(IN proposal_id VARCHAR(500))
BEGIN
    DECLARE employeeId BIGINT;
    DECLARE createDate DATE;
    declare createdBy VARCHAR(50);
    DECLARE content VARCHAR(200);
    DECLARE status VARCHAR(100);
    DECLARE type VARCHAR(255);

    SET employeeId = JSON_UNQUOTE(JSON_EXTRACT(proposal_id, '$.employeeId'));
    SET createDate = JSON_UNQUOTE(JSON_EXTRACT(proposal_id, '$.createDate'));
    SET createdBy = JSON_UNQUOTE(JSON_EXTRACT(proposal_id, '$.createdBy'));
    SET content = JSON_UNQUOTE(JSON_EXTRACT(proposal_id, '$.content'));
    SET status = JSON_UNQUOTE(JSON_EXTRACT(proposal_id, '$.status'));
    SET type = JSON_UNQUOTE(JSON_EXTRACT(proposal_id, '$.type'));
    
    
    insert into proposal_advice (employee_id, create_date, created_by, content, status, type)
    values (employeeId, createDate, createdBy, content, status, type);
    
    SELECT * FROM proposal_advice WHERE id = LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `create_registration` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_registration`(IN registration_json VARCHAR(500))
BEGIN
    DECLARE employeeId BIGINT;
    DECLARE createDate DATE;
    declare createdBy VARCHAR(50);
    DECLARE content VARCHAR(200);
    DECLARE status VARCHAR(100);

    SET employeeId = JSON_UNQUOTE(JSON_EXTRACT(registration_json, '$.employeeId'));
    SET createDate = JSON_UNQUOTE(JSON_EXTRACT(registration_json, '$.createDate'));
    SET createdBy = JSON_UNQUOTE(JSON_EXTRACT(registration_json, '$.createdBy'));
    SET content = JSON_UNQUOTE(JSON_EXTRACT(registration_json, '$.content'));
    SET status = JSON_UNQUOTE(JSON_EXTRACT(registration_json, '$.status'));
    
    
    insert into registration (employee_id, create_date, created_by, content, status)
    values (employeeId, createDate, createdBy, content, status);
    
    SELECT * FROM registration WHERE id = LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `create_relationship` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_relationship`(IN relationshipJson VARCHAR(5000))
BEGIN
	
    DECLARE name VARCHAR(255);
    DECLARE gender VARCHAR(255);
    DECLARE employeeId BIGINT;
    DECLARE dateOfBirth DATE;
    DECLARE postcode VARCHAR(20);
    DECLARE relationship VARCHAR(100);
    DECLARE address VARCHAR(255);

    SET name = JSON_UNQUOTE(JSON_EXTRACT(relationshipJson, '$.name'));
    SET gender = JSON_UNQUOTE(JSON_EXTRACT(relationshipJson, '$.gender'));
    SET employeeId = JSON_UNQUOTE(JSON_EXTRACT(relationshipJson, '$.employeeId'));
    SET dateOfBirth = JSON_UNQUOTE(JSON_EXTRACT(relationshipJson, '$.dateOfBirth'));
    SET postcode = JSON_UNQUOTE(JSON_EXTRACT(relationshipJson, '$.postcode'));
	SET relationship = JSON_UNQUOTE(JSON_EXTRACT(relationshipJson, '$.relationship'));
	SET address = JSON_UNQUOTE(JSON_EXTRACT(relationshipJson, '$.address'));



    

    INSERT INTO relationship ( name, gender, employee_id, date_of_birth, postcode, relationship,address)
    VALUES ( name, gender, employeeId, dateOfBirth, postcode, relationship, address);
    
    SELECT * FROM relationship WHERE id = LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `create_salary_increment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_salary_increment`(IN salaryIncrementJson VARCHAR(5000))
BEGIN
	
    
    DECLARE employeeId BIGINT;
    declare leaderId BIGINT;
    DECLARE createDate DATE;
    declare createdBy VARCHAR(50);
    DECLARE reason VARCHAR(200);
    DECLARE status VARCHAR(100);
    DECLARE salaryLevel VARCHAR(255);
   

    SET employeeId = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.employeeId'));
    SET leaderId = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.leaderId'));
    SET createDate = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.createDate'));
    SET createdBy = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.createdBy'));
    SET reason = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.reason'));
    SET status = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.status'));
    SET salaryLevel = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.salaryLevel'));
    
    
    

    INSERT INTO 
    salary_increment (employee_id, leader_id, create_date, created_by, reason, status, salary_level)
    VALUES (employeeId, leaderId,createDate, createdBy, reason, status, salaryLevel);
    
    SELECT * FROM salary_increment WHERE id = LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `create_user` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_user`(IN userJson VARCHAR(500))
BEGIN
    DECLARE userId BIGINT;
    DECLARE userUsername VARCHAR(255);
    DECLARE userPassword VARCHAR(255);
    DECLARE userRoleId BIGINT;
    DECLARE userName VARCHAR(255);
    DECLARE userEmail VARCHAR(255);
    DECLARE userPhone VARCHAR(20);

    -- Trích xuất dữ liệu từ chuỗi JSON
    SET userId = JSON_UNQUOTE(JSON_EXTRACT(userJson, '$.id'));
    SET userUsername = JSON_UNQUOTE(JSON_EXTRACT(userJson, '$.username'));
    SET userPassword = JSON_UNQUOTE(JSON_EXTRACT(userJson, '$.password'));
    SET userRoleId = JSON_UNQUOTE(JSON_EXTRACT(userJson, '$.roleId'));
    SET userName = JSON_UNQUOTE(JSON_EXTRACT(userJson, '$.name'));
    SET userEmail = JSON_UNQUOTE(JSON_EXTRACT(userJson, '$.email'));
    SET userPhone = JSON_UNQUOTE(JSON_EXTRACT(userJson, '$.phone'));

    -- Chèn dữ liệu vào bảng user
    INSERT INTO user (id, username, password, role_id, name, email, phone)
    VALUES (userId, userUsername, userPassword, userRoleId, userName, userEmail, userPhone);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_certificate_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_certificate_by_id`(IN certificateId BIGINT)
BEGIN
    delete c from certificate c where c.id = certificateId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_employee_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_employee_by_id`(IN employee_id BIGINT)
BEGIN
    delete e from employee e where e.employee_id = employee_id;
    
    #delete employee attribute
    delete c from certificate c where c.employee_id = employee_id;
	delete r from relationship r where r.employee_id = employee_id;
    
    #delete employee form
    delete pa from proposal_advice pa where pa.employee_id = employee_id;
    delete p from promotion p where p.employee_id = employee_id;
    delete si from salary_increment si where si.employee_id = employee_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_profile_end_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_profile_end_by_id`(IN profileId BIGINT)
BEGIN
	DELETE r FROM registration r where r.id = (select pe1.registration_id from profile_end pe1 where pe1.id = profileId);
    DELETE pe FROM profile_end pe where pe.id = profileId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_promotion_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_promotion_by_id`(IN promotionId BIGINT)
BEGIN
    delete FROM promotion where id = promotionId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_proposal_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_proposal_by_id`(IN proposal_id VARCHAR(500))
BEGIN
    delete from proposal_advice where id = proposal_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_registration_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_registration_by_id`(IN registrationId BIGINT)
BEGIN
    delete r from registration r where r.id = registrationId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_relationship_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_relationship_by_id`(IN relationshipId BIGINT)
BEGIN
    delete from relationship where id = relationshipId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_salary_increment_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_salary_increment_by_id`(IN salaryIncrementId BIGINT)
BEGIN
    delete FROM salary_increment where id = salaryIncrementId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `exist_certificate_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `exist_certificate_by_id`(IN certificate_id VARCHAR(500))
BEGIN
    SELECT COUNT(*) FROM certificate c WHERE c.id = certificate_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `exist_employee_by_email` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `exist_employee_by_email`(IN email VARCHAR(500))
BEGIN
    SELECT COUNT(*) FROM employee e WHERE e.email = email;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `exist_employee_by_employee_code` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `exist_employee_by_employee_code`(IN code VARCHAR(500))
BEGIN
    SELECT COUNT(*) FROM employee e WHERE e.employee_code = code;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `exist_employee_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `exist_employee_by_id`(IN employee_id VARCHAR(500))
BEGIN
    SELECT COUNT(*) FROM employee e WHERE e.employee_id = employee_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `exist_employee_by_phone` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `exist_employee_by_phone`(IN phone VARCHAR(500))
BEGIN
    SELECT COUNT(*) FROM employee e WHERE e.phone_number = phone;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `exist_employee_by_postcode` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `exist_employee_by_postcode`(IN postcode VARCHAR(500))
BEGIN
    SELECT COUNT(*) FROM employee e WHERE e.postcode = postcode;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `exist_leader_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `exist_leader_by_id`(IN userId BIGINT)
BEGIN
	select count(*) from user where id = userId and (role_id = 2 or role_id = 4); 
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `exist_profile_end_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `exist_profile_end_by_id`(IN profile_end_id BIGINT)
BEGIN
    SELECT COUNT(*) FROM profile_end pe  WHERE pe.id = profile_end_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `exist_profile_end_by_storage_number` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `exist_profile_end_by_storage_number`(IN storageNumber BIGINT)
BEGIN
    select count(*) from profile_end where storage_number = storageNumber;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `exist_promotion_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `exist_promotion_by_id`(IN promotion_id BIGINT)
BEGIN
    SELECT COUNT(*) FROM promotion  WHERE id = promotion_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `exist_proposal_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `exist_proposal_by_id`(IN proposal_id VARCHAR(500))
BEGIN
    SELECT COUNT(*) FROM proposal_advice pa WHERE pa.id = proposal_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `exist_registration_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `exist_registration_by_id`(IN registration_id VARCHAR(500))
BEGIN
    SELECT COUNT(*) FROM registration r WHERE r.id = registration_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `exist_relationship_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `exist_relationship_by_id`(IN relationship_id VARCHAR(500))
BEGIN
    SELECT COUNT(*) FROM relationship r  WHERE r.id = relationship_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `exist_relationship_by_postcode` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `exist_relationship_by_postcode`(IN postcode VARCHAR(500))
BEGIN
    SELECT COUNT(*) FROM relationship r WHERE r.postcode = postcode;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `exist_salary_increment_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `exist_salary_increment_by_id`(IN salary_increment_id BIGINT)
BEGIN
    SELECT COUNT(*) FROM salary_increment  WHERE id = salary_increment_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_certificate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_certificate`()
BEGIN
    SELECT * FROM certificate c; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_employee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_employee`()
BEGIN
    SELECT * FROM employee e; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_profile_end` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_profile_end`()
BEGIN
    SELECT * FROM profile_end pe;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_promotion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_promotion`()
BEGIN
    SELECT * FROM promotion  ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_proposal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_proposal`()
BEGIN
    SELECT * FROM proposal_advice  ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_registration` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_registration`()
BEGIN
    SELECT * FROM registration r ;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_relationship` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_relationship`()
BEGIN
    SELECT * from relationship r ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_salary_increment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_salary_increment`()
BEGIN
    SELECT * FROM salary_increment  ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_certificate_by_employee_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_certificate_by_employee_id`(IN employeeId BIGINT)
BEGIN
    select * from certificate c where c.employee_id = employeeId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_certificate_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_certificate_by_id`(IN certificateId BIGINT)
BEGIN
    SELECT * FROM certificate c where c.id = certificateId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_employee_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_employee_by_id`(IN employeeId BIGINT)
BEGIN
    SELECT * FROM employee e where e.employee_id = employeeId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_profile_end_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_profile_end_by_id`(IN profile_end_id BIGINT)
BEGIN
    SELECT * FROM profile_end pe  WHERE pe.id = profile_end_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_promotion_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_promotion_by_id`(IN promotion_id BIGINT)
BEGIN
    SELECT * FROM promotion  WHERE id = promotion_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_proposal_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_proposal_by_id`(IN proposal_id BIGINT)
BEGIN
    SELECT * FROM proposal_advice  WHERE id = proposal_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_registration_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_registration_by_id`(IN registration_id VARCHAR(500))
BEGIN
    SELECT * FROM registration r WHERE r.id = registration_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_relationship_by_employee_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_relationship_by_employee_id`(IN employee_id BIGINT)
BEGIN
    SELECT * from relationship r where r.employee_id = employee_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_relationship_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_relationship_by_id`(IN relationshipId BIGINT)
BEGIN
    SELECT * FROM relationship r where r.id = relationshipId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_role_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_role_by_id`(IN id BIGINT)
BEGIN
    SELECT * FROM role r 
    WHERE r.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_salary_increment_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_salary_increment_by_id`(IN salaryIncrementId BIGINT)
BEGIN
    SELECT * FROM salary_increment where id = salaryIncrementId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_user_by_username` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_user_by_username`(IN username VARCHAR(500))
BEGIN
    select * from user u where u.username = username;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `submit_profile_end` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `submit_profile_end`(IN id BIGINT, profile_end_json VARCHAR(5000))
BEGIN
	
    declare leaderId BIGINT;
    DECLARE status VARCHAR(100);
    DECLARE submitDate DATE;

    SET leaderId = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.leaderId'));
    SET status = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.status'));
    SET submitDate = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.submitDate'));
    
    update profile_end pe 
    set pe.leader_id = id,
		pe.status = status,
		pe.submit_date = submitDate
	where pe.id = id;
    
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `submit_promotion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `submit_promotion`(IN id BIGINT, promotionJson VARCHAR(5000))
BEGIN
	
    declare leaderId BIGINT;
    DECLARE status VARCHAR(100);
    DECLARE submitDate DATE;
    declare reason VARCHAR(100);

    SET leaderId = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.leaderId'));
    SET status = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.status'));
    SET submitDate = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.submitDate'));
    set reason = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.reason'));
    
    update promotion p
    set p.leader_id = leaderId,
		p.status = status,
		p.submit_date = submitDate,
        p.reason = reason
	where p.id = id;
    
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `submit_proposal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `submit_proposal`(IN proposalId VARCHAR(500), proposalJson VARCHAR(5000))
BEGIN
	DECLARE leaderId BIGINT;
    DECLARE status VARCHAR(100);
	DECLARE submitDate DATE;
    
    
    SET leaderId = JSON_UNQUOTE(JSON_EXTRACT(proposalJson, '$.leaderId'));
    SET status = JSON_UNQUOTE(JSON_EXTRACT(proposalJson, '$.status'));
    SET submitDate = JSON_UNQUOTE(JSON_EXTRACT(proposalJson, '$.submitDate'));

    update proposal_advice p
    set p.leader_id = leaderId,
		p.status = status,
        p.submit_date = submitDate
	where p.id = proposalId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `submit_registration` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `submit_registration`(IN registrationId VARCHAR(500), registrationJson VARCHAR(5000))
BEGIN
	DECLARE leaderId BIGINT;
    DECLARE status VARCHAR(100);
	DECLARE submitDate DATE;
    
    
    SET leaderId = JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.leaderId'));
    SET status = JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.status'));
    SET submitDate = JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.submitDate'));

    update registration r
    set r.leader_id = leaderId,
		r.status = status,
        r.submit_date = submitDate
	where r.id = registrationId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `submit_salary_increment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `submit_salary_increment`(IN id BIGINT, salaryIncrementJson VARCHAR(5000))
BEGIN
	
    declare leaderId BIGINT;
    DECLARE status VARCHAR(100);
    DECLARE submitDate DATE;

    SET leaderId = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.leaderId'));
    SET status = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.status'));
    SET submitDate = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.submitDate'));
    
    update salary_increment s 
    set s.leader_id = id,
		s.status = status,
		s.submit_date = submitDate
	where s.id = id;
    
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_certificate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_certificate`(IN id BIGINT, certificateJson VARCHAR(5000))
BEGIN
    DECLARE employeeId BIGINT;
    DECLARE certName VARCHAR(255);
    DECLARE startDate DATE;
    DECLARE content VARCHAR(255);
    DECLARE field VARCHAR(100);

	
    SET employeeId = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.employeeId'));
    SET certName = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.name'));
    SET startDate = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.startDate'));
    SET content = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.content'));
    SET field = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.field'));
    
    
    update certificate c
    set c.employee_id = employeeId,
		c.name = certName,
        c.start_date = startDate,
        c.content = content,
        c.field = field
	where c.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_profile_end_by_leader` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_profile_end_by_leader`(IN profileEndId BIGINT, profile_end_json VARCHAR(5000))
BEGIN
	DECLARE status VARCHAR(100);
	DECLARE rejectDate DATE;
    DECLARE rejectReason VARCHAR(255);
    DECLARE acceptDate DATE;
    DECLARE additionalDate DATE;
    DECLARE additionalReason VARCHAR(255);
    
    
    SET status = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.status'));
    SET rejectDate = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.rejectDate'));
    SET rejectReason = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.rejectReason'));
    SET acceptDate = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.acceptDate'));
    SET additionalDate = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.additionalDate'));
    SET additionalReason = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.additionalReason'));
    
    update profile_end pe 
    set pe.status = status,
		pe.reject_date = rejectDate,
        pe.accept_date = acceptDate,
        pe.additional_date = additionalDate,
        pe.additional_reason = additionalReason
	where pe.id = profileEndId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_profile_end_by_manager` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_profile_end_by_manager`(IN profileEndId BIGINT, profile_end_json VARCHAR(5000))
BEGIN
	DECLARE registrationId BIGINT;
    DECLARE reason VARCHAR(200);
    DECLARE status VARCHAR(100);
    declare storageNumber BIGINT;
    
    
    SET registrationId = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.registrationId'));
    SET reason = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.reason'));
    SET status = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.status'));
    SET storageNumber = JSON_UNQUOTE(JSON_EXTRACT(profile_end_json, '$.storageNumber'));

    update profile_end pe
    set pe.registration_id = registrationId,
		pe.reason = reason,
        pe.status = status,
        pe.storage_number = storageNumber
	where pe.id = profileEndId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_promotion_by_leader` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_promotion_by_leader`(IN id BIGINT, promotionJson VARCHAR(5000))
BEGIN
    
    DECLARE status VARCHAR(100);
    DECLARE rejectDate DATE;
    DECLARE rejectReason VARCHAR(255);
    DECLARE acceptDate DATE;
    DECLARE note VARCHAR(255);
    DECLARE additionalDate DATE;
    DECLARE additionalReason VARCHAR(255);

    SET status = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.status'));
    SET rejectDate = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.rejectDate'));
    SET rejectReason = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.rejectReason'));
    SET acceptDate = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.acceptDate'));
    SET note = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.note'));
    SET additionalDate = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.additionalDate'));
    SET additionalReason = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.additionalReason'));

    update promotion p 
    set p.status = status,
		p.reject_date = rejectDate,
        p.reject_reason = rejectReason,
        p.accept_date = acceptDate,
        p.note = note,
        p.additional_date = additionalDate,
        p.additional_reason = additionalReason
    where p.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_promotion_by_manager` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_promotion_by_manager`(IN promotionId BIGINT, IN promotionJson VARCHAR(5000))
BEGIN
    DECLARE employeeId BIGINT;
    DECLARE reason VARCHAR(200);
    DECLARE status VARCHAR(100);
    DECLARE oldPosition VARCHAR(255);
	DECLARE newPosition VARCHAR(255);
    SET employeeId = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.employeeId'));
    SET reason = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.reason'));
    SET status = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.status'));
    SET oldPosition = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.oldPosition'));
	SET newPosition = JSON_UNQUOTE(JSON_EXTRACT(promotionJson, '$.newPosition'));
    
    update promotion p
    set p.employee_id = employeeId,
		p.reason = reason,
        p.status = status,
        p.old_position = oldPosition,
        p.new_position = newPosition
	where p.id = promotionId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_proposal_by_leader` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_proposal_by_leader`(IN proposalId VARCHAR(500), proposalJson VARCHAR(5000))
BEGIN
	DECLARE status VARCHAR(100);
	DECLARE rejectDate DATE;
    DECLARE rejectReason VARCHAR(255);
    DECLARE acceptDate DATE;
    DECLARE note VARCHAR(255);
    DECLARE additionalDate DATE;
    DECLARE additionalReason VARCHAR(255);
    
    
    SET status = JSON_UNQUOTE(JSON_EXTRACT(proposalJson, '$.status'));
    SET rejectDate = JSON_UNQUOTE(JSON_EXTRACT(proposalJson, '$.rejectDate'));
    SET rejectReason = JSON_UNQUOTE(JSON_EXTRACT(proposalJson, '$.rejectReason'));
    SET acceptDate = JSON_UNQUOTE(JSON_EXTRACT(proposalJson, '$.acceptDate'));
    SET note = JSON_UNQUOTE(JSON_EXTRACT(proposalJson, '$.note'));
    SET additionalDate = JSON_UNQUOTE(JSON_EXTRACT(proposalJson, '$.additionalDate'));
    SET additionalReason = JSON_UNQUOTE(JSON_EXTRACT(proposalJson, '$.additionalReason'));
    
    update proposal_advice p 
    set p.status = status,
		p.reject_date = rejectDate,
        p.accept_date = acceptDate,
        p.note = note,
        p.additional_date = additionalDate,
        p.additional_reason = additionalReason
	where p.id = proposalId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_proposal_by_manager` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_proposal_by_manager`(IN proposalId VARCHAR(500), proposalJson VARCHAR(5000))
BEGIN
	DECLARE employeeId BIGINT;
    DECLARE content VARCHAR(200);
    DECLARE status VARCHAR(100);
    DECLARE type VARCHAR(255);
    
    
    SET employeeId = JSON_UNQUOTE(JSON_EXTRACT(proposalJson, '$.employeeId'));
    SET content = JSON_UNQUOTE(JSON_EXTRACT(proposalJson, '$.content'));
    SET status = JSON_UNQUOTE(JSON_EXTRACT(proposalJson, '$.status'));
    SET type = JSON_UNQUOTE(JSON_EXTRACT(proposalJson, '$.type'));

    update proposal_advice p
    set p.employee_id = employeeId,
		p.content = content,
        p.status = status,
        p.type = type
	where p.id = proposalId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_registration_by_manager` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_registration_by_manager`(IN registrationId VARCHAR(500), registrationJson VARCHAR(5000))
BEGIN
	DECLARE employeeId BIGINT;
    DECLARE content VARCHAR(200);
    DECLARE status VARCHAR(100);
    
    
    SET employeeId = JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.employeeId'));
    SET content = JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.content'));
    SET status = JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.status'));

    update registration r
    set r.employee_id = employeeId,
		r.content = content,
        r.status = status
	where r.id = registrationId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_relationship` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_relationship`(IN id BIGINT, relationshipJson VARCHAR(5000))
BEGIN
	DECLARE name VARCHAR(255);
    DECLARE gender VARCHAR(255);
    DECLARE employeeId BIGINT;
    DECLARE dateOfBirth DATE;
    DECLARE postcode VARCHAR(20);
    DECLARE relationship VARCHAR(100);
    DECLARE address VARCHAR(255);

    SET name = JSON_UNQUOTE(JSON_EXTRACT(relationshipJson, '$.name'));
    SET gender = JSON_UNQUOTE(JSON_EXTRACT(relationshipJson, '$.gender'));
    SET employeeId = JSON_UNQUOTE(JSON_EXTRACT(relationshipJson, '$.employeeId'));
    SET dateOfBirth = JSON_UNQUOTE(JSON_EXTRACT(relationshipJson, '$.dateOfBirth'));
    SET postcode = JSON_UNQUOTE(JSON_EXTRACT(relationshipJson, '$.postcode'));
	SET relationship = JSON_UNQUOTE(JSON_EXTRACT(relationshipJson, '$.relationship'));
	SET address = JSON_UNQUOTE(JSON_EXTRACT(relationshipJson, '$.address'));
    
    
    update relationship r
    set r.name = name,
		r.gender = gender,
        r.employee_id = employeeId,
        r.date_of_birth = dateOfBirth,
        r.postcode = postcode,
        r.relationship = relationship,
        r.address = address
	where r.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_salary_increment_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_salary_increment_by_id`(IN id BIGINT, salaryIncrementJson VARCHAR(5000))
BEGIN
	DECLARE employeeId BIGINT;
    declare leaderId BIGINT;
    DECLARE reason VARCHAR(200);
    DECLARE status VARCHAR(100);
    DECLARE salaryLevel VARCHAR(255);
    
    SET employeeId = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.employeeId'));
	SET leaderId = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.leaderId'));
    SET reason = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.reason'));
    SET status = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.status'));
    SET salaryLevel = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.salaryLevel'));
    
    update salary_increment s 
    set s.employee_id = employeeId,
		s.leader_id = leaderId,
		s.status = status,
		s.reason = reason,
        s.salary_level = salaryLevel
	where s.id = id;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_salary_increment_by_leader` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_salary_increment_by_leader`(IN id BIGINT, salaryIncrementJson VARCHAR(5000))
BEGIN
	DECLARE status VARCHAR(100);
	DECLARE rejectDate DATE;
    DECLARE rejectReason VARCHAR(255);
    DECLARE acceptDate DATE;
    DECLARE note VARCHAR(255);
    DECLARE additionalDate DATE;
    DECLARE additionalReason VARCHAR(255);
    
    
    SET status = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.status'));
    SET rejectDate = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.rejectDate'));
    SET rejectReason = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.rejectReason'));
    SET acceptDate = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.acceptDate'));
    SET note = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.note'));
    SET additionalDate = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.additionalDate'));
    SET additionalReason = JSON_UNQUOTE(JSON_EXTRACT(salaryIncrementJson, '$.additionalReason'));
    
    update salary_increment s 
    set s.status = status,
		s.reject_date = rejectDate,
        s.reject_reason = rejectReason,
        s.accept_date = acceptDate,
        s.note = note,
        s.additional_date = additionalDate,
        s.additional_reason = additionalReason
    where s.id = id;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-05 21:20:51
