-- Active: 1746678650813@@127.0.0.1@3306@mysql
CREATE DATABASE IF NOT EXISTS forensics;
USE forensics;

CREATE TABLE IF NOT EXISTS CaseInfo (
    CaseID INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(100) NOT NULL,
    Description TEXT NOT NULL,
    DateOpened DATE NOT NULL,
    DateClosed DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS Evidence (
    EvidenceID INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(100) NOT NULL,
    Description TEXT NOT NULL,
    EvidenceType TEXT NOT NULL,
    DateCollected DATE NOT NULL,
    EvidenceImage VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS LawEnforcementPersonnel (
    PersonnelID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Role TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS CaseEvidence (
    CaseID INT,
    EvidenceID INT,
    PRIMARY KEY (CaseID, EvidenceID),
    FOREIGN KEY (CaseID) REFERENCES CaseInfo(CaseID),
    FOREIGN KEY (EvidenceID) REFERENCES Evidence(EvidenceID)
);

CREATE TABLE IF NOT EXISTS ChainOfCustody (
    CustodyID INT PRIMARY KEY AUTO_INCREMENT,
    EvidenceID INT,
    PersonnelID INT,
    DateCollected DATE NOT NULL,
    FOREIGN KEY (EvidenceID) REFERENCES Evidence(EvidenceID),
    FOREIGN KEY (PersonnelID) REFERENCES LawEnforcementPersonnel(PersonnelID)
);