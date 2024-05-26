-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: code_fulcrum
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` char(15) NOT NULL,
  `name` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `quantity` int NOT NULL,
  `definition` json DEFAULT NULL,
  `createdAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `product_chk_1` CHECK (regexp_like(`name`,_utf8mb4'^[a-zA-Z_]+$'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('06f9825f-1b50-1','TootPaste','cusmetics',15,'{\"price\": 349.99, \"expiry_date\": 1711324800000, \"manufacturing_date\": 1643068800000}','2024-05-26 11:06:40','2024-05-26 11:06:40'),('0dfc7fb8-1b51-1','Face_Washkkk','cusmetics',15,'{\"price\": 349.99, \"expiry_date\": 1711324800000, \"manufacturing_date\": 1643068800000}','2024-05-26 11:14:01','2024-05-26 11:14:01'),('1a618c5d-1b50-1','lotion','cusmetics',15,'{\"price\": 3349.99, \"expiry_date\": 1711324800000, \"manufacturing_date\": 1643068800000}','2024-05-26 11:07:12','2024-05-26 11:08:27'),('5cb0ef0c-1b4f-1','Key_Ring_Royal','Accessories',25,'{\"price\": 549.99, \"expiry_date\": 1732492800000, \"manufacturing_date\": 1679702400000}','2024-05-26 11:01:54','2024-05-26 11:01:54'),('a7374421-1b4f-1','Key_Ring_kids','Accessories',25,'{\"price\": 1549.99, \"expiry_date\": 1721865600000, \"manufacturing_date\": 1679702400000}','2024-05-26 11:03:59','2024-05-26 11:03:59'),('ab1a6574-1b50-1','Face_Wash','cusmetics',15,'{\"price\": 349.99, \"expiry_date\": 1711324800000, \"manufacturing_date\": 1643068800000}','2024-05-26 11:11:15','2024-05-26 11:11:15'),('b307b241-1b4f-1','Key_Ring_Car','Accessories',15,'{\"price\": 3549.99, \"expiry_date\": 1721865600000, \"manufacturing_date\": 1679702400000}','2024-05-26 11:04:19','2024-05-26 11:04:19'),('b86f305a-1b50-1','Soap','cusmetics',15,'{\"price\": 349.99, \"expiry_date\": 1711324800000, \"manufacturing_date\": 1643068800000}','2024-05-26 11:11:37','2024-05-26 11:13:19'),('ce894190-1b4f-1','Tv','Electronics',15,'{\"price\": 113549.99, \"expiry_date\": 1721865600000, \"manufacturing_date\": 1679702400000}','2024-05-26 11:05:05','2024-05-26 11:05:05'),('e06642c7-1b4f-1','Laptop','Electronics',15,'{\"price\": 313549.99, \"expiry_date\": 1711324800000, \"manufacturing_date\": 1674604800000}','2024-05-26 11:05:35','2024-05-26 11:05:35'),('fe2bc91f-1b4f-1','Sun_Screen','cusmetics',15,'{\"price\": 549.99, \"expiry_date\": 1711324800000, \"manufacturing_date\": 1643068800000}','2024-05-26 11:06:25','2024-05-26 11:06:25');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-26 16:22:11
