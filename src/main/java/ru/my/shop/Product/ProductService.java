package ru.my.shop.Product;

import ru.my.shop.MySqlConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductService extends MySqlConnect {

    public static void createNewProduct(Product p) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = "INSERT INTO products (name, price, category) VALUES (\"" + p.getName() + "\", " + (double) p.getPrice() + ", \""+ p.getCategory() +"\");";
        System.out.println(query);
        int row = st.executeUpdate(query);
        System.out.println(row);
    }
    private  static void updateProduct(Connection con, String nameProduct, double price ) throws SQLException {
        Statement st = con.createStatement();
        String query = "UPDATE products set price=" + price + " where name =\"" + nameProduct + "\";";
        System.out.println(query);
        int row = st.executeUpdate(query);
        System.out.println(row);
    }

    public static ResultSet selectNameCategoryProduct(String nameProduct, String categoryProduct) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = "SELECT * FROM products WHERE NAME = \"" + nameProduct +  "\" OR category = \"" + categoryProduct + "\";";
        System.out.println(query);
        ResultSet row = st.executeQuery(query);
        System.out.println(row);
        return row;
    }
    public static ResultSet selectCategoryProduct(String categoryProduct) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = "SELECT * FROM products WHERE NAME = \"" + categoryProduct +  "\";";
        System.out.println(query);
        ResultSet row = st.executeQuery(query);
        System.out.println(row);
        return row;
    }
}