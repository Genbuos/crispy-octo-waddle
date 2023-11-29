-- -----------------------------------------------------
-- Schema full-stack-ecommerce
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `jordy`;

CREATE SCHEMA `jordy`;
USE `jordy` ;

-- -----------------------------------------------------
-- Table `full-stack-ecommerce`.`product_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jordy`.`product_category` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `full-stack-ecommerce`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jordy`.`product` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `sku` VARCHAR(255) DEFAULT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `unit_price` DECIMAL(13,2) DEFAULT NULL,
  `image_url` VARCHAR(255) DEFAULT NULL,
  `active` BIT DEFAULT 1,
  `units_in_stock` INT(11) DEFAULT NULL,
   `date_created` DATETIME(6) DEFAULT NULL,
  `last_updated` DATETIME(6) DEFAULT NULL,
  `category_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category` (`category_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Add sample data
-- -----------------------------------------------------

INSERT INTO product_category(category_name) VALUES ('BRACELETS');

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('BRACE-HEAL-1000', 'Conscious', 'A handmade 7.5 inch elastic bracelet made with silver obsidian and tigereye round stones.',
'assets/images/products/placeholder.png'
,1,100,14.00,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('BRACE-HEAL-1001', 'Calm Bonds', 'A handmade 7.5 inch elastic bracelet made with sodalite round beads and lapis lazuli chips. ',
'assets/images/products/placeholder.png'
,1,100,14.00,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('BRACE-HEAL-1002', 'Sharp Mind', 'A handmade 7 inch elastic bracelet made with jade and glass beads. ',
'assets/images/products/placeholder.png'
,1,100,14.00,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('BRACE-HEAL-1003', 'Volcano Glass', 'A handmade 7.5 inch elastic bracelet made with silver obsidian and 3 eye tibetan dzi.',
'assets/images/products/placeholder.png'
,1,100,14.00,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('BRACE-HEAL-1004', 'Grounded', 'A handmade 7.5 inch elastic bracelet made with tigereye and silver obsidian round beads.',
'assets/images/products/placeholder.png'
,1,100,14.00,1, NOW());
