-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 08, 2020 at 04:46 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mcqs_assignment`
--

-- --------------------------------------------------------

--
-- Table structure for table `java_questions`
--

CREATE TABLE `java_questions` (
  `ID` int(11) NOT NULL,
  `Questions` varchar(255) NOT NULL,
  `Ans_one` varchar(100) NOT NULL,
  `Ans_two` varchar(100) NOT NULL,
  `Ans_three` varchar(100) NOT NULL,
  `Ans_four` varchar(100) NOT NULL,
  `Correct_ans` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `java_questions`
--

INSERT INTO `java_questions` (`ID`, `Questions`, `Ans_one`, `Ans_two`, `Ans_three`, `Ans_four`, `Correct_ans`) VALUES
(1, 'Which data type value is returned by all transcendental math functions?', 'int', 'float', 'double', 'long', 'double'),
(2, 'Which of these operators is used to allocate memory to array variable in Java?', 'malloc', 'alloc', 'new', 'new malloc', 'new'),
(3, 'Which of these is an incorrect array declaration?', 'int arr[] = new int[5]', 'int [] arr = new int[5]', 'int arr[] = new int[5]', 'int arr[] = int [5] new', 'int arr[] = new int[5]'),
(4, 'Which of these is necessary to specify at time of array initialization?', 'Row', 'Column', 'Both Row and Column', 'None of the mentioned', 'Row'),
(5, 'Which of the following can be operands of arithmetic operators?', 'Numeric', 'Boolean', 'Characters', 'Both Numeric & Characters', 'Both Numeric & Characters'),
(6, 'Decrement operator, −−, decreases the value of variable by what number?', '1', '2', '3', '4', '1'),
(7, ' Which of these access specifiers must be used for main() method?', 'private', 'public', 'protected', 'none of the mentioned', 'public'),
(8, 'What is the process by which we can control what parts of a program can access the members of a class?', 'Polymorphism', 'Abstraction', 'Encapsulation', 'Recursion', 'Encapsulation'),
(9, 'Which of this keyword can be used in a subclass to call the constructor of superclass?', 'super', 'this', 'extent', 'extends', 'super'),
(10, 'Which of the following is a super class of all exception type classes?', 'Catchable', 'RuntimeExceptions', 'String', 'Throwable', 'Throwable');

-- --------------------------------------------------------

--
-- Table structure for table `science_questions`
--

CREATE TABLE `science_questions` (
  `ID` int(11) NOT NULL,
  `Questions` varchar(255) NOT NULL,
  `Ans_one` varchar(100) NOT NULL,
  `Ans_two` varchar(100) NOT NULL,
  `Ans_three` varchar(100) NOT NULL,
  `Ans_four` varchar(100) NOT NULL,
  `Correct_ans` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `science_questions`
--

INSERT INTO `science_questions` (`ID`, `Questions`, `Ans_one`, `Ans_two`, `Ans_three`, `Ans_four`, `Correct_ans`) VALUES
(1, 'Which of these in not a core datatype?', 'Lists', 'Dictionary', 'Class', 'Tuples', 'Class'),
(2, 'What is the output of “hello”+1+2+3 ?', 'hello123', 'hello', 'Error', 'hello6', 'Error'),
(3, 'Which of the following statements is used to create an empty set?', '{ }', 'set()', '[ ]', '( )', 'set()'),
(4, 'What is the maximum possible length of an identifier?', '31 characters', '63 characters', '79 characters', 'none of the mentioned', 'none of the mentioned'),
(5, 'Which of the following is not a keyword?', 'eval', 'assert', 'nonlocal', 'pass', 'eval'),
(6, 'Which of the following cannot be a variable?', '__init__', 'in', 'it', 'on', 'in'),
(7, 'Given a function that does not return any value, What value is thrown by default when executed in shell.', 'int', 'bool', 'void', 'None', 'None'),
(8, 'Which of the following will run without errors?', 'round(45.8)', 'round(6352.898,2,5)', 'round()', 'round(7463.123,2,1)', 'round(45.8)'),
(9, 'Which is the correct operator for power(xy)?', 'X^y', 'X**y', 'X^^y', 'None of the above', 'X**y'),
(10, 'What is the answer to this expression, 22 % 3 is?', '7', '1', '0', '5', '1');

-- --------------------------------------------------------

--
-- Table structure for table `student_info`
--

CREATE TABLE `student_info` (
  `ID` int(11) NOT NULL,
  `Name` varchar(150) NOT NULL,
  `Email` varchar(150) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Token` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_info`
--

INSERT INTO `student_info` (`ID`, `Name`, `Email`, `Username`, `Password`, `Phone`, `Address`, `Token`) VALUES
(1, 'Ramesh Bhandari', 'ramesh1@gmail.com', 'ramesh', '1234', '9863622122', 'Jhapa', 'ramesh366'),
(2, 'Sabin Chapagain', 'sabin@gmail.com', 'sabin', 'sabin123', '9804924926', 'Jhapa', 'sabin366'),
(3, 'Bishal Dahal', 'bishal@gmail.com', 'bishal11', 'bishal', '9856721344', 'Morang ', 'bishal11366'),
(4, 'mili', '123', 'mili', 'a', '12345', 'kik', '');

-- --------------------------------------------------------

--
-- Table structure for table `web_questions`
--

CREATE TABLE `web_questions` (
  `ID` int(11) NOT NULL,
  `Questions` varchar(255) NOT NULL,
  `Ans_one` varchar(100) NOT NULL,
  `Ans_two` varchar(100) NOT NULL,
  `Ans_three` varchar(100) NOT NULL,
  `Ans_four` varchar(100) NOT NULL,
  `Correct_ans` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `web_questions`
--

INSERT INTO `web_questions` (`ID`, `Questions`, `Ans_one`, `Ans_two`, `Ans_three`, `Ans_four`, `Correct_ans`) VALUES
(1, 'HTML stands for?', 'Hyper Text Markup Language', 'High Text Markup Language', 'Hyper Tabular Markup Language', 'None of these', 'Hyper Text Markup Language'),
(2, 'which of the following tag is used to mark a begining of paragraph ?', '<TD>', '<br>', '<P>', '<TR>', '<P>'),
(3, 'Correct HTML tag for the largest heading is', '<head>', '<h6>', '<heading>', '<h1>', '<h1>'),
(4, 'The attribute of <form> tag', 'Method', 'Action', 'Both (a)&(b)', 'None of these', 'Both (a)&(b)'),
(5, 'Markup tags tell the web browser', 'How to organise the page', 'How to display the page', 'How to display message box on page', 'None of these', 'How to display the page'),
(6, 'www is based on which model?', 'Local-server', 'Client-server', '3-tier', 'None of these', 'Client-server'),
(7, '  Which of the following attributes of text box control allow to limit the maximum character?', 'size', 'len', 'maxlength', 'all of these', 'maxlength'),
(8, ' HTML is a subset of', 'SGMT', 'SGML', 'SGMD', 'None of these', 'SGML'),
(9, 'A much better approach to establish the base URL is to use', 'BASE element', 'HEAD element', 'both (a) and (b)', 'None of these', 'BASE element'),
(10, 'The latest HTML standard is', 'XML', 'HTML 4.0', 'HTML 5.0', 'None of these', 'HTML 5.0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `java_questions`
--
ALTER TABLE `java_questions`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `science_questions`
--
ALTER TABLE `science_questions`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `student_info`
--
ALTER TABLE `student_info`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `web_questions`
--
ALTER TABLE `web_questions`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `java_questions`
--
ALTER TABLE `java_questions`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `science_questions`
--
ALTER TABLE `science_questions`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `student_info`
--
ALTER TABLE `student_info`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `web_questions`
--
ALTER TABLE `web_questions`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
