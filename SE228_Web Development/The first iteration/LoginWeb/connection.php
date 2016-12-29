<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "myDB";

// 创建连接
$conn = new mysqli($servername, $username, $password, $dbname);
// 检测连接
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

/**
 * Created by PhpStorm.
 * User: ChenJiayang
 * Date: 2016/3/27
 * Time: 16:16
 */