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
<div style="text-align:center;">
<?php
echo "您购买的BookID是";
echo $_POST['order_bookid'];
echo"<br>";
echo"<br>";
echo"<br>";
?>
</div>
<div style="text-align:center;">
<p>请您填写收货信息,若尚未登录，请先<a href="indexLogin.html">登录</a></p>
<br>
<br>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>购买</title>

</head>
<body>
    <form action="insert_order.php" method="post">
        studentID:<input type="text" name="studentID" class="studentID" placeholder="请输入您的学号">
        BookID:<input type="text" name="BookID" class="BookID" placeholder="请输入您的书号">
        number:<input type="text" name="number" class ="number" placeholder="请输入您购买的数量">
        Address:<input type="text" name="Address" class ="Address" placeholder="请输入您的地址">
        Tel:<input type="text" name="Tel" class ="Tel" placeholder="请输入您的电话号码">
        <input type="submit" value="提交订单">
    </form>
</body>
</html>
</div>