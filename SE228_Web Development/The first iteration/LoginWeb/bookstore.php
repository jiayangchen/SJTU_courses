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

<?php

/* Output the table mybook*/

    include 'connection.php';
    $sql_book = "SELECT BookID, BookName, Author,Press,Quantity,Price FROM mybook";
    $result_book = $conn->query($sql_book);


echo"<br>";
echo"<br>";
echo"<br>";
echo "<table border=1 align=\"center\"  class='Tab'>";
echo "<tr><td>BookID</td><td>BookName</td><td>Author</td><td>Press</td><td>Quantity</td><td>Price</td></tr>";

while($row = $result_book->fetch_assoc())
{
    echo "<tr>";
    echo "<td>".$row["BookID"]."</td>";
    echo "<td>".$row["BookName"]." </td>";
    echo "<td>".$row["Author"]." </td>";
    echo "<td>".$row["Press"]." </td>";
    echo "<td>".$row["Quantity"]." </td>";
    echo "<td>".$row["Price"]." </td>";
    echo "</tr>";
}

echo "</table>";

$conn->close();
?>

<br>
<br>
<form action="order.php" method="post">
    <div style="text-align:center;">
    order_bookid:<input type="text" name="order_bookid" class="order_bookid" placeholder="请输入您要购买的书号！">
    <input type="submit" value="BUY">
    </div>
</form>
</body>
</html>