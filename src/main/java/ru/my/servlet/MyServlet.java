package ru.my.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = "/servlet")
public class MyServlet extends HttpServlet {
    public MyServlet() {
        System.out.println("Running");
    }

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Random r = new Random();
        System.out.println(" MyServlet is invoking");
        response.getWriter().append("Hello! This random number: ").append(String.valueOf(r.nextInt())).append(" оправленный параметр Name: ").append(request.getParameter("name"));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        response.getWriter().append("Форма с данными получена");
    }
}
