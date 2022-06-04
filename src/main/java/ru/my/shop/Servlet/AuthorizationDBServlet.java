package ru.my.shop.Servlet;

import ru.my.shop.Person.Person;
import ru.my.shop.Person.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/account")
public class AuthorizationDBServlet extends HttpServlet {

 protected void doGET(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

request.getRequestDispatcher("/person/welcome.jsp").forward(request,response);
  }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");

        String login1 = request.getParameter("login");
       String password1 = request.getParameter("password");
       Person user = new  Person();
       user.setLogin(login1);
       user.setPassword(password1);
        Connection con = null;
        ServletHelper.populateHtmlBegin(response);
        int i =0;
            try {
                ResultSet row =   PersonService.foundPerson(user);
                while (row.next()) {
                    String uname = row.getString("uname");
                    i++;
                    Person a = new Person(uname);
                    a.getUname();
                   response.getWriter().append(a.getUname());
           request.setAttribute("uname",a.getUname() );
                    doGET(request, response);


                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }}
        if (i == 0){
        response.getWriter().append("<p>Неверный логин или пароль!<p>");
        } ServletHelper.populateHtmlEnd(response);
}


}