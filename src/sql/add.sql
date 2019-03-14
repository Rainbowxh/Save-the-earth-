-- add a room

INSERT INTO `room` (`room_uuid`, `user_uuid`, `room_describtion`, `room_belong`, `room_longitude`, `room_latitude`) VALUES ('A0930302', '1553118', '这是一个四人寝室`', b'1', '127.333333', '21.444444');
INSERT INTO `room` (`room_uuid`, `user_uuid`, `room_describtion`, `room_belong`, `room_longitude`, `room_latitude`) VALUES ('A0930301', '1553117', '这是旭东的小房间', b'0', '123.334343', '121.343333');
INSERT INTO `facility` (`facility_id`, `facility_name`, `facility_type`, `facility_describtion`, `facility_strart`, `facility_end`, `latitude`, `longitude`) VALUES ('Room123', '点灯', '室内', '这是一盏灯', CURRENT_TIMESTAMP, NULL, NULL, NULL);

-- add foreign key
ALTER TABLE `parkingSpace` ADD CONSTRAINT `user_uuid` FOREIGN KEY (`user_uuid`) REFERENCES `user`(`uesr_uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `parkingSpace` ADD CONSTRAINT `parking_user_uuid` FOREIGN KEY (`user_uuid`) REFERENCES `user`(`uesr_uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `parkingSpace` ADD CONSTRAINT `parking_user_uuid` FOREIGN KEY (`user_uuid`) REFERENCES `user`(`user_uuid`) ON DELETE RESTRICT ON UPDATE RESTRICT;