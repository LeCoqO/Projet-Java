-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 04 mai 2022 à 19:08
-- Version du serveur :  10.4.13-MariaDB
-- Version de PHP : 7.3.21
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */
;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */
;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */
;
/*!40101 SET NAMES utf8mb4 */
;
--
-- Base de données : `projet_java`
--
-- --------------------------------------------------------
--
-- Structure de la table `appartement`
--
DROP TABLE IF EXISTS `appartement`;
CREATE TABLE IF NOT EXISTS `appartement` (
  `IdAppart` int(11) NOT NULL AUTO_INCREMENT,
  `CategorieAppart` varchar(50) COLLATE utf8_bin NOT NULL,
  `NumAppart` int(11) NOT NULL,
  `IdBatiment` int(11) NOT NULL,
  PRIMARY KEY (`IdAppart`),
  KEY `Appartement_Batiment_FK` (`IdBatiment`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin;
-- --------------------------------------------------------
--
-- Structure de la table `ass_campagne_locataire`
--
DROP TABLE IF EXISTS `ass_campagne_locataire`;
CREATE TABLE IF NOT EXISTS `ass_campagne_locataire` (
  `IdCampagne` int(11) NOT NULL,
  `IdLocataire` int(11) NOT NULL,
  PRIMARY KEY (`IdCampagne`, `IdLocataire`),
  KEY `CAMPAGNE_LOCATAIRE_Locataire_FK` (`IdLocataire`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin;
-- --------------------------------------------------------
--
-- Structure de la table `ass_campagne_partenaire`
--
DROP TABLE IF EXISTS `ass_campagne_partenaire`;
CREATE TABLE IF NOT EXISTS `ass_campagne_partenaire` (
  `IdCampagne` int(11) NOT NULL,
  `IdPartenaire` int(11) NOT NULL,
  PRIMARY KEY (`IdCampagne`, `IdPartenaire`),
  KEY `CAMPAGNE_PARTENAIRE_Partenaire_FK` (`IdPartenaire`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin;
-- --------------------------------------------------------
--
-- Structure de la table `ass_employe_campagne`
--
DROP TABLE IF EXISTS `ass_employe_campagne`;
CREATE TABLE IF NOT EXISTS `ass_employe_campagne` (
  `IdCampagne` int(11) NOT NULL,
  `IdEmploye` int(11) NOT NULL,
  `DroitCampagne` tinyint(1) NOT NULL,
  PRIMARY KEY (`IdCampagne`, `IdEmploye`),
  KEY `EMPLOYE_CAMPAGNE_Employe_FK` (`IdEmploye`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin;
-- --------------------------------------------------------
--
-- Structure de la table `batiment`
--
DROP TABLE IF EXISTS `batiment`;
CREATE TABLE IF NOT EXISTS `batiment` (
  `IdBatiment` int(11) NOT NULL AUTO_INCREMENT,
  `AdresseBatiment` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`IdBatiment`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin;
-- --------------------------------------------------------
--
-- Structure de la table `campagne`
--
DROP TABLE IF EXISTS `campagne`;
CREATE TABLE IF NOT EXISTS `campagne` (
  `IdCampagne` int(11) NOT NULL AUTO_INCREMENT,
  `MessageCampagne` varchar(255) COLLATE utf8_bin NOT NULL,
  `TypeCampagne` enum('Information', 'Marketing', 'Urgence') COLLATE utf8_bin NOT NULL,
  `TitreCampagne` varchar(50) COLLATE utf8_bin NOT NULL,
  `DateCampagne` date NOT NULL,
  PRIMARY KEY (`IdCampagne`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin;
-- --------------------------------------------------------
--
-- Structure de la table `employe`
--
DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `IdEmploye` int(11) NOT NULL AUTO_INCREMENT,
  `NomEmploye` varchar(50) COLLATE utf8_bin NOT NULL,
  `PrenomEmploye` varchar(50) COLLATE utf8_bin NOT NULL,
  `Login` varchar(50) COLLATE utf8_bin NOT NULL,
  `Password` varchar(50) COLLATE utf8_bin NOT NULL,
  `Fonction` enum('Utilisateur', 'Gestionnaire', 'Administrateur') COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`IdEmploye`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin;
-- --------------------------------------------------------
--
-- Structure de la table `locataire`
--
DROP TABLE IF EXISTS `locataire`;
CREATE TABLE IF NOT EXISTS `locataire` (
  `IdLocataire` int(11) NOT NULL AUTO_INCREMENT,
  `NomLocataire` varchar(50) COLLATE utf8_bin NOT NULL,
  `PrenomLocataire` varchar(50) COLLATE utf8_bin NOT NULL,
  `AgeLocataire` int(3) NOT NULL,
  `TelLocataire` varchar(50) COLLATE utf8_bin NOT NULL,
  `MailLocataire` varchar(50) COLLATE utf8_bin NOT NULL,
  `CatProfessionnel` varchar(50) COLLATE utf8_bin NOT NULL,
  `IdAppart` int(11) NOT NULL,
  PRIMARY KEY (`IdLocataire`),
  KEY `Locataire_Appartement_FK` (`IdAppart`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin;
-- --------------------------------------------------------
--
-- Structure de la table `partenaire`
--
DROP TABLE IF EXISTS `partenaire`;
CREATE TABLE IF NOT EXISTS `partenaire` (
  `IdPartenaire` int(11) NOT NULL AUTO_INCREMENT,
  `NomPartenaire` varchar(50) COLLATE utf8_bin NOT NULL,
  `PrenomPartenaire` varchar(50) COLLATE utf8_bin NOT NULL,
  `AgePartenaire` int(3) NOT NULL,
  `TelPartenaire` varchar(50) COLLATE utf8_bin NOT NULL,
  `MailPartenaire` varchar(50) COLLATE utf8_bin NOT NULL,
  `AdressePartenaire` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`IdPartenaire`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin;
-- --------------------------------------------------------
--
-- Contraintes pour les tables déchargées
--
--
-- Contraintes pour la table `appartement`
--
ALTER TABLE `appartement`
ADD CONSTRAINT `Appartement_Batiment_FK` FOREIGN KEY (`IdBatiment`) REFERENCES `batiment` (`IdBatiment`);
--
-- Contraintes pour la table `ass_campagne_locataire`
--
ALTER TABLE `ass_campagne_locataire`
ADD CONSTRAINT `CAMPAGNE_LOCATAIRE_Campagne_FK` FOREIGN KEY (`IdCampagne`) REFERENCES `campagne` (`IdCampagne`),
  ADD CONSTRAINT `CAMPAGNE_LOCATAIRE_Locataire_FK` FOREIGN KEY (`IdLocataire`) REFERENCES `locataire` (`IdLocataire`);
--
-- Contraintes pour la table `ass_campagne_partenaire`
--
ALTER TABLE `ass_campagne_partenaire`
ADD CONSTRAINT `CAMPAGNE_PARTENAIRE_Campagne_FK` FOREIGN KEY (`IdCampagne`) REFERENCES `campagne` (`IdCampagne`),
  ADD CONSTRAINT `CAMPAGNE_PARTENAIRE_Partenaire_FK` FOREIGN KEY (`IdPartenaire`) REFERENCES `partenaire` (`IdPartenaire`);
--
-- Contraintes pour la table `ass_employe_campagne`
--
ALTER TABLE `ass_employe_campagne`
ADD CONSTRAINT `EMPLOYE_CAMPAGNE_Campagne_FK` FOREIGN KEY (`IdCampagne`) REFERENCES `campagne` (`IdCampagne`),
  ADD CONSTRAINT `EMPLOYE_CAMPAGNE_Employe_FK` FOREIGN KEY (`IdEmploye`) REFERENCES `employe` (`IdEmploye`);
--
-- Contraintes pour la table `employe`
--
--
-- Contraintes pour la table `locataire`
--
ALTER TABLE `locataire`
ADD CONSTRAINT `Locataire_Appartement_FK` FOREIGN KEY (`IdAppart`) REFERENCES `appartement` (`IdAppart`);
--
-- Contraintes pour la table `partenaire`
--
COMMIT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */
;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */
;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */
;