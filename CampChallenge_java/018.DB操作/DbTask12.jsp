<%-- 
    Document   : DbTask12
    Created on : 2017/09/21, 10:57:11
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
        <h1>複合検索</h1>
        
        <form action="/SampleB/DbTask12" method="get">
            <div>
                Name:<input type="text" name="Name">
            </div>
            <div>
                Age:<input type="text" name="Age">
            </div>
            <div>
                Birthday:<input type="text" name="Birthday">
            </div>
            <div>
                <input type="submit" name="submit">
            </div>
            <div>
                全て未入力の場合全表示
            </div>
            
        </form>
    </body>
</html>
