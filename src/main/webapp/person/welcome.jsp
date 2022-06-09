<%@ page import="java.util.Date" pageEncoding="UTF-8" %>
<head>
    <title>Онлайн-магазин</title>
 </head>
<%
String name = (String)request.getAttribute("uname");
out.print("Добро пожаловать, "+name+"!");
%>
<html>
<div>
    <p><a href="./person/personInfo.jsp">Личные данные</a></p>
</div>

<div>
    <p><a href="./viewBasket">Корзина</a></p>
</div>

<p><a href="./index.html">На главную</a></p>

