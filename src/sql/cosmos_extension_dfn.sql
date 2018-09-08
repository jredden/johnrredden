-- MySQL dump 10.13  Distrib 5.1.41, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: cosmos
-- ------------------------------------------------------
-- Server version	5.1.41-3ubuntu12.10
-- used with libnoise

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
-- Table structure for table `PlanetoidExtension`
--

DROP TABLE IF EXISTS `PlanetoidExtension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PlanetoidExtension` (
`planetoidExtensionId` int unsigned NOT NULL auto_increment,
`planetoidId` int unsigned NOT NULL,
`planetoidName` varchar(255),
`texture` varchar(255),
`nightTexture` varchar(255),
`semiMajorAxis` double,
`eccentricity` double,
`colorR` double,
`colorG` double,
`colorB` double,
`specularTexture` varchar(255),
`specularPower` int,
`hazeColorR` double,
`hazeColorG` double,
`hazeColorB` double,
`hazeDensity` double,
`oblateness` double, 
`atmosphereHeight` int,
`atmosphereLowerR` double,
`atmosphereLowerG` double,
`atmosphereLowerB` double,
`atmosphereUpperR` double,
`atmosphereUpperG` double,
`atmosphereUpperB` double,
`atmosphereSkyR` double,
`atmosphereSkyG` double,
`atmosphereSkyB` double,
`cloudHeight` int,
`cloudSpeed` int,
`cloudMap` varchar(255),
`orbitPeriod` double,
`orbitSemiMajorAxis` double,
`orbitEccentricity` double,
`orbitInclination` double,
`orbitLongOfPeriCentre` double,
`orbitMeanLongitude` double,
`obliquity` double,
`rotationPeriod` double,
`albedo` double,
`planarClass` varchar(255),
`emmisive` tinyint,
`bumpMap` varchar(255),
`bumpHeight` double,
`specularColorR` double,
`specularColorG` double,
`specularColorB` double,
`Datestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`planetoidExtensionId`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `StarExtension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `StarExtension` (
`starExtensionId` int unsigned NOT NULL auto_increment,
`starId` int unsigned NOT NULL DEFAULT 0,
`starName` varchar(255),
`period` double,
`semiMajorAxis` double,
`eccentricity` double,
`ascendingNode` double,
`inclination` double,
`apparantMagnitude` double,
`Datestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 PRIMARY KEY (`starExtensionId`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

