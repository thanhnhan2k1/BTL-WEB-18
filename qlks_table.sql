-- create database QLKS;

--
-- Table structure for table `room_hotel`
--

DROP TABLE IF EXISTS `room_hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_hotel` (
  `code` int NOT NULL,
  `name` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `price` int NOT NULL,
  `room_img` varchar(2000) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `saleoff` float NOT NULL DEFAULT '0',
  `des` varchar(255),
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Table structure for table `user_hotel`
--

DROP TABLE IF EXISTS `user_hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_hotel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `role` int NOT NULL DEFAULT '1',
  `dob` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Table structure for table `cart`
--
DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `roomcode` int NOT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_details` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` int NOT NULL,
  `checkin` date DEFAULT NULL,
  `checkout` date DEFAULT NULL,
  `price` int NOT NULL,
  `saleoff` float NOT NULL,
  `userid` int NOT NULL,
  `create_at` date DEFAULT NULL,
  `roomid` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Table structure for table `stats`
-- 
DROP TABLE IF EXISTS `stats`;
CREATE TABLE `stats` (
  `id_room` int,
  `name_room` varchar(150),
  `revenue` long,
  PRIMARY KEY (`id_room`)
);
-- Trigger
SET SQL_SAFE_UPDATES = 0;

DELIMITER $$
CREATE TRIGGER room_update 
AFTER INSERT
ON room_hotel
for each row
BEGIN
	INSERT INTO stats(id_room, name_room, revenue)
	VALUES(new.code, new.name, 0);
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER revenue_update 
AFTER INSERT 
ON order_details 
for each row
BEGIN
	UPDATE stats 
    SET revenue = new.amount + revenue
    where id_room = NEW.roomid ;
END $$
DELIMITER ;