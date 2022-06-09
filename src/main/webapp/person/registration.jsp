<%@ page import="java.util.Date" pageEncoding="UTF-8" %>
 <%@page import="java.sql.*,java.util.*"%>

<html>
 <head>
     <title>Онлайн-магазин</title>
      <form action="../registrAccount" method = "post" >
 </head>
 <body>
 <h1> РЕГИСТРАЦИЯ </h1>
 <h1> Введите данные: </h1>
     <label>Имя:
     <br> <input type="text" required name ="uname" placeholder="Имя" ><br />
     </label>
     <br><label> Фамилия:
       <br>  <input type="text" required name="lname" placeholder="Фамилия" />
    <br/> </label>
     <br><label>  Возраст:
     <br> <input type="number" required name="age" placeholder="Возраст" min=1 />
     <br/><label>
     <br><label>Номер телефона:
       <br> <input type="text" name="tel" placeholder="Номер телефона" required maxlength="13" id="tel"><br />
      </label>
       <br><label> Адрес:
             <br>  <input type="text" required name="address" placeholder="Адрес" />
          <br/> </label>
     <br><label> Ваш логин/почта:
      <br> <input type="text" name="login" placeholder="Почта"><br/>
        </label>
       <br>  <label>Пароль:
       <br>  <input type="password"  name="password" placeholder="Введите пароль" required minlength="5" ><br />
      </label>

      <br> <input type="submit" value="Зарегистрировать" />
 </form>

 </body>
 </html>