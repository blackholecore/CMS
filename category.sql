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
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `category_id` bigint(20) NOT NULL,
  `cat_title` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `slug` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `icon` varchar(70) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`category_id`, `cat_title`, `slug`, `icon`) VALUES
(1, 'Đồ ăn', 'food', 'do-an.jpg'),
(2, 'Nấu ăn', 'cooking', 'nau-an.jpg'),
(3, 'Phong cách sống', 'life-style', 'phong-cach-song.jpg'),
(4, 'Trò chơi', 'game', 'tro-choi.jpg'),
(5, 'Thể thao', 'sport', 'the-thao.jpg'),
(6, 'Windows 11', 'windows-11', 'win-11.jpg'),
(7, 'Cuộc sống', 'cuoc-song', 'cuoc-song.jpg'),
(8, 'AI - MACHINE LEARNING', 'ai-machine-learning', 'ai.jpg'),
(9, 'Video, phim, nhạc', 'video-phim-nhac', 'video-phim.jpg'),
(10, 'Internet', 'internet', 'internet.jpg'),
(11, 'Công nghệ', 'cong-nghe', 'cong-nghe.jpg'),
(12, 'CategoryBot', 'categorybot', 'Florentino.jpg'),
(14, 'Test1', 'test1', ''),
(15, 'Test2', 'test2', 'sharingan.jpg'),
(16, 'Test3', 'test4', 'sharingan.jpg'),
(17, 'Test4', 'test4', 'sharingan.jpg'),
(18, 'Test5', 'test5', 'sharingan.jpg');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `category_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
