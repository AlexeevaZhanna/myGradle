package ru.my.shop.Servlet;

import ru.my.shop.Product.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/remove")
 public class RemoveFromBasketServlet  extends HttpServlet {
    public static final String CONTENT_TYPE = "text/html;charset=UTF-8";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType(CONTENT_TYPE);
        Integer id = Integer.valueOf(request.getParameter("id"));

        Object myBasket = request.getSession().getAttribute("myBasket");

        BasketService.removeFromBasket( (int)id, (List<Product>) myBasket);

        RequestDispatcher rd = request.getRequestDispatcher("/viewBasket");
        rd.include(request, response);

    }

}
