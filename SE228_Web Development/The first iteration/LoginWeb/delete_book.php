<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>网上书店</title>
    <style type="text/css">
        div#container{width:1366px}
        div#header {background-color:#99bbbb;}
        h1 {margin-bottom:0; }
        .Tab td{color: #99bbbb}
    </style>
</head>
<body>
<div id="container">
    <div id="header">
        <h1 align="center">欢迎来到梦想云网上书店</h1>
    </div>
</div>

<div style="text-align: center">
<?php

/* Delete the book */

include "connection.php";

$bookid=$_POST['BookID'];

mysqli_query($conn,"DELETE FROM mybook WHERE BookID=$bookid");

echo "书籍";
echo $bookid;
echo "已成功删除";

mysqli_close($conn);

?>

<br>
<br>
<br>
<a href="adminManager.php"><input type="submit" value="返回管理页面"></a>
</div>