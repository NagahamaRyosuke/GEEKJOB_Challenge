<%-- 
    Document   : challenge8-1
    Created on : 2017/09/05, 15:43:24
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
        <h1>for文1</h1>
    </body>
</html>

<%
    int answer = 0;
    int x = 8;
    
    for(int i=0 ;i<20 ;i++){
        answer = x * 8;
        out.print(answer+"<br>");
        x = answer;
    }
%>
