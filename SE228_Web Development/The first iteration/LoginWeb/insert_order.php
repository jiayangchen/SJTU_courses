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

/*Get the information from the input box*/

$sid=$_POST['studentID'];
$bid=$_POST['BookID'];
$num=$_POST['number'];
$add=$_POST['Address'];
$tel=$_POST['Tel'];

/*insert the record*/

$sql_find_bookid="SELECT BookID,Quantity FROM mybook";
$result_find_bookid=$conn->query($sql_find_bookid);

if ($result_find_bookid->num_rows > 0) {
    while($row = $result_find_bookid->fetch_assoc()) {
        if($row['BookID']==$bid and $row['Quantity']>=$num){
            $sql_insert_order = "INSERT INTO  myorder (studentID, BookID, Address,Tel,Number)
            VALUES ('$sid', '$bid', '$add','$tel','$num')";

            /*If mysql_connection successfully, check the studentID and the
            BookID in the DB, if hit, then output the tuple*/
            
            if ($conn->query($sql_insert_order) === TRUE) {
                echo "订单提交成功";
                echo "您的订单信息如下，请核对";
                echo "<br>";
                echo "<br>";
                echo "<br>";
                echo "<table border=1 align='center'>";
                echo "<tr><td>studentID</td><td>BookID</td><td>Address</td><td>Tel</td><td>Number</td></tr>";
                /*We should check the both sid and bid to make sure that this was the record we created a moment ago
                  because someone may use the same studentID but order different book in different time*/
                echo "<tr>";
                echo "<td>" . $sid . "</td>";
                echo "<td>" . $bid . "</td>";
                echo "<td>" . $add . "</td>";
                echo "<td>" . $tel . "</td>";
                echo "<td>" . $num . "</td>";
                echo "</tr>";
                echo "</table>";

                
                /* Update the table mybook's quantity*/
                
                $sql_origin_quantity = "SELECT Quantity FROM mybook WHERE BookID=$bid";
                $result_origin_num = $conn->query($sql_origin_quantity);

                if ($result_origin_num->num_rows > 0) {
                    while ($row = $result_origin_num->fetch_assoc()) {
                        $new_num = $row['Quantity']-$num;
                        mysqli_query($conn, "UPDATE mybook SET Quantity=$new_num
                        WHERE BookID=$bid");
                    }
                }
            }
        }
    }
}

$conn->close();
?>

<br>
<br>
<br>
<a href="succeed.html"><input type="submit" value="确认付款"></a>
</div>



