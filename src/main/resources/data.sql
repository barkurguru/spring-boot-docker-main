CREATE TABLE Person (
    ID int AUTO_INCREMENT,
    First_Name varchar(255),
    Last_Name varchar(255),
    Age int,
    Country varchar(255),
    PRIMARY KEY (ID)
);

INSERT INTO Person (First_Name, Last_Name, Age, Country) VALUES ('Sanath', 'Jayasooriya', 50, 'Sri Lanka');
INSERT INTO Person (First_Name, Last_Name, Age, Country) VALUES ('Virat', 'Kohli', 35, 'India');
INSERT INTO Person (First_Name, Last_Name, Age, Country) VALUES ('Ben', 'Stokes', 30, 'England');
INSERT INTO Person (First_Name, Last_Name, Age, Country) VALUES ('Babar', 'Azam', 25, 'Pakistan');
INSERT INTO Person (First_Name, Last_Name, Age, Country) VALUES ('Shane', 'Watson', 40, 'Australia');