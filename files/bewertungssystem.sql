-- Adminer 4.6.2 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP DATABASE IF EXISTS `bewertungssystem`;
CREATE DATABASE `bewertungssystem` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `bewertungssystem`;

DROP TABLE IF EXISTS `aktivitaeten`;
CREATE TABLE `aktivitaeten` (
  `NameID` int(11) NOT NULL AUTO_INCREMENT,
  `Aktivitaet` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`NameID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

TRUNCATE `aktivitaeten`;
INSERT INTO `aktivitaeten` (`NameID`, `Aktivitaet`) VALUES
(1,	'gut'),
(2,	'schlecht'),
(3,	'extras');

DROP TABLE IF EXISTS `angenehmeaktivitaeten`;
CREATE TABLE `angenehmeaktivitaeten` (
  `AngenehmeID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `PlusPunktenZahl` int(11) NOT NULL,
  PRIMARY KEY (`AngenehmeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

TRUNCATE `angenehmeaktivitaeten`;
INSERT INTO `angenehmeaktivitaeten` (`AngenehmeID`, `Name`, `PlusPunktenZahl`) VALUES
(1,	'eine Umarmung',	15),
(2,	'höflich sein',	5),
(3,	'Aufräumen',	5),
(4,	'Wäsche aufhängen',	7),
(5,	'Müll rausbringen',	3);

DROP TABLE IF EXISTS `extras`;
CREATE TABLE `extras` (
  `ExtrasID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `HabenFürPunkte` int(11) NOT NULL,
  `DanachAbziehenPunkte` int(11) NOT NULL,
  PRIMARY KEY (`ExtrasID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

TRUNCATE `extras`;
INSERT INTO `extras` (`ExtrasID`, `Name`, `HabenFürPunkte`, `DanachAbziehenPunkte`) VALUES
(1,	'ins Kino gehen',	30,	15),
(2,	'5 Euro mehr Taschengeld',	15,	10),
(3,	'7 Euro mehr Taschengeld',	20,	10),
(4,	'8 Euro mehr Taschengeld',	25,	10),
(5,	'bei Freund/Freundin übernachten',	20,	10),
(6,	'etwas schönes neues kaufen',	15,	10);

DROP TABLE IF EXISTS `kindangenehmeaktivitaet`;
CREATE TABLE `kindangenehmeaktivitaet` (
  `EintragsDatum` date NOT NULL,
  `KindNR` int(11) NOT NULL,
  `AngenehmeAktivitaetNR` int(11) NOT NULL,
  KEY `FK_KindAngenehmeAktivitaet_AngenehmeAktivitaeten` (`AngenehmeAktivitaetNR`),
  KEY `FK_KindAngenehmeAktivitaet_Kinder` (`KindNR`),
  CONSTRAINT `FK_KindAngenehmeAktivitaet_AngenehmeAktivitaeten` FOREIGN KEY (`AngenehmeAktivitaetNR`) REFERENCES `angenehmeaktivitaeten` (`AngenehmeID`),
  CONSTRAINT `FK_KindAngenehmeAktivitaet_Kinder` FOREIGN KEY (`KindNR`) REFERENCES `kinder` (`KindID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

TRUNCATE `kindangenehmeaktivitaet`;
INSERT INTO `kindangenehmeaktivitaet` (`EintragsDatum`, `KindNR`, `AngenehmeAktivitaetNR`) VALUES
('2018-01-21',	1,	1),
('2018-01-22',	4,	3),
('2018-01-22',	2,	2),
('2018-01-23',	3,	4),
('2018-01-25',	5,	4),
('2018-01-26',	4,	5),
('2018-01-26',	1,	2),
('2018-01-27',	1,	1),
('2018-01-28',	1,	3),
('2018-01-29',	1,	1),
('2018-01-29',	1,	4),
('2018-01-30',	1,	1),
('2018-02-01',	1,	1),
('2018-03-15',	2,	5),
('2018-04-05',	5,	4),
('2018-04-06',	4,	2),
('2018-04-01',	3,	5),
('2018-03-08',	5,	1),
('2018-04-03',	2,	4),
('2018-04-01',	2,	4),
('2018-03-03',	5,	3),
('2018-02-02',	5,	2),
('2018-02-03',	5,	5),
('2018-03-05',	5,	1),
('2018-04-03',	2,	1),
('2018-02-09',	2,	5),
('2018-03-12',	3,	4),
('2018-03-05',	5,	4),
('2018-03-02',	5,	1),
('2018-04-01',	5,	1),
('2018-03-07',	2,	1),
('2018-04-08',	5,	3),
('2018-03-02',	4,	4),
('2018-02-01',	6,	4),
('2018-02-02',	6,	3),
('2018-04-02',	4,	2),
('2018-04-03',	3,	4),
('2018-04-08',	5,	3),
('2018-03-04',	6,	2);

DROP TABLE IF EXISTS `kinder`;
CREATE TABLE `kinder` (
  `KindID` int(11) NOT NULL AUTO_INCREMENT,
  `AlterKindes` int(11) NOT NULL,
  `PunktenStart` int(11) NOT NULL,
  PRIMARY KEY (`KindID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

TRUNCATE `kinder`;
INSERT INTO `kinder` (`KindID`, `AlterKindes`, `PunktenStart`) VALUES
(1,	10,	25),
(2,	11,	20),
(3,	12,	15),
(4,	13,	10),
(5,	14,	6),
(6,	15,	3);

DROP TABLE IF EXISTS `kindextras`;
CREATE TABLE `kindextras` (
  `EintragsDatum` date NOT NULL,
  `KindNR` int(11) NOT NULL,
  `ExtrasNR` int(11) NOT NULL,
  KEY `FK_KindExtras_Extras` (`ExtrasNR`),
  KEY `FK_KindExtras_Kinder` (`KindNR`),
  CONSTRAINT `FK_KindExtras_Extras` FOREIGN KEY (`ExtrasNR`) REFERENCES `extras` (`ExtrasID`),
  CONSTRAINT `FK_KindExtras_Kinder` FOREIGN KEY (`KindNR`) REFERENCES `kinder` (`KindID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

TRUNCATE `kindextras`;
INSERT INTO `kindextras` (`EintragsDatum`, `KindNR`, `ExtrasNR`) VALUES
('2018-03-01',	1,	1),
('2018-03-16',	5,	4);

DROP TABLE IF EXISTS `kindunangenehmeaktivitaet`;
CREATE TABLE `kindunangenehmeaktivitaet` (
  `EintragsDatum` date NOT NULL,
  `KindNR` int(11) NOT NULL,
  `UnangenehmeAktivitaetNR` int(11) NOT NULL,
  KEY `FK_KindUnangenehmeAktivitaet_Kinder` (`KindNR`),
  KEY `FK_KindUnangenehmeAktivitaet_UnangenehmeAktivitaeten` (`UnangenehmeAktivitaetNR`),
  CONSTRAINT `FK_KindUnangenehmeAktivitaet_Kinder` FOREIGN KEY (`KindNR`) REFERENCES `kinder` (`KindID`),
  CONSTRAINT `FK_KindUnangenehmeAktivitaet_UnangenehmeAktivitaeten` FOREIGN KEY (`UnangenehmeAktivitaetNR`) REFERENCES `unangenehmeaktivitaeten` (`UnangenehmeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

TRUNCATE `kindunangenehmeaktivitaet`;
INSERT INTO `kindunangenehmeaktivitaet` (`EintragsDatum`, `KindNR`, `UnangenehmeAktivitaetNR`) VALUES
('2018-01-11',	1,	1),
('2018-01-15',	5,	7),
('2018-01-16',	2,	2),
('2018-01-18',	3,	6),
('2018-01-20',	2,	4),
('2018-01-25',	4,	5),
('2018-01-26',	1,	1),
('2018-01-27',	2,	3);

DROP TABLE IF EXISTS `unangenehmeaktivitaeten`;
CREATE TABLE `unangenehmeaktivitaeten` (
  `UnangenehmeID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `MinusPunktenZahl` int(11) NOT NULL,
  PRIMARY KEY (`UnangenehmeID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

TRUNCATE `unangenehmeaktivitaeten`;
INSERT INTO `unangenehmeaktivitaeten` (`UnangenehmeID`, `Name`, `MinusPunktenZahl`) VALUES
(1,	'frech sein',	3),
(2,	'Lügen erzählen',	3),
(3,	'am Esstisch stören',	5),
(4,	'eine Hausaufgabe vergessen',	7),
(5,	'Unpünktlichkeit',	6),
(6,	'Geschwister ärgern',	5),
(7,	'einen Wutanfall bekommen',	6);

-- 2018-04-19 07:34:25
