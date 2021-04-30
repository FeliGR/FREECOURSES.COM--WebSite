-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cursos_libres
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cursos_libres
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cursos_libres` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `cursos_libres` ;

-- -----------------------------------------------------
-- Table `cursos_libres`.`courses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursos_libres`.`courses` (
  `id_course` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `price` FLOAT NULL DEFAULT NULL,
  `status` BIT(1) NULL DEFAULT NULL,
  `thematic` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_course`))
ENGINE = MyISAM
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cursos_libres`.`enrollments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursos_libres`.`enrollments` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `grade` FLOAT NULL DEFAULT NULL,
  `id_section` INT(11) NOT NULL,
  `id_student` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKc3630rcfa6cwaw36767bx6gfo` (`id_section` ASC) VISIBLE,
  INDEX `FK5x0hgbqivjw8ynxp8w08frkts` (`id_student` ASC) VISIBLE)
ENGINE = MyISAM
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cursos_libres`.`managers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursos_libres`.`managers` (
  `id` VARCHAR(64) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cursos_libres`.`persons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursos_libres`.`persons` (
  `id` VARCHAR(64) NOT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `type` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cursos_libres`.`professors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursos_libres`.`professors` (
  `id` VARCHAR(64) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(255) NULL DEFAULT NULL,
  `specialty` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cursos_libres`.`sections`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursos_libres`.`sections` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `schedule` VARCHAR(255) NULL DEFAULT NULL,
  `id_course` INT(11) NOT NULL,
  `id_professor` VARCHAR(64) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKbjoavu2p6y6oqk6m252eoffww` (`id_course` ASC) VISIBLE,
  INDEX `FK75xl6sfxy93paxvrm6dffx8qa` (`id_professor` ASC) VISIBLE)
ENGINE = MyISAM
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cursos_libres`.`students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursos_libres`.`students` (
  `id` VARCHAR(64) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
