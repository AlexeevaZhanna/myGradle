package ru.my.shop.product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/account")
public class AuthorizationDBServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Connection con = null;
        try {
            try {
                ServletHelper.populateHtmlBegin(response);
                if (MySqlConnect.foundPerson(login, password) != false){
                    response.getWriter().append("<p>Вы вошли в аккаунт!<p>");

                } else {
                    response.getWriter().append("<p>Неверный логин или пароль!<p>");
                    ServletHelper.populateHtmlEnd(response);

                }
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

    }
}