<%-- 
    Document   : DbTask11
    Created on : 2017/09/20, 17:24:34
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
        <h1>上書き用フォーム</h1>
        
        <form action="/SampleB/DbTask11" method="GET">
            <div>
                IDからprofileを上書きする
            </div>
            <div>
                ID:<input type="text" name="Id"> 
            </div>
            <div>
                上書きの内容
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
