
DROP DATABASE IF EXISTS bd_eventos;
CREATE DATABASE IF NOT EXISTS bd_eventos;

USE bd_eventos;


CREATE TABLE `expositor` (
  `codigo` varchar(20) NOT NULL,
  `id_expositor` varchar(20) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `cargo` varchar(400) NOT NULL,
  `empresa` varchar(50) NOT NULL,
  `resenia` text NOT NULL,
  `imagen` longblob,
  PRIMARY KEY (`id_expositor`)
);

INSERT INTO `expositor` VALUES ('1','1','Guillermo','Bouroncle Calixto','Gerente General','Autoridad Portuaria Nacional','Abogado por la Universidad Católica del Perú y Máster en Derecho Marítimo Internacional por el Instituto de Derecho Marítimo Internacional de la OMI en Malta.',NULL),('1','2','Luis','García Lumbreras','Jefe de la Unidad de Protección y Seguridad','Autoridad Portuaria Nacional','Es titulado como Oficial de Marina Mercante, con estudios de Maestría en la especialidad de “Administración Marítima Portuaria y de Pesca” y en “Gestión de Recursos Humanos y Calidad”, siguió un diplomado en Contrataciones de Asociación Publico Privado, con experiencia laboral a cargo de diferentes unidades y dependencias navales de la Marina de Guerra del Perú, también cuenta con experiencia en los cargos de Director de Capacitación, Asesor Académico e Instructor de Cursos OMI de la Escuela Nacional de Marina Mercante y desde el año 2016 forma parte de la Autoridad Portuaria Nacional y actualmente ocupa el cargo de Jefe de la Unidad de Protección y Seguridad (UPS), asimismo se desempeñó como docente de la facultad de ingeniería marítima de la Universidad Tecnológica del Perú.',NULL);


CREATE TABLE `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(300) DEFAULT NULL,
  `direccion` varchar(300) DEFAULT NULL,
  `estrellas` varchar(300) DEFAULT NULL,
  `phone` varchar(300) DEFAULT NULL,
  `web` varchar(300) DEFAULT NULL,
  `latitud` double DEFAULT NULL,
  `longitud` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `hotel` VALUES (1,'5 estrellas','av las begonias','5','98789789','www.5estrellas.com',-6.799661253359545,-79.60031732448572);



CREATE TABLE `agenda` (
  `id_agenda` varchar(20) NOT NULL,
  `tema` varchar(100) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `id_expositor` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_agenda`),
  KEY `id_expositor` (`id_expositor`),
  CONSTRAINT `agenda_ibfk_1` FOREIGN KEY (`id_expositor`) REFERENCES `expositor` (`id_expositor`)
);

CREATE TABLE `lugarturistico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(300) DEFAULT NULL,
  `resenia` varchar(300) DEFAULT NULL,
  `latitud` double DEFAULT NULL,
  `longitud` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO `lugarturistico` VALUES (1,'Mueso de Sipan','Ubicado en cusco',-6.799661253359545,-79.60031732448572);




