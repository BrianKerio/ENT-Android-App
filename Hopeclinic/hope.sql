-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 27, 2023 at 10:05 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hope`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(10) UNSIGNED NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `email`, `password`) VALUES
(1, 'brian', 'brian@gmail.com', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `assign`
--

CREATE TABLE `assign` (
  `id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `assign_status` varchar(20) NOT NULL DEFAULT 'Pending deliver',
  `materials` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `assign`
--

INSERT INTO `assign` (`id`, `emp_id`, `order_id`, `assign_status`, `materials`) VALUES
(1, 7, 1, 'Delivered', ',Pair Of Gloves,catheters,nebulizers,Bipolar forceps'),
(2, 7, 2, 'Delivered', ',Pair Of Gloves,catheters,nebulizers'),
(3, 7, 3, 'Delivered', ',Pair Of Gloves,syringe,needle');

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `order_id` int(11) NOT NULL,
  `client_id` int(15) NOT NULL,
  `county_id` int(11) DEFAULT NULL,
  `town_id` int(11) DEFAULT NULL,
  `address` varchar(11) DEFAULT NULL,
  `date_to_deliver` varchar(20) DEFAULT NULL,
  `time_to_deliver` varchar(20) DEFAULT NULL,
  `order_status` varchar(11) NOT NULL DEFAULT '0',
  `order_date` varchar(20) DEFAULT NULL,
  `date_delivered` varchar(20) DEFAULT NULL,
  `order_remark` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`order_id`, `client_id`, `county_id`, `town_id`, `address`, `date_to_deliver`, `time_to_deliver`, `order_status`, `order_date`, `date_delivered`, `order_remark`) VALUES
(1, 16, 1, 11, 'Greenland', NULL, NULL, '8', '2023-11-06 17:36:57', NULL, NULL),
(2, 16, 1, 11, 'Greenland', NULL, NULL, '8', '2023-11-21 12:55:01', NULL, NULL),
(3, 1, 1, 1, 'Mathare', NULL, NULL, '8', '2023-11-21 15:08:33', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `client_id` int(11) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `phone_no` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  `status` varchar(55) NOT NULL DEFAULT 'Pending approval',
  `password` varchar(50) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT current_timestamp(),
  `remarks` text DEFAULT NULL,
  `user` varchar(10) NOT NULL DEFAULT 'Client'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`client_id`, `first_name`, `last_name`, `username`, `phone_no`, `email`, `status`, `password`, `date_created`, `remarks`, `user`) VALUES
(1, 'Keith', 'onyango', 'keith', '0712345678', 'keith@gmail.com', 'Approved', '1234', '2022-09-27 12:24:16', NULL, 'Client'),
(2, 'abigael', 'kiprotich', 'kiprotich', '0723456789', 'abby@gmail.com', 'Approved', '1234', '2022-09-27 12:31:27', NULL, 'Supplier'),
(11, 'Eunice', 'wambui', 'eunice', '0758964285', 'eunice@gmail.com', 'Approved', '1234', '2022-10-11 13:42:31', NULL, 'Supplier'),
(14, 'john', 'paul', 'john', '0745678123', 'john@gmail.com', 'Approved', '1234', '2023-02-14 05:43:44', NULL, 'Supplier'),
(15, 'mary', 'wambui', 'wambui', '0729983861', 'mary@gmail.com', 'Approved', '1234', '2023-02-14 06:56:13', NULL, 'Client'),
(16, 'brian', 'kerio', 'brian', '0745765354', 'briankerio@gmail.com', 'Approved', '1234', '2023-09-10 14:38:27', NULL, 'Client'),
(17, 'vanessa', 'ndinda', 'vanessa', '0723456234', 'vanessa@gmail.com', 'Approved', '1234', '2023-10-17 16:03:31', NULL, 'Client'),
(18, 'George', 'kimani', 'kimani', '0725654765', 'liveairmarket254@gmail.com', 'Approved', '1234', '2023-11-03 15:31:28', NULL, 'Client');

-- --------------------------------------------------------

--
-- Table structure for table `counties`
--

