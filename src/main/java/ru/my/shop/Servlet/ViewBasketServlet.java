package ru.my.shop.Servlet;

import ru.my.shop.Product.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("ALL")
@WebServlet(urlPatterns = "/viewBasket")
public class ViewBasketServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_BEGIN = "<table style=\" border: 1px solid white; border-collapse: collapse;\">\n" +
            "  <tr>\n" +
            "    <th>Название</th>\n" +
            "    <th>Цена</th>\n" +
            "    <th>Удалить</th>\n" +
            "  </tr>";

    public static final String TABLE_END = "</table>";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletHelper.populateHtmlBegin(response);

        HttpSession httpSession = request.getSession();

        List<Product> myBasket = (List<Product>)httpSession.getAttribute("myBasket");
        if (myBasket!=null && myBasket.size() != 0) {
            response.getWriter().append("<p>Ваша корзина:</p>");

            response.getWriter().append(TABLE_BEGIN);
        for (int i=0; i < myBasket.size(); i++) {
            Product p = myBasket.get(i);
            response.getWriter().append("<p>\n" +
                    "    <td>" + p.getName() + "</td>\n" +
                    "    <td>" + p.getPrice() + "</td>\n" +
                    "<td> <input  min=1 /></td>\n" +
                    "    <td><a href= \"./remove?id=" + i +
                    "\">Удалить</a></td>\n" + "  </tr>");
            response.getWriter().append("<p><button><a href=\"./buy\">Купить</a></button></p>");
        }response.getWriter().append(TABLE_END);
        } else {
            response.getWriter().append("<p>Ваша корзина пуста!</p>");
        }

        ServletHelper.populateHtmlEnd(response);
    }
    }

