package ru.my.shop;

import ru.my.shop.product.Product;
import ru.my.shop.product.ProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {


    public ProductServlet() {
        System.out.println("Running");
    }

    private static final long serialVersionUID = 1L;

    private Map<String, Product> products = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        products = ProductService.getAll();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String productName = request.getParameter("name");

        response.setContentType("text/html;charset=UTF-8");

        Product foundProduct = products.get(productName);

        if (foundProduct != null) {
            response.getWriter().append("<html><body><p>" + "Название: " + foundProduct.getName() + " Цена: " + foundProduct.getPrice() + " Категория: " + foundProduct.getCategory() + " </p><p><a href=\"./\">На главную</a></p></body></html>");
        }  else {
            response.getWriter().append("<html><body><p>Неизвестный продукт</p><p><a href=\"./\">На главную</a></p></body></html>");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pName = request.getParameter("name");
        String pPrice = request.getParameter("price");
        String pCategory = request.getParameter("category");

        Product product = new Product(pName ,Double.valueOf(pPrice), pCategory);
        ProductService.add(product);

        response.getWriter().append("<html><body><p>Продукт добавлен</p><p><a href=\"./\">На главную</a></p></body></html>");
    }
}
