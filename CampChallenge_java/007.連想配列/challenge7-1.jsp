<%-- 
    Document   : challenge7-1
    Created on : 2017/09/05, 15:21:52
    Author     : Ryosuke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>連想配列の作成</h1>
    </body>
</html>

<%
    HashMap<String,String> list = new HashMap<String,String>();
    
    list.put("1","AAA");
    list.put("hello", "world");
    list.put("soeda","33");
    list.put("20", "20");
%>
