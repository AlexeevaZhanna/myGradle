<%@ page import="java.util.Date" pageEncoding="UTF-8" %>
<head>
    <title>Онлайн-магазин</title>
   <form action="" method = "get" >
 </head>
<%
String name = request.getParameter("uname");
out.print("Добро пожаловать, "+name+"!");
%>
<html>

<div>
    <p><a href="../viewBasket">Корзина</a></p>
</div>

<p><a href="../index.html">На главную</a></p>

