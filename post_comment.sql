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
-- Cấu trúc bảng cho bảng `post_comment`
--

CREATE TABLE `post_comment` (
  `post_comment_id` bigint(20) NOT NULL,
  `comment_title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `updatedAt` datetime NOT NULL,
  `published` tinyint(1) NOT NULL,
  `publishedAt` datetime NOT NULL,
  `content` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `post_id` bigint(20) NOT NULL,
  `comment_email` varchar(254) COLLATE utf8_unicode_ci DEFAULT NULL,
  `comment_website` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `comment_fullname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `post_comment`
--

INSERT INTO `post_comment` (`post_comment_id`, `comment_title`, `updatedAt`, `published`, `publishedAt`, `content`, `post_id`, `comment_email`, `comment_website`, `comment_fullname`) VALUES
(1, 'Botcomment', '2022-04-07 16:37:08', 1, '2022-04-07 16:37:08', 'First Comment!', 36, 'kiemtienonline2357@gmail.com', 'huynh.it.24@gmail.com', 'Admin'),
(2, 'Bài viết hay', '2022-05-02 13:07:00', 1, '2022-05-02 13:07:00', 'Bài viết hay quá! Mong thớt viết nhiều bài hay hơn nữa!', 6, 'nguoidoc123@yahoo.com', NULL, NULL),
(3, 'Test Comment', '2022-05-14 00:00:00', 1, '2022-05-14 00:00:00', '<p>Test</p>\r\n', 45, 'huynh.it.24@gmail.com', 'http://huynhit24-001-site1.btempurl.com/', 'Nguyá»n VÄn Huá»³nh'),
(4, 'Test Comment 2', '2022-05-14 00:00:00', 0, '2022-05-14 00:00:00', '<p>Test</p>\r\n', 45, 'huynh.it.24@gmail.com', 'http://huynhit24-001-site1.btempurl.com/', 'Nguyễn Văn Huỳnh');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `post_comment`
--
ALTER TABLE `post_comment`
  ADD PRIMARY KEY (`post_comment_id`),
  ADD KEY `post_id` (`post_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `post_comment`
--
ALTER TABLE `post_comment`
  MODIFY `post_comment_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `post_comment`
--
ALTER TABLE `post_comment`
  ADD CONSTRAINT `post_comment_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
