USE `company_db`;

-- -----------------------------------------------------
-- Table `company_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`users`
(
    `id`       INT          NOT NULL AUTO_INCREMENT,
    `email`    VARCHAR(254) NOT NULL,
    `password` VARCHAR(50)  NOT NULL,
    /**
     * 0 - администратор (Role.ADMINISTRATOR)
	 * 1 - руководитель (Role.DIRECTOR)
     * 2 - бухгалтер (Role.ACCOUNTANT)
     */
    `role`     TINYINT      NOT NULL CHECK (`role` IN (0, 1, 2)) DEFAULT 2,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `company_db`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`company`
(
    `ynn`           INT          NOT NULL,
    `id`            INT          NOT NULL AUTO_INCREMENT,
    `okpo`          INT          NOT NULL,
    `name`          VARCHAR(100) NOT NULL,
    `full_name`     VARCHAR(250) NOT NULL,
    `year`          YEAR         NOT NULL,
    `period`        VARCHAR(30)  NOT NULL,
    `activity_type` VARCHAR(25)  NOT NULL,
    PRIMARY KEY (`ynn`),
    UNIQUE INDEX `ynn_UNIQUE` (`ynn` ASC) VISIBLE,
    UNIQUE INDEX `okpo_UNIQUE` (`okpo` ASC) VISIBLE,
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `company_db`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`address`
(
    `ynn`      INT          NOT NULL,
    `address`  VARCHAR(250) NULL DEFAULT NULL,
    `area`     VARCHAR(20)  NOT NULL,
    `district` VARCHAR(45)  NOT NULL,
    PRIMARY KEY (`ynn`),
    UNIQUE INDEX `ynn_UNIQUE` (`ynn` ASC) VISIBLE,
    CONSTRAINT `address_FK`
        FOREIGN KEY (`ynn`)
            REFERENCES `company_db`.`company` (`ynn`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `company_db`.`cattle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`cattle`
