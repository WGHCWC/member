
#com.mysql.cj.jdbc.ClientPreparedStatement: update MemberInfo  set level='-1' ,name='问问二位we',address='为为w为', background='为为w我',introduce='二位我w' password='ddd'where mail='1@1.com';
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
insert into MemberInfo values (1,'admin','ZQ','北京','群众','1@1.com','admin','master');

insert into MemberInfo values (2,'admin','张三','苏州','群众','1@2.com','admin','master');

update MemberInfo  set level='user' where mail='1@1.com';


##############################会议申报
DROP TABLE IF EXISTS `Meeting`;
CREATE TABLE `Meeting`
(
    `id`          int(10)    COLLATE utf8_bin not null auto_increment,
    `name`       varchar(50)  COLLATE utf8_bin not null ,
    `address`    varchar(500) COLLATE utf8_bin not null,
    `mail`       varchar(50)  COLLATE utf8_bin NOT NULL,
    `introduce` varchar(500) COLLATE utf8_bin,
    `day` varchar(50) COLLATE utf8_bin,
    `startTime` varchar(50) COLLATE utf8_bin,
    `endTime`    varchar(50) default '0' COLLATE utf8_bin not null ,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

insert into Meeting set name='安全会议',address='中央大厅',mail='101@.com',introduce='test',day='2019-1-1',startTime='08:00',endTime='9:00';

select * from Meeting;

############################通知消息
DROP TABLE IF EXISTS `Message`;
CREATE TABLE `Message`
(
    `id`          int(10)    COLLATE utf8_bin not null auto_increment,
    `date`       varchar(20)  COLLATE utf8_bin not null ,
    `title`    varchar(50) COLLATE utf8_bin not null,
    `details`       varchar(5000)  COLLATE utf8_bin NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

insert into Message set title='中央大厅',date='2018-02-10',details=' 　时值清明，在中国传统文化里，清明节体现着饮水思源等意义。共和国是红色的，没有英烈的抛头颅洒热血，就没有如今国家的昌盛、人民的幸福。今年清明节，各地广泛开展以“慎终追远，';


select * from Message;



############################### 文章评审

DROP TABLE IF EXISTS `Article`;
CREATE TABLE `Article`
(
    `id`          int(10)    COLLATE utf8_bin not null auto_increment,
    `title`       varchar(50)  COLLATE utf8_bin not null ,
    `mail`       varchar(50)  COLLATE utf8_bin not null ,
    `author`    varchar(50) COLLATE utf8_bin not null,
    `address`       varchar(50)  COLLATE utf8_bin NOT NULL,
    `introduce`    varchar(1000) COLLATE utf8_bin not null ,
    `times`    int(10) default 0 COLLATE utf8_bin not null ,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;


insert into Article set title='中央大厅',mail='101@.com',author='张三',address='http://www.baidu.com',introduce="hello";
DELETE FROM Article WHERE id=1;
select * from Article;

# DROP TABLE IF EXISTS `Message`;
# CREATE TABLE `Message`
# (
#     `id`          int(10)    COLLATE utf8_bin not null auto_increment,
#     `date`        varchar(20)  not null ,
#     `title`       varchar(50)  COLLATE utf8_bin not null ,
#     `details`       varchar(5000)  COLLATE utf8_bin NOT NULL,
#     PRIMARY KEY (`id`)
# ) ENGINE = InnoDB
#   AUTO_INCREMENT = 1
#   DEFAULT CHARSET = utf8
#   COLLATE = utf8_bin;
DROP TABLE IF EXISTS `Message`;
CREATE TABLE `Message`
(
    `id`          int(10)    COLLATE utf8_bin not null auto_increment,
    `date`       varchar(20)  COLLATE utf8_bin not null ,
    `title`    varchar(50) COLLATE utf8_bin not null,
    `details`       varchar(5000)  COLLATE utf8_bin NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;
insert  into Message set date='2018-10-09',title='hello',details='你好';

insert into Message set title='中央大厅',date='2018-02-10',details='时值清明，在中国传统文化里，清明节体现着饮水思源等意义。共和国是红色的，没有英烈的抛头颅洒热血，就没有如今国家的昌盛、人民的幸福。今年清明节，各地广泛开展以慎终追远';

