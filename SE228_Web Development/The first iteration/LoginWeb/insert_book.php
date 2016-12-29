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
    include "connection.php";

$bookid=$_POST['BookID'];
$bname=$_POST['BookName'];
$bauthor=$_POST['Author'];
$bpress=$_POST['Press'];
$bquantity=$_POST['Quantity'];
$bprice=$_POST['Price'];

/*Insert the new book information */

$sql_insert_newbook = "INSERT INTO mybook (BookID, BookName, Author,Press,Quantity,Price)
VALUES ('$bookid', '$bname', '$bauthor','$bpress','$bquantity','$bprice')";

/*Output the result*/

if ($conn->query($sql_insert_newbook) === TRUE) {
    echo "新书信息录入成功";
    echo "新书信息如下，请核对";
    echo "<br>";
    echo "<br>";
    echo "<br>";
    echo "<table border=1 align='center'>";
    echo "<tr><td>BookID</td><td>BookName</td><td>Author</td><td>Press</td><td>Quantity</td><td>Price</td></tr>";
    /*We should check the both sid and bid to make sure that this was the record we created a moment ago
      because someone may use the same studentID but order different book in different time*/
    echo "<tr>";
    echo "<td>" . $bookid . "</td>";
    echo "<td>" . $bname . "</td>";
    echo "<td>" . $bauthor . "</td>";
    echo "<td>" . $bpress. "</td>";
    echo "<td>" . $bquantity. "</td>";
    echo "<td>" . $bprice. "</td>";
    echo "</tr>";
    echo "</table>";
} else {
    echo "Error: " . $sql_insert_newbook . "<br>" . $conn->error;
}
$conn->close();
?>

<br>
<br>
<br>
<a href="adminManager.php"><input type="submit" value="返回管理页面"></a>
    </div>
