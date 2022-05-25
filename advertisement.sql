-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 16, 2022 lúc 05:45 AM
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
-- Cấu trúc bảng cho bảng `advertisement`
--

CREATE TABLE `advertisement` (
  `banner_id` bigint(20) NOT NULL,
  `image` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `link` varchar(70) COLLATE utf8_unicode_ci DEFAULT NULL,
  `from_date` datetime NOT NULL,
  `to_date` datetime NOT NULL,
  `created_date` datetime NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `advertisement`
--

INSERT INTO `advertisement` (`banner_id`, `image`, `link`, `from_date`, `to_date`, `created_date`, `status`) VALUES
(1, 'may-rua-xe-336x280_1.png', 'https://meta.vn/may-rua-xe-c817', '2022-05-02 12:58:45', '2022-07-01 17:58:45', '2022-05-02 12:58:45', 1),
(2, 'may-pha-ca-phe-336x280-a.png', 'https://meta.vn/may-pha-ca-phe-c581', '2022-05-02 13:05:11', '2022-07-01 18:05:12', '2022-05-02 13:05:11', 1),
(3, 'noi-u-nhiet-336x280_1.png', 'https://meta.vn/timkiem.html?q=noi-u-nhiet', '2022-05-02 13:06:24', '2022-08-06 18:06:25', '2022-05-02 13:06:24', 1),
(4, 'Banner-tu-lanh-336x280_1.png', 'https://meta.vn/timkiem.html?q=Banner-tu-lanh', '2022-05-02 16:43:04', '2022-07-31 21:43:05', '2022-05-02 16:43:04', 1),
(6, 'Payment_MoMo.png', 'https://momo.vn/', '2022-05-14 00:00:00', '2022-05-14 00:00:00', '2022-05-14 00:00:00', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `advertisement`
--
ALTER TABLE `advertisement`
  ADD PRIMARY KEY (`banner_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `advertisement`
--
ALTER TABLE `advertisement`
  MODIFY `banner_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
