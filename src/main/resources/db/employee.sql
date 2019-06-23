CREATE DATABASE IF NOT EXISTS `springboot`;

USE `springboot`;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
    `id` varchar(100) NOT NULL,
    `name` varchar(100) NOT NULL,
    `location` varchar(100) NOT NULL,
    `role` varchar(100) NOT NULL,
    `department` varchar(100) NOT NULL,
    `interests` varchar(500) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8;


