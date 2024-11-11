# Host: localhost  (Version 5.5.5-10.4.32-MariaDB)
# Date: 2024-11-11 14:57:58
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "producto"
#

DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `promocion` varchar(10) DEFAULT NULL,
  `categoria` enum('componentes','sensores') NOT NULL,
  `estado` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

#
# Data for table "producto"
#

INSERT INTO `producto` VALUES (1,'Resistencia ',0.50,100,'img1.jpg','','componentes',1),(2,'Condensador',0.80,50,'img2.jpg','','componentes',1),(3,'Transistor ',1.20,200,'img3.jpg','nuevo','componentes',1),(4,'Diodo ',0.30,500,'img4.jpg','','componentes',1),(5,'LED Rojo ',0.15,1000,'img7.jpg','','componentes',1),(6,'Sensor de temp.',2.50,80,'img5.jpg','','sensores',1),(7,'Sensor ultrasón.',3.50,40,'img6.jpg','nuevo','sensores',1),(8,'Sensor de gas',4.00,70,'img8.jpg','','sensores',1),(9,'Sensor de luz',0.75,300,'img9.jpg','','sensores',1),(10,'Sensor de mov.',5.00,60,'img10.jpg','','sensores',1);

#
# Structure for table "usuario"
#

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidoPat` varchar(45) DEFAULT NULL,
  `apellidoMat` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `estado` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

#
# Data for table "usuario"
#

INSERT INTO `usuario` VALUES (9,'incos','incos','PAOLA','SANDOVAL','QUIROGA','Galindo','3164916',1),(10,'roy','roy123','roy','izquierdo ','malori','zona sud','66668788',1),(11,'pame','pame','Pame','sant','Quisp','Galindo','9876419',1),(12,'pamela','pamela','pamela','santos','quispe','Blan','86578',1),(13,'roy','roy','roy','izquierdo','malori','1ro de mayo','60789012',1),(14,'roy','roy','roy','izquierdo','malori','1ro de mayo','60789012',1);

#
# Structure for table "pedido"
#

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT 0,
  `idusuario` int(11) DEFAULT NULL,
  `idproducto` int(11) DEFAULT NULL,
  `estado` int(11) NOT NULL DEFAULT 1,
  `nombreProducto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idusuario` (`idusuario`),
  KEY `idproducto` (`idproducto`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`id`),
  CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

#
# Data for table "pedido"
#

INSERT INTO `pedido` VALUES (1,0,13,NULL,1,'Diodo');
