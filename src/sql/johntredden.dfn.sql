DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `User_id` int unsigned NOT NULL auto_increment
  ,`User_status` ENUM('candidate1', 'candidate2', 'registered')
  ,`firstName` varchar(255) NOT NULL default ''
  ,`lastName` varchar(255) NOT NULL default ''
  ,`emailAddress` varchar(255) NOT NULL default ''
  ,`password` varchar(255)  NOT NULL default ''
  ,`Datestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  ,KEY `User_idKey` (`User_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

