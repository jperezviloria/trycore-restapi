CREATE TABLE Person(
                       ID INT AUTO_INCREMENT,
                       NAME VARCHAR(80) NOT NULL,
                       AGE INT NOT NULL,
                       HEIGHT INT NOT NULL,
                       WEIGHT INT NOT NULL,
                       GENDER VARCHAR(20) NOT NULL,
                       BIRTH DATE NOT NULL,
                       ID_PLANET INT NOT NULL,
                       COUNTER INT NOT NULL,
                       PRIMARY KEY (ID),
                       FOREIGN KEY (ID_PLANET) REFERENCES Planet(ID)
);
