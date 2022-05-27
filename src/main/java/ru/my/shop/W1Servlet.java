package ru.my.shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/w1servlet")
public class W1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setAttribute("name", req.getParameter("name") );
        req.setAttribute("lastName", req.getParameter("lastName"));
                req.setAttribute("age", req.getParameter("age"));
       req.getRequestDispatcher("/w1.jsp").forward(req,resp);
    }
}
