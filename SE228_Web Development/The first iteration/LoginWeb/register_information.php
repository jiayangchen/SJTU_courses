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
<div style="text-align:center;">
    <br>
    <br>
<?php
echo "<h1>欢迎来到注册页面</h1>";
echo"<br>";
?>
<br>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>

</head>
<body>
<form action="register.php" method="post">
    studentid:<input type="text" name="studentid" class="studentid" placeholder="请输入学号">
    <br>
    password:<input type="password" name="password" class="password" placeholder="请输入密码">
    <br>
    repassword:<input type="password" name="repassword" class="repassword" placeholder="请确认密码">
    <br>
    <br>
    <input type="submit" value="立即注册">
</form>
</body>
</html>
</div>