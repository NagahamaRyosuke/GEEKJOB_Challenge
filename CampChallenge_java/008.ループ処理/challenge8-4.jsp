<%-- 
    Document   : challenge8-4
    Created on : 2017/09/05, 16:16:46
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
        <h1>while文</h1>
    </body>
</html>

<%
    int x = 1000;
    
    while(x>100){
        x = x / 2;
        out.print(x+"<br>");
    }
%>
