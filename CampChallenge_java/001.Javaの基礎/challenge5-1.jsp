<%-- 
    Document   : challenge5-1
    Created on : 2017/09/04, 16:01:43
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
        <h1>変数の宣言と表示(if文)</h1>
    </body>
</html>

<%
    int number = 2;
    
    if(number == 1){
        out.print("1です!");
    } else if(number == 2){
        out.print("プログラミングキャンプ!");
    } else {
        out.print("その他です!");
    }
%>
