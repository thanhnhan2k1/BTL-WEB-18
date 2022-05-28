--
-- data in table 'room_hotel'
--
INSERT INTO `qlks`.`room_hotel` (`code`, `name`, `type`, `price`, `room_img`) VALUES ('1', 'Spring', 'Single Room', '100', 'image/r1.jpg');
INSERT INTO `qlks`.`room_hotel` (`code`, `name`, `type`, `price`, `room_img`, `saleoff`) VALUES ('2', 'Summer', 'Single Room', '120', 'image/r2.jpg', '0');
INSERT INTO `qlks`.`room_hotel` (`code`, `name`, `type`, `price`, `room_img`, `saleoff`) VALUES ('3', 'Autumn', 'Double Room', '200', 'image/r3.jpg', '0.2');
INSERT INTO `qlks`.`room_hotel` (`code`, `name`, `type`, `price`, `room_img`, `saleoff`) VALUES ('4', 'Winter', 'Double Room', '190', 'image/r4.jpg', '0.1');
INSERT INTO `qlks`.`room_hotel` (`code`, `name`, `type`, `price`, `room_img`, `saleoff`) VALUES ('5', 'Spring 1', 'Double Room', '200', 'image/r5.jpg', '0');
INSERT INTO `qlks`.`room_hotel` (`code`, `name`, `type`, `price`, `room_img`, `saleoff`) VALUES ('6', 'Summer 1', 'Single Room', '100', 'image/r6.jpg', '0');
INSERT INTO `qlks`.`room_hotel` (`code`, `name`, `type`, `price`, `room_img`, `saleoff`) VALUES ('7', 'Autumn 1', 'Double Room', '200', 'image/r7.jpg', '0');
INSERT INTO `qlks`.`room_hotel` (`code`, `name`, `type`, `price`, `room_img`, `saleoff`) VALUES ('8', 'Winter 1', 'Single Room', '120', 'image/r8.jpg', '0.2');
INSERT INTO `qlks`.`room_hotel` (`code`, `name`, `type`, `price`, `room_img`, `saleoff`) VALUES ('9', 'Spring 2', 'Double Room', '210', 'image/r9.jpg', '0.1');
INSERT INTO `qlks`.`room_hotel` (`code`, `name`, `type`, `price`, `room_img`, `saleoff`) VALUES ('10', 'Summer 2', 'Single Room', '100', 'image/r10.jpg', '0.1');
INSERT INTO `qlks`.`room_hotel` (`code`, `name`, `type`, `price`, `room_img`, `saleoff`) VALUES ('11', 'Autumn 2', 'Single Room', '90', 'image/r10.jpg', '0.2');
--
-- data in table 'user_hotel'
--
INSERT INTO `user_hotel` VALUES (7,'Nguyen Thi Thai','Ha Nam','0348292974','thaithai@gmail.com','thaithai','thai123',1,'2001-05-10'),(8,'Hoang Van Nam','Ha Noi',
'0973829302','namhoang@gmail.com','admin','admin',0,'2000-10-05'),(9,'Nguyễn Thị Thanh Nhàn','Ha Noi','0123489222','thanhnhan2k1@gmail.com','thanhnhan','123456',1,'2001-05-18');
INSERT INTO `qlks`.`user_hotel` (`id`, `name`, `address`, `phone`, `email`, `username`, `password`, `role`, `dob`) VALUES ('1', 'Trần Thanh Vân', 'Đà Nẵng', '0987654321', 'van@gmail.com', 'van123', '123456', '1', '1999-12-11');
INSERT INTO `qlks`.`user_hotel` (`id`, `name`, `address`, `phone`, `email`, `username`, `password`, `role`, `dob`) VALUES ('2', 'Đinh Thành Vinh', 'Tuyên Quang', '0100281839', 'e@gmail.com', 'vinh123', '123456', '1', '2000-03-15');
INSERT INTO `qlks`.`user_hotel` (`id`, `name`, `address`, `phone`, `email`, `username`, `password`, `role`, `dob`) VALUES ('3', 'Trần Ngọc Hoài', 'Quảng Bình', '0987651234', 'd@gmail.com', 'h123', '123456', '1', '2001-12-11');
INSERT INTO `qlks`.`user_hotel` (`id`, `name`, `address`, `phone`, `email`, `username`, `password`, `role`, `dob`) VALUES ('4', 'Nguyễn Văn Trưởng', 'Tp HCM', '0123456789', 'c@gmail.com', 'tr123', '123456', '1', '1997-07-11');
INSERT INTO `qlks`.`user_hotel` (`id`, `name`, `address`, `phone`, `email`, `username`, `password`, `role`, `dob`) VALUES ('5', 'Phạm Ngọc Hân', 'Nha Trang', '0383700383', 'b@gmail.com', 'han123', '123456', '1', '1999-12-01');
INSERT INTO `qlks`.`user_hotel` (`id`, `name`, `address`, `phone`, `email`, `username`, `password`, `role`, `dob`) VALUES ('6', 'Trần Ngọc Ánh', 'Ninh Bình', '013400382', 'a@gmail.com', 'anh123', '123456', '0', '1998-12-11');
--
-- data in table 'cart'
--
INSERT INTO `cart` VALUES (32,201,NULL);
--
-- data in table 'oder_details'
--

