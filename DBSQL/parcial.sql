-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: parcial
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `carrito`
--

DROP TABLE IF EXISTS `carrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrito` (
  `idCarrito` int NOT NULL AUTO_INCREMENT,
  `total` decimal(10,4) DEFAULT NULL,
  `dni` int NOT NULL,
  PRIMARY KEY (`idCarrito`),
  KEY `fk_carrito_usuario1_idx` (`dni`),
  CONSTRAINT `fk_carrito_usuario1` FOREIGN KEY (`dni`) REFERENCES `usuario` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito`
--

LOCK TABLES `carrito` WRITE;
/*!40000 ALTER TABLE `carrito` DISABLE KEYS */;
INSERT INTO `carrito` VALUES (1,NULL,65649826),(2,NULL,85232545),(5,NULL,89658236),(6,NULL,89658236),(7,NULL,12345782),(8,NULL,12345782),(9,NULL,0),(10,NULL,12345782),(11,NULL,12345782),(12,NULL,12345782),(13,NULL,12345782),(14,196.0000,12345782);
/*!40000 ALTER TABLE `carrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestion`
--

DROP TABLE IF EXISTS `gestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gestion` (
  `idGestion` int NOT NULL,
  `codigoProducto` varchar(3) NOT NULL,
  `cantidad` int DEFAULT NULL,
  PRIMARY KEY (`idGestion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestion`
--

LOCK TABLES `gestion` WRITE;
/*!40000 ALTER TABLE `gestion` DISABLE KEYS */;
/*!40000 ALTER TABLE `gestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `idPago` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `tarjeta` bigint DEFAULT NULL,
  `idCarrito` int NOT NULL,
  `dni` int DEFAULT NULL,
  `idPedido` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPago`),
  KEY `fk_pago_carrito1_idx` (`idCarrito`),
  CONSTRAINT `fk_pago_carrito1` FOREIGN KEY (`idCarrito`) REFERENCES `carrito` (`idCarrito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `codigo` varchar(3) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `precioUnitario` decimal(10,4) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `foto1` mediumblob,
  `foto2` varchar(20000) DEFAULT NULL,
  `cantidadVendido` int DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES ('ABC','Manzana',25.0000,'Chilena jugosa',15,NULL,'data:image/jpeg;base64,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',NULL),('ARZ','Arroz',5.0000,'El arroz de siempre',30,NULL,'https://plazavea.vteximg.com.br/arquivos/ids/204511-450-450/433778.jpg?v=636773180862900000',NULL),('AVN','Avena',5.0000,'Comienza Bien',25,NULL,'https://www.pasosonline.com.ar/wp-content/uploads/2018/08/QAVENAINST.jpg',NULL),('CCL','Coca Cola',10.0000,'Muerte A Pepsi',10,NULL,'https://lh3.googleusercontent.com/proxy/Ew36ybJwoHmg_9v-itgOQgOiK8eYnXoVcuwkEZVJ4R_Q3TppfgUDzkU5C0pIBVSoYuIoMLfCgYK-MMlEnXpUOQw0aaEae-vCH0O2H7piydboAkDADqEnLoWFNCvpNq4ol_Bedfz5oqpGwprmwntWA5rrctXkS9zzx6tPOA',NULL),('CRZ','Chorizo',8.0000,'Parrillero y Jugoso',8,NULL,'https://cdn.lumingo.com/medias/0100532153-000000000004701814-0-c515Wx515H?context=bWFzdGVyfGltYWdlc3wzNzkwMHxpbWFnZS9qcGVnfGltYWdlcy9oM2MvaDI0LzkxNjI0MDg3ODc5OTguanBnfGZiMTMxNzBmYjAzZDI1YmZjY2JhYzBkNTlmM2E2NjZkZWMxMzliYTY2YjA3NTI5MjRlZWRlYTJiNzA0YmZhYjc',NULL),('DFC','Leche En Bolsa',23.0000,'Toma Tu Leche',25,NULL,'https://wongfood.vteximg.com.br/arquivos/ids/211986-750-750/24322-1.jpg?v=636562126407430000',NULL),('FDS','Fideos',15.0000,'Con esta pasta, te haces adicto',20,NULL,'https://vivanda.vteximg.com.br/arquivos/ids/166602-1000-1000/20098648.jpg?v=636137830951000000',NULL),('FRG','Frugos',5.0000,'De Durazno',10,NULL,'https://lh3.googleusercontent.com/proxy/EMWKSjMxOxVKyYmRTeDNcXoYJJu2VjDQxQH8EIjs_w2bB514yShpRo8S4BVRhutRevSev5hOACxkO2xuTchQC9M7g0TkR9D8mcRIy2Xe6u8jOd-Kd33vOtBObKBmYf5_qn4b',NULL),('HVS','Huevos',0.3000,'Los Huevos Del Peru',30,NULL,'https://s7d2.scene7.com/is/image/TottusPE/41530803?$S7Product$&wid=458&hei=458&op_sharpen=0',NULL),('LEP','Leche En Polvo',10.0000,'Un polvito maÃ±anero para el desayuno',5,NULL,'https://lacolonia.vteximg.com.br/arquivos/ids/189282-500-500/Abarrotes-Leches-en-Polvo-Suplementos-y-Modificadores-Leches-en-Polvo_088169030298_1.jpg?v=637122069026400000',NULL),('LJA','LejÃ­a',15.0000,'Limpia Todo',25,NULL,'https://promart.vteximg.com.br/arquivos/ids/323600-1000-1000/30310.jpg?v=636985603864900000',NULL),('PNT','Paneton',25.0000,'Cuanta Pasa Cuanta Fruta Que Delicia',25,NULL,'https://wstodinno.azurewebsites.net/theme_es//images/homeconfig/todinno_y%20toddinito.png',NULL),('PSC','Pepsi Cola',10.0000,'Muerte A Coca Cola',10,NULL,'https://metrocolombiafood.vteximg.com.br/arquivos/ids/157515-750-750/7702090022780-1.jpg?v=636670246657600000',NULL),('XCD','Mermelada',10.0000,'De piÃ±a casera',5,NULL,'https://lh3.googleusercontent.com/proxy/x_eYuBe5muFTwVmfATQ6ak4j25kRGSaxGsj3kusDNgatRhEKE3WT4KSWYZ6vr7q7ByWEP23W6_w3lI-LIILcLHul31-iHmwjBWjJVZcSRY3OSt6ENh3ZEgGE_GZ2vuo9zLBQZcH5q7TsO3hWhuV2z2P7Vm6LEwV458vjq6qSNm4',NULL);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productoxcarrito`
--

DROP TABLE IF EXISTS `productoxcarrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productoxcarrito` (
  `idProductoxCarrito` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(3) NOT NULL,
  `idCarrito` int NOT NULL,
  `cantidad` int DEFAULT NULL,
  `subtotal` decimal(10,4) DEFAULT NULL,
  PRIMARY KEY (`idProductoxCarrito`),
  KEY `fk_producto_has_carrito_carrito1_idx` (`idCarrito`),
  KEY `fk_productoxcarrito_producto1_idx` (`codigo`),
  CONSTRAINT `fk_producto_has_carrito_carrito1` FOREIGN KEY (`idCarrito`) REFERENCES `carrito` (`idCarrito`),
  CONSTRAINT `fk_productoxcarrito_producto1` FOREIGN KEY (`codigo`) REFERENCES `producto` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productoxcarrito`
--

LOCK TABLES `productoxcarrito` WRITE;
/*!40000 ALTER TABLE `productoxcarrito` DISABLE KEYS */;
INSERT INTO `productoxcarrito` VALUES (19,'ARZ',14,1,12.0000),(20,'LEP',14,1,52.0000),(21,'ABC',14,1,32.0000),(22,'CRZ',14,1,25.0000),(23,'ARZ',14,3,15.0000),(24,'ARZ',14,2,10.0000),(25,'ARZ',14,3,15.0000),(26,'ARZ',14,6,30.0000),(27,'ARZ',14,1,5.0000);
/*!40000 ALTER TABLE `productoxcarrito` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `quieroMiSubtotal` BEFORE INSERT ON `productoxcarrito` FOR EACH ROW BEGIN
		DECLARE precio DECIMAL(10,4);
		SELECT precioUnitario INTO precio FROM producto WHERE codigo = new.codigo ;
		SET new.subtotal = new.cantidad * precio;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `quieroMiTotal` AFTER INSERT ON `productoxcarrito` FOR EACH ROW BEGIN
		
        DECLARE finTotal DECIMAL(10,4);
        SELECT sum(subtotal) as finTotal INTO finTotal FROM productoxcarrito WHERE idCarrito = new.idCarrito;
		UPDATE carrito SET total=finTotal WHERE idCarrito= new.idCarrito;      
		END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idRol` int NOT NULL,
  `nombreRol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Admin'),(2,'Gestor'),(3,'Registrado');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spring_session`
--

DROP TABLE IF EXISTS `spring_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint NOT NULL,
  `LAST_ACCESS_TIME` bigint NOT NULL,
  `MAX_INACTIVE_INTERVAL` int NOT NULL,
  `EXPIRY_TIME` bigint NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spring_session`
--

LOCK TABLES `spring_session` WRITE;
/*!40000 ALTER TABLE `spring_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `spring_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spring_session_attributes`
--

DROP TABLE IF EXISTS `spring_session_attributes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`),
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spring_session_attributes`
--

LOCK TABLES `spring_session_attributes` WRITE;
/*!40000 ALTER TABLE `spring_session_attributes` DISABLE KEYS */;
/*!40000 ALTER TABLE `spring_session_attributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `dni` int NOT NULL,
  `idRol` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `password` varchar(1000) DEFAULT NULL,
  `activo` int DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `fk_usuario_rol1_idx` (`idRol`),
  CONSTRAINT `fk_usuario_rol1` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (12345782,3,'Sigmund ','Freud','freud@correo.com','$2y$12$Q5N5AE.23CpLE6ydFhl6ded./dGFma/7Ef67v8ljCZ.diSAN4dtjO',1),(16516581,2,'Michel ','Foucault','foucault@correo.com','$2y$12$Q5N5AE.23CpLE6ydFhl6ded./dGFma/7Ef67v8ljCZ.diSAN4dtjO',1),(25651652,2,'Friedrich ','Nietzsche','nietzsche@correo.com','$2y$12$Q5N5AE.23CpLE6ydFhl6ded./dGFma/7Ef67v8ljCZ.diSAN4dtjO',1),(32165552,3,'Edgar ','Duarte','eduarte@correo.com','$2y$12$Q5N5AE.23CpLE6ydFhl6ded./dGFma/7Ef67v8ljCZ.diSAN4dtjO',1),(32348526,3,'Patricia','Baena','pbaena@correo.com','$2y$12$Q5N5AE.23CpLE6ydFhl6ded./dGFma/7Ef67v8ljCZ.diSAN4dtjO',1),(35795214,3,'Paola ','Marin','pmarin@correo.com','$2y$12$Q5N5AE.23CpLE6ydFhl6ded./dGFma/7Ef67v8ljCZ.diSAN4dtjO',1),(52584256,1,'Pepe','Mujica','admin@correo.com','$2y$12$Q5N5AE.23CpLE6ydFhl6ded./dGFma/7Ef67v8ljCZ.diSAN4dtjO',1),(56154815,2,'Jacques','Lacan','lacan@correo.com','$2y$12$Q5N5AE.23CpLE6ydFhl6ded./dGFma/7Ef67v8ljCZ.diSAN4dtjO',1),(56265265,3,'Marius ','Tortosa','mtortosa@correo.com','$2y$12$Q5N5AE.23CpLE6ydFhl6ded./dGFma/7Ef67v8ljCZ.diSAN4dtjO',1),(65649826,3,'Manuel ','Rio','mrio@correo.com','$2y$12$Q5N5AE.23CpLE6ydFhl6ded./dGFma/7Ef67v8ljCZ.diSAN4dtjO',1),(78524158,2,'Juanito','AlimaÃ±a','gestor@correo.com','$2y$12$Q5N5AE.23CpLE6ydFhl6ded./dGFma/7Ef67v8ljCZ.diSAN4dtjO',1),(85232545,3,'Estefania ','Lora','elora@correo.com','$2y$12$Q5N5AE.23CpLE6ydFhl6ded./dGFma/7Ef67v8ljCZ.diSAN4dtjO',1),(89658236,3,'Rosa','Rosita','registrado@correo.com','$2y$12$Q5N5AE.23CpLE6ydFhl6ded./dGFma/7Ef67v8ljCZ.diSAN4dtjO',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'parcial'
--
/*!50003 DROP PROCEDURE IF EXISTS `guardarRegistrados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `guardarRegistrados`(IN dni int, IN  nombre varchar(45), IN apellido varchar(45), IN correo varchar(45), IN password varchar(1000) )
BEGIN 
INSERT INTO `parcial`.`usuario` (`dni`, `idRol`, `nombre`, `apellido`, `correo`, `password`, `activo`) VALUES (dni, '3', nombre, apellido, correo, password,'1');
SELECT * FROM usuario;
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

-- Dump completed on 2020-06-04 19:36:58
