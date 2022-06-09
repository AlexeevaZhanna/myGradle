package ru.my.shop.Servlet;

import ru.my.shop.Product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/deleteProduct")
public class RemoveProductServlet extends HttpServlet{

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            response.setContentType("text/html;charset=UTF-8");
            String id = request.getParameter("id");

            try {
                ProductService.deleteProduct(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.getWriter().append("<p> Товар: "   +id+ "  удален." +"</p>");
            response.getWriter().append("<p><a href=\"./management.html"+ "\">Назад</a></p>");

        }

    }
