<?php
include "../connection.php";
// sql to create table

$sql_myadmin = "CREATE TABLE `myadmin` (
 `studentID` varchar(10) NOT NULL,
 `password` varchar(50) DEFAULT NULL,
 PRIMARY KEY (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
";

$sql_myusers="CREATE TABLE `myusers` (
 `studentID` varchar(10) NOT NULL,
 `password` varchar(50) NOT NULL,
 PRIMARY KEY (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1";

$sql_mybook="CREATE TABLE `mybook` (
 `BookID` int(11) NOT NULL,
 `BookName` varchar(20) CHARACTER SET latin1 NOT NULL,
 `Author` varchar(15) CHARACTER SET latin1 NOT NULL,
 `Press` varchar(50) CHARACTER SET latin1 NOT NULL,
 `Quantity` int(11) NOT NULL,
 `Price` int(100) NOT NULL,
 PRIMARY KEY (`BookID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8";

$sql_myorder="CREATE TABLE `myorder` (
 `studentID` varchar(10) NOT NULL,
 `BookID` int(11) NOT NULL,
 `Address` varchar(100) NOT NULL,
 `Tel` int(11) NOT NULL,
 `Number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1";


$conn->close();
?>