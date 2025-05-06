CREATE DATABASE IF NOT EXISTS forensics;
USE forensics;

CREATE TABLE CaseInfo (
    CaseID INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(100) NOT NULL,
    Description TEXT NOT NULL,
    DateOpened DATE NOT NULL,
    DateClosed DATE NOT NULL
);

INSERT INTO CaseInfo (Title, Description, DateOpened, DateClosed) VALUES
('Robbery', 'Bank robbery in San Jose', '2024-01-01', '2024-02-15'),
('Homicide', 'Case involving multiple victims', '2024-03-05', '2024-04-01');