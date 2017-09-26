<%-- 
    Document   : InventoryControlLogin
    Created on : 2017/09/22, 14:21:53
    Author     : Ryosuke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="InventoryControl.css" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ログイン</h1>
        <div>
            <form action="/SampleB/InventoryControlLogin" method="post">
                <p>name</p>
                <div>
                    <input type="text" name="Name" required>
                </div>
                <p>password</p>
                <div>
                    <input type="password" name="Password" required>
                </div>
                <div>
                    <input type="submit" name="login" value="ログイン">
                    <input type="reset" value="キャンセル">
                </div>
            </form>
        </div>
    </body>
</html>
