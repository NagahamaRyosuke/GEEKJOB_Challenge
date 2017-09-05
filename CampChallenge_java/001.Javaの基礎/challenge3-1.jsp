<%-- 
    Document   : challenge3-1
    Created on : 2017/09/04, 15:34:57
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
        <h1>四則演算</h1>
    </body>
</html>

<%
    final int NUMBER = 100;
    int number = 5;
    int answer = 0;
    
    out.print("定数 :"+NUMBER+"<br>");
    out.print("変数 :"+number+"<br><br>");
    
    answer = NUMBER + number;
    out.print("加算結果 :"+answer+"<br>");
    
    answer = NUMBER - number;
    out.print("減算結果 :"+answer+"<br>");

    answer = NUMBER * number;
    out.print("乗算結果 :"+answer+"<br>");
    
    answer = NUMBER / number;
    out.print("除算結果 :"+answer+"<br>");
    
%>

