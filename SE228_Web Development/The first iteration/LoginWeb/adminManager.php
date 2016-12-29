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
        <h1 align="center">梦想云网上书店</h1>
    </div>
</div>
<br>
<br>
<div style="text-align: center">
    
    
    
<?php
    echo "Welcome, My Admin:";
    echo "5140379036";
    echo "<br>";
    echo "<br>";
    echo "<a href=\"insert_book_information.php\"><input type=\"submit\" value=\"添加图书\"></a>";
    echo "&nbsp;";
    echo "&nbsp;";
    echo "&nbsp;";
    echo "<a href=\"update_book_information.php\"><input type=\"submit\" value=\"更新图书\"></a>";
echo "&nbsp;";
echo "&nbsp;";
echo "&nbsp;";
echo "<a href=\"delete_book_information.php\"><input type=\"submit\" value=\"删除图书\"></a>";
?>
    <br>
    <br>
<form action="search_book.php" method="post">
    <input type="text" name="bookname" class="bookname" placeholder="请输入书名">
    &nbsp;
    <input type="submit" value="搜索">
</form>    
    
    
</div>
