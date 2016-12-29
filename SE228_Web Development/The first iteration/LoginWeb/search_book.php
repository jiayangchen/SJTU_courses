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
<div style="text-align: center">
<?php
    include "connection.php";
    $bookname=$_POST['bookname'];
    //echo $bookname;

    $sql_find_likebook="SELECT BookID,BookName,Author,Press,Quantity,Price FROM mybook WHERE BookName LIKE '%$bookname%'";
    $result_likebook=$conn->query($sql_find_likebook);

if ($result_likebook->num_rows>0) {
    while ($row = $result_likebook->fetch_assoc()) {


        echo "查询信息如下";
        echo "<br>";
        echo "<br>";
        echo "<br>";
        echo "<table border=1 align='center'>";
        echo "<tr><td>BookID</td><td>BookName</td><td>Author</td><td>Press</td><td>Quantity</td><td>Price</td></tr>";

        echo "<tr>";
        echo "<td>" . $row['BookID'] . "</td>";
        echo "<td>" . $row['BookName'] . "</td>";
        echo "<td>" . $row['Author'] . "</td>";
        echo "<td>" . $row['Press'] . "</td>";
        echo "<td>" . $row['Quantity'] . "</td>";
        echo "<td>" . $row['Price'] . "</td>";
        echo "</tr>";
        echo "</table>";
    }
}

?>
    <br>
    <br>
    <a href="adminManager.php"><input type="submit" value="返回管理页面"></a>
</div>
