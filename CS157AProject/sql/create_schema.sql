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
    EvidenceImage VARCHAR(255) NOT NULL -- Evidence image
);
CREATE TABLE IF NOT EXISTS LawEnforcementPersonnel (
    PersonnelID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Role TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS Suspects (
    SuspectID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Address TEXT NOT NULL,
    EyeColor TEXT NOT NULL,
    HairColor TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS Location (
    LocationID INT PRIMARY KEY AUTO_INCREMENT,
    StreetNo VARCHAR(100) NOT NULL,
    Street TEXT NOT NULL,
    City TEXT NOT NULL,
    State TEXT NOT NULL,
    ZIP TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS CaseEvidence (
    CaseID INT,
    EvidenceID INT,
    PRIMARY KEY (CaseID, EvidenceID),
    FOREIGN KEY (CaseID) REFERENCES CaseInfo(CaseID),
    FOREIGN KEY (EvidenceID) REFERENCES Evidence(EvidenceID)
);

CREATE TABLE IF NOT EXISTS CasePersonnel(
    CaseID INT,
    PersonnelID INT,
    PRIMARY KEY (CaseID, PersonnelID),
    FOREIGN KEY (CaseID) REFERENCES CaseInfo(CaseID),
    FOREIGN KEY (PersonnelID) REFERENCES LawEnforcementPersonnel(PersonnelID)
);

CREATE TABLE IF NOT EXISTS CaseLocation(
    CaseID INT,
    LocationID INT,
    PRIMARY KEY (CaseID, LocationID),
    FOREIGN KEY (CaseID) REFERENCES CaseInfo(CaseID),
    FOREIGN KEY (LocationID) REFERENCES Location(LocationID)
);

CREATE TABLE IF NOT EXISTS CaseSuspect (
    CaseID INT,
    SuspectID INT,
    PRIMARY KEY (CaseID , SuspectID),
    FOREIGN KEY (CaseID)
        REFERENCES CaseInfo (CaseID),
    FOREIGN KEY (SuspectID)
        REFERENCES Suspects (SuspectID)
);

INSERT INTO CaseInfo (Title, Description, DateOpened, DateClosed) VALUES
('Robbery', 'Bank robbery in San Jose', '2024-01-01', '2024-02-15'),
('Homicide', 'Case involving multiple victims', '2024-03-05', '2024-04-01');
