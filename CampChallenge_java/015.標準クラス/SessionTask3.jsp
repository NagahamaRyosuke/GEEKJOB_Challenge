<%-- 
    Document   : SessionTask3
    Created on : 2017/09/15, 15:13:19
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
        <h1>データの受け渡し</h1>
        
        <%--servletは割り当てられてるURLを呼ぶ--%>
        <form action="/SampleB/SessionTask3" method="GET">
            <div>
                Name:<input type="text" name="Name" size="40">
            </div>
            <div>
                Gender:
                <input type="radio" name="Gender" value="man">man
                <input type="radio" name="Gender" value="woman">woman
            </div>
            <div>
                Hobby:
                <textarea name="Hobby" rows="4" cols="40"></textarea>
            </div>
            
            <input type="submit" name="Submit">
        </form>
</html>
