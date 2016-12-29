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
    <br>
    <br>
<?php
echo "欢迎来到删除图书的页面";
echo"<br>";
?>
<p>请您填写需要删除的图书信息</a></p>
<br>
<br>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>删除图书</title>

</head>
<body>
<form action="delete_book.php" method="post">
    BookID:<input type="text" name="BookID" class="BookID" placeholder="请输入要删除的书号">
    <input type="submit" value="确认删除">
</form>
</body>
</html>
</div>