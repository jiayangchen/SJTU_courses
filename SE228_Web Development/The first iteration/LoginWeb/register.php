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

/*Get the information*/

$new_studentid=$_POST['studentid'];
$new_password=$_POST['password'];
$new_repassword=$_POST['repassword'];

if ($new_password==$new_repassword){
    include "connection.php";
    
    /*Inert*/
    
    $sql_insert_user = "INSERT INTO  myusers (studentID, password)
    VALUES ('$new_studentid','$new_password')";
    if ($conn->query($sql_insert_user) === TRUE) {
        echo "注册成功";
        echo "您的注册信息如下，请核对";
        echo "<br>";
        echo "<br>";
        echo "<br>";
        echo "<table border=1 align='center'>";
        echo "<tr><td>studentID</td><td>password</td></tr>";
        echo "<tr>";
        echo "<td>" . $new_studentid . "</td>";
        echo "<td>" . $new_password . "</td>";
        echo "</tr>";
        echo "</table>";
        echo "<a href=\"bookstore.php\"><input type=\"submit\" value=\"前往书店\"></a>";
    }
    else{
        echo"您已注册过，请登录";
        echo "<br>";
        echo "<br>";
        echo "<a href=\"indexLogin.html\"><input type=\"submit\" value=\"返回登录\"></a>";
    }
    $conn->close();
}

else{
    
    /*Test the same*/
    echo "密码不一致，请重新输入";
    echo "<br>";
    echo "<br>";
    echo "<a href=\"register_information.php\"><input type=\"submit\" value=\"重新注册\"></a>";
}
?>
    </div>
    