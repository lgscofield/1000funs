SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `1000funs` ;
CREATE SCHEMA IF NOT EXISTS `1000funs` DEFAULT CHARACTER SET utf8 ;
USE `1000funs` ;

-- -----------------------------------------------------
-- Table `1000funs`.`shop`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `1000funs`.`shop` ;

CREATE  TABLE IF NOT EXISTS `1000funs`.`shop` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `number` VARCHAR(45) NULL ,
  `shop_name` VARCHAR(45) NULL ,
  `address` VARCHAR(45) NULL ,
  `deleted` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `1000funs`.`food`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `1000funs`.`food` ;

CREATE  TABLE IF NOT EXISTS `1000funs`.`food` (
  `id` INT NOT NULL ,
  `number` VARCHAR(45) NULL ,
  `shop_id` INT NULL COMMENT 'necessary' ,
  `food_name` VARCHAR(45) NULL ,
  `detail` VARCHAR(400) NULL ,
  `image` VARCHAR(400) NULL ,
  `price` DOUBLE NULL ,
  `stockout` TINYINT(1) NULL COMMENT 'should we move this flag to \\\" spell_item\\\" ?' ,
  `droped` TINYINT(1) NULL ,
  `deleted` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `1000funs`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `1000funs`.`user` ;

CREATE  TABLE IF NOT EXISTS `1000funs`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `user_name` VARCHAR(45) NULL ,
  `phone` VARCHAR(45) NULL ,
  `email` VARCHAR(45) NULL ,
  `register_time` VARCHAR(45) NULL ,
  `score` INT NULL ,
  `quota` DOUBLE NULL ,
  `deleted` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `1000funs`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `1000funs`.`order` ;

CREATE  TABLE IF NOT EXISTS `1000funs`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `number` VARCHAR(45) NULL ,
  `shop_id` INT NULL ,
  `create_time` VARCHAR(45) NULL ,
  `except_time` VARCHAR(45) NULL ,
  `userId` INT NULL ,
  `address` VARCHAR(200) NULL ,
  `remark` VARCHAR(45) NULL ,
  `status` INT NULL COMMENT '0:new\\n1:dealed\\n2:exception\\n' ,
  `manager_id` INT NULL ,
  `manager_remark` VARCHAR(45) NULL ,
  `evaluated` TINYINT(1) NULL COMMENT 'Is user evaluate this order.' ,
  `deleted` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `1000funs`.`evaluate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `1000funs`.`evaluate` ;

CREATE  TABLE IF NOT EXISTS `1000funs`.`evaluate` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `order_id` INT NULL ,
  `speed` INT NULL ,
  `taste` INT NULL ,
  `service` INT NULL ,
  `detail` VARCHAR(200) NULL ,
  `deleted` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `1000funs`.`password`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `1000funs`.`password` ;

CREATE  TABLE IF NOT EXISTS `1000funs`.`password` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `user_id` INT NULL ,
  `password` VARCHAR(200) NULL ,
  `create_time` VARCHAR(45) NULL ,
  `overdue` TINYINT(1) NULL COMMENT 'is overdue . this is for give user the tips: your password has been changed 2 days ago . but , maybe use a table to record this is more benifit .' ,
  `deleted` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `1000funs`.`spell_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `1000funs`.`spell_group` ;

CREATE  TABLE IF NOT EXISTS `1000funs`.`spell_group` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `shop_id` INT NULL ,
  `spell_group_name` VARCHAR(45) NULL ,
  `price` DOUBLE NULL ,
  `image` VARCHAR(200) NULL ,
  `detail` VARCHAR(200) NULL ,
  `deleted` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `1000funs`.`spell_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `1000funs`.`spell_item` ;

CREATE  TABLE IF NOT EXISTS `1000funs`.`spell_item` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `group_id` INT NULL ,
  `food_id` INT NULL ,
  `orderNumber` INT NULL COMMENT 'control the view .' ,
  `deleted` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `1000funs`.`suite_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `1000funs`.`suite_group` ;

CREATE  TABLE IF NOT EXISTS `1000funs`.`suite_group` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `number` VARCHAR(45) NULL ,
  `shop_id` INT NULL ,
  `suite_group_name` VARCHAR(45) NULL ,
  `price` DOUBLE NULL ,
  `image` VARCHAR(200) NULL ,
  `detail` VARCHAR(200) NULL ,
  `deleted` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `1000funs`.`suite`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `1000funs`.`suite` ;

CREATE  TABLE IF NOT EXISTS `1000funs`.`suite` (
  `id` INT NOT NULL ,
  `number` VARCHAR(45) NULL ,
  `shop_id` VARCHAR(45) NULL COMMENT 'necessary' ,
  `suite_name` VARCHAR(45) NULL ,
  `detail` VARCHAR(400) NULL ,
  `image` VARCHAR(400) NULL ,
  `price` DOUBLE NULL ,
  `stockout` TINYINT(1) NULL COMMENT 'should we move this flag to \\\" spell_item\\\" ?' ,
  `droped` TINYINT(1) NULL ,
  `delete` TINYINT(1) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `1000funs`.`suite_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `1000funs`.`suite_item` ;

CREATE  TABLE IF NOT EXISTS `1000funs`.`suite_item` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `group_id` INT NULL ,
  `suite_id` INT NULL ,
  `deleted` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `1000funs`.`suite_food`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `1000funs`.`suite_food` ;

CREATE  TABLE IF NOT EXISTS `1000funs`.`suite_food` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `suite_id` INT NULL ,
  `food_id` INT NULL ,
  `deleted` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `1000funs`.`pre_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `1000funs`.`pre_order` ;

CREATE  TABLE IF NOT EXISTS `1000funs`.`pre_order` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `number` VARCHAR(20) NULL ,
  `shop_id` INT NULL ,
  `user_id` INT NULL ,
  `except_time` VARCHAR(45) NULL ,
  `remark` VARCHAR(45) NULL ,
  `create_time` VARCHAR(45) NULL ,
  `deleted` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `1000funs`.`pre_order_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `1000funs`.`pre_order_item` ;

CREATE  TABLE IF NOT EXISTS `1000funs`.`pre_order_item` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `pre_order_id` INT NULL ,
  `item_type` INT NULL COMMENT '0 spell , 1 suite' ,
  `item_id` INT NULL COMMENT 'itemType and itemId decide which food is the user wanted.' ,
  `deleted` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
