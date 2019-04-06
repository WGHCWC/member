
com.mysql.cj.jdbc.ClientPreparedStatement: update MemberInfo  set level='-1' ,name='问问二位we',address='为为w为', background='为为w我',introduce='二位我w' password='ddd'where mail='1@1.com';
SET FOREIGN_KEY_CHECKS = 0;

################会员管理
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

update MemberInfo  set level='-1' ,name='ww',address='sss', background='ddd',password='ddd',introduce='dd' where mail='1@1.com';


##############################会议申报
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

update Meeting  set status='-1' where id=1;
select * from Meeting;

############################通知消息
DROP TABLE IF EXISTS `Message`;
CREATE TABLE `Message`
(
    `id`          int(10)    COLLATE utf8_bin not null auto_increment,
    `title`       varchar(50)  COLLATE utf8_bin not null ,
    `author`    varchar(50) COLLATE utf8_bin not null,
    `main`       varchar(5000)  COLLATE utf8_bin NOT NULL,
    `status`    varchar(10) default '0' COLLATE utf8_bin not null ,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

insert into Message set title='中央大厅',author='101@.com',main='test';

update Message  set status='-1' where id=1;
select * from Message;
DELETE FROM Message WHERE id=1;
select * from Message;


############################### 文章评审

DROP TABLE IF EXISTS `Article`;
CREATE TABLE `Article`
(
    `id`          int(10)    COLLATE utf8_bin not null auto_increment,
    `times`        int(10) default 0 not null ,
    `title`       varchar(50)  COLLATE utf8_bin not null ,
    `author`    varchar(50) COLLATE utf8_bin not null,
    `main`       varchar(5000)  COLLATE utf8_bin NOT NULL,
    `status`    varchar(10) default '0' COLLATE utf8_bin not null ,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;


insert into Article set title='中央大厅',author='101@.com',main='test';
insert into Article set title='中央大厅',author='101@.com',main='test';
update Article  set status='-1' where id=1;
DELETE FROM Article WHERE id=1;
select * from Article;