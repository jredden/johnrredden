DROP TABLE IF EXISTS `Rename`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Rename`(
`renameId` int unsigned NOT NULL auto_increment,
`objectId` int unsigned NOT NULL,
`objectType` ENUM (
	'PLANETOID',
	'STAR',
	'CLUSTER'
) DEFAULT NULL,
`genericName` varchar(255) NOT NULL,
`renameName` varchar(255) NOT NULL,
`renameCount` int NOT NULL,
`datestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`renameId`),
KEY `object_id` (`objectId`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
