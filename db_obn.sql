-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 20, 2021 at 08:22 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_obn`
--

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `post_id` int(11) NOT NULL,
  `title` varchar(128) NOT NULL,
  `section` varchar(30) DEFAULT NULL,
  `content` mediumtext NOT NULL,
  `author_id` int(100) NOT NULL,
  `p_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`post_id`, `title`, `section`, `content`, `author_id`, `p_date`) VALUES
(3, 'SPOTIFY SUBSCRIPTIONS', 'Software', 'A spokesperson for Spotify indicated that the survey should not be taken as concrete product plans. “At Spotify, we routinely conduct a number of surveys in an effort to improve our user experience. Some of those end up paving the path for our broader user experience and others serve only as important learnings,” the spokesperson said. “We have no further news to share on future plans at this time.\"', 3, '2020-11-08 20:44:38'),
(4, 'NEW ZENBOOK SERIES FROM ASUS', 'News', 'The flagship ZenBook S is 15mm thick and weighs 2.9 pounds. It has a 13.9-inch IPS touchscreen (3300 x 2200) with a 3:2 aspect ratio, 500 nits at peak brightness, and 100 percent coverage of the DCI-P3 color gamut.\r\n\r\nThe ZenBook S (and as a matter of fact, almost all of Asus’ new laptops announced today) is, as mentioned, powered with Intel’s 11th Gen processors, starting with a Core i5 variant and working up to a Core i7 variant with Iris Xe architecture graphics. You’ll be able to configure this model with up to 16GB of RAM. And speaking of RAM, Asus is using super-fast LPDDR4x memory clocked at 4,266MHz in this and a few of its other models.\r\n\r\n', 5, '2020-11-08 20:48:01'),
(15, 'LENOVO SMART CLOCK', 'Hardware', 'Lenovo’s latest entrant in this space, the $49.95 Smart Clock Essential, sits somewhere in between all of that. It’s a voice-controlled, Google Assistant smart speaker with a simple, black-and-white segmented LED display. It displays the current time, weather conditions, day, and your currently set alarms. The display will automatically adjust its brightness depending on the light levels of the room, so it’s not blinding you in the middle of the night. But it’s not a touchscreen, doesn’t display photos or video, and can’t be used for monitoring camera feeds. It’s effectively what you’d get if you combined a modern smart speaker with an old-school LED clock radio from the 1980s.', 4, '2020-11-08 20:50:10'),
(16, 'XBOX SERIES S AND SERIES X PRE-ORDERS', 'News', 'Xbox Series S and Series X consoles will both be available starting on November 10th, and if you missed out on preordering either (or both — look, I’m not going to judge), you might be able to snag one online on launch day. Due to the pandemic, combined with the high demand for these consoles, retailers like Best Buy and Target are only selling online. That means you won’t be able to walk into a store to pick one up — unless you’ve purchased it already online. Only then will you be able to arrange an in-store pickup.', 2, '2020-11-08 20:53:41'),
(18, 'WhatsApp PAY IN INDIA', 'Software', '“Now you’re going to be able to easily send money to your friends and family through WhatsApp just as easily as sending a message,” said Zuckerberg. He also suggested that digital payments were “especially important” during a global pandemic, as they eliminate the need for the in-person exchange of cash.', 7, '2020-11-08 20:57:22'),
(19, 'GOOGLE MEET NOISE CANCELLATION', 'Software', 'This time around, Google Meet, yet another application which has become more popular especially due to the lockdown has started rolling out a noise-cancellation feature. \r\n\r\n\r\n\r\nBut there is a problem here, the noise-cancellation feature will not be available for everyone, it’s only for G Suite Enterprise or G Suite Enterprise for Education customers.\r\n\r\n\r\nIf you have a subscription to G-Suite, you should be able to see an option for enabling noise cancellation under your Google Meet Settings as the update rolls out this week. ', 1, '2020-11-08 21:04:24'),
(20, 'CLOUD GAMING - IS THIS THE FUTURE?', 'Software', 'Cloud Gaming is really the new thing in the gaming industry and seeing how we can actually play games simply via the internet without any essential hardware is simply amazing. \r\n\r\nTo give you a brief idea about Cloud Gaming, let’s just say we have a high-end computer somewhere and you are controlling it and seeing the output on your screen, now the screen can be a Television screen, a monitor or even a Smartphone.\r\n\r\nWhatever we are doing does not have hardware involved, not even cables. All this is only possible via fast internet. For a smooth and high quality gaming experience, you’d need (in my opinion) at least a 25 Mbps (Download) speed. \r\n\r\nGoogle Stadia recommends 10 Mbps download speed for 720p streaming. \r\n', 6, '2020-11-08 21:07:25'),
(23, 'ACCESSORIES FOR SONY PLAYSTATION 5', 'Hardware', 'The DualSense Controller is $70, which is $10 more than the DualShock 4. The DualSense is a good successor to the PS4’s controller, given all the improvements that come with it. If you already owned a PS4 or own a DualShock 4, you can still use the controller on the PS5, but it will only work while playing PS4 games.\r\n', 1, '2020-12-03 20:35:07'),
(43, 'STREAMLABS DECK - OVERVIEW', 'Software', 'As a streamer I’d love to have a separate device to control my scenes and display sources without leaving the game I’m playing. Elgato Gaming released a really cool tech lately called the Elgato Stream Deck and the Stream Deck Mini (the smaller version) which basically had a set of buttons which were essentially screens themselves helping you to control your stream without switching from the game. But since this is hardware, it costs you a price. The Elgato Stream Deck is priced at over 11000 INR in India and the Stream Deck Mini is priced around 8000 INR (prices fluctuate, the prices may vary depending upon the time you are reading this thread or even the place from where you’re shopping). ', 1, '2020-12-16 02:10:38');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `role` int(255) NOT NULL,
  `name` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role`, `name`) VALUES
(0, 'Admin'),
(1, 'Writer');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `name` varchar(300) NOT NULL,
  `user_id` int(11) NOT NULL,
  `email_id` varchar(80) DEFAULT NULL,
  `password` varchar(128) NOT NULL,
  `role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`name`, `user_id`, `email_id`, `password`, `role`) VALUES
('Sreekesh Iyer', 1, 'sreekesh.subramanian@gmail.com', '12345678', 0),
('Jisha Philip', 2, 'jishaannphilip@gmail.com', '12345678', 1),
('Sakshi Kharche', 3, 'sakshikharche23@gmail.com', '12345678', 1),
('Vaibhavi Jadhav', 4, 'vaibhavijadhav2707@gmail.com', '12345678', 1),
('Pawan Sharma', 5, 'pawansharma@gmail.com', '12345678', 1),
('Rajat K', 6, 'rajat@gmail.com', '12345278', 1),
('Maitreyee Chand', 7, 'mchand@gmail.com', '29345678', 1),
('Rohini Pant', 8, 'rohinip@gmail.com', '12371078', 1),
('Karan Sharma', 9, 'ksharma@gmail.com', '12340985', 1),
('Shyam S', 10, 'shyam@gmail.com', '11384653', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`post_id`),
  ADD KEY `author_id` (`author_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email_id` (`email_id`),
  ADD KEY `role` (`role`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `post_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `post_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role`) REFERENCES `roles` (`role`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
