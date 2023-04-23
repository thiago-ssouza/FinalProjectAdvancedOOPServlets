CREATE SCHEMA `final_prj_db` ;

CREATE TABLE `final_prj_db`.`user` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `phoneNumber` VARCHAR(15) NOT NULL,
  `streetNumber` INT NOT NULL,
  `streetName` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `stateProvince` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `postalCode` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);