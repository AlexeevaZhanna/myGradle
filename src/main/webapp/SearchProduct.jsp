 <%@ page import="java.util.Date" pageEncoding="UTF-8" %>
  <%@page import="java.sql.*,java.util.*"%>

 <html>
  <head>
      <title>Онлайн-магазин</title>
  <body>

 <body>
 <h2> ПОИСК ТОВАРА </h3>
 <h2> Введите данные: </h2>
    <div>
       <form action="./searchProduct" method="get">
               <label for="name">Введите имя товара:</label><br>
               <input type="text" id="name=" name="name"><br>

               <label for="id">Введите id товара:</label><br>
               <input type="text" id="id=" name="id"><br>

               <label for="price">Введите цену товара:</label><br>
               <input type="text" id="price=" name="price"><br>

               <label for="category">Введите категорию товара:</label><br>
               <input type="text" id="category=" name="category"><br>
               <input type="submit" value="Найти">

           </form>
     <div>

 </form>

 </body>
 </html>