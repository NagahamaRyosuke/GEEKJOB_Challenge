<%-- 
    Document   : challenge4-1
    Created on : 2017/09/04, 15:54:16
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
        <h1>文字の連結表示</h1>
    </body>
</html>

<%
    String a = "groove";
    String b = "-";
    String c = "gear";
    
    out.print(a+b+c);
%>
