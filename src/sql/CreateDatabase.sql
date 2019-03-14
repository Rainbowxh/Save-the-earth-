CREATE TABLE room (
  `room_uuid`       VARCHAR(32) COMMENT '房间Id'  NOT NULL,
  `user_uuid`       BIGINT COMMENT '用户Id' ,
  `room_describtion`  VARCHAR(250) COMMENT '房间描述',
  `room_belong` BIT COMMENT '是否所属',
  `room_longitude` double(10,6) COMMENT '房间经度',
  `room_latitude` double(10,6) COMMENT '房间维度',
  PRIMARY KEY room(room_uuid)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '房间表';


CREATE TABLE `FinalPaper`.`record` (
`record_id` VARCHAR(30) NOT NULL COMMENT '记录编号' ,
`user_uuid` BIGINT  COMMENT '用户id' ,
 `item_id` VARCHAR(30)  COMMENT '物品id' ,
 `record_type` VARCHAR(30)  COMMENT '记录类型' ,
 `record_describtion` VARCHAR(500)  COMMENT '记录描述' ,
 `record_startTime` DATETIME  DEFAULT CURRENT_TIMESTAMP COMMENT '记录开始时间' ,
  `record_endTime` DATATIME  COMMENT '记录截止时间'
  , `record_finish` BIT DEFAULT b'0' COMMENT '是否被完成' ,
  PRIMARY KEY (`record_id`)
  ) ENGINE = InnoDB CHARSET=utf8
   COLLATE utf8_unicode_ci COMMENT = '记录表';

CREATE TABLE `FinalPaper`. `user`(
 `uesr_uuid` BIGINT NOT NULL  AUTO_INCREMENT COMMENT '用户id';,
 `user_name` VARCHAR(30) NULL COMMENT '用户姓名' ,
 `user_type` INT NULL COMMENT '用户类型' ,
 `user_telephone` INT NULL COMMENT '用户手机' ,
 `user_email` VARCHAR(50) NULL COMMENT '用户邮箱' CHECK (`user_email` like '%@%'),
 `user_describtion` VARCHAR(500) NULL COMMENT '用户描述' ,
 `property` DECIMAL NULL COMMENT '用户资产数目' ,
 PRIMARY KEY (`uesr_uuid`)
 ) ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_unicode_ci COMMENT = '用户';

CREATE TABLE `FinalPaper`.`facility` (
`facility_id` VARCHAR(30) NULL COMMENT '设备id' ,
`facility_name` VARCHAR(30) NOT NULL COMMENT '设备名称' ,
`facility_type` VARCHAR(30) NULL COMMENT '设备类型' ,
`facility_describtion` VARCHAR(500) NULL COMMENT '设备描述' ,
`facility_start` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '设备起始时间' ,
`facility_end` DATETIME NULL COMMENT '设备终止时间' , `latitude` FLOAT NULL COMMENT '纬度' ,
`longitude` FLOAT NULL COMMENT '经度' )
ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_unicode_ci COMMENT = '设备表';


CREATE TABLE `FinalPaper`.`parkingSpace` (
`parking_id` VARCHAR(30) NOT NULL COMMENT '停车位编号' ,
`parking_user` VARCHAR(30) NULL COMMENT '停车位用户' ,
`parking_type` VARCHAR(30) NULL COMMENT '停车位类型' ,
`parking_describtion` VARCHAR(500) NULL COMMENT '停车位描述' ,
`parking_belong` BIT NULL DEFAULT b'0' COMMENT '停车位是否所属' ,
 `latitude` FLOAT NULL COMMENT '纬度' ,
 `longitude` FLOAT NULL COMMENT '经度' ,
 PRIMARY KEY (`parking_id`))
 ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_unicode_ci COMMENT = '停车位';


CREATE TABLE `FinalPaper`.`transaction` (
`transaction_id` VARCHAR(30) NOT NULL COMMENT '交易编号' ,
`transaction_from` VARCHAR(30) NOT NULL COMMENT '交易发起者' ,
`transaction_to` VARCHAR(30) NOT NULL COMMENT '交易接受者' ,
`transaction_amount` INT NOT NULL COMMENT '交易数量' ,
`transaction_describtion` VARCHAR(500)  COMMENT '交易描述',
`transaction_start` DATETIME  DEFAULT CURRENT_TIMESTAMP COMMENT '交易开始' ,
`transaction_end` DATETIME  COMMENT '交易截止' )
ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_unicode_ci COMMENT = '交易表';


CREATE TABLE `FinalPaper`.`worker` (
`worker_id` VARCHAR(30) NOT NULL COMMENT '工作编号' ,
`worker_type` VARCHAR(30) NULL COMMENT '工作类型' ,
`worker_email` VARCHAR(50) NULL COMMENT '工作邮箱' ,
`worker_telephone` VARCHAR(30) NOT NULL COMMENT '工作电话' ,
`worker_describtion` VARCHAR(500) NOT NULL COMMENT '工作描述' ,
`worker_on` BIT NULL DEFAULT b'0' COMMENT '工作安排' ,
PRIMARY KEY (`worker_id`)
) ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_unicode_ci COMMENT = '工作者表';
ALTER TABLE `worker` ADD `worker_name` VARCHAR(30) NOT NULL COMMENT '工作名字' AFTER `worker_id`;

CREATE TABLE `FinalPaper`.`building` (
`building_id` INT NOT NULL AUTO_INCREMENT COMMENT '楼房id' ,
`building_name` VARCHAR(30) NOT NULL ,
`building_description` VARCHAR(500) NULL ,
`latitude` FLOAT NULL ,
`longitude` FLOAT NULL ,
PRIMARY KEY (`building_id`)) ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_unicode_ci COMMENT = '楼房表';


ALTER TABLE `building` ADD UNIQUE(`building_name`);
ALTER TABLE `room` ADD CONSTRAINT `building_id` FOREIGN KEY (`building_id`) REFERENCES `building`(`building_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TRIGGER `updateFacilityType` AFTER INSERT ON `record`
 FOR EACH ROW update facility set facility.facility_type = new.record_type WHERE facility.facility_id  = new.facility_id