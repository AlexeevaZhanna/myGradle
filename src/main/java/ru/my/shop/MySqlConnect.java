package ru.my.shop;

import ru.my.shop.Product.Product;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class MySqlConnect {


    public static void main(String[] args) throws SQLException {
        Connection con = null;
      try { Product p = new Product("Трюль");
      //  selectNameProduct("Трюф");
        } finally {
            if (con != null)
                con.close();
        }
    }
    public static ResultSet selectNameProduct(String nameProduct) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = "SELECT * FROM products WHERE NAME = \"" + nameProduct +  "\";";
        System.out.println(query);
        ResultSet row = st.executeQuery(query);
        System.out.println(row);
        return row;
    }

    public static Connection getConnection() {
        Properties props = getProperties();
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection con = DriverManager.getConnection(url,
                    username, password);

            System.out.println("Connection successful");
            return con;

        } catch (Exception ex) {
            System.out.println("Connection failed");
            System.out.println(ex);
        }
        return null;
    }

    private static Properties getProperties() {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("src/main/resources/database.properties"))) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }
}