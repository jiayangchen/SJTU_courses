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
<br>
<br>
<div style="text-align: center">
<?php
include "connection.php";

$bookid=$_POST['BookID'];
$bquantity=$_POST['Quantity'];


$sql_find_book = "SELECT BookID FROM mybook";
$result_find_book = $conn->query($sql_find_book);

if ($result_find_book->num_rows > 0) {
    while ($row = $result_find_book->fetch_assoc()) {
        if ($row['BookID'] == $bookid) {
            $sql_origin_quantity = "SELECT Quantity FROM mybook WHERE BookID=$bookid";
            $result_origin_num = $conn->query($sql_origin_quantity);

            if ($result_origin_num->num_rows > 0) {
                while ($row = $result_origin_num->fetch_assoc()) {
                    $new_num = $row['Quantity'] + $bquantity;
                    mysqli_query($conn, "UPDATE mybook SET Quantity=$new_num
                    WHERE BookID=$bookid");
                    echo "原有书籍信息更新成功";
                    echo "更新信息如下，请核对";
                    echo "<table border=1 align=\"center\"  class='Tab'>";
                    echo "<tr><td>BookID</td><td>Quantity</td></tr>";

                    echo "<tr>";
                    echo "<td>" . $bookid . "</td>";
                    echo "<td>" . $bquantity. "</td>";
                    echo "</tr>";
                    echo "</table>";
                }
            }
        }
    }
}
?>

<br>
<br>
<br>
<a href="adminManager.php"><input type="submit" value="返回管理页面"></a>
</div>
