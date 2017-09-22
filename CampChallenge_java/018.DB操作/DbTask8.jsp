<%-- 
    Document   : DbTask8
    Created on : 2017/09/20, 15:39:56
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
        <h1>検索用フォーム　一部一致</h1>
        
        <form action="/SampleB/DbTask8" method="GET">
            <div>
                検索:<input type="text" name="Name" size="40"> 
            </div>
            <div>
                <input type="submit" name="submit">
            </div>
        </form>    
    </body>
</html>
