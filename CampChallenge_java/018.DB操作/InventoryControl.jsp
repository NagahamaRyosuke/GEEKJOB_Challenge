<%-- 
    Document   : InventoryControl
    Created on : 2017/09/21, 17:44:50
    Author     : Ryosuke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="InventoryControl.css" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>在庫管理システム</h1>
        
        <hr>
        <p>登録</p>
        <div>
            <form action="/SampleB/InventoryControl" method="get">
                <div>
                    商品コード:<input type="text" name="code" required>
                </div>
                <div>
                    商品名:<input type="text" name="product_name" required>
                </div>
                <div>
                    価格:<input type="text" name="price" required>
                </div>
                <div>
                    <input type="submit" name="entry" value="登録">
                    <input type="reset" value="キャンセル">
                </div>
            </form>
        </div>
        <hr>
        <p>検索</p>
        <div>
            <form action="/SampleB/InventoryControl" method="get">
                <div>
                    商品コード:<input type="text" name="code">
                </div>
                <div>
                    商品名:<input type="text" name="product_name">
                </div>
                <div>
                    価格:<input type="text" name="price">
                </div>
                <div>
                    <input type="submit" name="search" value="検索">
                    <input type="reset" value="キャンセル">
                </div>
            </form>
            <hr>
            <form action="InventoryControlLogin.jsp" method="get">
                <input type="submit" value="ログアウト">
            </form>
        </div>
    </body>
</html>
