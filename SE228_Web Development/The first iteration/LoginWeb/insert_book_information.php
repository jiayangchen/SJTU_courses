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
echo "欢迎来到添加图书的页面";
echo"<br>";
?>
<p>请您填写需要添加的图书信息</a></p>
<br>
<br>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加图书</title>

</head>
<body>
<form action="insert_book.php" method="post">
    BookID:<input type="text" name="BookID" class="BookID" placeholder="请输入书号">
    BookName:<input type="text" name="BookName" class="BookName" placeholder="请输入书名">
    Author:<input type="text" name="Author" class="Author" placeholder="请输入作者">
    Press:<input type="text" name="Press" class="Press" placeholder="请输入出版社">
    Quantity:<input type="text" name="Quantity" class ="Quantity" placeholder="请输入书籍数量">
    <br>
    <br>
    <br>
    Price:<input type="text" name="Price" class ="Price" placeholder="请输入书籍价格">
    &nbsp;&nbsp;&nbsp;
    <input type="submit" value="确认添加">
</form>
</body>
</html>
    </div>