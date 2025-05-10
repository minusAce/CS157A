-- Active: 1746678650813@@127.0.0.1@3306@forensics
INSERT INTO CaseInfo (Title, Description, DateOpened, DateClosed) VALUES
('Robbery', 'Bank robbery in San Jose', '2024-01-01', '2024-02-15'),
('Homicide', '5 San Jose locals murdered by use of a firearm', '2024-03-05', '2024-04-01'),
('Assault', 'Downtown San Jose altercation turned violent, suspect slapped victim', '2021-02-02', '2021-03-03'),
('Kidnapping', '25 Year Old Victim seen being taken from her home', '2024-03-03', '2024-04-04'),
('Homicide', 'Man found dead in home with weapon nearby', '2010-01-01', '2011-02-15'),
('Fraud', 'White collar financial Crime', '2024-11-05', '2025-04-01'),
('Theft', 'Valuable missing from college housing', '2012-01-01', '2015-02-15'),
('Homicide', 'Woman found deceased near 7-11', '2019-03-05', '2023-04-01'),
('Robbery', 'Armed robbery of a college student for jewelry', '2024-01-01', '2024-03-15'),
('Arson', 'Fires down Guadalupe River', '2016-03-05', '2017-04-01'),
('Kidnapping', 'Male Victim seen by many witnesses being taken into car forcefully', '2010-01-01', '2013-02-15'),
('Fraud', 'Identity Fraud', '2021-03-05', '2022-04-01'),
('Homicide', 'Couple found deceased in apartment', '2013-01-01', '2014-02-15'),
('Homicide', 'Elderly man found deceased in car', '2015-03-05', '2018-08-01'),
('Breaking & Entering', 'South San Jose home found with broken windows and kicked in door', '2021-01-01', '2021-02-15');


INSERT INTO Evidence (Title, Description, EvidenceType, DateCollected) VALUES
('Glock 17', 'All black firearm found in possession of suspect', 'Firearm', '2023-04-01'),
('USB Drive', 'Storage device found containing illicit files', 'Digital', '2023-05-12'),
('Ski Mask', 'Black ski mask left at crime scene', 'Clothing', '2023-03-22'),
('Blood Sample', 'Blood sample collected from crime scene', 'Biological', '2023-06-15'),
('Laptop', 'Laptop belonging to the main suspect', 'Digital', '2023-02-10'),
('Broken Bottle', 'Shattered glass bottle used as weapon', 'Weapon', '2023-01-28'),
('Surveillance Tape', 'Footage from security camera', 'Digital', '2023-03-05'),
('Wallet', 'Victim''s wallet found near the alley', 'Personal Item', '2023-04-18'),
('Knife', 'Foldable knife with fingerprints', 'Weapon', '2023-05-01'),
('Gloves', 'Pair of leather gloves found at the scene', 'Clothing', '2023-06-30'),
('Cell Phone', 'Suspect''s phone with GPS data', 'Digital', '2023-03-19'),
('Keycard', 'Access card to restricted building', 'Access Device', '2023-02-22'),
('Backpack', 'Abandoned backpack containing suspicious materials', 'Container', '2023-01-15'),
('License Plate', 'Detached plate found in getaway vehicle', 'Vehicle Part', '2023-04-11'),
('Flashlight', 'Flashlight with DNA traces', 'Tool', '2023-05-25');

INSERT INTO LawEnforcementPersonnel (Name, Role) VALUES
('Fabian', 'Lieutenant'),
('Gabriel', 'Investigator'),
('Ansh', 'Sergeant'),
('Gabe', 'Sergeant'),
('Karla', 'Lieutenant'),
('Miguel', 'Lieutenant'),
('Rajat', 'Sergeant'),
('Mike', 'Investigator'),
('Ashley', 'Detective'),
('Ruth', 'Lieutenant'),
('Alex', 'Investigator'),
('Neal', 'Detective'),
('Gonzalo', 'Patrol'),
('Kevin', 'Lieutenant'),
('Ignacio', 'Sergeant');

INSERT INTO ChainOfCustody (PersonnelID, EvidenceID, DateLogged) VALUES
(1, 1, '2023-04-01 10:00:00'),
(2, 2, '2023-05-12 11:00:00'),
(3, 3, '2023-03-22 12:00:00'),
(4, 4, '2023-06-15 13:00:00'),
(5, 5, '2023-02-10 14:00:00'),
(6, 6, '2023-01-28 15:00:00'),
(7, 7, '2023-03-05 16:00:00'),
(8, 8, '2023-04-18 17:00:00'),
(9, 9, '2023-05-01 18:00:00'),
(10, 10, '2023-06-30 19:00:00'),
(11, 11, '2023-03-19 20:00:00'),
(12, 12, '2023-02-22 21:00:00'),
(13, 13, '2023-01-15 22:00:00'),
(14, 14, '2023-04-11 23:00:00'),
(15, 15, '2023-05-25 00:00:00');
