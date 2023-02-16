-- CREATE TABLE 'dept' (
--     'id' int(11) NOT NULL AUTO INCREMENT ,
--     'dept_name' varchar(256) DEFAULT NULL,
--     PRIMARY KEY ('id')
-- ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8


-- the table to store BranchSession data
CREATE TABLE IF NOT EXISTS `order_info`
(
    `order_id`          INT(11)       NOT NULL ,
    `goods_id`          INT(11)       NOT NULL,
    `order_name`        VARCHAR(128)  NOT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

insert into order_info values(1,1,'订单1');
insert into order_info values(2,2,'订单2');


CREATE TABLE IF NOT EXISTS `stock_info`
(
    `goods_id`                  INT(11)       NOT NULL ,
    `total_number`              INT(11)       NOT NULL,
    PRIMARY KEY (`goods_id`)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

insert into stock_info values(1,100);
insert into stock_info values(2,200);

