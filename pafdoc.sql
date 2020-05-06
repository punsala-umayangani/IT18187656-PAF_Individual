-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 11:51 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pafdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `pafdoc`
--

CREATE TABLE `pafdoc` (
  `docid` int(11) NOT NULL,
  `docName` varchar(100) NOT NULL,
  `docSpecial` varchar(50) NOT NULL,
  `docAddress` varchar(50) NOT NULL,
  `docPhone` varchar(15) NOT NULL,
  `docEmail` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pafdoc`
--

INSERT INTO `pafdoc` (`docid`, `docName`, `docSpecial`, `docAddress`, `docPhone`, `docEmail`) VALUES
(1, 'Punsala', 'ENT', 'Galle', '0712345678', 'punsala@gmail.com'),
(3, 'Sakura', 'EYE', 'Mathara', '0779876543', 'saku@gmail.com'),
(5, 'Vika', 'Special', 'Kurunegala', '0761932222', 'vika@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pafdoc`
--
ALTER TABLE `pafdoc`
  ADD PRIMARY KEY (`docid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pafdoc`
--
ALTER TABLE `pafdoc`
  MODIFY `docid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