CREATE TABLE `counties` (
  `county_id` int(11) NOT NULL,
  `county_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `counties`
--

INSERT INTO `counties` (`county_id`, `county_name`) VALUES
(1, 'Meru'),
(2, 'Kiambu'),
(3, 'Mombasa'),
(4, 'Kwale'),
(5, 'Embu');

-- --------------------------------------------------------

--
-- Table structure for table `delivery`
--

CREATE TABLE `delivery` (
  `id` int(11) NOT NULL,
  `county_id` int(11) NOT NULL,
  `town_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `address` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `delivery`
--

INSERT INTO `delivery` (`id`, `county_id`, `town_id`, `client_id`, `address`) VALUES
(1, 1, 11, 16, 'Greenland'),
(2, 1, 1, 1, 'Mathare');

-- --------------------------------------------------------

--
-- Table structure for table `delivery_cost`
--

CREATE TABLE `delivery_cost` (
  `d_id` int(11) NOT NULL,
  `cost` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `delivery_cost`
--

INSERT INTO `delivery_cost` (`d_id`, `cost`) VALUES
(1, 300);

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `emp_id` int(11) NOT NULL,
  `f_name` varchar(30) NOT NULL,
  `l_name` varchar(15) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `date_added` timestamp NOT NULL DEFAULT current_timestamp(),
  `userlevel` varchar(20) NOT NULL DEFAULT 'Staff',
  `status` varchar(20) NOT NULL DEFAULT 'Active',
  `contact` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`emp_id`, `f_name`, `l_name`, `username`, `email`, `password`, `date_added`, `userlevel`, `status`, `contact`) VALUES
(1, 'John', 'Kamau', 'kamau', 'kamaujohn@gmail.com', '1234', '2023-02-28 07:53:50', 'Finance', 'Active', '0763456234'),
(2, 'Marion', 'kiprotich', 'marion', 'marionkitrotich@gmail.com', '1234', '2023-03-10 07:39:34', 'Shipping Manager', 'Active', '0773456789'),
(3, 'Brian', 'kaplong', 'kaplong', 'kaplongbrian@gmail.com', '1234', '2023-03-10 07:43:48', 'Driver', 'Active', '0723456123'),
(4, 'Mercy', 'wambui', 'wambui', 'mercywambui@gmail.com', '1234', '2023-03-10 07:44:41', 'Driver', 'Active', '0709567345'),
(5, 'Harun', 'mohammed', 'Harun', 'mohammedharun@gmail.com', '1234', '2023-03-10 08:28:07', 'Stock manager', 'Active', '0734567345'),
(6, 'Dennis', 'mwangi', 'dennis', 'dennismwangi@gmail.com', '1234', '2023-06-19 09:16:53', 'Service manager', 'Active', '0723456784'),
(7, 'Susan', 'Kiprop', 'susan', 'kipsusan@gmail.com', '1234', '2023-06-19 22:26:32', 'Specialist', 'Active', '0734127635'),
(8, 'Gerald', 'Kihito', 'gerald', 'gkihito@gmail.com', '1234', '2023-07-17 14:04:34', 'Specialist', 'Active', '0786354876'),
(9, 'Samuel', 'kithinji', 'kithinji', 'samkithinji@gmail.com', '1234', '2023-07-17 14:05:32', 'Specialist', 'Active', '0745345987'),
(10, 'Victoria', 'munene', 'victoria', 'vicmunene@gmail.com', '1234', '2023-07-17 14:07:50', 'Receptionist', 'Active', '0734675345');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `fb_id` int(11) NOT NULL,
  `comment` text NOT NULL,
  `fb` text NOT NULL,
  `fb_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `client_id` int(11) NOT NULL,
  `staff_id` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `client_id` int(15) NOT NULL,
  `county_id` int(11) DEFAULT NULL,
  `town_id` int(11) DEFAULT NULL,
  `address` varchar(11) DEFAULT NULL,
  `date_to_deliver` varchar(20) DEFAULT NULL,
  `time_to_deliver` varchar(20) DEFAULT NULL,
  `order_status` varchar(11) NOT NULL DEFAULT '0',
  `order_date` varchar(20) DEFAULT NULL,
  `date_delivered` varchar(20) DEFAULT NULL,
  `order_remark` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order_items`
--

CREATE TABLE `order_items` (
  `item_id` int(11) NOT NULL,
  `stock_id` int(15) NOT NULL,
  `order_id` int(15) NOT NULL,
  `item_price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `item_status` int(11) NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  `prescription` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `order_items`
--

INSERT INTO `order_items` (`item_id`, `stock_id`, `order_id`, `item_price`, `quantity`, `item_status`, `client_id`, `prescription`) VALUES
(1, 2, 1, 7395, 1, 1, 16, ''),
(2, 1, 2, 5199, 1, 1, 16, 'albedanazole 1x1'),
(3, 1, 3, 5155, 1, 1, 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `order_id` int(15) NOT NULL,
  `mpesa_code` varchar(15) NOT NULL,
  `client_id` int(15) NOT NULL,
  `order_cost` int(11) NOT NULL,
  `delivery_cost` int(11) NOT NULL,
  `total_cost` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`payment_id`, `order_id`, `mpesa_code`, `client_id`, `order_cost`, `delivery_cost`, `total_cost`, `status`) VALUES
(1, 1, '', 16, 12500, 0, 0, 1),
(2, 2, '', 16, 9500, 0, 0, 1),
(3, 3, '', 1, 9500, 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `items` text NOT NULL,
  `request_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `request_status` varchar(30) NOT NULL DEFAULT 'Pending approval',
  `remarks` text NOT NULL,
  `quantity` varchar(11) NOT NULL,
  `amount` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE `services` (
  `stock_id` int(11) NOT NULL,
  `image` varchar(50) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`stock_id`, `image`, `product_name`, `price`, `stock`, `last_update`, `description`) VALUES
(1, 'hearingtest2.png', 'Hearing Tests', 800, 800, '2023-09-10 14:29:17', 'There is a great need for quality ENT service in this area and we have invested in a state of the art digital Pure Tone Audiometry Machine which performs all hearing tests ,including bone hearing and acoustic reflexes. This couple with modern hearing methods givers our clients quality hearing services under one roof.'),
(2, 'nosesurge.jpg', 'Nasal Cauterisation', 600, 20, '2023-09-10 14:24:45', 'We offer a comprehensive portfolio of architectural film for use in residences and commercial properties. We professionally install these films and engineer them to address building glass issues related to safety, heat, glare and decorative features\r\n\r\nWe supply and install films on windows, doors, partitions, shower enclosures and other smooth glass surfaces. If you have concerns about discomfort, energy costs, security, or privacy, you’ll be happy to know that our window tinting can address them for a fraction of the cost of new windows, doors or specialty glass.\r\n\r\nWe offer a wide variety of office and house window tint to suite your needs.\r\n\r\n1. Solar Protective Window Tint\r\n2. Reflective Window Tint\r\nThese films offers a cost-effective and simple way to add a style to your living area. These films can dramatically improve the comfort level of your indoor living space while enhancing a dramatic outdoor style statement.\r\n\r\nWith a wide variety of options like silver, gold, bronze, blue and gray you can fine-tune for the perfect complement to your office or home’s siding, roof and landscaping.\r\n\r\nReflects Heat\r\nReduces Fading\r\nSaves Energy\r\nReduces Glare\r\nBlocks UV Rays\r\nHigh Interior & Exterior Reflectance\r\n3. Ceramic Window Tint\r\n4. Decorative Window Film'),
(3, 'earendoscope.jpg', 'Video Endoscopic disease diagnosis', 50, 500, '2023-09-10 14:26:02', 'We offer a comprehensive portfolio of architectural film for use in residences and commercial properties. We professionally install these films and engineer them to address building glass issues related to safety, heat, glare and decorative features\r\n\r\nWe supply and install films on windows, doors, partitions, shower enclosures and other smooth glass surfaces. If you have concerns about discomfort, energy costs, security, or privacy, you’ll be happy to know that our window tinting can address them for a fraction of the cost of new windows, doors or specialty glass.\r\n\r\nWe offer a wide variety of office and house window tint to suite your needs.\r\n\r\n1. Solar Protective Window Tint\r\nThese films block harmful heat and glare. These are perfectly designed for your home and office to mitigate the negative effects of the sun and reject up to 99% of solar energy.\r\n\r\nReflects heat\r\nReduces fading\r\nReduces glare\r\nReduces UV rays\r\nReduces cooling costs\r\n2. Reflective Window Tint\r\n3. Ceramic Window Tint\r\n4. Decorative Window Film');

-- --------------------------------------------------------

--
-- Table structure for table `service_payment`
--

CREATE TABLE `service_payment` (
  `payment_id` int(11) NOT NULL,
  `order_id` int(15) NOT NULL,
  `mpesa_code` varchar(15) NOT NULL,
  `client_id` int(15) NOT NULL,
  `order_cost` int(11) NOT NULL,
  `delivery_cost` int(11) NOT NULL,
  `total_cost` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `service_payment`
--

INSERT INTO `service_payment` (`payment_id`, `order_id`, `mpesa_code`, `client_id`, `order_cost`, `delivery_cost`, `total_cost`, `status`) VALUES
(1, 1, 'QRTYBB23TT', 16, 7395, 1, 7395, 1),
(2, 2, 'QRTYBB23TT', 16, 5199, 1, 5199, 1),
(3, 3, 'RTYUI12345', 1, 5155, 1, 5155, 1);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `stock_id` int(11) NOT NULL,
  `image` varchar(50) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`stock_id`, `image`, `product_name`, `price`, `stock`, `last_update`, `description`) VALUES
(1, '1694354209_4029.jpg', 'JH W3 OTC Hearing Aids', 9500, 387, '2023-11-21 12:08:33', 'JH-W3-OTC-Hearing-Aids'),
(2, '1694354124_4485.jpg', 'JH-A610 mini rechargeable ITE ', 12500, 43, '2023-11-06 14:36:57', 'JH-A610 mini rechargeable ITE hearing aids prevent feedback'),
(3, '1694353994_8597.jpg', 'JH-117 Analog BTE Hearing Amplifier', 6700, 54, '2023-09-10 14:02:24', 'JH-117 Analog BTE Hearing Aid / Hearing Amplifier'),
(6, 'othoscope.jpg', 'othoscope.', 7600, 20, '2023-11-21 11:27:35', 'An otoscope is a tool which shines a beam of light to help visualize and examine the condition of the ear canal and eardrum'),
(7, 'specula.jpg', 'Nasal Specula', 4500, 34, '2023-11-21 11:28:54', 'Nasal Specula');

-- --------------------------------------------------------

--
-- Table structure for table `supply_payment`
--

CREATE TABLE `supply_payment` (
  `id` int(11) NOT NULL,
  `supplier_id` varchar(25) NOT NULL,
  `amount` varchar(25) NOT NULL,
  `payment_description` varchar(50) NOT NULL,
  `payment_status` varchar(25) NOT NULL DEFAULT 'unpaid',
  `payment_date` datetime NOT NULL DEFAULT current_timestamp(),
  `quantity` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `towns`
--

CREATE TABLE `towns` (
  `town_id` int(11) NOT NULL,
  `town_name` varchar(50) NOT NULL,
  `county_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `towns`
--

INSERT INTO `towns` (`town_id`, `town_name`, `county_id`) VALUES
(1, 'Meru town', 1),
(2, 'Maua', 1),
(3, 'Kainjai', 1),
(4, 'Kiambu town', 2),
(5, 'Limuru', 2),
(6, 'Thika', 2),
(7, 'Kikuyu', 2),
(8, 'Old town', 3),
(9, 'Mambasa town', 3),
(10, 'Ngumbu', 1),
(11, 'Mikinduri', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `assign`
--
ALTER TABLE `assign`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `emp_id` (`emp_id`);

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `client_code` (`client_id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `client_code_2` (`client_id`),
  ADD KEY `client_id` (`client_id`),
  ADD KEY `location_id` (`county_id`),
  ADD KEY `ap_id` (`town_id`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`client_id`);

--
-- Indexes for table `counties`
--
ALTER TABLE `counties`
  ADD PRIMARY KEY (`county_id`);

--
-- Indexes for table `delivery`
--
ALTER TABLE `delivery`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ap_id` (`county_id`),
  ADD KEY `client_id` (`client_id`),
  ADD KEY `town_id` (`town_id`);

--
-- Indexes for table `delivery_cost`
--
ALTER TABLE `delivery_cost`
  ADD PRIMARY KEY (`d_id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`fb_id`),
  ADD KEY `staff_id` (`staff_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `client_code` (`client_id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `client_code_2` (`client_id`),
  ADD KEY `client_id` (`client_id`),
  ADD KEY `location_id` (`county_id`),
  ADD KEY `ap_id` (`town_id`);

--
-- Indexes for table `order_items`
--
ALTER TABLE `order_items`
  ADD PRIMARY KEY (`item_id`),
  ADD KEY `product_code` (`stock_id`),
  ADD KEY `order_code` (`order_id`),
  ADD KEY `order_code_2` (`order_id`),
  ADD KEY `order_code_3` (`order_id`),
  ADD KEY `product_id` (`stock_id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `pro_id` (`stock_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `order_id_2` (`order_id`),
  ADD KEY `client_id` (`client_id`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_id` (`client_id`);

--
-- Indexes for table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`stock_id`);

--
-- Indexes for table `service_payment`
--
ALTER TABLE `service_payment`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `order_id_2` (`order_id`),
  ADD KEY `client_id` (`client_id`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`stock_id`);

--
-- Indexes for table `supply_payment`
--
ALTER TABLE `supply_payment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `towns`
--
ALTER TABLE `towns`
  ADD PRIMARY KEY (`town_id`),
  ADD KEY `county_id` (`county_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `assign`
--
ALTER TABLE `assign`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `client_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `counties`
--
ALTER TABLE `counties`
  MODIFY `county_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `delivery`
--
ALTER TABLE `delivery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `delivery_cost`
--
ALTER TABLE `delivery_cost`
  MODIFY `d_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `fb_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order_items`
--
ALTER TABLE `order_items`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `request`
--
ALTER TABLE `request`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `services`
--
ALTER TABLE `services`
  MODIFY `stock_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `service_payment`
--
ALTER TABLE `service_payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `stock_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `supply_payment`
--
ALTER TABLE `supply_payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `towns`
--
ALTER TABLE `towns`
  MODIFY `town_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `delivery`
--
ALTER TABLE `delivery`
  ADD CONSTRAINT `delivery_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `counties` (`county_id`),
  ADD CONSTRAINT `delivery_ibfk_2` FOREIGN KEY (`town_id`) REFERENCES `towns` (`town_id`),
  ADD CONSTRAINT `delivery_ibfk_3` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
