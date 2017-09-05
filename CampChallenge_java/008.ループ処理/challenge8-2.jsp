<%-- 
    Document   : challenge8-2
    Created on : 2017/09/05, 15:52:28
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
        <h1>for文2</h1>
    </body>
</html>

<%
    String data = "";
    String a = "A";

    for(int i=0 ;i<30 ;i++){
        data = data + a;
        out.print(data+"<br>");
    }
%>
