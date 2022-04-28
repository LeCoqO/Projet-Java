-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 28 avr. 2022 à 13:47
-- Version du serveur :  10.4.13-MariaDB
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet_java`
--

-- --------------------------------------------------------

--
-- Structure de la table `appartement`
--

DROP TABLE IF EXISTS `appartement`;
CREATE TABLE IF NOT EXISTS `appartement` (
  `IdAppart` int(11) NOT NULL auto_increment,
  `AdresseAppart` varchar(50) COLLATE utf8_bin NOT NULL,
  `CategorieAppart` varchar(50) COLLATE utf8_bin NOT NULL,
  `NumAppart` int(11) NOT NULL,
  `IdBatiment` int(11) NOT NULL,
  PRIMARY KEY (`IdAppart`),
  KEY `Appartement_Batiment_FK` (`IdBatiment`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `ass_campagne_personne`
--

DROP TABLE IF EXISTS `ass_campagne_personne`;
CREATE TABLE IF NOT EXISTS `ass_campagne_personne` (
  `IdCampagne` int(11) NOT NULL,
  `IdPersonne` int(11) NOT NULL,
  PRIMARY KEY (`IdCampagne`,`IdPersonne`),
  KEY `CAMPAGNE_PERSONNE_Personne0_FK` (`IdPersonne`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `ass_employe_campagne`
--

DROP TABLE IF EXISTS `ass_employe_campagne`;
CREATE TABLE IF NOT EXISTS `ass_employe_campagne` (
  `IdCampagne` int(11) NOT NULL,
  `IdPersonne` int(11) NOT NULL,
  PRIMARY KEY (`IdCampagne`,`IdPersonne`),
  KEY `EMPLOYE_CAMPAGNE_Employe0_FK` (`IdPersonne`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `batiment`
--

DROP TABLE IF EXISTS `batiment`;
CREATE TABLE IF NOT EXISTS `batiment` (
  `IdBatiment` int(11) NOT NULL auto_increment,
  `AdresseBatiment` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`IdBatiment`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `campagne`
--

DROP TABLE IF EXISTS `campagne`;
CREATE TABLE IF NOT EXISTS `campagne` (
  `IdCampagne` int(11) NOT NULL auto_increment,
  `MessageCampagne` varchar(50) COLLATE utf8_bin NOT NULL,
  `TypeCampagne` varchar(50) COLLATE utf8_bin NOT NULL,
  `TitreCampagne` varchar(50) COLLATE utf8_bin NOT NULL,
  `DateCampagne` date NOT NULL,
  `DroitCampagne` tinyint(1) NOT NULL,
  PRIMARY KEY (`IdCampagne`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `IdPersonne` int(11) NOT NULL auto_increment,
  `NomEmploye` varchar(50) COLLATE utf8_bin NOT NULL,
  `PrenomEmploye` varchar(50) COLLATE utf8_bin NOT NULL,
  `Fonction` varchar(50) COLLATE utf8_bin NOT NULL,
  `TelEmploye` varchar(50) COLLATE utf8_bin NOT NULL,
  `MailEmploye` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`IdPersonne`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `locataire`
--

DROP TABLE IF EXISTS `locataire`;
CREATE TABLE IF NOT EXISTS `locataire` (
  `IdPersonne` int(11) NOT NULL auto_increment,
  `NomLocataire` varchar(50) COLLATE utf8_bin NOT NULL,
  `PrenomLocataire` varchar(50) COLLATE utf8_bin NOT NULL,
  `AgeLocataire` int(11) NOT NULL,
  `AdresseLocataire` varchar(50) COLLATE utf8_bin NOT NULL,
  `CatProfessionnel` varchar(50) COLLATE utf8_bin NOT NULL,
  `MailLocataire` varchar(50) COLLATE utf8_bin NOT NULL,
  `IdAppart` int(11) NOT NULL,
  PRIMARY KEY (`IdPersonne`),
  KEY `Locataire_Appartement0_FK` (`IdAppart`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `partenaire`
--

DROP TABLE IF EXISTS `partenaire`;
CREATE TABLE IF NOT EXISTS `partenaire` (
  `IdPersonne` int(11) NOT NULL auto_increment,
  `NomPartenaire` varchar(50) COLLATE utf8_bin NOT NULL,
  `PrenomPartenaire` varchar(50) COLLATE utf8_bin NOT NULL,
  `AgePartenaire` int(11) NOT NULL,
  `TelPartenaire` varchar(50) COLLATE utf8_bin NOT NULL,
  `MailPartenaire` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`IdPersonne`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `IdPersonne` int(11) NOT NULL auto_increment,
  `Login` char(30) NOT NULL,
  `Password` char(30) NOT NULL,
  PRIMARY KEY (`IdPersonne`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `appartement`
--
ALTER TABLE `appartement`
  ADD CONSTRAINT `Appartement_Batiment_FK` FOREIGN KEY (`IdBatiment`) REFERENCES `batiment` (`IdBatiment`);

--
-- Contraintes pour la table `ass_campagne_personne`
--
ALTER TABLE `ass_campagne_personne`
  ADD CONSTRAINT `CAMPAGNE_PERSONNE_Campagne_FK` FOREIGN KEY (`IdCampagne`) REFERENCES `campagne` (`IdCampagne`),
  ADD CONSTRAINT `CAMPAGNE_PERSONNE_Personne0_FK` FOREIGN KEY (`IdPersonne`) REFERENCES `personne` (`IdPersonne`);

--
-- Contraintes pour la table `ass_employe_campagne`
--
ALTER TABLE `ass_employe_campagne`
  ADD CONSTRAINT `EMPLOYE_CAMPAGNE_Campagne_FK` FOREIGN KEY (`IdCampagne`) REFERENCES `campagne` (`IdCampagne`),
  ADD CONSTRAINT `EMPLOYE_CAMPAGNE_Employe0_FK` FOREIGN KEY (`IdPersonne`) REFERENCES `employe` (`IdPersonne`);

--
-- Contraintes pour la table `employe`
--
ALTER TABLE `employe`
  ADD CONSTRAINT `Employe_Personne_FK` FOREIGN KEY (`IdPersonne`) REFERENCES `personne` (`IdPersonne`);

--
-- Contraintes pour la table `locataire`
--
ALTER TABLE `locataire`
  ADD CONSTRAINT `Locataire_Appartement0_FK` FOREIGN KEY (`IdAppart`) REFERENCES `appartement` (`IdAppart`),
  ADD CONSTRAINT `Locataire_Personne_FK` FOREIGN KEY (`IdPersonne`) REFERENCES `personne` (`IdPersonne`);

--
-- Contraintes pour la table `partenaire`
--
ALTER TABLE `partenaire`
  ADD CONSTRAINT `Partenaire_Personne_FK` FOREIGN KEY (`IdPersonne`) REFERENCES `personne` (`IdPersonne`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
