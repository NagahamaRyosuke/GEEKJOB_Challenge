<%-- 
    Document   : InventoryControlResult
    Created on : 2017/09/25, 16:13:12
    Author     : Ryosuke
--%>

<%@page import="org.camp.servlet.InventoryControlScope"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%
    ArrayList<InventoryControlScope> check= (ArrayList)request.getAttribute("check");    
%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="InventoryControl.css" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table align="center" border=1>
            <tr><th>code</th><th>name</th><th>price</th></tr>
                <tr>
            <%
                for(InventoryControlScope chk:check){
            %>
                <td><%=chk.getCode()%></td>
                <td><%=chk.getProduct_name()%></td>
                <td><%=chk.getPrice()%></td>
                </tr>
            <%}%>
        </table>
        <a href=InventoryControl.jsp>戻る</a>
    </body>
</html>
