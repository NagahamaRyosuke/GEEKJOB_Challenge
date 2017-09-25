<%-- 
    Document   : SessionTask4
    Created on : 2017/09/19, 11:04:27
    Author     : Ryosuke
--%>

<%
    HttpSession hs = request.getSession();
            
    String Name = (String) hs.getAttribute("Name");
    String Gender = (String) hs.getAttribute("Gender");
    String Hobby = (String) hs.getAttribute("Hobby");
%>

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
                Name:<input type="text" name="Name" size="40"value="<%=Name%>">
            </div>
            <div>
                Gender:
                <input type="radio" name="Gender" value="man" <%if(Gender.equals("man")){out.print("checked");}%>>man
                <input type="radio" name="Gender" value="woman" <%if(Gender.equals("woman")){out.print("checked");}%>>woman
            </div>
            <div>
                Hobby:
                <textarea name="Hobby" rows="4" cols="40"value=""><%=Hobby%></textarea>
            </div>
            
            <input type="submit" name="Submit">
        </form>
    </body>
</html>
