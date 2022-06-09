<%@ page import="java.util.Date" pageEncoding="UTF-8" %>
 <%@page import="java.sql.*,java.util.*"%>

<html>
 <head>
     <title>Онлайн-магазин</title>
 <body>
 <h2> ПОИСК ПОКУПАТЕЛЯ </h3>
 <h2> Введите данные: </h2>
    <div>
        <form action="../registrAccount" method="get">
            <label for="uname">Имя клиента:</label><br>
            <input type="text" id="uname=" name="uname"><br>

            <label for="lname">Фамилия клиента:</label><br>
            <input type="text" id="lname=" name="lname"><br>

            <label for="age">Возраст клиента:</label><br>
            <input type="text" id="age=" name="age"><br>

            <label for="tel">Телефон клиента:</label><br>
            <input type="text" id="tel=" name="tel"><br>

            <label for="login">Почта/логин клиента:</label><br>
            <input type="text" id="login=" name="login"><br>

     <div>
      <br> <input type="submit" value="Поиск" />
 </form>

 </body>
 </html>