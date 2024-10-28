
DROP DATABASE IF EXISTS money_master_webwizard;
CREATE DATABASE money_master_webwizard;

use money_master_webwizard;



CREATE TABLE Student (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

INSERT INTO Student (first_name, last_name, email)
VALUES
('John', 'Doe', 'john.doe@example.com'),
('Jane', 'Smith', 'jane.smith@example.com'),
('Alice', 'Johnson', 'alice.johnson@example.com');

drop table USER;
CREATE TABLE USER (
    USERNAME VARCHAR(255) PRIMARY KEY NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    ROLE VARCHAR(50) NOT NULL
);

-- password abcd--
INSERT INTO USER (USERNAME, PASSWORD, ROLE) VALUES
('u1', '$2a$10$7LyA2iqkdouw2hgNI4Lq3OkEXS873EbKV.7qrybParzCIeD/VMZqm', 'admin'),
('u2', '$2a$10$7LyA2iqkdouw2hgNI4Lq3OkEXS873EbKV.7qrybParzCIeD/VMZqm', 'ceo'),
('u3', '$2a$10$7LyA2iqkdouw2hgNI4Lq3OkEXS873EbKV.7qrybParzCIeD/VMZqm', 'admin');

DROP table CONTACT;
CREATE TABLE CONTACT (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    FIRST_NAME VARCHAR(255) NOT NULL,
    LAST_NAME VARCHAR(255) NOT NULL,
    TELEPHONE_NUMBER VARCHAR(15),
    EMAIL_ADDRESS VARCHAR(255) CHECK (EMAIL_ADDRESS LIKE '%_@__%.__%'),
    HOME_ADDRESS VARCHAR(255),
    USER VARCHAR(255) NOT NULL,
    CONSTRAINT FK_USER FOREIGN KEY (USER) REFERENCES USER(USERNAME)
);

INSERT INTO CONTACT (FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL_ADDRESS, HOME_ADDRESS, USER) VALUES
('John', 'Doe', '123-456-7890', 'john.doe@example.com', '123 Main St, Springfield', 'u1'),
('Jane', 'Smith', '987-654-3210', 'jane.smith@example.com', '456 Elm St, Springfield', 'u2'),
('Alice', 'Johnson', '555-555-5555', 'alice.johnson@example.com', '789 Maple Ave, Springfield', 'u3');
