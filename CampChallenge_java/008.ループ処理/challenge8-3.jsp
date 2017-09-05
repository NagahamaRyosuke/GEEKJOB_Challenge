<%-- 
    Document   : challenge8-3
    Created on : 2017/09/05, 16:03:50
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
        <h1>for文3</h1>
    </body>
</html>

<%
    int answer = 0;
    
    for(int i=0 ;i<=100 ;i++){
        answer = answer + i;
        out.print(answer+"<br>");
    }
    
%>

