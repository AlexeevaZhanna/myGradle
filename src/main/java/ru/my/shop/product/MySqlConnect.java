package ru.my.shop.product;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

class TestMySqlConnect {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, SQLException {

        Connection con = null;
        try{
            con = getConnection();
            Product p = new Product("Рис", 150 , "Бакалея" );
            createNewProduct(con, p);
            // updateProduct(con, "Рис",  p.getPrice()- p.getPrice() * 15/100);

        } finally {
            if (con != null)
                con.close();
        }

    }
    private  static void createNewProduct(Connection con, Product p) throws SQLException {
        Statement st = con.createStatement();
        String query = "INSERT INTO products (name, price, category) VALUES (\"" +
                p.getName() + "\", " + (double) p.getPrice() + ", \""+ p.getCategory() +"\");";
        System.out.println(query);
        int row = st.executeUpdate(query);
        System.out.println(row);
    }
    private  static void updateProduct(Connection con, String nameProduct, double price ) throws SQLException {
        Statement st = con.createStatement();
        String query = "UPDATE products set price=" + price +" where name =\"" + nameProduct + "\";";
        System.out.println(query);
        int row = st.executeUpdate(query);
        System.out.println(row);
    }
    static void selectNameProduct(Connection con, String nameProduct) throws SQLException {
        Statement st = con.createStatement();
        String query = "SELECT * FROM products WHERE NAME = " +  nameProduct + "\";";
        System.out.println(query);
        int row = st.executeUpdate(query);
        System.out.println(row);
    }
    private static Connection getConnection() {
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
    }}