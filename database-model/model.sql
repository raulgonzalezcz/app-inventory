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
CREATE SCHEMA IF NOT EXISTS `inventario` DEFAULT CHARACTER SET utf8 ;
USE `inventario` ;

-- -----------------------------------------------------
-- Table `inventario`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`usuario` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `contrasena` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(100) NOT NULL,
  `admin` TINYINT NOT NULL DEFAULT 0,
  `fecha_creacion` DATETIME NOT NULL DEFAULT  NOW(),
  `activo` VARCHAR(45) NOT NULL DEFAULT 1,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventario`.`tipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`tipo` (
  `tipo_id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT  NOW(),
  PRIMARY KEY (`tipo_id`),
  UNIQUE INDEX `tipo_id_UNIQUE` (`tipo_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventario`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`marca` (
  `marca_id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT  NOW(),
  `descripcion` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`marca_id`),
  UNIQUE INDEX `marca_id_UNIQUE` (`marca_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventario`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`producto` (
  `producto_id` INT NOT NULL AUTO_INCREMENT,
  `tipo_id` INT NOT NULL,
  `marca_id` INT NOT NULL,
  `precio_venta` DOUBLE NOT NULL,
  `descripcion` VARCHAR(300) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT  NOW(),
  PRIMARY KEY (`producto_id`),
  UNIQUE INDEX `producto_id_UNIQUE` (`producto_id` ASC),
  INDEX `tipo_id_idx` (`tipo_id` ASC),
  INDEX `marca_id_idx` (`marca_id` ASC),
  CONSTRAINT `tipo_id_fk`
    FOREIGN KEY (`tipo_id`)
    REFERENCES `inventario`.`tipo` (`tipo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `marca_id_fk`
    FOREIGN KEY (`marca_id`)
    REFERENCES `inventario`.`marca` (`marca_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventario`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`proveedor` (
  `proveedor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT  NOW(),
  `descripcion` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`proveedor`),
  UNIQUE INDEX `proveedor_UNIQUE` (`proveedor` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventario`.`almacen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`almacen` (
  `almacen_id` INT NOT NULL AUTO_INCREMENT,
  `ubicacion` VARCHAR(500) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT  NOW(),
  PRIMARY KEY (`almacen_id`),
  UNIQUE INDEX `almacen_id_UNIQUE` (`almacen_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventario`.`producto_proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`producto_proveedor` (
  `producto_id` INT NOT NULL,
  `proveedor_id` INT NOT NULL,
  `precio_compra` INT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT  NOW(),
  PRIMARY KEY (`producto_id`, `proveedor_id`),
  INDEX `proveedor_id_fk_idx` (`proveedor_id` ASC),
  CONSTRAINT `producto_id_fk`
    FOREIGN KEY (`producto_id`)
    REFERENCES `inventario`.`producto` (`producto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `proveedor_id_fk`
    FOREIGN KEY (`proveedor_id`)
    REFERENCES `inventario`.`proveedor` (`proveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventario`.`producto_almacen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`producto_almacen` (
  `almacen_id` INT NOT NULL,
  `producto_id` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT  NOW(),
  PRIMARY KEY (`almacen_id`, `producto_id`),
  FOREIGN KEY (`almacen_id`) REFERENCES `inventario`.`almacen` (`almacen_id`),
  FOREIGN KEY (`producto_id`) REFERENCES `inventario`.`producto` (`producto_id`)
  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventario`.`venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`venta` (
  `venta_id` INT NOT NULL,
  `usuario_id` INT NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT  NOW(),
  UNIQUE INDEX `usuario_id_UNIQUE` (`usuario_id` ASC),
  PRIMARY KEY (`venta_id`),
  CONSTRAINT `usuario_id_fk`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `inventario`.`usuario` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventario`.`venta_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario`.`venta_producto` (
  `venta_id` INT NOT NULL,
  `producto_id` INT NOT NULL,
  PRIMARY KEY (`venta_id`, `producto_id`),
  FOREIGN KEY (`venta_id`) REFERENCES `inventario`.`venta` (`venta_id`),
  FOREIGN KEY (`producto_id`) REFERENCES `inventario`.`producto` (`producto_id`)
  )
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
