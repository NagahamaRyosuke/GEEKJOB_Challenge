<%-- 
    Document   : DbTask10
    Created on : 2017/09/20, 17:14:07
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
        <h1>削除用フォーム</h1>
        
        <form action="/SampleB/DbTask10" method="GET">
            <div>
                削除:<input type="text" name="id" size="40"> 
            </div>
            <div>
                <input type="submit" name="submit">
            </div>
    </body>
</html>