(
    `ynn`                    INT NOT NULL,
    `milk_yield`             INT NULL DEFAULT NULL,
    `average_daily_increase` INT NULL DEFAULT NULL,
    `cattle_producers`       INT NULL DEFAULT NULL,
    `cattle_cultivation`     INT NULL DEFAULT NULL,
    `current_end_balance`    INT NOT NULL,
    `prev_end_balance`       INT NULL DEFAULT NULL,
    PRIMARY KEY (`ynn`),
    UNIQUE INDEX `ynn_UNIQUE` (`ynn` ASC) VISIBLE,
    INDEX `cattle_FK_idx` (`ynn` ASC) VISIBLE,
    CONSTRAINT `cattle_FK`
        FOREIGN KEY (`ynn`)
            REFERENCES `company_db`.`company` (`ynn`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `company_db`.`coefficients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`coefficients`
(
    `ynn`                           INT    NOT NULL,
    `own_security`                  DOUBLE NOT NULL,
    `current_liquidity`             DOUBLE NOT NULL,
    `financial_security`            DOUBLE NOT NULL,
    `absolute_liquidity`            DOUBLE NULL DEFAULT NULL,
    `end_net_assets`                INT    NOT NULL,
    `begin_net_assets`              INT    NULL DEFAULT NULL,
    `profitability`                 DOUBLE NULL DEFAULT NULL,
    `profitability_without_support` DOUBLE NULL DEFAULT NULL,
    PRIMARY KEY (`ynn`),
    UNIQUE INDEX `ynn_UNIQUE` (`ynn` ASC) VISIBLE,
    INDEX `coefficients_FK_idx` (`ynn` ASC) VISIBLE,
    CONSTRAINT `coefficients_FK`
        FOREIGN KEY (`ynn`)
            REFERENCES `company_db`.`company` (`ynn`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `company_db`.`company_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`company_info`
(
    `ynn`              INT         NOT NULL,
    `industry_code`    INT         NOT NULL,
    `industry_name`    VARCHAR(70) NOT NULL,
    `department_name`  VARCHAR(55) NOT NULL,
    `association_name` VARCHAR(40) NOT NULL,
    `ownership_type`   VARCHAR(25) NOT NULL,
    PRIMARY KEY (`ynn`),
    UNIQUE INDEX `ynn_UNIQUE` (`ynn` ASC) VISIBLE,
    CONSTRAINT `additional_info_FK`
        FOREIGN KEY (`ynn`)
            REFERENCES `company_db`.`company` (`ynn`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `company_db`.`crop_production`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`crop_production`
(
    `id`              INT    NOT NULL AUTO_INCREMENT,
    `ynn`             INT    NOT NULL,
    `column_index`    INT    NOT NULL,
    `full_cost_price` DOUBLE NULL DEFAULT NULL,
    `bailed_out`      DOUBLE NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `crop_production_FK_idx` (`ynn` ASC) VISIBLE,
    CONSTRAINT `crop_production_FK`
        FOREIGN KEY (`ynn`)
            REFERENCES `company_db`.`company` (`ynn`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `company_db`.`dairy_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`dairy_products`
(
    `ynn`                    INT    NOT NULL,
    `cattle`                 DOUBLE NULL DEFAULT NULL,
    `output_dairy_products`  DOUBLE NULL DEFAULT NULL,
    `cost_dairy_products`    INT    NULL DEFAULT NULL,
    `production_growth`      DOUBLE NULL DEFAULT NULL,
    `production_cost_growth` INT    NULL DEFAULT NULL,
    PRIMARY KEY (`ynn`),
    UNIQUE INDEX `ynn_UNIQUE` (`ynn` ASC) VISIBLE,
    INDEX `dairy_products_FK_idx` (`ynn` ASC) VISIBLE,
    CONSTRAINT `dairy_products_FK`
        FOREIGN KEY (`ynn`)
            REFERENCES `company_db`.`company` (`ynn`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `company_db`.`enterprise_statistic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`enterprise_statistic`
(
    `id`                        INT NOT NULL AUTO_INCREMENT,
    `ynn`                       INT NOT NULL,
    `column_index`              INT NOT NULL,
    `number_of_enterprises`     INT NULL DEFAULT NULL,
    `amount_authorized_capital` INT NULL DEFAULT NULL,
    `share_state_ownership`     INT NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `statistic_FK` (`ynn` ASC) VISIBLE,
    CONSTRAINT `statistic_FK`
        FOREIGN KEY (`ynn`)
            REFERENCES `company_db`.`company` (`ynn`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `company_db`.`expenses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`expenses`
(
    `ynn`                INT NOT NULL,
    `labor_cost`         INT NOT NULL,
    `material_costs`     INT NOT NULL,
    `feed`               INT NULL DEFAULT NULL,
    `purchased_feed`     INT NULL DEFAULT NULL,
    `deprecation`       INT NULL DEFAULT NULL,
    `insurance_payments` INT NULL DEFAULT NULL,
    `other_costs`        INT NULL DEFAULT NULL,
    `total_costs`        INT NOT NULL,
    `planting_costs`     INT NULL DEFAULT NULL,
    PRIMARY KEY (`ynn`),
    UNIQUE INDEX `ynn_UNIQUE` (`ynn` ASC) VISIBLE,
    INDEX `expenses_FK_idx` (`ynn` ASC) VISIBLE,
    CONSTRAINT `expenses_FK`
        FOREIGN KEY (`ynn`)
            REFERENCES `company_db`.`company` (`ynn`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `company_db`.`fixed_assets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`fixed_assets`
(
    `ynn`              INT NOT NULL,
    `fixed_assets`     INT NULL DEFAULT NULL,
    `loans_borrowings` INT NULL DEFAULT NULL,
    `total_4`          INT NULL DEFAULT NULL,
    `shortterm_debt`   INT NOT NULL,
    `total_5`          INT NOT NULL,
    `sales_revenue`    INT NOT NULL,
    `profit`           INT NULL DEFAULT NULL,
    PRIMARY KEY (`ynn`),
    UNIQUE INDEX `ynn_UNIQUE` (`ynn` ASC) VISIBLE,
    INDEX `assets_FK_idx` (`ynn` ASC) VISIBLE,
    CONSTRAINT `assets_FK`
        FOREIGN KEY (`ynn`)
            REFERENCES `company_db`.`company` (`ynn`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `company_db`.`grounds`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`grounds`
(
    `id`               INT    NOT NULL AUTO_INCREMENT,
    `ynn`              INT    NOT NULL,
    `products_index`   INT    NOT NULL,
    `total_products`   DOUBLE NULL DEFAULT NULL,
    `hectare_products` DOUBLE NULL DEFAULT NULL,
    `production_cost`  DOUBLE NULL DEFAULT NULL,
    `hectare_index`    INT    NOT NULL,
    `hectare`          DOUBLE NOT NULL,
    `ballogectars`     DOUBLE NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `grounds_FK_idx` (`ynn` ASC) VISIBLE,
    CONSTRAINT `grounds_FK`
        FOREIGN KEY (`ynn`)
            REFERENCES `company_db`.`company` (`ynn`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `company_db`.`header`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`header`
(
    `id`   INT  NOT NULL AUTO_INCREMENT,
    `text` TEXT NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `company_db`.`sales_return`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`sales_return`
(
    `ynn`                       INT    NOT NULL,
    `sales_return`              DOUBLE NULL DEFAULT NULL,
    `current_dividend_payments` INT    NULL DEFAULT NULL,
    `prev_dividend_payments`    INT    NULL DEFAULT NULL,
    `total_end_debt`            INT    NOT NULL,
    `overdue_end_debt`          INT    NULL DEFAULT NULL,
    `total_begin_debt`          INT    NULL DEFAULT NULL,
    `overdue_begin_debt`        INT    NULL DEFAULT NULL,
    PRIMARY KEY (`ynn`),
    UNIQUE INDEX `ynn_UNIQUE` (`ynn` ASC) VISIBLE,
    INDEX `sales_return_FK_idx` (`ynn` ASC) VISIBLE,
    CONSTRAINT `sales_return_FK`
        FOREIGN KEY (`ynn`)
            REFERENCES `company_db`.`company` (`ynn`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `company_db`.`staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company_db`.`staff`
(
    `id`             INT    NOT NULL AUTO_INCREMENT,
    `ynn`            INT    NOT NULL,
    `column_index`   INT    NOT NULL,
    `average_number` INT    NULL DEFAULT NULL,
    `salary_fund`    DOUBLE NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `staff_FK_idx` (`ynn` ASC) VISIBLE,
    CONSTRAINT `staff_FK`
        FOREIGN KEY (`ynn`)
            REFERENCES `company_db`.`company` (`ynn`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `company_db`.`correlation`
(
    `ynn`                              INT    NOT NULL,
    `profit_and_net_discounted`        DOUBLE NULL,
    `profit_and_cost_recovery`         DOUBLE NULL,
    `profit_and_profitability`         DOUBLE NULL,
    `net_discounted_and_cost_recovery` DOUBLE NULL,
    `net_discounted_and_profitability` DOUBLE NULL,
    `cost_recovery_and_profitability`  DOUBLE NULL,
    PRIMARY KEY (`ynn`),
    UNIQUE INDEX `ynn_UNIQUE` (`ynn` ASC) VISIBLE,
    CONSTRAINT `correlation_FK`
        FOREIGN KEY (`ynn`)
            REFERENCES `company_db`.`company` (`ynn`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;
