package ru.my.shop.product;

import ru.my.shop.person.Person;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class MySqlConnect {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, SQLException {
        Connection con = null;
        try{
            Person p = new Person( "shannita@rambler.ru", "666666");
         System.out.println(foundPerson("shannita@rambler.ru", "666666"));;
        } finally {
            if (con != null)
                con.close();
        }

    }


    public static void insertPerson( Person p) throws SQLException{
        Statement st = getConnection().createStatement();
        String query= "INSERT INTO person (uname, lname, age, tel, address, login, password)  VALUES ('" + p.getUname() +"',  '" + p.getLname() + "' , '" + p.getAge() + "', '" + p.getTel() + "', '" + p.getAddress() + "','" + p.getLogin() + "','" + p.getPassword() + "')";
        st.executeUpdate(query);
        int row = st.executeUpdate(query);
        System.out.println(row);
    }

      public static boolean foundPerson(String login, String password) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = "SELECT * FROM person WHERE login = '"+ login +"' AND password = '" + password+ "'";
        System.out.println(query);
       ResultSet rs = st.executeQuery(query);
          boolean rc = false;
          rc = rs.next();
          return rc;
      }

    private  static void createNewProduct(Connection con, Product p) throws SQLException {
        Statement st = con.createStatement();
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
    }
}