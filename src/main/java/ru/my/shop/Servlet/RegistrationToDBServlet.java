package ru.my.shop.Servlet;

import ru.my.shop.Person.PersonService;
import ru.my.shop.Person.Person;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/registrAccount")

public class RegistrationToDBServlet extends HttpServlet {

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
