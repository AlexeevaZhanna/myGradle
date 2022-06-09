 <%@ page import="java.util.Date" pageEncoding="UTF-8" %>
  <%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<!--suppress XmlInvalidId -->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Онлайн-магазин</title>
</head>
<body>
<h1>Добавление товаров</h1>
<div>
    <form action="./product" method="post">
        <label for="name">Наименование товара:</label><br>
        <input type="text" id="name=" name="name"><br>
        <label for="price">Цена товара:</label><br>
        <input type="price" id="price" name="price"><br>
        <label for="category">Категория товара:</label><br>
        <input type="text" id="category" name="category"><br>


        <input type="submit" value="Добавить">

    </form>
</div>


<div>
    <p><a href="./SearchProduct.jsp">Форма поиска товаров</a></p>
    <p><a href="./">На главную</a></p>
</div>
</body>
</html>