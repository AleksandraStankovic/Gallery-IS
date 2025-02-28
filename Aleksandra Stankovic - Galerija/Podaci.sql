-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: projektni_zadatak
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
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,'Leonadro','Da Vinci','0000'),(11,'Frida','Kahlo','1111'),(22,'Klod','Mone','2222');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `dobavljac`
--

LOCK TABLES `dobavljac` WRITE;
/*!40000 ALTER TABLE `dobavljac` DISABLE KEYS */;
INSERT INTO `dobavljac` VALUES (1,'Patre 4','Skulptor','1234');
/*!40000 ALTER TABLE `dobavljac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `individualac`
--

LOCK TABLES `individualac` WRITE;
/*!40000 ALTER TABLE `individualac` DISABLE KEYS */;
INSERT INTO `individualac` VALUES ('Pero ','Peric',1),('Jovo ','Jovic',2);
/*!40000 ALTER TABLE `individualac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `inventar`
--

LOCK TABLES `inventar` WRITE;
/*!40000 ALTER TABLE `inventar` DISABLE KEYS */;
INSERT INTO `inventar` VALUES (1,20,12),(1,50,45),(1,10,106);
/*!40000 ALTER TABLE `inventar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `kategorija`
--

LOCK TABLES `kategorija` WRITE;
/*!40000 ALTER TABLE `kategorija` DISABLE KEYS */;
INSERT INTO `kategorija` VALUES (1,'Cetkica'),(2,'Platno'),(3,'Slika');
/*!40000 ALTER TABLE `kategorija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `klijent`
--

LOCK TABLES `klijent` WRITE;
/*!40000 ALTER TABLE `klijent` DISABLE KEYS */;
INSERT INTO `klijent` VALUES (1,'Patre 2','12345'),(2,'Patre 3','24856');
/*!40000 ALTER TABLE `klijent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `nabavka`
--

LOCK TABLES `nabavka` WRITE;
/*!40000 ALTER TABLE `nabavka` DISABLE KEYS */;
INSERT INTO `nabavka` VALUES (1,'2001-01-01',1,1,1),(2,'2001-01-01',1,1,1),(11,'2001-01-01',1,1,1);
/*!40000 ALTER TABLE `nabavka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `nabavka_stavka`
--

LOCK TABLES `nabavka_stavka` WRITE;
/*!40000 ALTER TABLE `nabavka_stavka` DISABLE KEYS */;
INSERT INTO `nabavka_stavka` VALUES (11,12,1,1.00),(11,45,4,1.00);
/*!40000 ALTER TABLE `nabavka_stavka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `narudzba`
--

LOCK TABLES `narudzba` WRITE;
/*!40000 ALTER TABLE `narudzba` DISABLE KEYS */;
INSERT INTO `narudzba` VALUES (1,'2001-01-01 00:00:00',1,1,1);
/*!40000 ALTER TABLE `narudzba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `narudzba_stavka`
--

LOCK TABLES `narudzba_stavka` WRITE;
/*!40000 ALTER TABLE `narudzba_stavka` DISABLE KEYS */;
INSERT INTO `narudzba_stavka` VALUES (1,34,1,1);
/*!40000 ALTER TABLE `narudzba_stavka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `poslovnica`
--

LOCK TABLES `poslovnica` WRITE;
/*!40000 ALTER TABLE `poslovnica` DISABLE KEYS */;
INSERT INTO `poslovnica` VALUES (1,'Patre 1','12345'),(2,'Patre 10','23456');
/*!40000 ALTER TABLE `poslovnica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `proizvod`
--

LOCK TABLES `proizvod` WRITE;
/*!40000 ALTER TABLE `proizvod` DISABLE KEYS */;
INSERT INTO `proizvod` VALUES (1,3,'Slika6',4500.00),(2,3,'Slika2',450.00),(3,3,'Slika3',800.00),(4,3,'Slika4',500.00),(12,2,'Platno 10x10cm',5.00),(45,1,'Cetkica 106',4.00),(101,3,'Slika7',230.00),(102,3,'Slika8',250.00),(105,3,'Slika10',800.00),(106,2,'Platno 20x30cm',8.00),(108,3,'Slika20',25.00);
/*!40000 ALTER TABLE `proizvod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `racun`
--

LOCK TABLES `racun` WRITE;
/*!40000 ALTER TABLE `racun` DISABLE KEYS */;
INSERT INTO `racun` VALUES (1,'2001-01-01 12:00:00',1,293.00),(2,'2001-01-01 12:00:00',1,293.00),(4,'2001-02-02 00:00:00',2,293.00),(9,'2024-09-21 17:38:40',2,101.00);
/*!40000 ALTER TABLE `racun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `racun_stavka`
--

LOCK TABLES `racun_stavka` WRITE;
/*!40000 ALTER TABLE `racun_stavka` DISABLE KEYS */;
INSERT INTO `racun_stavka` VALUES (1,2,2,90.00),(1,3,2,90.00),(1,4,1,5.00),(2,2,2,90.00),(4,2,1,1.00),(9,1,3,13701.00);
/*!40000 ALTER TABLE `racun_stavka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sertifikat`
--

LOCK TABLES `sertifikat` WRITE;
/*!40000 ALTER TABLE `sertifikat` DISABLE KEYS */;
INSERT INTO `sertifikat` VALUES (2,'2023-01-01',1,1,1,1),(3,'2024-02-02',2,1,2,1),(4,'2024-09-21',1,1,3,1);
/*!40000 ALTER TABLE `sertifikat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `slika`
--

LOCK TABLES `slika` WRITE;
/*!40000 ALTER TABLE `slika` DISABLE KEYS */;
INSERT INTO `slika` VALUES ('Mona Liza',1,1),('Tajna Veceras',1,2),('Vitruvijanski covjek',1,3),('Lokvanji',22,4),('Dvije Fride',11,101),('Impresija - Izlazak sunca',22,102);
/*!40000 ALTER TABLE `slika` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `status_narudzbe`
--

LOCK TABLES `status_narudzbe` WRITE;
/*!40000 ALTER TABLE `status_narudzbe` DISABLE KEYS */;
INSERT INTO `status_narudzbe` VALUES (1,'Dostavljeno'),(2,'U toku');
/*!40000 ALTER TABLE `status_narudzbe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ustanova`
--

LOCK TABLES `ustanova` WRITE;
/*!40000 ALTER TABLE `ustanova` DISABLE KEYS */;
INSERT INTO `ustanova` VALUES ('ETFBL',2);
/*!40000 ALTER TABLE `ustanova` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `zaposleni`
--

LOCK TABLES `zaposleni` WRITE;
/*!40000 ALTER TABLE `zaposleni` DISABLE KEYS */;
INSERT INTO `zaposleni` VALUES (1,'Marko','Markovic','26538'),(2,'Jovana','Jovic','12345');
/*!40000 ALTER TABLE `zaposleni` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-22 20:22:40
