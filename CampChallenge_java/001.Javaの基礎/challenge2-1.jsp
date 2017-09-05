<%-- 
    Document   : challenge2-1
    Created on : 2017/09/04, 15:31:12
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
        <h1>自己紹介</h1>
    </body>
</html>

        <%
            String name = "長濱亮輔です";
            out.print(name);
        %>