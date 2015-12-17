-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2015 年 07 月 06 日 12:12
-- 服务器版本: 5.5.20
-- PHP 版本: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `dms`
--
CREATE DATABASE `dms` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `dms`;

-- --------------------------------------------------------

--
-- 表的结构 `adm`
--

CREATE TABLE IF NOT EXISTS `adm` (
  `adm_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pwd` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`adm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `adm`
--

INSERT INTO `adm` (`adm_id`, `pwd`, `name`) VALUES
('123', '123', '测试者');

-- --------------------------------------------------------

--
-- 表的结构 `bring_out`
--

CREATE TABLE IF NOT EXISTS `bring_out` (
  `things_id` int(20) NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`things_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `bring_out`
--

INSERT INTO `bring_out` (`things_id`, `stu_id`, `date`, `name`) VALUES
(1, '20131003764', '2015-08-06', '巧克力'),
(2, '20131003766', '2015-09-06', '电锯');

-- --------------------------------------------------------

--
-- 表的结构 `dorm`
--

CREATE TABLE IF NOT EXISTS `dorm` (
  `dorm_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dorm_building` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dorm_no` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dorm_size` int(5) NOT NULL,
  PRIMARY KEY (`dorm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `dorm`
--

INSERT INTO `dorm` (`dorm_id`, `dorm_building`, `dorm_no`, `dorm_size`) VALUES
('1', '13', '748', 4);

-- --------------------------------------------------------

--
-- 表的结构 `maintain`
--

CREATE TABLE IF NOT EXISTS `maintain` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `dorm_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `book_time` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `reason` text COLLATE utf8mb4_unicode_ci,
  `date` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `solve` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=8 ;

--
-- 转存表中的数据 `maintain`
--

INSERT INTO `maintain` (`id`, `dorm_id`, `book_time`, `reason`, `date`, `solve`) VALUES
(1, '1', '2015-07-01', '电扇坏了', '2015-07-02', '是'),
(2, '1', '2015-07-01', '空调坏了', '2015-07-21', '是'),
(3, '1', '2015-07-02', '老衲爆了', '2015-07-03', '否'),
(4, '1', '2015-07-02', '全都爆了', '2015-07-03', '是'),
(5, '1', '2015-07-08', '4554', '2015-07-03', '是'),
(6, '1', '2015-07-06', '13354', '2015-07-04', '否'),
(7, '1', '', '', '2015-07-06', '否');

-- --------------------------------------------------------

--
-- 表的结构 `stay_o_late`
--

CREATE TABLE IF NOT EXISTS `stay_o_late` (
  `rec_id` int(20) NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `reason` text COLLATE utf8mb4_unicode_ci,
  `time` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `counsellor` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=7 ;

--
-- 转存表中的数据 `stay_o_late`
--

INSERT INTO `stay_o_late` (`rec_id`, `stu_id`, `reason`, `time`, `date`, `counsellor`) VALUES
(1, '20131003764', '宵夜', '23:55:02', '2015-07-05', '老衲'),
(2, '20131003764', '学习', '06:20:02', '2015-07-05', '老衲999'),
(3, '20131003766', '出去浪', '23:01:51', '2015-07-05', 'AAA'),
(6, '20131003764', '', '23:32:05', '2015-07-05', '');

-- --------------------------------------------------------

--
-- 表的结构 `stud_dorm`
--

CREATE TABLE IF NOT EXISTS `stud_dorm` (
  `stu_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dorm_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `starttime` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `endtime` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `stud_dorm`
--

INSERT INTO `stud_dorm` (`stu_id`, `dorm_id`, `starttime`, `endtime`) VALUES
('20131003764', '1', '', ''),
('20131003765', '1', '', ''),
('20131003766', '1', '', ''),
('20131003767', '1', '', '');

-- --------------------------------------------------------

--
-- 表的结构 `stud_post`
--

CREATE TABLE IF NOT EXISTS `stud_post` (
  `card_id` int(20) NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `send_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `stud_post`
--

INSERT INTO `stud_post` (`card_id`, `stu_id`, `send_name`, `date`) VALUES
(1, '20131003764', '老衲', '2015-07-02'),
(2, '20131003764', 'QJL', '2015-07-03'),
(3, '20131003764', '老衲的同学', '2015-07-22'),
(4, '20131003764', '神秘人', '2012-12-28'),
(5, '20131003766', 'xx哥', '2014-07-14');

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sex` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dept` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `s_tel` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `l_tel` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pwd` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `class` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`id`, `name`, `sex`, `dept`, `s_tel`, `l_tel`, `pwd`, `class`) VALUES
('20131003764', 'LCT', '男', '思科信息学院', '666666', '18866666666', '069055', '计算机1307'),
('20131003765', '老衲一', '男', '思科信息学院', '888888', '14567896542', '111111', '计算机1307'),
('20131003766', '老衲3', '男', '国际金融学院', '115555', '78945612305', '456789', '计算机1307'),
('20131003767', '老衲2', '男', '新闻传播学院', '123456', '78945612345', '000000', '计算机1307');

-- --------------------------------------------------------

--
-- 表的结构 `visit`
--

CREATE TABLE IF NOT EXISTS `visit` (
  `visit_id` int(20) NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `vid` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `time` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`visit_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `visit`
--

INSERT INTO `visit` (`visit_id`, `stu_id`, `date`, `vid`, `name`, `time`) VALUES
(1, '20131003764', '2015-07-05', '1325', 'happy', '08:52'),
(2, '20131003764', '2015-07-05', '20131003745', 'QJL', '15:56');

-- --------------------------------------------------------

--
-- 表的结构 `water_order`
--

CREATE TABLE IF NOT EXISTS `water_order` (
  `water_id` int(20) NOT NULL AUTO_INCREMENT,
  `dorm_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `number` int(2) NOT NULL,
  `date` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `solve` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`water_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=7 ;

--
-- 转存表中的数据 `water_order`
--

INSERT INTO `water_order` (`water_id`, `dorm_id`, `number`, `date`, `solve`) VALUES
(1, '1', 2, '2015-07-02', '否'),
(2, '1', 1, '2015-07-03', '否'),
(3, '1', 1, '2015-08-01', '是'),
(4, '1', 2, '2015-07-04', '是'),
(5, '1', 999, '2015-07-04', '是'),
(6, '1', 5, '2015-07-06', '否');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
