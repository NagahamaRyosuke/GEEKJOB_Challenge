<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    UserDataBeans userbeans = (UserDataBeans)session.getAttribute("userbeans");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <% if(!session.getAttribute("flag").equals("true")){ %>
        <h1>登録確認</h1>
        名前:<%= userbeans.getName()%><br>
        生年月日:<%= userbeans.getYear()+"年"+userbeans.getMonth()+"月"+userbeans.getDay()+"日"%><br>
        種別:<%= userbeans.getType()%><br>
        電話番号:<%= userbeans.getTell()%><br>
        自己紹介:<%= userbeans.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= session.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1>
        <%if(session.getAttribute("name").equals("true")){%>名前が未入力です<br><%}%>
        <%if(session.getAttribute("year").equals("true")){%>年が未入力です<br><%}%>
        <%if(session.getAttribute("month").equals("true")){%>月が未入力です<br><%}%>
        <%if(session.getAttribute("day").equals("true")){%>日が未入力です<br><%}%>
        <%if(session.getAttribute("type").equals("true")){%>種別が未入力です<br><%}%>
        <%if(session.getAttribute("tell").equals("true")){%>電話番号が未入力です<br><%}%>
        <%if(session.getAttribute("comment").equals("true")){%>自己紹介が未入力です<br><%}%>
    <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
