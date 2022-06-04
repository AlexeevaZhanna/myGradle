<%@ page import="java.util.Date" pageEncoding="UTF-8" %>
<html>
 <head>

     <title>Онлайн-магазин</title>
 </head>
 <body>
 <h1> Авторизируйтесь </h1>
 <form action="../account" method="post">
 <br>  <label> Логин:
    <br> <input type="text" name="login" placeholder="Ваша почта"><br/>
            </label>
           <br>  <label>Пароль:
           <br>  <input type="password"  name="password" placeholder="Введите пароль" required minlength="5" ><br />
          </label>

          <br> <input type="submit" value="Войти" />

 </form>

 </body>
 </html>