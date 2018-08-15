CREATE TABLE `taximanage`.`manager` (
  `account` VARCHAR(20) NOT NULL DEFAULT '账号',
  `pwd` VARCHAR(45) NULL DEFAULT '密码',
  PRIMARY KEY (`account`));

CREATE TABLE `taximanage`.`driver` (
  `did` INT NOT NULL,
  `idno` VARCHAR(45) NULL,
  `dname` VARCHAR(45) NULL,
  `sex` VARCHAR(3) NULL,
  `driveage` INT NULL,
  `carid` INT NULL,
  `licenceid` VARCHAR(45) NULL,
  `licencedate` VARCHAR(45) NULL,
  `isallow` INT NULL,
  PRIMARY KEY (`did`));


CREATE TABLE `taximanage`.`car` (
  `carid` INT NOT NULL,
  `cartype` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `buydate` VARCHAR(45) NULL,
  `carstate` VARCHAR(45) NULL,
  `isRent` INT NULL,
  PRIMARY KEY (`carid`));

CREATE TABLE `taximanage`.`rentmessage` (
  `rentid` INT NOT NULL,
  `did` INT NULL,
  `carid` INT NULL,
  `begindate` VARCHAR(45) NULL,
  `enddate` VARCHAR(45) NULL,
  `money` VARCHAR(45) NULL,
  `bmoney` VARCHAR(45) NULL,
  PRIMARY KEY (`rentid`));


CREATE TABLE `taximanage`.`illegalnotes` (
  `illegalid` INT NOT NULL,
  `did` INT NULL,
  `carid` INT NULL,
  `punishment` VARCHAR(45) NULL,
  `illegaldate` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `detail` VARCHAR(45) NULL,
  PRIMARY KEY (`illegalid`));


INSERT INTO `taximanage`.`manager` (`account`, `pwd`) VALUES ('jswang', '123');

INSERT INTO `taximanage`.`car` (`carid`, `cartype`, `color`, `buydate`, `carstate`, `isRent`) VALUES ('1', '奔驰', '黑色', '2018-01-02', '良好', '0');
INSERT INTO `taximanage`.`car` (`carid`, `cartype`, `color`, `buydate`, `carstate`, `isRent`) VALUES ('2', '宝马', '白色', '2018-02-01', '全新', '0');
INSERT INTO `taximanage`.`car` (`carid`, `cartype`, `color`, `buydate`, `carstate`, `isRent`) VALUES ('3', '奥迪', '银色', '2018-03-01', '良好', '0');


INSERT INTO `taximanage`.`driver` (`did`, `idno`, `dname`, `sex`, `driveage`, `carid`, `licenceid`, `licencedate`, `isallow`) VALUES ('1', '0001', '张三', '男', '5', '1', '1234', '2020-12-01', '1');
INSERT INTO `taximanage`.`driver` (`did`, `idno`, `dname`, `sex`, `driveage`, `carid`, `licenceid`, `licencedate`, `isallow`) VALUES ('2', '0002', '李四', '女', '15', '2', '4321', '2025-01-01', '1');
