CREATE DATABASE  IF NOT EXISTS `zemoso`;
USE `zemoso`;



INSERT INTO `users` (`username`,`password`,`enabled`)
VALUES 
('john','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
('mary','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
('susan','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1);


DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  CONSTRAINT `username` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
);


INSERT INTO `authorities` 
VALUES 
('john','ROLE_ADMIN'),
('mary','ROLE_USER'),
('susan','ROLE_USER');

