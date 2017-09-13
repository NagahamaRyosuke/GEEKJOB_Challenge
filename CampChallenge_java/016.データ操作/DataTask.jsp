<%-- 
    Document   : DataTask
    Created on : 2017/09/13, 15:08:57
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
        <h1>HTMLの入力データの取得と表示</h1>
        
        <%
            request.setCharacterEncoding("UTF-8");
            
            out.print(request.getParameter("name"));
            out.print(request.getParameter("gender"));
            out.print(request.getParameter("hobby"));
        %>
    </body>
</html>
