CREATE DATABASE IF NOT EXISTS `springboot`;

USE `springboot`;

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
    `id` varchar(100) NOT NULL,
    `title` varchar(100) NOT NULL,
    `abstraction` varchar(100) NOT NULL,
    `language` varchar(100) NOT NULL,
    `publication_date` date NOT NULL,
    `author` varchar(100) NOT NULL,
    `topics` varchar(100) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8;


