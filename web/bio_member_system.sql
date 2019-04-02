

SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `MemberInfo`;
CREATE TABLE `MemberInfo`
(
    `id`         int(10)                  NOT NULL AUTO_INCREMENT,
    `level`      varchar(10)                  NOT NULL,
    `name`       varchar(50)  COLLATE utf8_bin,
    `address`    varchar(500) COLLATE utf8_bin,
    `background` varchar(20)  COLLATE utf8_bin,
    `mail`       varchar(50)  COLLATE utf8_bin NOT NULL,
    `password`  varchar(50) COLLATE utf8_bin NOT NULL,
    `introduce` varchar(500) COLLATE utf8_bin,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;
insert into MemberInfo values (1,'admin','ZQ','苏州','群众','1@1.com','admin','master');

insert into MemberInfo values (2,'admin','ZQ','苏州','群众','1@2.com','admin','master');
#  insert into MemberInfo set level=?,name=?,address=?,background=?,mail=?,password=?;


##会议申报
DROP TABLE IF EXISTS `Meeting`;
CREATE TABLE `Meeting`
(
    `id`          int(10)    COLLATE utf8_bin not null auto_increment,
    `name`       varchar(50)  COLLATE utf8_bin not null ,
    `address`    varchar(500) COLLATE utf8_bin not null,
    `mail`       varchar(50)  COLLATE utf8_bin NOT NULL,
    `introduce` varchar(500) COLLATE utf8_bin,
    `status`    varchar(10) default '0' COLLATE utf8_bin not null ,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

insert into Meeting set name='安全会议',address='中央大厅',mail='101@.com',introduce='test';
select * from Meeting;

update Meeting  set status='-1' where id=1;