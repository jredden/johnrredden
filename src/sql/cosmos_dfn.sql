-- MySQL dump 10.13  Distrib 5.1.41, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: cosmos
-- ------------------------------------------------------
-- Server version	5.1.41-3ubuntu12.10

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
-- Table structure for table `ClusterRep`
--

DROP TABLE IF EXISTS `ClusterRep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ClusterRep` (
  `clusterRepId` int unsigned NOT NULL auto_increment,
  `systemId` int unsigned NOT NULL,
  `clusterName` varchar(255),
  `distance_sys_virt_centre` double DEFAULT NULL,
  `angle_in_radians` double DEFAULT NULL,
  `cluster_description` ENUM (
  'SINGLESTAR'
  , 'DOUBLESTAR_BINARY'
  , 'DOUBLESTAR_SPREAD'
  , 'THREESTAR_TRINARY'
  , 'THREESTAR_BINARYPLUSONE'
  , 'THREESTAR_SPREAD'
  , 'FOURSTAR_TRINARYPLUSONE'
  , 'FOURSTAR_TWOBINARIES'
  , 'FOURSTAR_SPREAD'
  , 'FIVESTAR_FOURSTARSPREADPLUSONE'
  , 'FIVESTAR_SPREAD'
  , 'CLUSTER_N'
  ) DEFAULT NULL,
  `Datestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`clusterRepId`),
  KEY `clusterrep_system_id` (`SystemId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Planetoid`
--

DROP TABLE IF EXISTS `Planetoid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Planetoid` (
  `planetoidId` int unsigned NOT NULL auto_increment,
  `repId` int unsigned NULL,
  `planetoidName` varchar(255),
  `Radius` double NOT NULL,
  `DistanceToPrimary` double NOT NULL,
  `Degree` double NOT NULL,
  `Temperature` double NOT NULL,
  `PercentWater` double DEFAULT NULL,
  `Datestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`planetoidId`),
  KEY `rep_id` (`repId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PlanetoidAtmosphere`
--

DROP TABLE IF EXISTS `Atmosphere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Atmosphere` (
  `atmosphereId` int unsigned NOT NULL auto_increment,
  `planetoidId` int unsigned NOT NULL,
  `chem_name` varchar(64) NOT NULL,
  `percentage` double NOT NULL,
  `datestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`atmosphereId`),
  KEY `atmosphere_planetoid_id` (`planetoidId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PlanetoidRep`
--

DROP TABLE IF EXISTS `PlanetoidRep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PlanetoidRep` (
  `planetoidrepId` int unsigned NOT NULL auto_increment,
  `domain` ENUM('cluster', 'star', 'planetoid'),
  `ownerId` int unsigned NOT NULL,
  `planetoidId` int unsigned NULL,
  `Datestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`planetoidrepId`),
  KEY `owner_id` (`ownerId`),
  KEY `planetoid_id` (`planetoidId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table ClusterToStar
--
-- sub clusters describe possible configurations for stars
-- that have planetoids.  Planetoids can be "rogue" with an 
-- irregular orbit around a cluster of stars and be "owned" by
-- the cluster.
--

DROP TABLE IF EXISTS `ClusterToStar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ClusterToStar` (
  `clusterToStarId` int unsigned NOT NULL auto_increment, 
  `clusterRepId` int NOT NULL,
  `sub_cluster_description` ENUM(
    'SINGLESTAR'
  , 'DOUBLESTAR_BINARY_0'
  , 'DOUBLESTAR_BINARY_1'
  , 'THREESTAR_TRINARY_0'
  , 'THREESTAR_TRINARY_1'
  , 'THREESTAR_TRINARY_2'
  , 'THREESTAR_BINARYPLUSONE_2'
  , 'THREESTAR_BINARYPLUSONE_BINARY_0'  
  , 'THREESTAR_BINARYPLUSONE_BINARY_1'  
  , 'FOURSTAR_TRINARYPLUSONE_1'
  , 'FOURSTAR_TRINARYPLUSONE_TRINARY_0'
  , 'FOURSTAR_TRINARYPLUSONE_TRINARY_1'
  , 'FOURSTAR_TRINARYPLUSONE_TRINARY_2'
  , 'FOURSTAR_2BINARIES_0_BINARY_0'
  , 'FOURSTAR_2BINARIES_1_BINARY_0'
  , 'FOURSTAR_2BINARIES_0_BINARY_1'
  , 'FOURSTAR_2BINARIES_1_BINARY_1'
  , 'FIVESTAR_FOURSTARSPREADPLUSONE'
  , 'FIVESTAR_FOURSTARSPREADPLUSONE_1'
  , 'NONE'
  ) DEFAULT NULL,
  `Datestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`clusterToStarId`),
  KEY `cluster_to_star_clusterRepId` (`clusterRepId`),
  KEY `cluster_to_star_starId` (`clusterToStarId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Star`
--

DROP TABLE IF EXISTS `Star`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Star` (
  `starId` int unsigned NOT NULL auto_increment,
  `clusterToStarId` int unsigned NOT NULL,
  `Name` varchar(255),
  `distance_clust_virt_centre` double DEFAULT NULL,
  `luminosity` double DEFAULT NULL,
  `no_planets_allowed` char(1) DEFAULT NULL,
  `angle_in_radians_s` double DEFAULT NULL,
  `star_color` varchar(40) DEFAULT NULL,
  `star_type` varchar(40) DEFAULT NULL,
  `star_size` double DEFAULT NULL,
  `Datestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`starId`),
  KEY `cluster_to_star_id` (`clusterToStarId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SystemRep`
--

DROP TABLE IF EXISTS `System`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `System` (
  `SystemId` int unsigned NOT NULL auto_increment,
  `distance_to_galaxy_centre` double DEFAULT NULL,
  `ucoordinate` double DEFAULT NULL,
  `vcoordinate` double DEFAULT NULL,
  `systemName` varchar(255) DEFAULT NULL,
  `Datestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY `system_id` (`SystemId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-02-09  9:18:01
