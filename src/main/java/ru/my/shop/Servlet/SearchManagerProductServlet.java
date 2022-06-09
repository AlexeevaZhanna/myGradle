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


@WebServlet(urlPatterns = "/searchProduct")
public class SearchManagerProductServlet extends  HttpServlet{

        private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException {
            response.setContentType("text/html;charset=UTF-8");
            String nameProduct = request.getParameter("name");
            String idProduct = request.getParameter("id");
            String priceProduct = String.valueOf(request.getParameter("price"));
            String categoryProduct = request.getParameter("category");
            Connection con = null;
            ServletHelper.populateHtmlBegin(response);
            int i =0;
            try {

                ResultSet row =   ProductService.selectManagerProduct(nameProduct, idProduct, priceProduct,categoryProduct);

                while (row.next()) {
                    String name = row.getString("name");
                    double price = row.getDouble("price");
                    String category = row.getString("category");
                    String id = row.getString("id");


                    Product sp = new Product(name, price, category, id);
                    response.getWriter().append("<p> Товар: " + name + " Цена: " + price +" Категория: " + category + " id: " + id +  "</p>");
                    i++;
                    response.getWriter().append("<p><a href=\"./deleteProduct?id=" + sp.getId() + "\">Удалить</a></p>");
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
            if (i == 0){
                response.getWriter().append("<p>Товар не найден!<p>");
            }
            ServletHelper.populateHtmlEnd(response);


        }
}