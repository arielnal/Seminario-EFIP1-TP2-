
-- -----------------------------------------------------
-- Schema lotequen
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lotequen` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema seminario_efip1
-- -----------------------------------------------------

create database `lotequen`;
USE `lotequen`;

-- -----------------------------------------------------
-- Table `lotequen`.`Domicilio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lotequen`.`Domicilio` (
  `Id_Domicilio` INT NOT NULL AUTO_INCREMENT,
  `Dirección` VARCHAR(45) NOT NULL,
  `Barrio` VARCHAR(45) NOT NULL,
  `Tiempo_Residencia` INT NOT NULL,
  PRIMARY KEY (`Id_Domicilio`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `Id_Domicilio_UNIQUE` ON `lotequen`.`Domicilio` (`Id_Domicilio` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lotequen`.`Garante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lotequen`.`Garante` (
  `Id_Garante` INT NOT NULL AUTO_INCREMENT,
  `Dom_Id` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `DNI` INT NOT NULL,
  `Ingresos` DOUBLE NOT NULL,
  PRIMARY KEY (`Id_Garante`),
  CONSTRAINT `Dom_Id`
    FOREIGN KEY (`Dom_Id`)
    REFERENCES `lotequen`.`Domicilio` (`Id_Domicilio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `Id_Garante_UNIQUE` ON `lotequen`.`Garante` (`Id_Garante` ASC) VISIBLE;

CREATE INDEX `Domicilio_Id_idx` ON `lotequen`.`Garante` (`Dom_Id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lotequen`.`Titular`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lotequen`.`Titular` (
  `Id_Titular` INT NOT NULL AUTO_INCREMENT,
  `Garante_Id` INT NOT NULL,
  `Domicilio_Id` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `DNI` INT NOT NULL,
  `Ingreso` DOUBLE NOT NULL,
  `Nacionalidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id_Titular`),
  CONSTRAINT `Domicilio_Id`
    FOREIGN KEY (`Domicilio_Id`)
    REFERENCES `lotequen`.`Domicilio` (`Id_Domicilio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Garante_Id`
    FOREIGN KEY (`Garante_Id`)
    REFERENCES `lotequen`.`Garante` (`Id_Garante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `Id_Titular_UNIQUE` ON `lotequen`.`Titular` (`Id_Titular` ASC) VISIBLE;

CREATE INDEX `Domicilio_Id_idx` ON `lotequen`.`Titular` (`Domicilio_Id` ASC) VISIBLE;

CREATE INDEX `Garante_Id_idx` ON `lotequen`.`Titular` (`Garante_Id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lotequen`.`Tierra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lotequen`.`Tierra` (
  `Id_Tierra` INT NOT NULL AUTO_INCREMENT,
  `Parcelas` INT NOT NULL,
  `Catastro` VARCHAR(45) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id_Tierra`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `Id_Tierras_UNIQUE` ON `lotequen`.`Tierra` (`Id_Tierra` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lotequen`.`Densidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lotequen`.`Densidad` (
  `Id_Densidad` INT NOT NULL AUTO_INCREMENT,
  `Denominación` VARCHAR(45) NOT NULL,
  `Valor` DOUBLE NOT NULL,
  `Año_Alta` INT NOT NULL,
  PRIMARY KEY (`Id_Densidad`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `Id_Densidad_UNIQUE` ON `lotequen`.`Densidad` (`Id_Densidad` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lotequen`.`Lote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lotequen`.`Lote` (
  `Id_Lote` INT NOT NULL AUTO_INCREMENT,
  `Tierra_Id` INT NOT NULL,
  `Densidad_Id` INT NOT NULL,
  `Nomenclatura` VARCHAR(45) NOT NULL,
  `Manzana` INT NOT NULL,
  `Lote` INT NOT NULL,
  PRIMARY KEY (`Id_Lote`),
  CONSTRAINT `Tierra_Id`
    FOREIGN KEY (`Tierra_Id`)
    REFERENCES `lotequen`.`Tierra` (`Id_Tierra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Densidad_Id`
    FOREIGN KEY (`Densidad_Id`)
    REFERENCES `lotequen`.`Densidad` (`Id_Densidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `Id_Lotes_UNIQUE` ON `lotequen`.`Lote` (`Id_Lote` ASC) VISIBLE;

CREATE INDEX `Tierras_Id_idx` ON `lotequen`.`Lote` (`Tierra_Id` ASC) VISIBLE;

CREATE INDEX `Densidad_Id_idx` ON `lotequen`.`Lote` (`Densidad_Id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lotequen`.`Financiación`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lotequen`.`Financiación` (
  `Id_Financiación` INT NOT NULL AUTO_INCREMENT,
  `Grupo` VARCHAR(45) NOT NULL,
  `Años` INT NOT NULL,
  `Aporte_Inicial` DOUBLE NOT NULL,
  `Valor_Cuota` DOUBLE NOT NULL,
  PRIMARY KEY (`Id_Financiación`))
ENGINE = InnoDB

CREATE UNIQUE INDEX `Id_Grupo_UNIQUE` ON `lotequen`.`Financiación` (`Id_Financiación` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lotequen`.`Beneficiario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lotequen`.`Beneficiario` (
  `Id_Beneficiario` INT NOT NULL AUTO_INCREMENT,
  `Titular1_Id` INT NOT NULL,
  `Titular2_Id` INT NULL,
  `CoTitular` VARCHAR(2) NOT NULL,
  `Lote_Id` INT NOT NULL,
  `Financiación_Id` INT NOT NULL,
  `Índice_Construcción` DOUBLE NULL,
  PRIMARY KEY (`Id_Beneficiario`),
  CONSTRAINT `Titular1_Id`
    FOREIGN KEY (`Titular1_Id`)
    REFERENCES `lotequen`.`Titular` (`Id_Titular`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Titular2_Id`
    FOREIGN KEY (`Titular2_Id`)
    REFERENCES `lotequen`.`Titular` (`Id_Titular`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Lote_Id`
    FOREIGN KEY (`Lote_Id`)
    REFERENCES `lotequen`.`Lote` (`Id_Lote`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Financiación_Id`
    FOREIGN KEY (`Financiación_Id`)
    REFERENCES `lotequen`.`Financiación` (`Id_Financiación`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idBeneficiario_UNIQUE` ON `lotequen`.`Beneficiario` (`Id_Beneficiario` ASC) VISIBLE;

CREATE INDEX `Titular1_Id_idx` ON `lotequen`.`Beneficiario` (`Titular1_Id` ASC) VISIBLE;

CREATE INDEX `Titular2_Id_idx` ON `lotequen`.`Beneficiario` (`Titular2_Id` ASC) VISIBLE;

CREATE INDEX `Lote_Id_idx` ON `lotequen`.`Beneficiario` (`Lote_Id` ASC) VISIBLE;

CREATE INDEX `Grupo_Id_idx` ON `lotequen`.`Beneficiario` (`Financiación_Id` ASC) VISIBLE;



-- -----------------------------------------------------
-- Insert 
-- -----------------------------------------------------

insert into Domicilio (id_Domicilio, dirección, Barrio, Tiempo_Residencia) 
values 
	(1, 'Suite 65', 'CO', 5),
	(2, 'PO Box 47410', 'ID', 12),
	(3, 'Room 1416', 'VN', 13),
	(4, '17th Floor', 'CN', 20),
	(5, 'PO Box 96367', 'HN', 20),
	(6, 'Suite 12', 'ID', 8),
	(7, 'PO Box 27246', 'VN', 12),
	(8, 'Apt 1045', 'ID', 5),
	(9, 'Apt 689', 'SY', 6),
	(10, 'PO Box 17012', 'CN', 6);

insert into Financiación (Id_Financiación, Grupo, Años, Aporte_Inicial, Valor_Cuota)
 values
	(1, 'G1', 7, 6265026.62, 301752.57),
	(2, 'G4', 15, 4701142.49, 271268.38),
	(3, 'G4', 15, 4262362.06, 305009.63),
	(4, 'G2', 10, 3260114.13, 133499.56),
	(5, 'G3', 12, 5307052.58, 160380.09),
	(6, 'G3', 12, 6428244.45, 343410.5),
	(7, 'G2', 10, 3719772.37, 106587.15),
	(8, 'G1', 7, 4234821.83, 335312.56),
	(9, 'G2', 12, 3005584.97, 82674.58),
	(10, 'G2', 12, 6476434.03, 199706.56);


-- -----------------------------------------------------
-- Select 
-- -----------------------------------------------------

select * from financiación where Años > 10;

-- -----------------------------------------------------
-- Delete
-- -----------------------------------------------------

delete from Financiación;
