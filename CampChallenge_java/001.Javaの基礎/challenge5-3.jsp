<%-- 
    Document   : challenge5-3
    Created on : 2017/09/04, 16:57:04
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
        <h1>switch文2</h1>
    </body>
</html>

<%
    char word = 'あ';

    switch(word){
        case 'A':
            out.print("英語");
            break;
        case 'あ':
            out.print("日本語");
            break;
    }
%>