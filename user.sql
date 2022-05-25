-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 16, 2022 lúc 05:46 AM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `weblog`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `fullname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` datetime DEFAULT current_timestamp(),
  `gender` tinyint(1) DEFAULT 1,
  `address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(254) COLLATE utf8_unicode_ci NOT NULL,
  `mobile` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `avatar` varchar(70) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1,
  `isMember` tinyint(1) NOT NULL DEFAULT 1,
  `isAdmin` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`user_id`, `fullname`, `birthday`, `gender`, `address`, `email`, `mobile`, `password`, `avatar`, `status`, `isMember`, `isAdmin`) VALUES
(2, 'Nguyễn Văn Huỳnh', '2022-03-20 22:38:41', 1, 'Đồng Nai', 'huynh.it.24@gmail.com', '0365204529', '57186e8e34491d7883851f128596219c', 'Florentino.jpg', 1, 0, 1),
(3, 'Nguyễn Lê Đắc Lộc', '2001-03-24 11:20:44', 1, 'Sài Gòn', 'dacloc@gmail.com', '03882432434', '5bf4530dbd016e140a83396087e9f0a8', 'Florentino.jpg', 1, 0, 1),
(4, 'Nguyễn Đặng Anh Khoa', '2022-03-23 23:31:20', 1, 'Kontum', 'khoaruoi69@gmail.com', NULL, 'e1ca5376d6f2b16dda39563d8690a67c', 'Florentino.jpg', 1, 1, 1),
(5, 'Nguyễn Đức Đạt', '2022-03-23 23:36:10', 1, 'Bình Phước', 'ducdat69@gmail.com', NULL, 'e7083024a5377b29ebd2396e6948dfa5', 'Florentino.jpg', 1, 1, 0),
(6, 'ABC', '2022-03-29 09:32:19', 1, NULL, 'abc@gmail.com', NULL, '202cb962ac59075b964b07152d234b70', 'Florentino.jpg', 0, 1, 0),
(7, 'Trần Thanh Phước', '2022-03-29 17:41:04', 1, NULL, 'thanhphuoc@gmail.com', NULL, '202cb962ac59075b964b07152d234b70', 'Florentino.jpg', 1, 1, 0),
(8, 'Nguyễn Bùi Hoàng Phước', '2022-03-29 17:50:37', 1, NULL, 'phuocbui@gmail.com', NULL, '81dc9bdb52d04dc20036dbd8313ed055', 'Florentino.jpg', 1, 1, 0),
(9, 'Nguyễn Văn Huỳnh', '2022-03-29 17:53:55', 1, NULL, 'kiemtienonline2357@gmail.com', NULL, '634e9c96c5332ae7b6c95a03e7ce3db9', 'Florentino.jpg', 1, 1, 0),
(10, 'John', '2022-03-29 18:36:30', 1, NULL, 'john@gmail.com', NULL, '202cb962ac59075b964b07152d234b70', 'Florentino.jpg', 1, 1, 0),
(11, 'AccDemo1', '2022-05-05 00:00:00', 1, '3690, tá» 4, áº¥p PhÃº LÃ¢m 1, xÃ£ PhÃº SÆ¡n, huyá»n TÃ¢n PhÃº, tá»nh Äá»ng Nai', 'accdemo1@gmail.com', '0365204529', '8c4edc215974b2f1a22ffc62640baddd', 'Florentino.jpg', 1, 1, 1),
(12, 'AccDemo2', '2022-05-05 00:00:00', 1, '3690, tá» 4, áº¥p PhÃº LÃ¢m 1, xÃ£ PhÃº SÆ¡n, huyá»n TÃ¢n PhÃº, tá»nh Äá»ng Nai', 'accdemo2@gmail.com', '0365204529', 'ad4f0a8f32e116613f3dfbf5fd017043', 'Florentino.jpg', 1, 1, 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
