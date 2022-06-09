package ru.my.shop.Servlet;

import ru.my.shop.Person.Person;
import ru.my.shop.Person.PersonService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/registrAccount")

public class RegistrationToDBServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String namePerson = request.getParameter("uname");
        String lnamePerson = request.getParameter("lname");
        String agePerson = request.getParameter("age");
        String telPerson = request.getParameter("tel");
        String loginPerson = request.getParameter("login");
        Connection con = null;
        ServletHelper.populateHtmlBegin(response);
        int i = 0;
        try {

            ResultSet row = PersonService.searchPerson(namePerson, lnamePerson, agePerson ,telPerson,loginPerson);

            while (row.next()) {
                String uname = row.getString("uname");
                String lname = row.getString("lname");
                String age = row.getString("age");
                String tel = row.getString("tel");
                String login =  row.getString("login");
                Person p = new Person(uname, lname,age,tel,login);

                response.getWriter().append("<p> Имя: " + uname +" Фамилия: " + lname + " Возраст: " + age + " Телефон: " + tel + " Логин/email: " + login + "</p>");
                i++;
                response.getWriter().append("<p><a href=\"./" + p.getUname() + "\">Изменить</a></p>");
                response.getWriter().append("<p><a href=\"./deletePerson?login=" + p.getLogin() + "\">Удалить</a></p>");
            }   response.getWriter().append("<p><a href=\"./management.html" + "\">Назад</a></p>");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if (i == 0) {
            response.getWriter().append("<p>Клиент не найден!<p>");
        }
        ServletHelper.populateHtmlEnd(response);
    }


        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String uname = request.getParameter("uname");
        String lname = request.getParameter("lname");
        String age = request.getParameter("age");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Person p = new Person(uname, lname, age, tel, address, login, password);
        Connection con = null;
      try{
            try {
                PersonService.insertPerson(p);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
       ServletHelper.populateHtmlBegin(response);
        response.getWriter().append("<p>Добро пожаловать, " + uname + "! Вы зарегистрировались." + "<p>");
       ServletHelper.populateHtmlEnd(response);
    }
}
