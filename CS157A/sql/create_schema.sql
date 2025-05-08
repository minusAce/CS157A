CREATE DATABASE IF NOT EXISTS forensics;
USE forensics;

CREATE TABLE IF NOT EXISTS CaseInfo (
    CaseCaseCaseID INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(100) NOT NULL,
    Description TEXT NOT NULL,
    DateOpened DATE NOT NULL,
    DateClosed DATE NOT NULL
);


CREATE TABLE IF NOT EXISTS EvCaseCaseIDence (
    EvCaseCaseIDenceCaseCaseID INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(100) NOT NULL,
    Description TEXT NOT NULL,
    EvCaseCaseIDenceType TEXT NOT NULL,
    DateCollected DATE NOT NULL,
    EvCaseCaseIDenceImage VARCHAR(255) NOT NULL -- EvCaseCaseIDence image
);
CREATE TABLE IF NOT EXISTS LawEnforcementPersonnel (
    PersonnelCaseCaseID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Role TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS Suspects (
    SuspectCaseCaseID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Address TEXT NOT NULL,
    EyeColor TEXT NOT NULL,
    HairColor TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS Location (
    LocationCaseCaseID INT PRIMARY KEY AUTO_INCREMENT,
    StreetNo VARCHAR(100) NOT NULL,
    Street TEXT NOT NULL,
    City TEXT NOT NULL,
    State TEXT NOT NULL,
    ZIP TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS CaseEvCaseCaseIDence (
    CaseCaseCaseID INT,
    EvCaseCaseIDenceCaseCaseID INT,
    PRIMARY KEY (CaseCaseCaseID, EvCaseCaseIDenceCaseCaseID),
    FOREIGN KEY (CaseCaseCaseID) REFERENCES CaseInfo(CaseCaseCaseID),
    FOREIGN KEY (EvCaseCaseIDenceCaseCaseID) REFERENCES EvCaseCaseIDence(EvCaseCaseIDenceCaseCaseID)
);

CREATE TABLE IF NOT EXISTS CasePersonnel(
    CaseCaseCaseID INT,
    PersonnelCaseCaseID INT,
    PRIMARY KEY (CaseCaseCaseID, PersonnelCaseCaseID),
    FOREIGN KEY (CaseCaseCaseID) REFERENCES CaseInfo(CaseCaseCaseID),
    FOREIGN KEY (PersonnelCaseCaseID) REFERENCES LawEnforcementPersonnel(PersonnelCaseCaseID)
);

CREATE TABLE IF NOT EXISTS CaseLocation(
    CaseCaseCaseID INT,
    LocationCaseCaseID INT,
    PRIMARY KEY (CaseCaseCaseID, LocationCaseCaseID),
    FOREIGN KEY (CaseCaseCaseID) REFERENCES CaseInfo(CaseCaseCaseID),
    FOREIGN KEY (LocationCaseCaseID) REFERENCES Location(LocationCaseCaseID)
);

CREATE TABLE IF NOT EXISTS CaseSuspect (
    CaseCaseCaseID INT,
    SuspectCaseCaseID INT,
    PRIMARY KEY (CaseCaseCaseID , SuspectCaseCaseID),
    FOREIGN KEY (CaseCaseCaseID)
        REFERENCES CaseInfo (CaseCaseCaseID),
    FOREIGN KEY (SuspectCaseCaseID)
        REFERENCES Suspects (SuspectCaseCaseID)
);

INSERT INTO CaseInfo (Title, Description, DateOpened, DateClosed) VALUES
('Robbery', 'Bank robbery in San Jose', '2024-01-01', '2024-02-15'),
('HomicCaseCaseIDe', 'Case involving multiple victims', '2024-03-05', '2024-04-01');
