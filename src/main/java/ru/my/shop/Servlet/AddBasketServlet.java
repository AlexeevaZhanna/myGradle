package ru.my.shop.Servlet;

import ru.my.shop.Product.Product;
import ru.my.shop.Product.ProductService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
           int i = 0;
        try {
           ResultSet res = ProductService.selectNameCategoryProduct(pName, pCategory);
           while (res.next()){
            i++;

        } }catch (SQLException e) {
            e.printStackTrace();
        } //Product selectProduct = new Product( );
      //  selectProduct.getName();


        Object myBasket = request.getSession().getAttribute("myBasket");
            if (myBasket !=null) {
                List<Product> list = (List<Product>)myBasket;
            //   list.add(selectProduct);
            } else {
                List<Product> list = new ArrayList();
           //    list.add(selectProduct);
          //      request.getSession().setAttribute("myBasket", list);
            }

            ServletHelper.populateHtmlBegin(response);

           response.getWriter().append("<p>Товар добавлен в корзину</p>");

            ServletHelper.populateHtmlEnd(response);
        }



    }

