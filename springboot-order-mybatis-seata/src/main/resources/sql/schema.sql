-- CREATE TABLE 'dept' (
--     'id' int(11) NOT NULL AUTO INCREMENT ,
--     'dept_name' varchar(256) DEFAULT NULL,
--     PRIMARY KEY ('id')
-- ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8


-- the table to store BranchSession data
CREATE TABLE IF NOT EXISTS `dept`
(
    `id`         INT(11)       NOT NULL ,
    `dept_name`  VARCHAR(128)  DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

-- INSERT INTO 'dept' values('1','经理');
insert into dept values(1,"经理");
insert into dept values(2,"项目经理");


CREATE TABLE IF NOT EXISTS `user_info`
(
    `user_id`           INT(11)       NOT NULL ,
    `user_name`         VARCHAR(64)   DEFAULT NULL,
    PRIMARY KEY (`user_id`)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

-- INSERT INTO 'dept' values('1','经理');
insert into user_info values(1,"高进军");
insert into user_info values(2,"高义卓");

