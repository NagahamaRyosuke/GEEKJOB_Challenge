<%-- 
    Document   : DbTask9
    Created on : 2017/09/20, 16:06:22
    Author     : Ryosuke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>データ挿入用フォーム</h1>
        
        <form action="/SampleB/DbTask9" method="GET">
            <div>
                ID:<input type="text" name="Id"> 
            </div>
            <div>
                name:<input type="text" name="Name" size="40"> 
            </div>
            <div>
                tel:<input type="text" name="Tel">
            </div>
            <div>
                age:<input type="text" name="Age">
            </div>
            <div>
                brithday:<input type="text" name="Birthday">
                例)2000-01-01
            </div>
            <div>
                <input type="submit" name="submit">
            </div>
        </form> 
    </body>
</html>
