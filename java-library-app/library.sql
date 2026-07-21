-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: librarydb
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `author` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_book_category_idx` (`category_id`),
  CONSTRAINT `fk_book_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Lập Trình JavaFX','Phạm Văn A',150000,1),(2,'Thiết Kế Mẫu Design Patterns','Nguyễn Văn B',180000,1),(3,'Dế Mèn Phiêu Lưu Ký','Tô Hoài',50000,2),(4,'Đắc Nhân Tâm','Dale Carnegie',120000,4),(5,'Nhà Giả Kim','Paulo Coelho',89000,2),(6,'Clean Code - Mã Sạch','Robert C. Martin',215000,1),(7,'Tư Duy Nhanh Và Chậm','Daniel Kahneman',190000,4),(8,'Sapiens - Lược Sử Loài Người','Yuval Noah Harari',230000,5),(9,'Cha Giàu Cha Nghèo','Robert Kiyosaki',110000,3),(10,'Cấu Trúc Dữ Liệu Và Giải Thuật','Trần Nhất Lý',165000,1),(11,'Tuổi Trẻ Đáng Giá Bao Nhiêu','Rosie Nguyễn',95000,4),(12,'Kinh Tế Học Hài Hước','Steven Levitt',140000,3),(13,'Mắt Biếc','Nguyễn Nhật Ánh',115000,2);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow_card`
--

DROP TABLE IF EXISTS `borrow_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `borrow_card` (
  `id` int NOT NULL AUTO_INCREMENT,
  `member_name` varchar(100) DEFAULT NULL,
  `borrow_date` datetime NOT NULL,
  `total_fee` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow_card`
--

LOCK TABLES `borrow_card` WRITE;
/*!40000 ALTER TABLE `borrow_card` DISABLE KEYS */;
INSERT INTO `borrow_card` VALUES (1,'Huy Phúc','2026-07-21 00:01:48',525000),(2,'Phạm Ngọc Huy Phúc','2026-07-21 00:07:14',10220000),(3,'Phạm Ngọc Huy Phúc','2026-07-21 00:08:51',1021999.9999999999);
/*!40000 ALTER TABLE `borrow_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Lập trình & Công nghệ'),(2,'Văn học & Nghệ thuật'),(3,'Kinh Tế & Quản Lý'),(4,'Kỹ Năng Sống'),(5,'Lịch Sử & Khoa Học');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-07-21 12:13:27
