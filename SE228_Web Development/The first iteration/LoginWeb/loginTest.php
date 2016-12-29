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
<html>
    <body>
    <div style="text-align: center">
    <?php

    include "connection.php";

    $sql_admin = "SELECT studentID, password FROM myadmin";
    $result_admin = $conn->query($sql_admin);

    $sql_users = "SELECT studentID, password FROM myusers";
    $result_users = $conn->query($sql_users);

    /*Test whether the login refer to admin or common users, if both not, jump to register*/
    if ($result_admin->num_rows==1) 
    {
        $row = $result_admin->fetch_assoc();
        if ($row['studentID']==$_POST['username']) 
        {
            if ($row['studentID']==$_POST['username'] and $row['password']==$_POST['password']) 
            {
                header("Location: adminManager.php");
            }
            else{
                echo "wrong password";
            }
        }
        
        else if ($result_users->num_rows>0)
        {
            while($row = $result_users->fetch_assoc())
            {
                if ($row['studentID']==$_POST['username']) 
                {
                    if ($row['password'] == $_POST['password']) 
                    {
                        echo "Welcome My sincere users:";
                        echo $_POST['username'];
                        echo"<br>";
                        echo"<br>";
                        echo "您的购买记录如下";
                        echo"<br>";
                        echo"<br>";
                        $sql_usersManager = "SELECT studentID, BookID, Address,Tel,Number FROM myorder";
                        $result_usersManager = $conn->query($sql_usersManager);
                        echo "<table border=1 align='center'>";
                        echo "<tr><td>studentID</td><td>BookID</td><td>Number</td></tr>";
                        while($row = $result_usersManager->fetch_assoc())
                        {
                            if ($row['studentID']==$_POST['username']) {
                                echo "<tr>";
                                echo "<td>" . $row["studentID"] . "</td>";
                                echo "<td>" . $row["BookID"] . " </td>";
                                echo "<td>" . $row["Number"] . " </td>";
                                echo "</tr>";
                            }
                        }
                        echo "</table>";
                        echo "<br>";
                        echo "<br>";
                        echo "<a href=\"bookstore.php\"><input type=\"submit\" value=\"前往书店\"></a>";
                    }
                    else{
                        echo "wrong password";
                    }
                }
                /*else{
                    header("Location:register.html");
                }*/
            }
        }
    }
    
    $conn->close();

    ?>
        </div>
    </body>
</html>

