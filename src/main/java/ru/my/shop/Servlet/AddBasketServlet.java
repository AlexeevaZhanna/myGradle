package ru.my.shop.Servlet;

import ru.my.shop.Product.Product;
import ru.my.shop.Product.ProductService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/addToBasket")
    public class AddBasketServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pName = request.getParameter("name");
        String pCategory = request.getParameter("category");
        Product p = new Product();
        p.getName();
        p.getCategory();
        Connection con = null;
        try {
            ResultSet res = ProductService.selectNameCategoryProduct(pName, pCategory);
            while (res.next()) {
                String name = res.getString("name");
                double price = res.getDouble("price");

                Product selectProduct = new Product(name, price);

                request.setAttribute("name", selectProduct.getName());
                request.setAttribute("price", selectProduct.getPrice());

            }
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
            Object myBasket = request.getSession().getAttribute("myBasket");
            String name = (String) request.getAttribute("name");
            Double price = (Double) request.getAttribute("price");
            Product selectProduct = new Product(name, price);
            if (myBasket != null) {
                List<Product> list = (List<Product>) myBasket;
                list.add(selectProduct);
            } else {
                List<Product> list = new ArrayList();
                list.add(selectProduct);
                request.getSession().setAttribute("myBasket", list);
            }

            ServletHelper.populateHtmlBegin(response);

            response.getWriter().append("<p>Товар добавлен в корзину</p>");

            ServletHelper.populateHtmlEnd(response);
        }
    }}

