-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema inventario
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema inventario
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `inventario`;
CREATE SCHEMA IF NOT EXISTS `inventario` DEFAULT CHARACTER SET utf8 ;
USE `inventario` ;

-- -----------------------------------------------------
-- Table `inventario`.`almacen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`almacen` (
  `almacen_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `ubicacion` VARCHAR(500) NOT NULL,
  `dimension` INT(11) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`almacen_id`),
  UNIQUE INDEX `almacen_id_UNIQUE` (`almacen_id` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inventario`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`marca` (
  `marca_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `descripcion` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`marca_id`),
  UNIQUE INDEX `marca_id_UNIQUE` (`marca_id` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inventario`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`proveedor` (
  `proveedor` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `descripcion` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`proveedor`),
  UNIQUE INDEX `proveedor_UNIQUE` (`proveedor` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inventario`.`tipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`tipo` (
  `tipo_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`tipo_id`),
  UNIQUE INDEX `tipo_id_UNIQUE` (`tipo_id` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inventario`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`producto` (
  `producto_id` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo_id` INT(11) NOT NULL,
  `marca_id` INT(11) NOT NULL,
  `almacen_id` INT(11) NOT NULL,
  `proveedor_id` INT(11) NOT NULL,
  `precio_venta` DOUBLE NOT NULL,
  `descripcion` VARCHAR(300) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cantidad` INT(11) NOT NULL,
  PRIMARY KEY (`producto_id`),
  UNIQUE INDEX `producto_id_UNIQUE` (`producto_id` ASC) ,
  INDEX `tipo_id_idx` (`tipo_id` ASC) ,
  INDEX `marca_id_idx` (`marca_id` ASC) ,
  INDEX `almacen_id_fk_idx` (`almacen_id` ASC) ,
  INDEX `proveedor_id_fk_idx` (`proveedor_id` ASC) ,
  CONSTRAINT `almacen_id_fk`
    FOREIGN KEY (`almacen_id`)
    REFERENCES `inventario`.`almacen` (`almacen_id`),
  CONSTRAINT `marca_id_fk`
    FOREIGN KEY (`marca_id`)
    REFERENCES `inventario`.`marca` (`marca_id`),
  CONSTRAINT `proveedor_id_fk`
    FOREIGN KEY (`proveedor_id`)
    REFERENCES `inventario`.`proveedor` (`proveedor`),
  CONSTRAINT `tipo_id_fk`
    FOREIGN KEY (`tipo_id`)
    REFERENCES `inventario`.`tipo` (`tipo_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inventario`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`usuario` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `contrasena` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(100) NOT NULL,
  `admin` TINYINT(4) NOT NULL DEFAULT '0',
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `activo` VARCHAR(45) NOT NULL DEFAULT '1',
  `correo` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inventario`.`venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`venta` (
  `venta_id` INT(11) NOT NULL,
  `usuario_id` INT(11) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`venta_id`),
  UNIQUE INDEX `usuario_id_UNIQUE` (`usuario_id` ASC) ,
  CONSTRAINT `usuario_id_fk`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `inventario`.`usuario` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inventario`.`venta_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`venta_producto` (
  `venta_id` INT(11) NOT NULL,
  `producto_id` INT(11) NOT NULL,
  PRIMARY KEY (`venta_id`, `producto_id`),
  INDEX `producto_id` (`producto_id` ASC) ,
  CONSTRAINT `venta_producto_ibfk_1`
    FOREIGN KEY (`venta_id`)
    REFERENCES `inventario`.`venta` (`venta_id`),
  CONSTRAINT `venta_producto_ibfk_2`
    FOREIGN KEY (`producto_id`)
    REFERENCES `inventario`.`producto` (`producto_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
