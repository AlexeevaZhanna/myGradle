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

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
         response.setContentType("text/html;charset=UTF-8");
     String nameProduct = request.getParameter("name");
     String priceProduct = request.getParameter("price");
     String categoryProduct = request.getParameter("category");
               Connection con = null;
       ServletHelper.populateHtmlBegin(response);
       int i =0;
            try {

          ResultSet row =   ProductService.selectNameCategoryProduct(nameProduct, categoryProduct);

                while (row.next()) {
              String name1 = row.getString("name");
              double price1 = row.getDouble("price");
              String category1 = row.getString("category");
              Product sp = new Product(name1, price1, category1);
              response.getWriter().append("<p> Товар: " + name1 + " Цена: " + price1 +" Категория: " + category1 +  "</p>");
              i++;
              response.getWriter().append("<p><a href=\"./addToBasket?name="  + sp.getName() + "\">В корзину</a></p>");
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
             response.getWriter().append("<p>Товар не найден!<p>");
         }
       ServletHelper.populateHtmlEnd(response);




    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pName = request.getParameter("name");
        String pPrice = request.getParameter("price");
        String pCategory = request.getParameter("category");
        Product product = new Product(pName ,Double.valueOf(pPrice), pCategory);
        Connection con = null;
        try{
            try {
                ProductService.createNewProduct(product);
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
        response.getWriter().append("<p>Продукт добавлен</p>");
        response.getWriter().append("<p><a href=\"./ProductAdd.html\">Добавить еще</a></p>");
        ServletHelper.populateHtmlEnd(response);
    }
}