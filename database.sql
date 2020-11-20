DROP TABLE `software`.`menu`;
CREATE TABLE `software`.`menu` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `foodname` VARCHAR(45) NULL,
  `foodtype` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `software`.`menu` (`foodname`, `foodtype`) VALUES ('food1', 'A');
INSERT INTO `software`.`menu` (`foodname`, `foodtype`) VALUES ('food2', 'B');
INSERT INTO `software`.`menu` (`foodname`, `foodtype`) VALUES ('food3', 'C');
INSERT INTO `software`.`menu` (`foodname`, `foodtype`) VALUES ('food4', 'B');

DROP TABLE `software`.`nutrition`;
CREATE TABLE `software`.`nutrition` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fid` INT NULL,
  `protein` INT NULL,
  `calorie` INT NULL,
  `fat` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_Reference_1` (`fid` ASC) INVISIBLE,
  CONSTRAINT `FK_Reference_1`
    FOREIGN KEY (`fid`)
    REFERENCES `software`.`menu` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `software`.`nutrition` (`fid`, `protein`, `calorie`, `fat`) VALUES ('1', '1', '1', '1');
INSERT INTO `software`.`nutrition` (`fid`, `protein`, `calorie`, `fat`) VALUES ('2', '2', '0', '1');
INSERT INTO `software`.`nutrition` (`fid`, `protein`, `calorie`, `fat`) VALUES ('3', '1', '0', '2');
INSERT INTO `software`.`nutrition` (`fid`, `protein`, `calorie`, `fat`) VALUES ('4', '0', '1', '0');

DROP TABLE `software`.`record`;
CREATE TABLE `software`.`record` (
  `idrecord` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NULL,
  PRIMARY KEY (`idrecord`),
  INDEX `FK_Reference_2` (`fname` ASC) VISIBLE,
  CONSTRAINT `FK_Reference_2`
    FOREIGN KEY (`fname`)
    REFERENCES `software`.`menu` (`foodname`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `software`.`record` (`fname`) VALUES ('food1');
INSERT INTO `software`.`record` (`fname`) VALUES ('food2');
INSERT INTO `software`.`record` (`fname`) VALUES ('food1');
INSERT INTO `software`.`record` (`fname`) VALUES ('food4');
